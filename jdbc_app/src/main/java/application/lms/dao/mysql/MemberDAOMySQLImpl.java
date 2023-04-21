package application.lms.dao.mysql;

import application.lms.LMSApplication;
import static application.lms.LMSApplication.con;
import application.lms.dao.MemberInfoDAO;
import java.io.BufferedReader;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MemberDAOMySQLImpl implements MemberInfoDAO {

    BufferedReader userChoice = LMSApplication.SELECT_CHOICE;
    PreparedStatement pst = null;

    public MemberDAOMySQLImpl() {
        con = LMSApplication.database.getConnection();
    }

    @Override
    public void memberOption() {
        while (true) {
            try {
                System.out.println("------------------------------");
                System.out.println("|   Library Members Details  |");
                System.out.println("------------------------------");

                System.out.println("1. View Members");
                System.out.println("2. View Member");
                System.out.println("3. Add Member");
                System.out.println("4. Remove Member");
                System.out.println("5. Exit to BookMenu");

                System.out.print("\n" + "Select Operation : ");

                String select = userChoice.readLine();
                switch (select) {
                    case "1":
                        System.out.println("View Members");
                        System.out.println("-----------");
                        viewMembers();
                        break;
                    case "2":
                        System.out.println("View Member");
                        System.out.println("-----------");
                        System.out.print("Enter the MemberID : ");
                        try {
                            viewMember(Integer.parseInt(userChoice.readLine()));
                        } catch (NumberFormatException nfe) {
                            System.out.println("\n" + "Please enter correct input" + "\n");
                        }
                        break;
                    case "3":
                        System.out.println("Add Member");
                        System.out.println("----------");
                        addMember();
                        break;
                    case "4":
                        System.out.println("Remove Member");
                        System.out.println("-------------");
                        System.out.print("Enter the Member-ID : ");
                        removeMember(Integer.parseInt(userChoice.readLine()));
                        break;
                    case "5":
                        LMSApplication.options();
                        break;
                    default:
                        System.out.println("Please Read The Menuscript and Enter again!");
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void viewMembers() {
        try ( Statement st = con.createStatement();  ResultSet rs = st.executeQuery("SELECT * FROM lms_Members")) {
            System.out.println("-".repeat(75));
            if (rs.next()) {
                System.out.println(String.format("%-17s%-15s%-15s%-12s%-12s", "MemberId", "Name", "Age", "Gender", "Mobile"));
                System.out.println("-".repeat(75));
                do {
                    System.out.println(String.format("%-17s%-15s%-15s%-12s%-12s", rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getLong(5)));
                } while (rs.next());
                System.out.println("-".repeat(75));
            }
        } catch (SQLException ex) {
            System.out.println("Something went worng");
        }
    }

    @Override
    public void viewMember(int id) {
        try ( Statement st = con.createStatement();  ResultSet rs = st.executeQuery("SELECT * FROM lms_Members where Member_id = " + id)) {
            boolean isAval = false;
            if (rs.next()) {
                isAval = true;
                System.out.println("This is the details of the Member you need");
                do {
                    System.out.println("\n" + "*".repeat(42));
                    System.out.println("This is the details of the Member you need");
                    System.out.println("*".repeat(42));
                    System.out.println("Member Id : " + rs.getInt(1));
                    System.out.println("Name      : " + rs.getString(2));
                    System.out.println("Age       : " + rs.getInt(3));
                    System.out.println("Gender    : " + rs.getString(4));
                    System.out.println("Mobile    : " + rs.getLong(5));
                    System.out.println("*".repeat(42) + "\n");
                } while (rs.next());
            }
            if (!isAval) {
                System.out.print("Enter the another Member id or E/e to exit : ");
                String newid = userChoice.readLine();
                if ("e".equalsIgnoreCase(newid)) {
                    memberOption();
                } else {
                    viewMember(Integer.parseInt(newid));
                }
            }
        } catch (Exception e) {
            System.out.println("Something went worng");
        }
    }

    @Override
    public void addMember() {
        try {
            System.out.print("Enter the Name : ");
            String name = userChoice.readLine();
            System.out.print("Enter the Age : ");
            int age = Integer.parseInt(userChoice.readLine());
            System.out.print("Enter the Gender : ");
            String gender = userChoice.readLine();
            System.out.print("Enter the Moblie No : ");
            long number = Long.parseLong(userChoice.readLine());

            pst = con.prepareStatement("INSERT INTO lms_Members VALUES (0, ?, ?, ?, ?)");
            pst.setString(1, name);
            pst.setInt(2, age);
            pst.setString(3, gender);
            pst.setLong(4, number);
            int x = pst.executeUpdate();
            System.out.println("\n" + "New Member added Successfully" + "\n");
            System.out.println("press 0 to main menu or enter 1 to add another Member");
            String userchoice = userChoice.readLine();
            if (userchoice.equals("0")) {
                memberOption();
            } else {
                addMember();
            }
        } catch (NumberFormatException nefe) {
            System.out.println("Please enter currect input");
        } catch (Exception ex) {
            System.out.println("Something went worng");
            ex.printStackTrace();
        }
    }

    @Override
    public void removeMember(int id) throws IOException {
        int memid = 0;
        boolean chemem = false;
        try {
            String checkmemb = "select Member_id from lms_IssueBooks where Is_returned = true and Member_id = " + id + ";";
            try {
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(checkmemb);
                if (rs.next()) {
                    memid = rs.getInt(1);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            if (memid != 0) {
                chemem = true;
            }

            if (chemem) {
                try {
                    con.setAutoCommit(false);
                    String ibremove = "delete from lms_IssueBooks where Is_returned = true and Member_id = " + id + "limit 1;";
                    String remove = "delete from lms_Members where Member_id = " + id + ";";
                    con.createStatement().executeUpdate(ibremove);
                    con.createStatement().executeUpdate(remove);
                    System.out.println("Member removed Successfully");
                    con.commit();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } else {
                String remove = "delete from lms_Members where Member_id = " + id + ";";
                con.createStatement().executeUpdate(remove);
                System.out.println("Member removed Successfully");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
