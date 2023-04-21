package com.bassure.learning.springmvc.lms.controller;

import com.bassure.learning.springmvc.lms.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class BookController {
    
    @Autowired
    private BookService bookService;
    
//    @GetMapping("/bookid/{id}")
//    @ResponseBody
//    public String getBook(@PathVariable int id){
//        System.out.println(id);
//        Books b = bookService.getBook(id);
//        System.out.println(b);
//        return "Success";
//    }
}
