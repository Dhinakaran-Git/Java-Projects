package com.application.lms.repo;

import com.application.lms.entity.BookCopies;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BookCopiesRepo extends JpaRepository<BookCopies, Integer>{

    public List<BookCopies> findByBookid(int bid);

    @Query(value = "select * from lms_bookcopies where book_id = :bid limit 1", nativeQuery = true)
    public Optional<BookCopies> findByBookidOne(int bid);

    @Query(value = "update lms_bookcopies set book_status = 'Removed' WHERE bookcopies_id = :bcid", nativeQuery = true)
    public void removeByBookId(int bcid);

    @Query(value = "select * from lms_bookcopies where book_status = 'Available' and bookcopies_id = :bookCopiesId", nativeQuery = true)
    public List<BookCopies> getAvailableCount(int bookCopiesId);
}
