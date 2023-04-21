package com.application.lms.serviceImpl;

import com.application.lms.entity.Author;
import com.application.lms.entity.Books;
import com.application.lms.repo.AuthorRepo;
import com.application.lms.repo.BookRepo;
import com.application.lms.service.BookService;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepo bookRepo;

    @Autowired
    private AuthorRepo authorRepo;

    @Autowired
    private BookCopiesServiceImpl bookCopiesServiceImpl;

    @Override
    public List<Books> getBooks() {
        return bookRepo.findAll();
    }

    @Override
    public Books newBook(Books b) {
        System.out.println("BOOKS : " + b);

        List<Author> authorList = new ArrayList<>();
        for (Author author : b.getAuthors()) {
            Author ex = authorRepo.findByAuthorName(author.getAuthorName());
            
            if (Objects.nonNull(ex)) {
                System.out.println("Author ex : "+ex);
                authorList.add(ex);
            } else {
                authorList.add(new Author(0, author.getAuthorName()));
            }
        }

        Books book = Books
                .builder()
                .isbnNo(b.getIsbnNo())
                .title(b.getTitle())
                .authors(authorList)
                .build();

        book = bookRepo.save(book);
        bookCopiesServiceImpl.newBookCopies(book);
        return book;
    }
}
