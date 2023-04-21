package com.application.lms.serviceImpl;

import com.application.lms.apirequest.BookRequest;
import com.application.lms.entity.Author;
import com.application.lms.entity.BookCopies;
import com.application.lms.entity.Books;
import com.application.lms.repo.AuthorRepo;
import com.application.lms.repo.BookCopiesRepo;
import com.application.lms.repo.BookRepo;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookServiceImplTest {

    @Mock
    private BookRepo bookRepo;

    @Mock
    private AuthorRepo authorRepo;

    @Mock
    private BookCopiesRepo bookCopiesRepo;

    
    @InjectMocks
    private BookServiceImpl bookServiceImpl;

    private Books book;
    private BookCopies bc;
    private Author author;

    private List<Books> books = new ArrayList<>();

    private List<Author> authorList = new ArrayList<>();


    @BeforeEach
    public void setUp() {
        author = Author.builder().authorId(1).authorName("Dhina").build();
        authorList.add(author);

        book = Books.builder().bookId(10).isbnNo(1001).title("Java").authors(authorList).build();

        books.add(book);
        books.add(Books
                .builder()
                .bookId(11)
                .isbnNo(1002)
                .title("React")
                .build());
        books.add(Books
                .builder()
                .bookId(12)
                .isbnNo(1003)
                .title("Mysql")
                .build());
        books.add(Books
                .builder()
                .bookId(13)
                .isbnNo(1004)
                .title("deep work")
                .build());
        books.add(Books
                .builder()
                .bookId(14)
                .isbnNo(1005)
                .title("hard work")
                .build());

    }

    @AfterEach
    public void tearDown() {
        books = null;
        book = null;
    }

    @Test
    public void testGetBooks() {
        System.out.println("getBooks");
        Mockito.when(bookRepo.findAll()).thenReturn(books);
        List<Books> getAll = bookServiceImpl.getBooks();
        Assertions.assertNotNull(getAll);
        Assertions.assertEquals(getAll.size(), books.size());
    }

    @Test
    public void testGetBook() {
        System.out.println("getBook");
        Optional<Books> opBook = Optional.of(book);
        Mockito.when(bookRepo.findById(ArgumentMatchers.any(Integer.class))).thenReturn(Optional.of(book));
        Optional<Books> expResult = bookServiceImpl.getBook(10);
        Assertions.assertEquals(expResult.get().getTitle(), book.getTitle());
    }

    @Test
    public void testNewBook() {
        System.out.println("newBook");
        List<String> list = new ArrayList<>();
        list.add("Dhina");
        BookRequest b = BookRequest.builder().name("Java").authors(list).isbn(10001).bid(10).build();

        Mockito.when(bookRepo.save(ArgumentMatchers.any(Books.class))).thenReturn(book);
        Mockito.when(authorRepo.findByAuthorName(ArgumentMatchers.any(String.class))).thenReturn(author);
        Mockito.when(bookCopiesRepo.save(bc)).thenReturn(new BookCopies(0, 1001, "Available"));

        Books book1 = bookServiceImpl.newBook(b);
        Assertions.assertNotNull(book1);
        Assertions.assertNotNull(book1.getAuthors());
        Assertions.assertEquals(b.getName(), book1.getTitle());
        Assertions.assertEquals(b.getAuthors().iterator().next(), book1.getAuthors().iterator().next().getAuthorName());
    }
}
