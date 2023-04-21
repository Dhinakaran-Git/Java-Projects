package application.lms.dao.mysql;

import application.lms.LMSApplication;
import static application.lms.LMSApplication.con;
import application.lms.dao.CollectBookDAO;
import java.io.BufferedReader;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Date;

public class CollectBookDAOMySQLImpl implements CollectBookDAO {

    BufferedReader select = LMSApplication.SELECT_CHOICE;
    Timestamp timeStamp = new Timestamp(new Date().getTime());
    int book_id = 0;
    int bookcop_id = 0;
    int memid = 0;

    public CollectBookDAOMySQLImpl() {
        con = LMSApplication.database.getConnection();
    }

    public int checkIsbnId(int isbnid) throws IOException {

        try {
            Statement st = con.createStatement();
            String sql = "select Book_id, BookCopies_id from lms_BookCopies where Book_Status = 'Issued' and Book_id = (select Book_id from lms_Books where Isbn_no = " + isbnid + ");";
            ResultSet rs = st.executeQuery(sql);

            if (rs.next()) {
                book_id = rs.getInt(1);
                bookcop_id = rs.getInt(2);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        System.out.println("BOOK ID : " + bookcop_id);
        if (book_id != 0) {
            return isbnid;
        } else {
            System.out.print("\nThe book is not avaiable please enter an another Isbn : ");
            return checkIsbnId(Integer.parseInt(select.readLine()));
        }
    }

    public int checkMemberId(int mid) throws IOException {
        try {
            String sql = "select Member_id from lms_IssueBooks where Member_id = " + mid + ";";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            if (rs.next()) {
                memid = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (memid != 0) {
            return mid;
        } else {
            System.out.print("The memberId is not yet registered enter an registered id - ");
            return checkMemberId(Integer.parseInt(select.readLine()));
        }
    }

    @Override
    public void collectBook() {
        boolean avaliable = true;
        try {
            con.setAutoCommit(false);
            System.out.print("Enter ISBN NO : ");
            checkIsbnId(Integer.parseInt(select.readLine()));

            System.out.print("enter the memberId - ");
            checkMemberId(Integer.parseInt(select.readLine()));

            int isid = 0;
            String verifysql = "select IssueBook_id from lms_IssueBooks where BookCopies_id = " + bookcop_id + " and Member_id = " + memid + ";";
            ResultSet rs = con.createStatement().executeQuery(verifysql);
            if (rs.next()) {
                isid = rs.getInt(1);
            }

            if (isid != 0) {
                if (memid == 0 && book_id == 0) {
                    avaliable = false;
                }
                if (avaliable) {
                    con.setAutoCommit(false);
                    System.out.print("is damaged type y/N - ");
                    String input = select.readLine();
                    if (input.toLowerCase().charAt(0) == 'y') {
                        String damupdate = "update lms_BookCopies set Book_Status = 'Damaged' where BookCopies_id =" + bookcop_id + ";";
                        con.createStatement().executeUpdate(damupdate);
                    }

                    String collect = "update lms_IssueBooks set Is_returned = true, In_date = '" + timeStamp + "' where Member_id = " + memid + ";";
                    con.createStatement().executeUpdate(collect);
                    con.commit();
                    System.out.println("Book Collected successfully");
                } else {
                    System.out.println("");
                    System.out.print("the member taken the different book or type e/E to move main menu - ");
                    String input = select.readLine();
                    if (input.toLowerCase().charAt(0) == 'e') {
                        LMSApplication.options();
                    }
                }
            } else {
                System.out.print("the enterd member id not taken any book or type e/E to move  main menu - ");
                String input = select.readLine();
                if (input.toLowerCase().charAt(0) == 'e') {
                    LMSApplication.options();
                }
            }
        } catch (IOException | SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void collectedBooks() {
        String ibsql = "select b.Isbn_no, b.title, ib.Member_id, ib.In_Date from lms_Books as b join lms_BookCopies as bc join lms_IssueBooks as ib on bc.Book_id = b.Book_id and bc.BookCopies_id = ib.BookCopies_id;";
        try ( Statement st = con.createStatement();  ResultSet rs = st.executeQuery(ibsql)) {
            if (rs.next()) {
                System.out.println("-".repeat(101));
                System.out.println(String.format("%-20s%-20s%-20s%-20s%-18s", "ISBN_NO", "TITLE", "MEMBER_ID", "COLLECTED_DATE", "COLLECTED_BOOKSTATUS"));
                System.out.println("-".repeat(101));
                do {
                    System.out.println(String.format("%-20s%-20s%-20s%-20s%-18s", rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getDate(4), true));
                    System.out.println("-".repeat(101));
                } while (rs.next());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
