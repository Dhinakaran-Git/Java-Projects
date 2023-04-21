package application.lms.dao.file;

import application.lms.LMSApplication;
import application.lms.dao.BookDAO;
import application.lms.dao.IssueBookDAO;
import application.lms.dao.MemberInfoDAO;
import static application.lms.dao.file.BookDAOFileImpl.memb;
import application.lms.model.Book;
import application.lms.model.IssueBook;
import application.lms.model.MembersInfo;
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
import java.util.List;
import java.util.Objects;

public class IssueBookDAOFileImpl implements IssueBookDAO {

    List<IssueBook> issueBooks = new ArrayList<>();
    BufferedReader selectChoice = new BufferedReader(new InputStreamReader(System.in));

    MemberInfoDAO me = LMSApplication.m;
    BookDAO b = LMSApplication.b;
    static BookDAOFileImpl bf;
    
    private DataOutputStream dataOutput = null;
    private DataInputStream dataInput = null;
    File fileLoc = new File("/home/bas200137/NetBeansProjects/jdbc_app/src/main/java/application/lms/dao/file/Issuebook.txt");

    public List<IssueBook> getIssueBooks() {
        return issueBooks;
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
            dataInput = new DataInputStream(new FileInputStream(fileLoc));

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
            dataOutput = new DataOutputStream(new FileOutputStream(fileLoc, true));
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
            dataOutput = new DataOutputStream(new FileOutputStream(fileLoc));
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

    {
        readIssueBook();
    }

    @Override
    public void issuedBooks() {
        System.out.println("-".repeat(101));
        System.out.println(String.format("%-20s%-20s%-20s%-20s%-18s", "ISBN_NO", "Title", "MemberId", "IssuedDate", "IssueBookStatus"));
        System.out.println("-".repeat(101));
        for (IssueBook issubook : issueBooks) {
            System.out.println(issubook);
        }
        System.out.println("-".repeat(101) + "\n");
    }

    @Override
    public void addIssueBook() {
        try {
            boolean issued = false;
            System.out.print("enter the memberId - ");
            int memberId = Integer.parseInt(selectChoice.readLine());
            memberId = checkMemberId(memberId);

            System.out.print("Enter a book title to check the book is available : ");
            String title = checkTitle(selectChoice.readLine());
            int isbn = 0;
            for (Book book : bf.getBooksAl()) {
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
                bf.updateBookList();
                issuedBooks();
                System.out.println("\n" + "Book issued successfully" + "\n");
            } else {
                System.out.println("\n" + "The Book is already taken and the book is not Avaliable" + "\n");
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (NumberFormatException nfe) {
            System.out.println("\n" + "Please enter correct input" + "\n");
        }
    }
    
    
    public int checkMemberId(int memberId) throws IOException {
        boolean registered = false;
        for (MembersInfo member : memb.getMembers()) {
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
        for (Book book : bf.getBooksAl()) {
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
}
