package com.application.lms.repo;

import com.application.lms.entity.BookCopies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookCopiesRepo extends JpaRepository<BookCopies, Integer>{
        
}
