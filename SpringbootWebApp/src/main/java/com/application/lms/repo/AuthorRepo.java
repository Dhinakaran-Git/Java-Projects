package com.application.lms.repo;

import com.application.lms.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepo extends JpaRepository<Author, Integer> {
 
    public Author findByAuthorName(String name); 
}
