package com.application.lms.service;

import com.application.lms.apirequest.IssueBookRequest;
import com.application.lms.entity.IssueBooks;
import java.util.List;

public interface IssueBookService {

    public List<IssueBooks> getIssueBooks();

    public String addIssueBook(IssueBookRequest bookCopiesAndMemberRequest);
}
