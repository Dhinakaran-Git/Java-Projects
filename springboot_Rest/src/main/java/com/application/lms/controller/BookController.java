package com.application.lms.controller;

import com.application.lms.entity.Books;
import com.application.lms.serviceImpl.BookServiceImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

    @Autowired
    private BookServiceImpl bookServiceImpl;

    @GetMapping("/books")
    public List<Books> getBookList() {
        return bookServiceImpl.getBooks();
    }

    @PostMapping("/addbooks")
    public Books addbook(@RequestBody Books b) {
        return bookServiceImpl.newBook(b);
    }
}
