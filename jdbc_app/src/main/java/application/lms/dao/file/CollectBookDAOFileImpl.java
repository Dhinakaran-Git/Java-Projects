package application.lms.dao.file;

import application.lms.LMSApplication;
import application.lms.dao.CollectBookDAO;
import application.lms.model.Book;
import application.lms.model.CollectBook;
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

public class CollectBookDAOFileImpl implements CollectBookDAO {

    List<CollectBook> collectBooks = new ArrayList<>();
    BufferedReader selectChoice = new BufferedReader(new InputStreamReader(System.in));
    BookDAOFileImpl b = new BookDAOFileImpl();
    MemberDAOFileImpl me = new MemberDAOFileImpl();
    IssueBookDAOFileImpl ib = new IssueBookDAOFileImpl();

    private DataOutputStream dataOutput = null;
    private DataInputStream dataInput = null;
    File fileLoc = new File("/home/bas200137/NetBeansProjects/jdbc_app/src/main/java/application/lms/dao/file/Colletbook.txt");

    public void writeCollect(CollectBook col) throws IOException {
        dataOutput.writeInt(col.getBookid());
        dataOutput.writeInt(col.getMemberId());
        dataOutput.writeUTF(col.getCollectDate());
        dataOutput.writeBoolean(col.isCollectBookStatus());
    }

    public void readCollectBook() {
        collectBooks.clear();
        try {
            dataInput = new DataInputStream(new FileInputStream(fileLoc));

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
            dataOutput = new DataOutputStream(new FileOutputStream(fileLoc, true));
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

    {
        readCollectBook();
    }

    @Override
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

    public int checkIsbnNo(int isbn) throws IOException {
        boolean validIsbn = false;
        for (Book book : b.booksAl) {
            if (book.getIsbn_No() == isbn) {
                validIsbn = true;
            }
        }
        if (validIsbn) {
            return isbn;
        } else {
            System.out.print("The Entered ISBN is not Matching to the available books in the library enter an valid isbn - ");
            int newOne = Integer.parseInt(selectChoice.readLine());
            return checkIsbnNo(newOne);
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

    @Override
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
                LMSApplication.options();
            }

            //If condition satistify then only enter outdate
            System.out.print("enter an outDate - ");
            String outDate = selectChoice.readLine();

            System.out.print("is damaged type y/N - ");
            String input = selectChoice.readLine();
            boolean isDamaged = false;
            if (input.toLowerCase().charAt(0) == 'y') {
                isDamaged = true;
                for (Book book : b.booksAl) {
                    if (book.getIsbn_No() == isbn) {
                        book.setIsDamaged(true);
                    }
                }
            }

            CollectBook ncollect = new CollectBook(isbn, memberId, outDate, isDamaged);
            addCollectBookFile(ncollect);
            b.updateBookList();
            ib.changeIssueBookFile();
            collectedBooks();

            System.out.println("\n" + "Book collected successfullly..." + "\n");
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (NumberFormatException nfe) {
            System.out.println("\n" + "Please enter correct input" + "\n");
        }
    }

    public boolean verifyIssuedBooks(int memberId, int isbn) throws IOException {
        boolean validIsbn = false;
        boolean isTakenBook = true;

        for (IssueBook issueBook : ib.issueBooks) {
            if (issueBook.getMemberId() == memberId && !issueBook.isIssueBookStatus()) {
                isTakenBook = false;
            }

            if (issueBook.getMemberId() == memberId && issueBook.getIsbnId() == isbn && issueBook.isIssueBookStatus()) {
                issueBook.setIssueBookStatus(false);
                validIsbn = true;
                for (Book book : b.booksAl) {
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
}
