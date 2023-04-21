package application.lms.dao.file;

import application.lms.dao.BookDAO;
import application.lms.model.Book;
import application.lms.model.IssueBook;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class BookDAOFileImpl implements BookDAO {

    List<Book> booksAl = new ArrayList<>();
    BufferedReader selectChoice = new BufferedReader(new InputStreamReader(System.in));

    static MemberDAOFileImpl memb;
    static IssueBookDAOFileImpl iss;

    private DataOutputStream dataOutput = null;
    private DataInputStream dataInput = null;
    File fileLoc = new File("/home/bas200137/NetBeansProjects/jdbc_app/src/main/java/application/lms/dao/file/Books.txt");

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
            dataInput = new DataInputStream(new FileInputStream(fileLoc));

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
            dataOutput = new DataOutputStream(new FileOutputStream(fileLoc, true));
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

    public void updateBookList() {
        try {
            dataOutput = new DataOutputStream(new FileOutputStream(fileLoc));
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

    {
        readBook();
    }

    @Override
    public void viewBooks() throws IOException {
        System.out.println("-".repeat(91));
        System.out.println(String.format("%8s %-5s %-20s %-20s %-18s %-18s", "ISBN_NO", "", "TITLE", "AUTHOR", "ISTHERE", "ISDAMAGED"));
        System.out.println("-".repeat(91));
        for (Book book : booksAl) {
            System.out.println(book);
        }
        System.out.println("-".repeat(91));
    }

    @Override
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
//                    options();
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

    @Override
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
            System.out.println("\n" + "New Book added Successfully" + "\n");
            viewBooks();
            System.out.print("press 0 to main menu or enter 1 to add another Book : ");
            String userchoice = selectChoice.readLine();
            if (userchoice.equals("0")) {
//                options();
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
//                    options();
                }
                return checkIsbn(isbnOption);
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
        return isbn;
    }

    @Override
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
        updateBookList();
        if (book_Removed) {
            System.out.println("\n" + "Book Removed successfully" + "\n");
        } else {
            System.out.println("Books is not avaliable, try again with valid isbn number");
        }
    }

    @Override
    public void statistics() {
        System.out.println("-".repeat(104));
        System.out.println(String.format("%-22s%-22s%-22s%-22s%-22s", "Total No Of Books", "Available Books", "To be Returned", "Total No of Members", "Damaged Books"));
        System.out.println("-".repeat(104));
        int totalNoOfBooks = booksAl.size(), availableBooks = 0, toBeReturned = 0, totalNoOfMembers = memb.getMembers().size(), damagedBooks = 0;

        for (Book book : booksAl) {
            if (book.isThere()) {
                availableBooks++;
            }
            if (book.isIsDamaged()) {
                damagedBooks++;
            }
        }

        for (IssueBook issueBook : iss.getIssueBooks()) {
            if (!issueBook.isIssueBookStatus()) {
                toBeReturned++;
            }
        }
        System.out.println(String.format("%-22s%-22s%-22s%-22s%-22s", totalNoOfBooks, availableBooks, toBeReturned, totalNoOfMembers, damagedBooks));
        System.out.println("-".repeat(104));
    }

    public List<Book> getBooksAl() {
        return booksAl;
    }
}
