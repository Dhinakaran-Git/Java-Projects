package com.application.lms.serviceImpl;

import com.application.lms.entity.BookCopies;
import com.application.lms.entity.Books;
import com.application.lms.repo.BookCopiesRepo;
import com.application.lms.service.BookCopiesService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookCopiesServiceImpl implements BookCopiesService {

    @Autowired
    private BookCopiesRepo bookCopiesRepo;

    @Override
    public List<BookCopies> getBookCopies() {
        return bookCopiesRepo.findAll();
    }

    public BookCopies newBookCopies(Books b) {
        BookCopies bc = BookCopies
                .builder()
                .bookStatus("Available")
                .bookid(b.getBookId())
                .build();
        return bookCopiesRepo.save(bc);
    }

    public List<BookCopies> getBookCopieid(int bid) {
        return bookCopiesRepo.findByBookid(bid);
    }

    public Optional<BookCopies> removeBookCopies(int bid) {
        return bookCopiesRepo.findByBookidOne(bid);
    }

    public void removeBookCopie(int bid) {
        bookCopiesRepo.removeByBookId(bid);
    }

    public List<BookCopies> getAvailableBooks(List<BookCopies> bookcopies) {
        return bookCopiesRepo.getAvailableCount(bookcopies.iterator().next().getBookCopiesId());
    }
}
