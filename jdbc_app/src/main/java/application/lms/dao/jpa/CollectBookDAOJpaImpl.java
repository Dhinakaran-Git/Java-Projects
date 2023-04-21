package application.lms.dao.jpa;

import application.lms.LMSApplication;
import application.lms.dao.CollectBookDAO;
import application.lms.model.jpaModel.BookCopies;
import application.lms.model.jpaModel.Books;
import application.lms.model.jpaModel.IssueBooks;
import application.lms.model.jpaModel.Member;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import java.io.BufferedReader;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class CollectBookDAOJpaImpl implements CollectBookDAO {

    BufferedReader select = LMSApplication.SELECT_CHOICE;
    Timestamp timeStamp = new Timestamp(new Date().getTime());
    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("lms");
    static EntityManager em = null;
    static EntityTransaction tx = null;
    private int isbnNo = 0;
    private List<BookCopies> filterBcResult = new ArrayList<>();

    public int checkIsbnId(int isbnid) throws IOException {
        em = emf.createEntityManager();
        int bookId = getBookid(isbnid);

        System.out.println("BOOKID==========" + bookId);

        List<BookCopies> bcObj = em.createQuery("SELECT cb FROM BookCopies cb WHERE cb.bookid = :id", BookCopies.class)
                .setParameter("id", bookId)
                .getResultList();

        filterBcResult = bcObj.stream()
                .filter(x -> x.getBookStatus().equals("Issued") && x.getBookid() == bookId).limit(1)
                .collect(Collectors.toList());

        if (!filterBcResult.isEmpty()) {
            return isbnid;
        } else {
            System.out.print("\nThe book is already issued Please Enter an another Isbn : ");
            isbnNo = Integer.parseInt(select.readLine());
            return checkIsbnId(isbnNo);
        }
    }

    public int getBookid(int isbn) throws IOException {
        em = emf.createEntityManager();
        List<Books> bookid = em.createQuery("SELECT b FROM Books b WHERE b.isbnNo = :isbnNo", Books.class)
                .setParameter("isbnNo", isbn)
                .getResultList();
        if (!bookid.isEmpty()) {
            System.out.println("BOOKID--------" + bookid.iterator().next().getBookId());
            return bookid.iterator().next().getBookId();
        } else {
            System.out.print("\nThe book is not avaiable please enter an another Isbn : ");
            isbnNo = Integer.parseInt(select.readLine());
            return getBookid(isbnNo);
        }
    }

    public String checkBookMember(int bookCopid, int memid) {
        em = emf.createEntityManager();
        List<IssueBooks> is = em.createQuery("SELECT ib FROM IssueBooks ib WHERE ib.bookCopiesId = :bcid")
                .setParameter("bcid", bookCopid)
                .getResultList();
        if (is.iterator().next().isReturned() == true || is.iterator().next().getMemberId() == memid) {
            return is.iterator().next().getOutDate();
        } else {
            System.out.println("The Member is not taken any book or member is taken anthor book");
            return null;
        }
    }

    public int checkMemberId(int mid) throws IOException {
        em = emf.createEntityManager();
        List<Member> member = em.createQuery("SELECT m FROM Member m WHERE memberId = :mem", Member.class)
                .setParameter("mem", mid)
                .getResultList();

        if (!member.isEmpty()) {
            return mid;
        } else {
            System.out.print("The memberId is not yet registered enter an registered id - ");
            return checkMemberId(Integer.parseInt(select.readLine()));
        }
    }

    @Override
    public void collectBook() {
        em = emf.createEntityManager();
        tx = em.getTransaction();
        try {
            tx.begin();
            System.out.print("Enter ISBN NO : ");
            isbnNo = Integer.parseInt(select.readLine());
            checkIsbnId(isbnNo);

            System.out.print("enter the memberId - ");
            int memberId = checkMemberId(Integer.parseInt(select.readLine()));

            String bookMember = checkBookMember(filterBcResult.iterator().next().getBookCopiesId(), memberId);

            System.out.println("ISBN      ---------" + isbnNo);
            System.out.println("MEMBERID  ---------" + memberId);

            if (bookMember != null) {
                em.getTransaction().begin();

                System.out.print("is damaged type y/N - ");
                String input = select.readLine();
                if (input.toLowerCase().charAt(0) == 'y') {
                    BookCopies c = em.find(BookCopies.class, filterBcResult.iterator().next().getBookCopiesId());
                    c.setBookStatus("Damaged");
                }

                BookCopies c = em.find(BookCopies.class, filterBcResult.iterator().next().getBookCopiesId());
                c.setBookStatus("Available");

                List<IssueBooks> issueList = em.createQuery("SELECT ib FROM IssueBooks ib WHERE ib.isReturned = FALSE and ib.memberId = :memid")
                        .setParameter("memid", memberId)
                        .getResultList();

                IssueBooks issue = em.find(IssueBooks.class, issueList.iterator().next().getIssueBookId());
                issue.setInDate(timeStamp.toString());
                issue.setReturned(true);

                em.getTransaction().commit();
                System.out.println("\n" + "Book Collected successfully" + "\n");
                em.close();
            }

        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (NumberFormatException nfe) {
            System.out.println("\n" + "Please Enter Correct Input" + "\n");
        }
    }

    @Override
    public void collectedBooks() {
        em = emf.createEntityManager();
        
        List<IssueBooks> is = em.createQuery("SELECT i FROM IssueBooks i").getResultList();
        if (!is.isEmpty()) {
            System.out.println("-".repeat(101));
            System.out.println(String.format("%-20s%-20s%-20s%-20s", "ISBN_NO", "TITLE", "MEMBER_ID", "COLLECTED_DATE"));
            System.out.println("-".repeat(101));
            for (IssueBooks i : is) {
                System.out.println(String.format("%-20s%-20s%-20s%-20s", i.getBookcopies().getBook().getIsbnNo(), i.getBookcopies().getBook().getTitle(), i.getMemberId(), i.getInDate()));
            }
            System.out.println("-".repeat(101));
        } else {
            System.out.println("*".repeat(55));
            System.out.println("*           Oops no books are Issued yet           *");
            System.out.println("*".repeat(55));
        }

    }
}
