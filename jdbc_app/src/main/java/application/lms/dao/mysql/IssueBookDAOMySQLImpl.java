package application.lms.dao.mysql;

import application.lms.LMSApplication;
import static application.lms.LMSApplication.con;
import application.lms.dao.IssueBookDAO;
import java.io.BufferedReader;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Date;

public class IssueBookDAOMySQLImpl implements IssueBookDAO {

    BufferedReader select = LMSApplication.SELECT_CHOICE;
    Timestamp timeStamp = new Timestamp(new Date().getTime());
    int book_id = 0;
    int bookcop_id = 0;
    int memid = 0;

    public IssueBookDAOMySQLImpl() {
        con = LMSApplication.database.getConnection();
    }

    public int checkIsbnId(int isbnid) throws IOException {
        try {
            Statement st = con.createStatement();
            String sql = "select Book_id, BookCopies_id from lms_BookCopies where Book_Status = 'Available' and Book_id = (select Book_id from lms_Books where Isbn_no = " + isbnid + ") limit 1;";
            ResultSet rs = st.executeQuery(sql);

            if (rs.next()) {
                book_id = rs.getInt(1);
                bookcop_id = rs.getInt(2);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        if (book_id != 0) {
            return isbnid;
        } else {
            System.out.print("\nThe book is not avaiable please enter an another Isbn : ");
            return checkIsbnId(Integer.parseInt(select.readLine()));
        }
    }

    public int checkMemberId(int mid) throws IOException {
        try {
            Statement st = con.createStatement();
            String sql = "select Member_id from lms_Members where Member_id = " + mid + ";";
            ResultSet rs = st.executeQuery(sql);

            if (rs.next()) {
                memid = rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (memid != 0) {
            return mid;
        } else {
            System.out.print("The memberId is not yet registered enter an registered id - ");
            return checkMemberId(Integer.parseInt(select.readLine()));
        }
    }

    @Override
    public void addIssueBook() {
        boolean avaliable = true;
        try {
            con.setAutoCommit(false);
            System.out.print("Enter ISBN NO : ");
            checkIsbnId(Integer.parseInt(select.readLine()));

            System.out.print("enter the memberId - ");
            checkMemberId(Integer.parseInt(select.readLine()));

            if (memid == 0 && book_id == 0) {
                avaliable = false;
            }
            System.out.println("BOOKID :" + book_id);
            System.out.println("memid :" + memid);
            if (avaliable) {
                String update = "update lms_BookCopies set Book_Status = 'Issued' where BookCopies_id =" + bookcop_id + ";";
                Statement st = con.createStatement();
                st.executeUpdate(update);

                String chmem = "insert into lms_IssueBooks(IssueBook_id, Out_date, Member_id, BookCopies_id, Is_returned) values(0,'" + timeStamp + "'," + memid + "," + bookcop_id + ", false);";
                st = con.createStatement();
                st.executeUpdate(chmem);
                System.out.println("Book Issued Successfully");
                con.commit();
            } else {
                System.out.println("The Member is already taken book");
            }
        } catch (IOException | SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void issuedBooks() {
        String ibsql = "select b.Isbn_no, b.title, ib.Member_id, ib.Out_Date as Issued_Date from lms_Books as b join lms_BookCopies as bc join lms_IssueBooks as ib on bc.Book_id = b.Book_id and bc.BookCopies_id = ib.BookCopies_id;";
        try ( Statement st = con.createStatement();  ResultSet rs = st.executeQuery(ibsql)) {
            if (rs.next()) {
                System.out.println("-".repeat(101));
                System.out.println(String.format("%-20s%-20s%-20s%-20s%-18s", "ISBN_NO", "TITLE", "MEMBER_ID", "ISSUED_DATE", "ISSUED_BOOKSTATUS"));
                System.out.println("-".repeat(101));
                do {
                    System.out.println(String.format("%-20s%-20s%-20s%-20s%-18s", rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getDate(4), true));
                    System.out.println("-".repeat(101));
                } while (rs.next());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
