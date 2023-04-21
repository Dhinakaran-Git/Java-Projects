package com.application.lms.repo;

import com.application.lms.entity.Books;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookRepoTest {
    
    @Autowired
    private BookRepo bookRepo;
    
    @Test
    @DisplayName("find by member")
    void testFindByMemberId(){
        Books ex = bookRepo.findByBookId(1003);
        Assertions.assertEquals("Harry potter", ex.getTitle());
        Assertions.assertEquals(3, ex.getBookId());
    }
}
