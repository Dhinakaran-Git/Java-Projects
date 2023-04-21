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

public class Librarian {

    List<Book> booksAl = new ArrayList<>();
    List<IssueBook> issueBooks = new ArrayList<>();
    List<CollectBook> collectBooks = new ArrayList<>();

    BufferedReader selectChoice = new BufferedReader(new InputStreamReader(System.in));

    private DataOutputStream dataOutput = null;
    private DataInputStream dataInput = null;

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
        System.out.println(" 6. To Issue a Book");
        System.out.println(" 7. See IssuedBooks");
        System.out.println(" 8. Collect Book");
        System.out.println(" 9. See Collected Book");
        System.out.println("10. Statistics");
        System.out.println("11. Exit");
    }

    public void writeBook(Book books) throws IOException {
        dataOutput.writeInt(books.getIsbn_No());
        dataOutput.writeUTF(books.getTitle());
        dataOutput.writeUTF(books.getAuthor());
        dataOutput.writeBoolean(books.isThere());
        dataOutput.writeBoolean(books.isIsDamaged());
    }

    public void readBook() {
        booksAl.clear();
        try {
            dataInput = new DataInputStream(new FileInputStream("/home/bas200137/NetBeansProjects/Library Management System/src/lms_with_files_v3/Books.txt"));

            while (true) {
                try {
                    Book b1 = new Book(dataInput.readInt(), dataInput.readUTF(), dataInput.readUTF(), dataInput.readBoolean(), dataInput.readBoolean());
                    booksAl.add(b1);
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

    public void addBookFile(Book fbook) {
        try {
            dataOutput = new DataOutputStream(new FileOutputStream("/home/bas200137/NetBeansProjects/Library Management System/src/lms_with_files_v3/Books.txt", true));
            writeBook(fbook);
            readBook();
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

    public void changeBookFile() {
        try {
            dataOutput = new DataOutputStream(new FileOutputStream("/home/bas200137/NetBeansProjects/Library Management System/src/lms_with_files_v3/Books.txt"));
            for (Book nbook : booksAl) {
                writeBook(nbook);
            }
            readBook();
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

    public void writeIssue(IssueBook is) throws IOException {
        dataOutput.writeInt(is.getIsbnId());
        dataOutput.writeUTF(is.getTitle());
        dataOutput.writeInt(is.getMemberId());
        dataOutput.writeUTF(is.getIssuedDate());
        dataOutput.writeBoolean(is.isIssueBookStatus());
    }

    public void readIssueBook() {
        issueBooks.clear();
        try {
            dataInput = new DataInputStream(new FileInputStream("/home/bas200137/NetBeansProjects/Library Management System/src/lms_with_files_v3/Issuebook.txt"));

            while (true) {
                try {

                    IssueBook is1 = new IssueBook(dataInput.readInt(), dataInput.readUTF(), dataInput.readInt(), dataInput.readUTF(), dataInput.readBoolean());
                    issueBooks.add(is1);
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

    public void addIssueBookFile(IssueBook issue) {
        try {
            dataOutput = new DataOutputStream(new FileOutputStream("/home/bas200137/NetBeansProjects/Library Management System/src/lms_with_files_v3/Issuebook.txt", true));
            writeIssue(issue);
            readIssueBook();
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

    public void changeIssueBookFile() {
        try {
            dataOutput = new DataOutputStream(new FileOutputStream("/home/bas200137/NetBeansProjects/Library Management System/src/lms_with_files_v3/Issuebook.txt"));
            for (IssueBook issubook : issueBooks) {
                writeIssue(issubook);
            }
            readIssueBook();
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

    public void writeCollect(CollectBook col) throws IOException {
        dataOutput.writeInt(col.getBookid());
        dataOutput.writeInt(col.getMemberId());
        dataOutput.writeUTF(col.getCollectDate());
        dataOutput.writeBoolean(col.isCollectBookStatus());
    }

    public void readCollectBook() {
        collectBooks.clear();
        try {
            dataInput = new DataInputStream(new FileInputStream("/home/bas200137/NetBeansProjects/Library Management System/src/lms_with_files_v3/Colletbook.txt"));

            while (true) {
                try {
                    CollectBook c1 = new CollectBook(dataInput.readInt(), dataInput.readInt(), dataInput.readUTF(), dataInput.readBoolean());
                    collectBooks.add(c1);
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

    public void addCollectBookFile(CollectBook col) {
        try {
            dataOutput = new DataOutputStream(new FileOutputStream("/home/bas200137/NetBeansProjects/Library Management System/src/lms_with_files_v3/Colletbook.txt", true));
            writeCollect(col);
            readCollectBook();
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
                    try {
                        int bookid = Integer.parseInt(selectChoice.readLine());
                        removeBook(bookid);
                    } catch (NumberFormatException nfe) {
                        System.out.println("\n" + RED + "Please enter correct input" + RESET + "\n");
                    }

                    break;
                case "5":
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

    {
        readBook();
        readIssueBook();
        readCollectBook();
    }

    public void viewBooks() throws IOException {
        System.out.println("-".repeat(91));
        System.out.println(String.format("%8s %-5s %-20s %-20s %-18s %-18s", "ISBN_NO", "", "TITLE", "AUTHOR", "ISTHERE", "ISDAMAGED"));
        System.out.println("-".repeat(91));
        for (Book book : booksAl) {
            System.out.println(book);
        }
        System.out.println("-".repeat(91));
    }

    public void viewBook(String title) {
        boolean isAvaliable = false;
        for (Book book : booksAl) {
            if (title.replaceAll("\\s", "").equalsIgnoreCase(book.getTitle().replaceAll("\\s", ""))) {
                isAvaliable = true;
                viewBookDetails(book);
            }
        }

        if (!isAvaliable) {
            try {
                System.out.println("\n" + "The book you searched is not available" + "\n");
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
        System.out.println("\n" + "*".repeat(42));
        System.out.println("This is the details of the book you need");
        System.out.println("*".repeat(42));
        System.out.println("ISBN NO     : " + b.getIsbn_No());
        System.out.println("BOOK NAME   : " + b.getTitle());
        System.out.println("AUTHOR NAME : " + b.getAuthor());
        System.out.println("*".repeat(42) + "\n");
    }

    public void addBook() throws IOException {
        boolean check = true;
        try {
            System.out.print("Enter the ISBN NO : ");
            int isbn_No = checkIsbn(Integer.parseInt(selectChoice.readLine()));
            System.out.print("Enter the Book Title : ");
            String b1 = selectChoice.readLine();
            System.out.print("Enter the Author Name : ");
            String author = selectChoice.readLine();
            boolean isThere = true;
            boolean isDamage = false;

            Book fbook = new Book(isbn_No, b1, author, isThere, isDamage);
            addBookFile(fbook);
        } catch (NumberFormatException nfe) {
            System.out.println("\n" + "Please enter correct input" + "\n");
            check = false;
        }

        if (check == true) {
            System.out.println("\n" + GREEN + "New Book added Successfully" + RESET + "\n");
            viewBooks();
            System.out.print("press 0 to main menu or enter 1 to add another Book : ");
            String userchoice = selectChoice.readLine();
            if (userchoice.equals("0")) {
                options();
            } else {
                addBook();
            }
        }
    }

    public boolean isAlreadyThere(int inp) {
        for (Book book : booksAl) {
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
        boolean book_Removed = false;
        if (isAlreadyThere(bookid) == true) {

            Iterator<Book> itr = booksAl.iterator();
            while (itr.hasNext()) {
                Book next = itr.next();
                if (bookid == next.getIsbn_No() && next.isThere() == true) {
                    itr.remove();
                    book_Removed = true;
                }
            }
        }
        changeBookFile();
        if (book_Removed) {
            System.out.println("\n" + GREEN + "Book Removed successfully" + RESET + "\n");
        } else {
            System.out.println("Books is not avaliable, try again with valid isbn number");
        }
    }

    public void issuedBooks() {
        System.out.println("-".repeat(101));
        System.out.println(String.format("%-20s%-20s%-20s%-20s%-18s", "ISBN_NO", "Title", "MemberId", "IssuedDate", "IssueBookStatus"));
        System.out.println("-".repeat(101));
        for (IssueBook issubook : issueBooks) {
            System.out.println(issubook);
        }
        System.out.println("-".repeat(101) + "\n");
    }

    public void addIssueBook() {
        try {
            boolean issued = false;
            System.out.print("enter the memberId - ");
            int memberId = Integer.parseInt(selectChoice.readLine());
            memberId = checkMemberId(memberId);

            System.out.print("Enter a book title to check the book is available : ");
            String title = checkTitle(selectChoice.readLine());
            int isbn = 0;
            for (Book book : booksAl) {
                if (book.isThere() && book.getTitle().trim().equalsIgnoreCase(title)) {
                    isbn = book.getIsbn_No();
                    book.setIsThere(false);
                    issued = true;
                    break;
                }
            }
            if (issued) {
                System.out.print("enter an indate - ");
                String inDate = selectChoice.readLine();
                IssueBook issue = new IssueBook(isbn, title, memberId, inDate, true);
                addIssueBookFile(issue);
                changeBookFile();
                issuedBooks();
                System.out.println("\n" + GREEN + "Book issued successfully" + RESET + "\n");
            } else {
                System.out.println("\n" + "The Book is already taken and the book is not Avaliable" + "\n");
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (NumberFormatException nfe) {
            System.out.println("\n" + RED + "Please enter correct input" + RESET + "\n");
        }
    }

    public int checkMemberId(int memberId) throws IOException {
        boolean registered = false;
        for (MembersInfo member : me.members) {
            if (member.getMemberId() == memberId) {
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
        for (Book book : booksAl) {
            if (book.getTitle().trim().equalsIgnoreCase(title.trim())) {
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
        for (Book book : booksAl) {
            if (book.getIsbn_No() == isbn) {
                validIsbn = true;
            }
        }
        if (validIsbn) {
            return isbn;
        } else {
            System.out.print("The Entered ISBN is not Matching to the available books in the library enter an valid isbn - ");
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

            //To check the correct member is return and correct book is return
            if (!verifyIssuedBooks(memberId, isbn)) {
                options();
            }

            //If condition satistify then only enter outdate
            System.out.print("enter an outDate - ");
            String outDate = selectChoice.readLine();

            System.out.print("is damaged type y/N - ");
            String input = selectChoice.readLine();
            boolean isDamaged = false;
            if (input.toLowerCase().charAt(0) == 'y') {
                isDamaged = true;
                for (Book book : booksAl) {
                    if (book.getIsbn_No() == isbn) {
                        book.setIsDamaged(true);
                    }
                }
            }

            CollectBook ncollect = new CollectBook(isbn, memberId, outDate, isDamaged);
            addCollectBookFile(ncollect);
            changeBookFile();
            changeIssueBookFile();
            collectedBooks();

            System.out.println("\n" + GREEN + "Book collected successfullly..." + RESET + "\n");
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (NumberFormatException nfe) {
            System.out.println("\n" + RED + "Please enter correct input" + RESET + "\n");
        }
    }

    public boolean verifyIssuedBooks(int memberId, int isbn) throws IOException {
        boolean validIsbn = false;
        boolean isTakenBook = true;

        for (IssueBook issueBook : issueBooks) {
            if (issueBook.getMemberId() == memberId && !issueBook.isIssueBookStatus()) {
                isTakenBook = false;
            }

            if (issueBook.getMemberId() == memberId && issueBook.getIsbnId() == isbn && issueBook.isIssueBookStatus()) {
                issueBook.setIssueBookStatus(false);
                validIsbn = true;
                for (Book book : booksAl) {
                    if (book.getIsbn_No() == issueBook.getIsbnId()) {
                        book.setIsThere(true);
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
        if (!collectBooks.isEmpty()) {
            System.out.println("-".repeat(81));
            System.out.println(String.format("%-20s%-20s%-20s%-18s", "ISBN_NO", "MemberId", "collectDate", "CollectBookStatus"));
            System.out.println("-".repeat(81));
            for (CollectBook collect : collectBooks) {
                System.out.println(collect);
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
        int totalNoOfBooks = booksAl.size(), availableBooks = 0, toBeReturned = 0, totalNoOfMembers = me.members.size(), damagedBooks = 0;

        for (Book book : booksAl) {
            if (book.isThere()) {
                availableBooks++;
            }
            if (book.isIsDamaged()) {
                damagedBooks++;
            }
        }

        for (IssueBook issueBook : issueBooks) {
            if (!issueBook.isIssueBookStatus()) {
                toBeReturned++;
            }
        }
        System.out.println(String.format("%-22s%-22s%-22s%-22s%-22s", totalNoOfBooks, availableBooks, toBeReturned, totalNoOfMembers, damagedBooks));
        System.out.println("-".repeat(104));
    }
}