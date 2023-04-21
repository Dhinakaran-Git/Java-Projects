package com.application.lms.controller;

import com.application.lms.apirequest.IssueBookRequest;
import com.application.lms.entity.IssueBooks;
import com.application.lms.serviceImpl.IssueBookServiceImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IssueBookController {
    
    @Autowired
    private IssueBookServiceImpl issueBookServiceImpl;
    
    @GetMapping("/getissuebooks")
    public ResponseEntity<List<IssueBooks>> getAllIssueBook(){
        return new ResponseEntity(issueBookServiceImpl.getIssueBooks(), HttpStatus.OK);
    }
    
    @PostMapping("/addissuebook")
    public String toIssueBook(@RequestBody IssueBookRequest request){
        return issueBookServiceImpl.addIssueBook(request);
    }
    
    @GetMapping("/collectbook")
    public String toCollectBook(@RequestBody IssueBookRequest request){
        return issueBookServiceImpl.collectBook(request);
    }
}
