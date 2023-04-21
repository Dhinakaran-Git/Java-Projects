package library_management_system;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Librarian {

    Book[] books = {
        new Book(1001, "New Moons", "Suzanne", true),
        new Book(1002, "PHP", "Collins", true),
        new Book(1003, "Sql", "Newport", true),
        new Book(1004, "Javascript", "James", true),
        new Book(1005, "English", "Joe", false),
        new Book(1006, "Java", "Rupesh", false),
        new Book(1007, "C++", "Jenny", false)
    };

    IssueBook[] issueBooks = {
        new IssueBook(1005, "English", 108, "05-06-2021", false),
        new IssueBook(1006, "Java", 109, "15-07-2021", false),
        new IssueBook(1007, "C++", 110, "25-04-2021", false)
    };

    CollectBook[] collectBooks = {};

    BufferedReader selectChoice = new BufferedReader(new InputStreamReader(System.in));
    ManageMembers me = new ManageMembers();

    public static final String RED = "\u001B[31m";
    public static final String RESET = "\u001B[0m";
    public static final String BLUE = "\u001B[34m";
    public static final String GREEN = "\u001B[32m";
    public static final String CYAN = "\u001B[36m";

    public static void display() {
        System.out.println(" 1. View Books");
        System.out.println(" 2. View Book");
        System.out.println(" 3. Add Book");
        System.out.println(" 4. Remove Book");
        System.out.println(" 5. Members");
        System.out.println(" 6. AddIssueBook");
        System.out.println(" 7. IssuedBooks");
        System.out.println(" 8. Collect Book");
        System.out.println(" 9. Collected Book");
        System.out.println("10. Statistics");
        System.out.println("11. Exit");
    }

    public void options() throws IOException {
        while (true) {
            System.out.println(RED + "*".repeat(41) + RESET);
            System.out.println(BLUE + "|\tLibrary Management System\t|" + RESET);
            System.out.println(RED + "*".repeat(41) + RESET);
            display();

            System.out.print("\nSelect Operation : ");
            String choice = selectChoice.readLine();
            switch (choice) {
                case "1":
                    System.out.println("View Books");
                    System.out.println("----------");
                    viewBooks();
                    break;
                case "2":
                    System.out.print("Enter the book title you want : ");
                    String title = selectChoice.readLine();
                    viewBook(title);
                    break;
                case "3":
                    System.out.println("ADD Books");
                    System.out.println("---------");
                    addBook();
                    break;
                case "4":
                    System.out.println("Remove Book");
                    System.out.println("-----------");
                    viewBooks();
                    System.out.print("Enter the ISBN-ID : ");
                    int bookid = Integer.parseInt(selectChoice.readLine());
                    removeBook(bookid);
                    break;
                case "5":
                    System.out.println("Members Details");
                    System.out.println("---------------");
                    ManageMembers m = new ManageMembers();
                    m.memberOption();
                    break;
                case "6":
                    System.out.println("AddIssueBook");
                    System.out.println("------------");
                    addIssueBook();
                    break;
                case "7":
                    System.out.println("IssuedBooks");
                    System.out.println("-----------");
                    issuedBooks();
                    break;
                case "8":
                    System.out.println("CollectBooks");
                    System.out.println("------------");
                    collectBook();
                    break;
                case "9":
                    System.out.println("CollectedBooks");
                    System.out.println("--------------");
                    collectedBooks();
                    break;
                case "10":
                    System.out.println("Statistics");
                    System.out.println("----------");
                    statistics();
                    break;
                case "11":
                    System.out.println("**".repeat(22));
                    System.out.println("Thanks for Visting our Library Management");
                    System.out.println("**".repeat(22));
                    System.exit(0);
                    break;
                default:
                    System.err.println("Please Read The Menuscript and Enter again!");
            }
        }
    }

    public void viewBooks() {
        System.out.println("-".repeat(91));
        System.out.println(String.format("%8s %-5s %-20s %-20s %-18s %-18s", "ISBN_NO", "", "TITLE", "AUTHOR", "ISTHERE", "ISDAMAGED"));
        System.out.println("-".repeat(91));
        for (Book book : books) {
            System.out.println(book);
        }
        System.out.println("-".repeat(91));
    }

    public void viewBook(String title) {
        boolean isAvaliable = false;
        for (Book book : books) {
            if (title.replaceAll("\\s", "").equalsIgnoreCase(book.getTitle().replaceAll("\\s", ""))) {
                isAvaliable = true;
                viewBookDetails(book);
            }
        }

        if (!isAvaliable) {
            try {
                System.out.println("The book you searched is not available");
                System.out.print("Enter the Book title you want or E/e to Exit : ");
                String bookName = selectChoice.readLine();
                if ("E".equals(bookName.toUpperCase())) {
                    options();
                } else {
                    viewBook(bookName);
                }
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
    }

    public void viewBookDetails(Book b) {
        System.out.println("\n"+"*".repeat(42));
        System.out.println("This is the details of the book you need");
        System.out.println("*".repeat(42));
        System.out.println("ISBN NO     : " + b.getIsbn_No());
        System.out.println("BOOK NAME   : " + b.getTitle());
        System.out.println("AUTHOR NAME : " + b.getAuthor());
        System.out.println("*".repeat(42)+"\n");
    }

    public void addBook() {

        try {
            System.out.print("Enter the ISBN NO : ");
            int isbn_No = checkIsbn(Integer.parseInt(selectChoice.readLine()));
            System.out.print("Enter the Book Title : ");
            String b1 = selectChoice.readLine();
            System.out.print("Enter the Author Name : ");
            String author = selectChoice.readLine();
            boolean isThere = true;

            Book[] newBook = Arrays.copyOf(books, books.length + 1);
            newBook[newBook.length - 1] = new Book(isbn_No, b1, author, isThere);

            System.out.println("\n" + GREEN + "New Book added Successfully" + RESET + "\n");
            books = newBook;
            System.out.println("press 0 to main menu or enter 1 to add another Book");
            String userchoice = selectChoice.readLine();
            if (userchoice.equals("0")) {
                options();
            } else {
                addBook();
            }
            System.out.println("\n");
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public boolean isAlreadyThere(int inp) {
        for (Book book : books) {
            if (book.getIsbn_No() == inp) {
                return true;
            }
        }
        return false;
    }

    public int checkIsbn(int isbn) {
        if (isAlreadyThere(isbn)) {
            try {
                System.out.println("\nAleady Exisest change the ISBN\n");
                System.out.print("Enter another ISBN to continue or Press 0 to main menu : ");
                int isbnOption = Integer.parseInt(selectChoice.readLine());
                if (0 == isbnOption) {
                    options();
                }
                return checkIsbn(isbnOption);
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
        return isbn;
    }

    public void removeBook(int bookid) {
        Book[] remove_book = new Book[books.length - 1];
        boolean member_Removed = false;
        if (isAlreadyThere(bookid) == true) {
            for (int i = 0, j = 0; i < books.length; i++) {
                if (bookid != books[i].getIsbn_No()) {
                    remove_book[j++] = books[i];
                    member_Removed = true;
                }
            }
        } else {
            remove_book = new Book[books.length];
            for (int i = 0, j = 0; i < books.length; i++) {
                remove_book[j++] = books[i];
                member_Removed = false;
            }
        }
        books = remove_book;
        if (member_Removed) {
            System.out.println(GREEN + "Member Removed successfully" + RESET);
        } else {
            System.out.println("Member id is doesn't available, try again with valid isbn number");
        }
    }

    public void issuedBooks() {
        System.out.println("-".repeat(101));
        System.out.println(String.format("%-20s%-20s%-20s%-20s%-18s", "ISBN_NO", "Title", "MemberId", "IssuedDate", "IssueBookStatus"));
        System.out.println("-".repeat(101));

        for (int i = 0; i < issueBooks.length; i++) {
            System.out.println(issueBooks[i]);
        }
        System.out.println("-".repeat(101) + "\n");
    }

    public void addIssueBook() {
        try {
            System.out.print("enter the memberId - ");
            int memberId = Integer.parseInt(selectChoice.readLine());
            memberId = checkMemberId(memberId);

            System.out.print("Enter an book title to check the book is available or not - ");
            String title = selectChoice.readLine();
            String newtitle = checkTitle(title);
            int isbn = 0;
            for (int i = 0; i < books.length; i++) {
                if (books[i].isThere() && books[i].getTitle().trim().equalsIgnoreCase(newtitle)) {
                    isbn = books[i].getIsbn_No();
                    books[i].setIsThere(false);
                    break;
                }
            }
            System.out.print("enter an indate - ");
            String inDate = selectChoice.readLine();

            IssueBook newIssueBooks = new IssueBook(isbn, title, memberId, inDate, false);
            IssueBook[] newList = Arrays.copyOf(issueBooks, issueBooks.length + 1);
            newList[newList.length - 1] = newIssueBooks;
            issueBooks = newList;

            System.out.println("\n" + GREEN + "Book issued successfully" + RESET + "\n");
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public int checkMemberId(int memberId) throws IOException {
        boolean registered = false;
        for (int i = 0; i < me.members.length; i++) {
            if (me.members[i].getMemberId() == memberId) {
                registered = true;
            }
        }

        if (registered) {
            return memberId;
        } else {
            System.out.print("The memberId is not yet registered enter an registered id - ");
            int reEnter = Integer.parseInt(selectChoice.readLine());
            return checkMemberId(reEnter);
        }
    }

    public String checkTitle(String title) throws IOException {
        boolean available = false;
        for (int i = 0; i < books.length; i++) {
            if (books[i].getTitle().trim().equalsIgnoreCase(title.trim())) {
                available = true;
                break;
            }
        }
        if (available) {
            return title;
        } else {
            System.out.print("\nThe book is not avaiable please enter an another book title : ");
            return checkTitle(selectChoice.readLine());
        }
    }

    public int checkIsbnNo(int isbn) throws IOException {
        boolean validIsbn = false;
        for (Book book : books) {
            if (book.getIsbn_No() == isbn) {
                validIsbn = true;
            }
        }

        if (validIsbn) {
            return isbn;
        } else {
            System.out.print("the entered isbn is not matching to the available books in the library enter an valid isbn - ");
            int newOne = Integer.parseInt(selectChoice.readLine());
            return checkIsbn(newOne);
        }

    }

    public void collectBook() {
        try {
            System.out.print("enter the memberId - ");
            int memberId = Integer.parseInt(selectChoice.readLine());
            memberId = checkMemberId(memberId);
            System.out.print("enter an isbn - ");
            int isbn = Integer.parseInt(selectChoice.readLine());
            isbn = checkIsbnNo(isbn);
            if (!verifyIssuedBooks(memberId, isbn)) {
                options();
            }
            System.out.print("enter an outDate - ");
            String outDate = selectChoice.readLine();

            System.out.print("is damaged type y/N - ");
            String input = selectChoice.readLine();
            boolean isDamaged = false;
            if (input.toLowerCase().charAt(0) == 'y') {
                isDamaged = true;
                for (int i = 0; i < books.length; i++) {
                    if (books[i].getIsbn_No() == isbn) {
                        books[i].setIsDamaged(true);
                    }
                }
            }

            CollectBook newCollected = new CollectBook(isbn, memberId, outDate, isDamaged);
            CollectBook[] newList = Arrays.copyOf(collectBooks, collectBooks.length + 1);
            newList[newList.length - 1] = newCollected;
            collectBooks = newList;

            System.out.println("\n" + GREEN + "Book collected successfullly..." + RESET + "\n");
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public boolean verifyIssuedBooks(int memberId, int isbn) throws IOException {
        boolean validIsbn = false;
        boolean isTakenBook = true;

        for (int i = 0; i < issueBooks.length; i++) {
            if (issueBooks[i].getMemberId() == memberId && issueBooks[i].isIssueBookStatus()) {
                isTakenBook = false;
            }

            if (issueBooks[i].getMemberId() == memberId && issueBooks[i].getIsbnId() == isbn && !issueBooks[i].isIssueBookStatus()) {
                issueBooks[i].setIssueBookStatus(true);
                validIsbn = true;
                for (int j = 0; j < books.length; j++) {
                    if (books[j].getIsbn_No() == issueBooks[i].getIsbnId()) {
                        books[j].setIsThere(true);
                        break;
                    }
                }
                break;
            }
        }

        if (validIsbn) {
            return true;

        } else {
            if (isTakenBook) {
                System.out.println("");
                System.out.print("the enterd member id not taken any book so far enter an another memberId or type e/E to move  main menu - ");
                String input = selectChoice.readLine();
                if (input.toLowerCase().charAt(0) == 'e') {
                    return false;
                } else {
                    return verifyIssuedBooks(checkMemberId(Integer.parseInt(input)), isbn);
                }
            } else {
                System.out.println("");
                System.out.print("the member taken the different book please provide the taken books isbn or type e/E to move main menu - ");
                String input = selectChoice.readLine();
                if (input.toLowerCase().charAt(0) == 'e') {
                    return false;
                } else {
                    return verifyIssuedBooks(memberId, checkIsbnNo(Integer.parseInt(input)));
                }
            }
        }

    }

    public void collectedBooks() {
        if (collectBooks.length != 0) {
            System.out.println("-".repeat(81));
            System.out.println(String.format("%-20s%-20s%-20s%-18s", "ISBN_NO", "MemberId", "collectDate", "CollectBookStatus"));
            System.out.println("-".repeat(81));
            for (int i = 0; i < collectBooks.length; i++) {
                System.out.println(collectBooks[i]);
            }
            System.out.println("-".repeat(81));
            System.out.println("");
        } else {
            System.out.println("*".repeat(55));
            System.out.println("*           Oops no books are collected yet           *");
            System.out.println("*".repeat(55));
        }
    }

    public void statistics() {
        System.out.println("-".repeat(104));
        System.out.println(String.format("%-22s%-22s%-22s%-22s%-22s", "Total No Of Books", "Available Books", "To be Returned", "Total No of Members", "Damaged Books"));
        System.out.println("-".repeat(104));
        int totalNoOfBooks = books.length, availableBooks = 0, toBeReturned = 0, totalNoOfMembers = me.members.length, damagedBooks = 0;

        for (int i = 0; i < books.length; i++) {
            if (books[i].isThere()) {
                availableBooks++;
            }
            if (books[i].isIsDamaged()) {
                damagedBooks++;
            }
        }

        for (int i = 0; i < issueBooks.length; i++) {
            if (!issueBooks[i].isIssueBookStatus()) {
                toBeReturned++;
            }
        }
        System.out.println(String.format("%-22s%-22s%-22s%-22s%-22s", totalNoOfBooks, availableBooks, toBeReturned, totalNoOfMembers, damagedBooks));
        System.out.println("-".repeat(104));
    }
}
