package com.mycompany.webapp1.dao.jpa;

//package application.lms.dao.jpa;
//
//import application.lms.model.jpaModel.BookCopies;
//import application.lms.model.jpaModel.Books;
//import application.lms.model.jpaModel.IssueBooks;
//import application.lms.model.jpaModel.Member;
//import jakarta.persistence.EntityManager;
//import jakarta.persistence.EntityManagerFactory;
//import jakarta.persistence.EntityTransaction;
//import jakarta.persistence.Persistence;
//import java.io.IOException;
//import java.sql.Timestamp;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//import java.util.stream.Collectors;
//
//public class IssueBookDAOJpaImpl{
//
//    Timestamp timeStamp = new Timestamp(new Date().getTime());
//    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("lms");
//    static EntityManager em = null;
//    static EntityTransaction tx = null;
//    private int isbnNo = 0;
//    private List<BookCopies> filterBcResult = new ArrayList<>();
//
//    public void issuedBooks() {
//        em = emf.createEntityManager();
//
//        List<IssueBooks> is = em.createQuery("SELECT ib FROM IssueBooks ib", IssueBooks.class).getResultList();
//        if (!is.isEmpty()) {
//            System.out.println("-".repeat(72));
//            System.out.println(String.format("%-20s%-20s%-20s%-20s", "ISBN_NO", "TITLE", "MEMBER_ID", "ISSUED_DATE"));
//            System.out.println("-".repeat(72));
//            for (IssueBooks i : is) {
//                System.out.println(String.format("%-20s%-20s%-20s%-20s", i.getBookcopies().getBook().getIsbnNo(), i.getBookcopies().getBook().getTitle(), i.getMemberId(), i.getOutDate()));
//            }
//            System.out.println("-".repeat(72));
//        } else {
//            System.out.println("*".repeat(55));
//            System.out.println("*           Oops no books are Issued yet           *");
//            System.out.println("*".repeat(55));
//        }
//    }
//
//    public int checkIsbnId(int isbnid) throws IOException {
//        em = emf.createEntityManager();
//        int bookId = getBookid(isbnid);
//
//        System.out.println("BOOKID==========" + bookId);
//
//        List<BookCopies> bcObj = em.createQuery("SELECT cb FROM BookCopies cb WHERE cb.bookid = :id", BookCopies.class)
//                .setParameter("id", bookId)
//                .getResultList();
//
//        filterBcResult = bcObj.stream()
//                .filter(x -> x.getBookStatus().equals("Available") && x.getBookid() == bookId).limit(1)
//                .collect(Collectors.toList());
//
//        if (!filterBcResult.isEmpty()) {
//            return isbnid;
//        } else {
//            System.out.print("\nThe book is already issued Please Enter an another Isbn : ");
//            isbnNo = Integer.parseInt(select.readLine());
//            return checkIsbnId(isbnNo);
//        }
//    }
//
//    public int getBookid(int isbn) throws IOException {
//        em = emf.createEntityManager();
//        List<Books> bookid = em.createQuery("SELECT b FROM Books b WHERE b.isbnNo = :isbnNo", Books.class)
//                .setParameter("isbnNo", isbn)
//                .getResultList();
//        if (!bookid.isEmpty()) {
//            System.out.println("BOOKID--------" + bookid.iterator().next().getBookId());
//            return bookid.iterator().next().getBookId();
//        } else {
//            System.out.print("\nThe book is not avaiable please enter an another Isbn : ");
//            isbnNo = Integer.parseInt(select.readLine());
//            return getBookid(isbnNo);
//        }
//    }
//
//    public int checkMemberId(int mid) throws IOException {
//        em = emf.createEntityManager();
//        List<Member> member = em.createQuery("SELECT m FROM Member m WHERE m.memberId = :mem", Member.class)
//                .setParameter("mem", mid)
//                .getResultList();
//
//        if (!member.isEmpty()) {
//            return mid;
//        } else {
//            System.out.print("The memberId is not yet registered enter an registered id - ");
//            return checkMemberId(Integer.parseInt(select.readLine()));
//        }
//    }
//
//    public void addIssueBook() {
//        em = emf.createEntityManager();
//        tx = em.getTransaction();
////        boolean issued = true;
//        try {
//            tx.begin();
//            System.out.print("Enter ISBN NO : ");
//            isbnNo = Integer.parseInt(select.readLine());
//            checkIsbnId(isbnNo);
//
//            System.out.print("enter the memberId - ");
//            int memberId = checkMemberId(Integer.parseInt(select.readLine()));
//
//            System.out.println("ISBN $$$$$$$$$$$$" + isbnNo);
//            System.out.println("MEMBERID $$$$$$$$$$$" + memberId);
//
//            em.getTransaction().begin();
//
//            BookCopies c = em.find(BookCopies.class, filterBcResult.iterator().next().getBookCopiesId());
//            c.setBookStatus("Issued");
//
//            IssueBooks issue = new IssueBooks(0, timeStamp.toString(), memberId, filterBcResult.iterator().next().getBookCopiesId(), false);
//            em.persist(issue);
//
//            em.getTransaction().commit();
//            System.out.println("\n" + "Book issued successfully" + "\n");
//            em.close();
//        } catch (IOException ioe) {
//            ioe.printStackTrace();
//        } catch (NumberFormatException nfe) {
//            System.out.println("\n" + "Please Enter Correct Input" + "\n");
//        }
//    }
//}
