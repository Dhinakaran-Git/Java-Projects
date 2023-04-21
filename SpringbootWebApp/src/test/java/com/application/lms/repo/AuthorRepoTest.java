package com.application.lms.repo;

import com.application.lms.entity.Author;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AuthorRepoTest {

    @Autowired
    private AuthorRepo authorRepo;

    void testFindByAuthorName() {
        Author exFindByAuthorName = authorRepo.findByAuthorName("Jonney");
        Assertions.assertEquals("Jonney", exFindByAuthorName.getAuthorName());
        Assertions.assertEquals(24, exFindByAuthorName.getAuthorId());
    }
}
