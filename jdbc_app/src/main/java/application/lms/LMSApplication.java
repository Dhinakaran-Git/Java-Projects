package application.lms;

import application.lms.dao.BookDAO;
import application.lms.dao.CollectBookDAO;
import application.lms.dao.IssueBookDAO;
import application.lms.dao.MemberInfoDAO;
import application.lms.dao.file.BookDAOFileImpl;
import application.lms.dao.file.CollectBookDAOFileImpl;
import application.lms.dao.file.IssueBookDAOFileImpl;
import application.lms.dao.file.MemberDAOFileImpl;
import application.lms.dao.jpa.BookDAOJpaImpl;
import application.lms.dao.jpa.CollectBookDAOJpaImpl;
import application.lms.dao.jpa.IssueBookDAOJpaImpl;
import application.lms.dao.jpa.MemberDAOJpaImpl;
import application.lms.dao.mysql.BookDAOMySQLImpl;
import application.lms.dao.mysql.CollectBookDAOMySQLImpl;
import application.lms.dao.mysql.DatabaseUtil;
import application.lms.dao.mysql.IssueBookDAOMySQLImpl;
import application.lms.dao.mysql.MemberDAOMySQLImpl;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Objects;

public class LMSApplication {

    public static final BufferedReader SELECT_CHOICE = new BufferedReader(new InputStreamReader(System.in));
    public static BookDAO b = null;
    public static MemberInfoDAO m = null;
    public static IssueBookDAO ib = null;
    public static CollectBookDAO cb = null;
    public static DatabaseUtil database = null;
    public static Connection con = null;

    public static void display() {
        System.out.println(" 1. View Books");
        System.out.println(" 2. View Book");
        System.out.println(" 3. Add Book");
        System.out.println(" 4. Remove Book");
        System.out.println(" 5. Members");
        System.out.println(" 6. To Issue a Book");
        System.out.println(" 7. See IssuedBooks");
        System.out.println(" 8. Collect Book");
        System.out.println(" 9. See Collected Book");
        System.out.println("10. Statistics");
        System.out.println("11. Exit");
    }

    public static void options() {
        while (true) {
            try {
                System.out.println("*".repeat(41));
                System.out.println("|\tLibrary Management System\t|");
                System.out.println("*".repeat(41));
                display();

                System.out.print("\n" + "Select Operation : ");
                String choice = SELECT_CHOICE.readLine();
                switch (choice) {
                    case "1":
                        System.out.println("\n" + "View Books");
                        System.out.println("----------");
                        b.viewBooks();
                        break;
                    case "2":
                        System.out.print("Enter the book title you want : ");
                        String title = SELECT_CHOICE.readLine();
                        b.viewBook(title.toLowerCase());
                        break;
                    case "3":
                        System.out.println("\n" + "ADD Books");
                        System.out.println("---------");
                        b.addBook();
                        break;
                    case "4":
                        System.out.println("\n" + "Remove Book");
                        System.out.println("-----------");
                        b.viewBooks();
                        System.out.print("Enter the ISBN-ID : ");
                        try {
                            int bookid = Integer.parseInt(SELECT_CHOICE.readLine());
                            b.removeBook(bookid);
                        } catch (NumberFormatException nfe) {
                            System.out.println("\n" + "Please enter correct input" + "\n");
                        }
                        break;
                    case "5":
                        m.memberOption();
                        break;
                    case "6":
                        System.out.println("\n" + "AddIssueBook");
                        System.out.println("------------");
                        ib.addIssueBook();
                        break;
                    case "7":
                        System.out.println("\n" + "IssuedBooks");
                        System.out.println("-----------");
                        ib.issuedBooks();
                        break;
                    case "8":
                        System.out.println("\n" + "CollectBooks");
                        System.out.println("------------");
                        cb.collectBook();
                        break;
                    case "9":
                        System.out.println("\n" + "CollectedBooks");
                        System.out.println("--------------");
                        cb.collectedBooks();
                        break;
                    case "10":
                        System.out.println("\n" + "Statistics");
                        System.out.println("----------");
                        b.statistics();
                        break;
                    case "11":
                        System.out.println("**".repeat(22));
                        System.out.println("Thanks for Visting our Library Management");
                        System.out.println("**".repeat(22));
                        if (Objects.nonNull(con)) {
                            con.close();
                        }
                        System.exit(0);
                        break;
                    default:
                        System.err.println("Please Read The Menuscript and Enter again!");
                }
            } catch (SQLException | IOException ex) {
                throw new Error("someting went worng : " + ex);
            }
        }
    }

    public static void main(String[] args) {
        while (true) {
            try {
                System.out.println("*".repeat(41));
                System.out.println("|\tLibrary Management System\t|");
                System.out.println("*".repeat(41));
                System.out.println("1. FILE");
                System.out.println("2. MYSQL");
                System.out.println("3. JPA With Hibernate");
                System.out.print("Enter the method you want : ");
                int use = Integer.parseInt(SELECT_CHOICE.readLine());
                switch (use) {
                    case 1:
                        b = new BookDAOFileImpl();
                        m = new MemberDAOFileImpl();
                        ib = new IssueBookDAOFileImpl();
                        cb = new CollectBookDAOFileImpl();
                        options();
                        break;
                    case 2:
                        database = new DatabaseUtil();
                        b = new BookDAOMySQLImpl();
                        m = new MemberDAOMySQLImpl();
                        ib = new IssueBookDAOMySQLImpl();
                        cb = new CollectBookDAOMySQLImpl();
                        options();
                        break;
                    case 3:
                        b = new BookDAOJpaImpl();
                        m = new MemberDAOJpaImpl();
                        ib = new IssueBookDAOJpaImpl();
                        cb = new CollectBookDAOJpaImpl();
                        options();
                        break;
                    default:
                        System.out.println("Please read the menuscript and Enter again!!");
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
