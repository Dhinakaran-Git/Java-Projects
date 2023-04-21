package application.lms;

import application.lms.model.jpaModel.Books;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.io.BufferedReader;
import java.io.IOException;

public class lms4 {

    static BufferedReader r = LMSApplication.SELECT_CHOICE;

    public static int getBookid(int isbn) throws IOException {
        EntityManagerFactory emf1 = Persistence.createEntityManagerFactory("lms");
        EntityManager em1 = emf1.createEntityManager();
        int bookid = 0;
        bookid = em1.createQuery("SELECT b FROM Books b WHERE cb.isbnNo = :isbnNo", Books.class)
                .setParameter("isbnNo", isbn)
                .getSingleResult().getBookId();
        System.out.println(bookid);
        if (bookid != 0) {
            return bookid;
        } else {
            System.out.print("\nThe book is not avaiable please enter an another Isbn : ");
            int newIsbn = Integer.parseInt(r.readLine());
//            checkIsbnId(newIsbn);
            return -1;
        }
    }

    public static void main(String[] args) throws IOException {
        EntityManagerFactory emf1 = Persistence.createEntityManagerFactory("lms");
        EntityManager em1 = emf1.createEntityManager();
        System.out.println("enter : ");
        int i = Integer.parseInt(r.readLine());
        int bookid = 0;
        bookid = em1.createQuery("SELECT b FROM Books b WHERE b.isbnNo = :isbnNo", Books.class)
                .setParameter("isbnNo", i)
                .getSingleResult().getBookId();
        System.out.println(bookid);
        if (bookid != 0) {
//            return bookid;
        } else {
            System.out.print("\nThe book is not avaiable please enter an another Isbn : ");
            int newIsbn = Integer.parseInt(r.readLine());
//            checkIsbnId(newIsbn);
//            return -1;
        }
    }

}
