package application.lms.dao.mysql;

import application.lms.LMSApplication;
import static application.lms.LMSApplication.con;
import application.lms.dao.BookDAO;
import application.lms.model.Book;
import java.io.BufferedReader;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BookDAOMySQLImpl implements BookDAO {

    BufferedReader selectChoice = LMSApplication.SELECT_CHOICE;

    public BookDAOMySQLImpl() {
        con = LMSApplication.database.getConnection();
    }

    @Override
    public void viewBooks() throws IOException {
        try ( Statement st = con.createStatement();  ResultSet rs = st.executeQuery("select b.Isbn_no, b.title, a.Name as Author_Name, bc.Book_Status from lms_BookCopies as bc join lms_Books as b on b.Book_id = bc.Book_id join lms_Author_Book as lmsa on b.Book_id = lmsa.Book_id join lms_Author as a on lmsa.Author_id = a.Author_id;")) {
            if (rs.next()) {
                System.out.println("-".repeat(68));
                System.out.println(String.format("%8s %-5s %-20s %-20s %-18s", "ISBN_NO", "", "TITLE", "AUTHOR", "ISAVILABLE"));
                System.out.println("-".repeat(68));
                do {
                    System.out.println(String.format("%8s %-5s %-20s %-20s %-18s", rs.getInt(1), " ", rs.getString(2), rs.getString(3), rs.getString(4)));
                } while (rs.next());
                System.out.println("-".repeat(68));
            }
        } catch (SQLException ex) {
            System.out.println("Something went worng");
        }
    }

    @Override
    public void viewBook(String title) {
        String bookDetalis = "select b.Isbn_no, b.title, a.Name as Author_Name, bc.Book_Status from lms_BookCopies as bc join lms_Books as b on b.Book_id = bc.Book_id and b.title = '" + title + "' join lms_Author_Book as lmsa on b.Book_id = lmsa.Book_id join lms_Author as a on lmsa.Author_id = a.Author_id;";
        try ( Statement st = con.createStatement();  ResultSet rs = st.executeQuery(bookDetalis)) {
            boolean isAval = false;
            if (rs.next()) {
                isAval = true;
                System.out.println("\n" + "*".repeat(42));
                System.out.println("This is the details of the book you need");
                System.out.println("*".repeat(42));
                System.out.println("ISBN NO     : " + rs.getInt(1));
                System.out.println("BOOK NAME   : " + rs.getString(2));
                System.out.println("AUTHOR NAME : " + rs.getString(3));
                System.out.println("Book Status : " + rs.getString(4));
                System.out.println("*".repeat(42) + "\n");
            }
            if (!isAval) {
                System.out.println("\n" + "The book you searched is not available" + "\n");
                System.out.print("Enter the Book title you want or E/e to Exit : ");
                String bookName = selectChoice.readLine();
                if ("E".equals(bookName.toUpperCase())) {
                    LMSApplication.options();
                } else {
                    viewBook(bookName);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addBook() throws IOException {
        System.out.print("Enter the ISBN NO : ");
        int isbn_No = Integer.parseInt(selectChoice.readLine());

        boolean find = true;
        String sql = "select Book_id from lms_Books where Isbn_no = " + isbn_No + ";";
        try ( Statement st = con.createStatement();  ResultSet rs = st.executeQuery(sql)) {
            rs.next();
            rs.getInt(1);
        } catch (SQLException ex) {
            find = false;
        }

        if (find) {
            System.out.print("The book is already exsists Click 1 to enter an another isbn or Click 0 to increase the copies ?- ");
            String copies = selectChoice.readLine();
            if ("0".equals(copies)) {
                try {
                    con.setAutoCommit(false);
                    Statement st1 = con.createStatement();
                    ResultSet rs = st1.executeQuery(sql);
                    rs.next();
                    int bid = rs.getInt(1);
                    st1.executeUpdate("insert into lms_BookCopies (Book_id) values(" + bid + ")");
                    System.out.println("Book Copie Added Successfully");
                    con.commit();
                } catch (SQLException ex) {
                    try {
                        addBook();
                        con.rollback();
                    } catch (SQLException ex1) {
                        ex1.printStackTrace();
                    }
                }
            } else {
                addBook();
            }
        } else {
            System.out.print("Enter the Book Title : ");
            String title = selectChoice.readLine();
            System.out.print("Enter the Author Name : ");
            String author = selectChoice.readLine();

            Book b = new Book(isbn_No, title, author);
            try {
                con.setAutoCommit(false);
                int bid = 0;
                int aid = 0;

                String bookadd = "INSERT INTO lms_Books VALUES (0, '" + b.getTitle() + "'," + b.getIsbn_No() + ");";
                Statement st = con.createStatement();
                st.executeUpdate(bookadd);

                String authoradd = "INSERT INTO lms_Author VALUES (0, '" + b.getAuthor() + "');";
                st = con.createStatement();
                st.executeUpdate(authoradd);

                String Book_id = "SELECT Book_id from lms_Books where title = '" + b.getTitle() + "';";
                st = con.createStatement();
                ResultSet bookrs = st.executeQuery(Book_id);
                if (bookrs.next()) {
                    bid = bookrs.getInt(1);
                }

                String bkCopiesadd = "INSERT INTO lms_BookCopies VALUES (0, " + bid + ", 'Available'" + ");";
                st = con.createStatement();
                st.executeUpdate(bkCopiesadd);

                String Author_id = "SELECT Author_id from lms_Author where Name = '" + b.getAuthor() + "';";
                st = con.createStatement();
                ResultSet authorrs = st.executeQuery(Author_id);
                if (authorrs.next()) {
                    aid = authorrs.getInt(1);
                }

                String bkabookadd = "INSERT INTO lms_Author_Book VALUES (0, " + aid + "," + bid + ")";
                st = con.createStatement();
                st.executeUpdate(bkabookadd);
                con.commit();

                System.out.println("New Book Added Successfully");
                viewBooks();
                System.out.print("press 0 to main menu or enter 1 to add another Book : ");
                String userchoice = selectChoice.readLine();
                if (userchoice.equals("0")) {
                    LMSApplication.options();
                } else {
                    addBook();
                }
                con.close();
            } catch (IOException | SQLException ioex) {
                try {
                    con.rollback();
                    ioex.printStackTrace();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    @Override
    public void removeBook(int isbn) {
        boolean copybook = false;
        String checkCopie = "select Book_id from lms_BookCopies where Book_Status = 'Available' and Book_id = (select Book_id from lms_Books where Isbn_no = " + isbn + ") limit 1;";
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(checkCopie);
            if (rs.next()) {
                if (rs.getInt(1) != 0) {
                    copybook = true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (copybook) {
            try {
                con.setAutoCommit(false);
                String ibremove = "delete from lms_IssueBooks where Is_returned = true and BookCopies_id = (select BookCopies_id from lms_BookCopies where Book_id = (select Book_id from lms_Books where Isbn_no = " + isbn + ") limit 1);";
                String remove = "delete from lms_BookCopies where Book_Status = 'Available' and Book_id = (select Book_id from lms_Books where Isbn_no = " + isbn + ") limit 1;";
                con.createStatement().executeUpdate(ibremove);
                con.createStatement().executeUpdate(remove);
                System.out.println("Book removed Successfully");
                con.commit();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("There is no book copies to delete");
        }
    }

    public int getResultSet(String sql) {
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0;
    }

    @Override
    public void statistics() {
        System.out.println("-".repeat(104));
        System.out.println(String.format("%-22s%-22s%-22s%-22s%-22s", "Total No Of Books", "Available Books", "To be Returned", "Total No of Members", "Damaged Books"));
        System.out.println("-".repeat(104));

        String sql1 = "select count(*) from lms_Books;";
        String sql2 = "select count(*) from lms_BookCopies where Book_Status = 'Available';";
        String sql3 = "select count(*) from lms_IssueBooks where Is_returned = true;";
        String sql4 = "select count(*) from lms_Members;";
        String sql5 = "select count(*) from lms_BookCopies where Book_Status = 'Damaged';";

        int totalNoOfBooks = getResultSet(sql1), availableBooks = getResultSet(sql2), toBeReturned = getResultSet(sql3), totalNoOfMembers = getResultSet(sql4), damagedBooks = getResultSet(sql5);

        System.out.println(String.format("%-22s%-22s%-22s%-22s%-22s", totalNoOfBooks, availableBooks, toBeReturned, totalNoOfMembers, damagedBooks));
        System.out.println("-".repeat(104));
    }
}
