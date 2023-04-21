package lms_with_arrays_v1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import static lms_with_arrays_v1.Librarian.BLUE;
import static lms_with_arrays_v1.Librarian.GREEN;
import static lms_with_arrays_v1.Librarian.RED;
import static lms_with_arrays_v1.Librarian.RESET;

public class ManageMembers {

    MembersInfo[] members = {
        new MembersInfo(101, "Gokulraj", 22, "male"),
        new MembersInfo(102, "Daniel", 20, "male"),
        new MembersInfo(103, "Dhinakaran", 24, "male"),
        new MembersInfo(104, "Moosa", 24, "male"),
        new MembersInfo(105, "Velsamy", 22, "male"),
        new MembersInfo(106, "Deva", 25, "male"),
        new MembersInfo(107, "Durga", 22, "Female"),
        new MembersInfo(108, "Rajali", 24, "Female"),
        new MembersInfo(109, "Sam", 24, "Male"),
        new MembersInfo(110, "Tamil", 22, "Male")
    };

    BufferedReader userChoice = new BufferedReader(new InputStreamReader(System.in));

    public static void memberDisplay() {
        System.out.println("1. View Members");
        System.out.println("2. View Member");
        System.out.println("3. Add Member");
        System.out.println("4. Remove Member");
        System.out.println("5. Exit to BookMenu");
    }

    public void memberOption() throws IOException {
        
        while (true) {
            System.out.println("\n"+BLUE+"------------------------------");
            System.out.println(BLUE+"|   Library Members Details  |");
            System.out.println("------------------------------"+RESET);
            memberDisplay();

            System.out.print("\nSelect Operation : ");

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
                    int vMember = Integer.parseInt(userChoice.readLine());
                    viewMember(vMember);
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
                    System.out.println("Exit to member");
                    System.out.println("----------------");
                    break;
                default:
                    System.out.println(RED + "Please Read The Menuscript and Enter again!" + RESET);
            }
        }
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
        System.out.println("\nThis is the details of the Member you need\n");
        System.out.println("Member Id : " + m.getMemberId());
        System.out.println("Name      : " + m.getName());
        System.out.println("Age       : " + m.getAge());
        System.out.println("Gender    : " + m.getGender());
    }

    public void viewMember(int id) throws IOException {
        boolean isAval = false;
        for (int i = 0; i < members.length; i++) {
            if (members[i].getMemberId() == id) {
                isAval = true;
                displayMember(members[i]);
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
        System.out.print("Enter the Member Id : ");
        int id = checkMemberId(Integer.parseInt(userChoice.readLine()));
        System.out.print("Enter the Name : ");
        String name = userChoice.readLine();
        System.out.print("Enter the Age : ");
        int age = Integer.parseInt(userChoice.readLine());
        System.out.print("Enter the Gender : ");
        String gender = userChoice.readLine();

        MembersInfo[] newMember = Arrays.copyOf(members, members.length + 1);
        newMember[newMember.length - 1] = new MembersInfo(id, name, age, gender);

        System.out.println("\n" + GREEN + "New Member added Successfully" + RESET + "\n");
        members = newMember;
        System.out.println("press 0 to main menu or enter 1 to add another Book");
        String userchoice = userChoice.readLine();
        if (userchoice.equals("0")) {
            memberOption();
        } else {
            addMember();
        }
        System.out.println("\n");
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
        MembersInfo[] removeMember = new MembersInfo[members.length - 1];
        boolean status = false;
        if (isAlreadyThere(rid) == true) {
            for (int i = 0, j = 0; i < members.length; i++) {
                if (rid != members[i].getMemberId()) {
                    removeMember[j++] = members[i];
                    status = true;
                }
            }
        } else {
            removeMember = new MembersInfo[members.length];
            for (int i = 0, j = 0; i < members.length; i++) {
                removeMember[j++] = members[i];
                status = false;
            }
        }
        members = removeMember;
        if (status) {
            System.out.println(GREEN + "\nMember Removed successfully" + RESET);
        } else {
            System.out.println("\nMember id is doesn't Available, Try again with valid Member-Id Number");
        }
    }
}
