package com.application.lms.serviceImpl;

import com.application.lms.apirequest.CollectBookRequest;
import com.application.lms.apirequest.IssueBookRequest;
import com.application.lms.entity.IssueBooks;
import com.application.lms.repo.IssueBookRepo;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;

public class IssueBookServiceImplTest {

    @Mock
    private IssueBookRepo issueBookRepo;

    @InjectMocks
    private IssueBookServiceImpl issueBookServiceImpl;

    public IssueBookServiceImplTest() {
    }

    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testGetIssueBooks() {
        System.out.println("getIssueBooks");
        IssueBookServiceImpl instance = new IssueBookServiceImpl();
        List<IssueBooks> expResult = instance.getIssueBooks();
        List<IssueBooks> result = instance.getIssueBooks();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testAddIssueBook() {
        System.out.println("addIssueBook");
        IssueBookRequest issueBookRequest = null;
        IssueBookServiceImpl instance = new IssueBookServiceImpl();
        String expResult = "";
        String result = instance.addIssueBook(issueBookRequest);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testCollectBook() {
        System.out.println("collectBook");
        CollectBookRequest collectRequest = null;
        IssueBookServiceImpl instance = new IssueBookServiceImpl();
        String expResult = "";
        String result = instance.collectBook(collectRequest);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testUserTransaction() {
        System.out.println("userTransaction");
        int userId = 0;
        IssueBookServiceImpl instance = new IssueBookServiceImpl();
        List<IssueBooks> expResult = null;
        List<IssueBooks> result = instance.userTransaction(userId);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

}
