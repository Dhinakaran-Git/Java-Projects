package com.application.lms.controller;

import com.application.lms.apirequest.BookRequest;
import com.application.lms.entity.Member;
import com.application.lms.serviceImpl.BookServiceImpl;
import com.application.lms.serviceImpl.MemberServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import java.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/book/api")
public class BookController {

    @Autowired
    private BookServiceImpl bookServiceImpl;

    @Autowired
    private MemberServiceImpl memberServiceImpl;
    
    @GetMapping("/books")
    public String bookPage(Model model, HttpServletRequest request) {
        model.addAttribute("book", bookServiceImpl.getBooks());
        Principal userPrincipal = request.getUserPrincipal();
        Member user = memberServiceImpl.findByMemberName(userPrincipal.getName()).get();
        model.addAttribute("role", user.getUserRole());
        return "bookportal";
    }

    @GetMapping("/viewbooks")
    public String viewBooks(Model model, HttpServletRequest request) {
        model.addAttribute("book", bookServiceImpl.getBooks());
        Principal userPrincipal = request.getUserPrincipal();
        Member user = memberServiceImpl.findByMemberName(userPrincipal.getName()).get();
        model.addAttribute("role", user.getUserRole());
        model.addAttribute("userid", user.getMemberId());
        return "viewbooks";
    }

    @GetMapping(value = "/book/{bid}")
    public String viewBook(@PathVariable int bid, Model model, HttpServletRequest request) {
        System.out.println("+++++++++++++++++++++++++++++++++++++++++"+bid);
        Principal userPrincipal = request.getUserPrincipal();
        Member user = memberServiceImpl.findByMemberName(userPrincipal.getName()).get();
        model.addAttribute("role", user.getUserRole());
        model.addAttribute("book", bookServiceImpl.getBook(bid));
        return "viewbook";
    }
    
    @GetMapping("/newbook")
    public String addBookPage() {
        return "addbooks";
    }

    @PostMapping("/newbook")
    public String addBooks(@ModelAttribute BookRequest bookrequest, Model model) {
        try {
            bookServiceImpl.newBook(bookrequest);
            return "redirect:/book/api/viewbooks";
        } catch (Exception e) {
            model.addAttribute("status", "Please enter correct input");
            return "addbooks";
        }
    }
    
    @GetMapping("/updatebook/{bid}")
    public String editBookPage(@PathVariable int bid, Model model) {
        System.out.println(bookServiceImpl.getBook(bid));
        model.addAttribute("book", bookServiceImpl.getBook(bid).get());
        return "editbook";
    }
    
    @PostMapping("/updatebook")
    public String editBook(@RequestParam int bookcopies, @RequestParam int bid){
        bookServiceImpl.updateBook(bookcopies, bid);
        return "redirect:/book/api/viewbooks";
    }
    
    @GetMapping(value = "/delbook/{bid}")
    public String removeMember(@PathVariable int bid, Model model) {
        bookServiceImpl.removeBook(bid);
        return "redirect:/book/api/viewbooks";
    }
}