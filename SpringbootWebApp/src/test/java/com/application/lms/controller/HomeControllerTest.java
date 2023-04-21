package com.application.lms.controller;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HomeControllerTest {
    
    public HomeControllerTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testHome() {
        System.out.println("home");
        HomeController instance = new HomeController();
        String expResult = "";
        String result = instance.home();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testAbout() {
        System.out.println("about");
        HomeController instance = new HomeController();
        String expResult = "";
        String result = instance.about();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
    
}
