package com.application.lms.serviceImpl;

import com.application.lms.apirequest.BookRequest;
import com.application.lms.entity.Author;
import com.application.lms.entity.BookCopies;
import com.application.lms.entity.Books;
import com.application.lms.repo.AuthorRepo;
import com.application.lms.repo.BookCopiesRepo;
import com.application.lms.repo.BookRepo;
import com.application.lms.service.BookService;
import jakarta.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepo bookRepo;

    @Autowired
    private AuthorRepo authorRepo;

    @Autowired
    private BookCopiesServiceImpl bookCopiesServiceImpl;

    @Autowired
    private BookCopiesRepo bookCopiesRepo;
    
    @Override
    public List<Books> getBooks() {
        return bookRepo.findAll();
    }

    public Optional<Books> getBook(int bid) {
        return bookRepo.findById(bid);
    }

    @Transactional
    @Modifying
    public Books newBook(BookRequest b) {
        System.out.println("BOOKS : " + b);
        List<Author> authorList = new ArrayList<>();

        //check author is already available then skip the author
        for (String author : b.getAuthors()) {
            Author ex = authorRepo.findByAuthorName(author);
            if (Objects.nonNull(ex)) {
                authorList.add(ex);
            } else {
                authorList.add(new Author(0, author));
            }
        }

        Books book = Books
                .builder()
                .isbnNo(b.getIsbn())
                .title(b.getName())
                .authors(authorList)
                .build();

        book = bookRepo.save(book);
        BookCopies bc = BookCopies
                .builder()
                .bookStatus("Available")
                .bookid(book.getBookId())
                .build();
        bookCopiesRepo.save(bc);
        return book;
    }

    public String updateBook(int bc, int bid) {
        for (int i = 0; i < bc; i++) {
            Books b = new Books();
            b.setBookId(bid);
            bookCopiesServiceImpl.newBookCopies(b);
        }
        return "success";
    }

    public void removeBook(int bid) {
        Optional<BookCopies> bc = bookCopiesServiceImpl.removeBookCopies(bid);
        if (bc.isEmpty() != true) {
            bookCopiesServiceImpl.removeBookCopie(bc.get().getBookCopiesId());
        } else {
            System.out.println("Book is not available");
        }
    }

}
