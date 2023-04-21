package application.lms.dao.jpa;

import application.lms.LMSApplication;
import application.lms.dao.BookDAO;
import application.lms.model.jpaModel.Author;
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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class BookDAOJpaImpl implements BookDAO {

    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("lms");
    static EntityManager em = null;
    static EntityTransaction tx = null;
    BufferedReader selectChoice = LMSApplication.SELECT_CHOICE;
    List<Books> filterBookList = new ArrayList<>();

    @Override
    public void addBook() throws IOException {
        em = emf.createEntityManager();
        tx = em.getTransaction();
        System.out.print("Enter the ISBN NO : ");
        int isbn_No = Integer.parseInt(selectChoice.readLine());

        filterBookList = em.createQuery("SELECT cb FROM Books cb WHERE cb.isbnNo = :isbnNo", Books.class)
                .setParameter("isbnNo", isbn_No)
                .getResultList();

        if (filterBookList.isEmpty()) {
            System.out.print("Enter the Book Title : ");
            String title = selectChoice.readLine();

            tx.begin();
            System.out.print("Enter how many authors written the Book : ");
            int numberOfAuthors = Integer.parseInt(selectChoice.readLine());

            List<Author> authors = addAuthors(numberOfAuthors);

            Books newBook = new Books(0, title, isbn_No, authors);
            System.out.println(newBook);
            em.merge(newBook);
            tx.commit();

            filterBookList = em.createQuery("SELECT cb FROM Books cb WHERE cb.isbnNo = :isbnNo", Books.class)
                    .setParameter("isbnNo", isbn_No)
                    .getResultList();
            
            addBookCopies("1");
            System.out.println("New Book Added Successfully");

            viewBooks();

            System.out.print("press 0 to main menu or enter 1 to add another Book : ");
            String userchoice = selectChoice.readLine();
            if (userchoice.equals("0")) {
                LMSApplication.options();
            } else {
                addBook();
            }
        } else {
            System.out.print("The book is already exsists Click 0 to enter an another isbn or Click 1 to increase the copies ?- ");
            String copies = selectChoice.readLine();
            addBookCopies(copies);
        }
    }

    public void addBookCopies(String copies) throws IOException {
        if ("1".equals(copies)) {
            try {
                BookCopies bc = new BookCopies(0, filterBookList.iterator().next().getBookId(), "Available");
                tx.begin();
                em.persist(bc);
                tx.commit();
                System.out.println("Book Copie Added Successfully");
            } catch (Exception ex) {
                tx.rollback();
            }
        } else {
            addBook();
        }
    }

    public List<Author> addAuthors(int numberOfAuthor) throws IOException {
        List<Author> authorsList = new ArrayList<>();
        Author author;
        for (int i = 1; i <= numberOfAuthor; i++) {
            System.out.print("Enter the " + i + " Author Name : ");
            author = new Author(0, selectChoice.readLine());

            authorsList.add(author);
        }
        return authorsList;
    }

    @Override
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

    @Override
    public void viewBook(String title) {
        em = emf.createEntityManager();
        try {
            boolean isAvaliable = false;
            List<Books> bo = em.createQuery("SELECT bo from Books bo", Books.class).getResultList();
            for (Books books : bo) {
                if (books.getTitle().equalsIgnoreCase(title)) {
                    isAvaliable = true;
                    viewBookDetails(books);
                }
            }
            if (!isAvaliable) {
                try {
                    System.out.println("\n" + "The book you searched is not available" + "\n");
                    System.out.print("Enter the Book title you want or E/e to Exit : ");
                    String bookName = selectChoice.readLine();
                    if ("e".equalsIgnoreCase(bookName)) {
                        LMSApplication.options();
                    } else {
                        viewBook(bookName);
                    }
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }
            }
        } finally {
            em.close();
        }
    }

    public void viewBookDetails(Books books) {
        System.out.println("\n" + "*".repeat(42));
        System.out.println("This is the details of the book you need");
        System.out.println("*".repeat(42));
        System.out.println("ISBN NO     : " + books.getIsbnNo());
        System.out.println("BOOK NAME   : " + books.getTitle());
        System.out.println("AUTHOR NAME : " + Arrays.toString(books.getAuthors().stream().map(m -> m.getAuthorName()).toArray()));
        System.out.println("*".repeat(42) + "\n");
    }

    @Override
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

    @Override
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
