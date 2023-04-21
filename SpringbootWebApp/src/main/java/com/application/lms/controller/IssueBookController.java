package com.application.lms.controller;

import com.application.lms.apirequest.CollectBookRequest;
import com.application.lms.apirequest.IssueBookRequest;
import com.application.lms.entity.Member;
import com.application.lms.serviceImpl.IssueBookServiceImpl;
import com.application.lms.serviceImpl.MemberServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import java.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IssueBookController {

    @Autowired
    private IssueBookServiceImpl issueBookServiceImpl;

    @Autowired
    private MemberServiceImpl memberServiceImpl;

    @GetMapping("/book/api/issuedbooks")
    public String getAllIssueBook(Model model) {
        model.addAttribute("issuebooks", issueBookServiceImpl.getIssueBooks());
        return "issuebooks";
    }

    @GetMapping("/book/api/issuebook")
    @ResponseBody
    public String toIssueBook(@RequestParam int isbnNo, @RequestParam int memberId) {
        IssueBookRequest request = new IssueBookRequest(memberId, isbnNo);
        System.out.println(request);
        issueBookServiceImpl.addIssueBook(request);
        return "Book is Issued Successfully";
    }

    @GetMapping("/book/api/collectbook")
    public String collectBookForm() {
        return "collectbook";
    }

    @GetMapping("/book/api/issuelist")
    public String userTransctions(Model model, HttpServletRequest request) {
        Principal userPrincipal = request.getUserPrincipal();
        Member user = memberServiceImpl.findByMemberName(userPrincipal.getName()).get();
        System.out.println(user.toString());
        model.addAttribute("history", issueBookServiceImpl.userTransaction(user.getMemberId()));
        return "userhistory";
    }

    @PostMapping("/book/api/tocollectbook")
    public String toCollectBook(@ModelAttribute CollectBookRequest request, Model model) {
        model.addAttribute("info", issueBookServiceImpl.collectBook(request));
        return "info";
    }
}
