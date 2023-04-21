package com.application.lms.repo;

import com.application.lms.entity.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepo extends JpaRepository<Books, Integer> {

    @Query(value = "select * from lms_books where isbn_no = :isbnNo", nativeQuery = true)
    public Books findByBookId(int isbnNo);
}
