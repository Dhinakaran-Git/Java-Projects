package lms_with_files_v3;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import static lms_with_files_v3.Librarian.BLUE;
import static lms_with_files_v3.Librarian.GREEN;
import static lms_with_files_v3.Librarian.RED;
import static lms_with_files_v3.Librarian.RESET;

public class ManageMembers {

    List<MembersInfo> members = new ArrayList<>();

    BufferedReader userChoice = new BufferedReader(new InputStreamReader(System.in));

    private DataInputStream dataInput = null;
    private DataOutputStream dataOutput = null;

    public void readMember() {
        members.clear();
        try {
            dataInput = new DataInputStream(new FileInputStream("/home/bas200137/NetBeansProjects/Library Management System/src/lms_with_files_v3/Members.txt"));

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
            dataOutput = new DataOutputStream(new FileOutputStream("/home/bas200137/NetBeansProjects/Library Management System/src/lms_with_files_v3/Members.txt", true));
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
            dataOutput = new DataOutputStream(new FileOutputStream("/home/bas200137/NetBeansProjects/Library Management System/src/lms_with_files_v3/Members.txt"));
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

    public void memberOption() throws IOException {
        while (true) {
            System.out.println(BLUE + "------------------------------" + RESET);
            System.out.println(BLUE + "|   Library Members Details  |" + RESET);
            System.out.println(BLUE + "------------------------------" + RESET);
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
                        System.out.println("\n" + RED + "Please enter correct input" + RESET + "\n");
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
                    Librarian li = new Librarian();
                    li.options();
                    break;
                default:
                    System.out.println(RED + "Please Read The Menuscript and Enter again!" + RESET);
            }
        }
    }

    {
        readMember();
    }

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
            System.out.println("\n" + RED + "Please enter correct input" + RESET + "\n");
            check = false;
        }

        if (check == true) {
            System.out.println("\n" + GREEN + "New Member added Successfully" + RESET + "\n");
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
            System.out.println(GREEN + "\n" + "Member Removed successfully" + "\n" + RESET);
        } else {
            System.out.println("\n" + "Member id is doesn't Available, Try again with valid Member-Id Number");
        }
    }
}
