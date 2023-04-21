package com.application.lms.repo;

import com.application.lms.entity.Books;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepo extends JpaRepository<Books, Integer> {

    public Books findByBookId(int isbn);
}
