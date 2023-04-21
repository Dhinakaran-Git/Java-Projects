package application.lms.dao.file;

import application.lms.LMSApplication;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import application.lms.dao.MemberInfoDAO;
import application.lms.model.MembersInfo;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class MemberDAOFileImpl implements MemberInfoDAO {

    List<MembersInfo> members = new ArrayList<>();

    BufferedReader userChoice = new BufferedReader(new InputStreamReader(System.in));

    private DataInputStream dataInput = null;
    private DataOutputStream dataOutput = null;

    static File fileLoc = null;

    static {
        fileLoc = new File("/home/bas200137/NetBeansProjects/jdbc_app/src/main/java/application/lms/dao/file/Members.txt");
    }

    public List<MembersInfo> getMembers() {
        return members;
    }

    public void readMember() {
        members.clear();
        try {
            dataInput = new DataInputStream(new FileInputStream(fileLoc));

            while (true) {
                try {
                    MembersInfo b1 = new MembersInfo(dataInput.readInt(), dataInput.readUTF(), dataInput.readInt(), dataInput.readUTF());
                    members.add(b1);
                } catch (EOFException eofe) {
                    break;
                }
            }
        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            if (Objects.nonNull(dataInput)) {
                try {
                    dataInput.close();
                } catch (IOException info) {
                    info.printStackTrace();
                }
            }
        }
    }

    public void writeMember(MembersInfo mem) throws IOException {
        dataOutput.writeInt(mem.getMemberId());
        dataOutput.writeUTF(mem.getName());
        dataOutput.writeInt(mem.getAge());
        dataOutput.writeUTF(mem.getGender());
    }

    public void addMemberFile(MembersInfo fmem) {
        try {
            dataOutput = new DataOutputStream(new FileOutputStream(fileLoc, true));
            writeMember(fmem);
            readMember();
        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            if (Objects.nonNull(dataOutput)) {
                try {
                    dataOutput.close();
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }
            }
        }
    }

    public void changeMemberFile() {
        try {
            dataOutput = new DataOutputStream(new FileOutputStream(fileLoc));
            for (MembersInfo nbook : members) {
                writeMember(nbook);
            }
            readMember();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            if (Objects.nonNull(dataOutput)) {
                try {
                    dataOutput.close();
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }
            }
        }
    }

    public static void memberDisplay() {
        System.out.println("1. View Members");
        System.out.println("2. View Member");
        System.out.println("3. Add Member");
        System.out.println("4. Remove Member");
        System.out.println("5. Exit to BookMenu");
    }

    /**
     *
     * @throws IOException
     */
    @Override
    public void memberOption() throws IOException {
        while (true) {
            System.out.println("------------------------------");
            System.out.println("|   Library Members Details  |");
            System.out.println("------------------------------");
            memberDisplay();

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
        }
    }

    {
        readMember();
    }

    @Override
    public void viewMembers() {
        System.out.println("-".repeat(62));
        System.out.println(String.format("%-20s%-20s%-15s%-18s", "MemberId", "Name", "Age", "Gender"));
        System.out.println("-".repeat(62));
        for (MembersInfo member : members) {
            System.out.println(member);
        }
        System.out.println("-".repeat(62));
    }

    public void displayMember(MembersInfo m) {
        System.out.println("\n" + "*".repeat(42));
        System.out.println("This is the details of the Member you need");
        System.out.println("*".repeat(42));
        System.out.println("Member Id : " + m.getMemberId());
        System.out.println("Name      : " + m.getName());
        System.out.println("Age       : " + m.getAge());
        System.out.println("Gender    : " + m.getGender());
        System.out.println("*".repeat(42) + "\n");
    }

    @Override
    public void viewMember(int id) throws IOException {
        boolean isAval = false;
        for (MembersInfo member : members) {
            if (member.getMemberId() == id) {
                isAval = true;
                displayMember(member);
            }
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
    }

    @Override
    public void addMember() throws IOException {
        boolean check = true;
        try {
            System.out.print("Enter the Member Id : ");
            int id = checkMemberId(Integer.parseInt(userChoice.readLine()));
            System.out.print("Enter the Name : ");
            String name = userChoice.readLine();
            System.out.print("Enter the Age : ");
            int age = Integer.parseInt(userChoice.readLine());
            System.out.print("Enter the Gender : ");
            String gender = userChoice.readLine();

            MembersInfo m1 = new MembersInfo(id, name, age, gender);
            addMemberFile(m1);
            viewMembers();
        } catch (NumberFormatException e) {
            System.out.println("\n" + "Please enter correct input" + "\n");
            check = false;
        }

        if (check == true) {
            System.out.println("\n" + "New Member added Successfully" + "\n");
            System.out.println("press 0 to main menu or enter 1 to add another Member");
            String userchoice = userChoice.readLine();
            if (userchoice.equals("0")) {
                memberOption();
            } else {
                addMember();
            }
        }
    }

    public boolean isAlreadyThere(int inp) {
        for (MembersInfo member : members) {
            if (member.getMemberId() == inp) {
                return true;
            }
        }
        return false;
    }

    public int checkMemberId(int id) throws IOException {
        if (isAlreadyThere(id)) {
            System.out.println("\nAleady Exisest change the MemberId\n");
            System.out.print("Enter another MemberId to Continue or Press 0 to main menu : ");
            int idOption = Integer.parseInt(userChoice.readLine());
            if (0 == idOption) {
                memberOption();
            }
            return checkMemberId(idOption);
        } else {
            return id;
        }
    }

    @Override
    public void removeMember(int rid) throws IOException {
        boolean status = false;
        if (isAlreadyThere(rid) == true) {
            Iterator<MembersInfo> itr = members.iterator();
            while (itr.hasNext()) {
                MembersInfo next = itr.next();
                if (rid == next.getMemberId()) {
                    itr.remove();
                    status = true;
                }
            }
        }
        changeMemberFile();
        if (status) {
            System.out.println("\n" + "Member Removed successfully" + "\n");
        } else {
            System.out.println("\n" + "Member id is doesn't Available, Try again with valid Member-Id Number");
        }
    }

}
