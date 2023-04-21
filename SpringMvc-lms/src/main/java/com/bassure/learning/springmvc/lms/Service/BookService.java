package com.bassure.learning.springmvc.lms.Service;

import com.bassure.learning.springmvc.lms.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;
    
//    public Books getBook(int id){
//        return bookRepository.getBookById(id);
//    }
}
