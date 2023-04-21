package com.mycompany.webapp1.dao.jpa;

import com.mycompany.webapp1.jpaModel.BookCopies;
import com.mycompany.webapp1.jpaModel.Books;
import com.mycompany.webapp1.jpaModel.IssueBooks;
import com.mycompany.webapp1.jpaModel.Member;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class BookDAOJpaImpl {

    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("lms");
    static EntityManager em = null;
    static EntityTransaction tx = null;
    List<Books> filterBookList = new ArrayList<>();

    public void addBook(Books b) throws IOException {
        em = emf.createEntityManager();
        tx = em.getTransaction();

        filterBookList = em.createQuery("SELECT cb FROM Books cb WHERE cb.isbnNo = :isbnNo", Books.class)
                .setParameter("isbnNo", b.getIsbnNo())
                .getResultList();

        tx.begin();
        Books newBook = b;
        System.out.println(newBook);
        em.merge(newBook);
        tx.commit();
        em.refresh(filterBookList);
        addBookCopies("1");
    }

    public void addBookCopies(String copies) throws IOException {
        try {
            BookCopies bc = new BookCopies(0, filterBookList.iterator().next().getBookId(), "Available");
            tx.begin();
            em.persist(bc);
            tx.commit();
            System.out.println("Book Copie Added Successfully");
        } catch (Exception ex) {
            tx.rollback();
        }
    }

//    public List<Author> addAuthors(int numberOfAuthor) throws IOException {
//        List<Author> authorsList = new ArrayList<>();
//        Author author;
//        for (int i = 1; i <= numberOfAuthor; i++) {
//            System.out.print("Enter the " + i + " Author Name : ");
//            author = new Author(0, selectChoice.readLine());
//
//            authorsList.add(author);
//        }
//        return authorsList;
//    }

    public void viewBooks() throws IOException {
        em = emf.createEntityManager();
        List<Books> bo = em.createQuery("SELECT bo from Books bo", Books.class).getResultList();

        System.out.println("-".repeat(68));
        System.out.println(String.format("%8s %-5s %-20s %-20s %-18s", "ISBN_NO", "", "TITLE", "AUTHOR", "ISAVILABLE"));
        System.out.println("-".repeat(68));
        bo.forEach(x -> System.out.println(String.format("%8s %-5s %-20s %-20s %-18s\n", x.getIsbnNo(), " ", x.getTitle(), Arrays.toString(x.getAuthors().stream().map(m -> m.getAuthorName()).toArray()), x.getBookCopies().iterator().next().getBookStatus())));
        System.out.println("-".repeat(68));
        em.close();
    }

    public Books viewBook(String title) {
        em = emf.createEntityManager();
        List<Books> bo = em.createQuery("SELECT bo from Books bo", Books.class).getResultList();
        for (Books books : bo) {
            if (books.getTitle().equalsIgnoreCase(title)) {
                return new Books(books.getBookId(), books.getTitle(), books.getIsbnNo(), books.getAuthors());
            }
        }
        return null;
    }

    public void removeBook(int isbn) {
        em = emf.createEntityManager();
        try {
            int bo = em.createQuery("SELECT bo from Books bo WHERE bo.isbnNo = : isbn", Books.class)
                    .setParameter("isbn", isbn)
                    .getSingleResult().getBookId();

//        System.out.println(bo);
            int bocopid = em.createQuery("SELECT bc FROM BookCopies bc WHERE bc.bookCopiesId = :bookCopid", BookCopies.class)
                    .setParameter("bookCopid", bo)
                    .getSingleResult().getBookCopiesId();

            BookCopies bkCop = em.find(BookCopies.class, bocopid);
            em.getTransaction().begin();
            if (Objects.nonNull(bkCop) && bkCop.getBookCopiesId() == bocopid && bkCop.getBookStatus().equals("Available") || bkCop.getBookStatus().equals("Damaged")) {
                bkCop.setBookStatus("Removed");
                System.out.println("Book is Removed Sussfully");
            } else {
                System.out.println("There is no book copies to delete");
            }
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public void statistics() {
        em = emf.createEntityManager();
        try {
            System.out.println("-".repeat(104));
            System.out.println(String.format("%-22s%-22s%-22s%-22s%-22s", "Total No Of Books", "Available Books", "To be Returned", "Total No of Members", "Damaged Books"));
            System.out.println("-".repeat(104));

            List<Books> bo = em.createQuery("SELECT bo from Books bo", Books.class).getResultList();
            List<IssueBooks> is = em.createQuery("SELECT ib FROM IssueBooks ib", IssueBooks.class).getResultList();
            int returned = is.stream().filter(x -> x.isReturned() == true).toList().size();
            List<BookCopies> bkCop = em.createQuery("SELECT bc FROM BookCopies bc").getResultList();
            int availBooks = bkCop.stream().filter(x -> x.getBookStatus().equals("Available")).toList().size();
            int damaged = bkCop.stream().filter(x -> x.getBookStatus().equals("Damaged")).toList().size();
            List<Member> member = em.createQuery("SELECT m FROM Member m").getResultList();

            int totalNoOfBooks = bo.size(), availableBooks = availBooks, toBeReturned = returned, totalNoOfMembers = member.size(), damagedBooks = damaged;

            System.out.println(String.format("%-22s%-22s%-22s%-22s%-22s", totalNoOfBooks, availableBooks, toBeReturned, totalNoOfMembers, damagedBooks));
            System.out.println("-".repeat(104));
        } finally {
            em.close();
        }

    }
}
