package com.application.lms.repo;

import com.application.lms.entity.BookCopies;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookCopiesRepoTest {
    
    @Autowired
    private BookCopiesRepo bookCopiesRepo;

    @Test
    void testfindByBookid() {
        List<BookCopies> exFindByBookid = bookCopiesRepo.findByBookid(23);
        Assertions.assertNotNull(exFindByBookid);
    }
}
