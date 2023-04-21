package com.application.lms.serviceImpl;

import com.application.lms.apirequest.IssueBookRequest;
import com.application.lms.entity.BookCopies;
import com.application.lms.entity.Books;
import com.application.lms.entity.IssueBooks;
import com.application.lms.entity.Member;
import com.application.lms.repo.BookCopiesRepo;
import com.application.lms.repo.BookRepo;
import com.application.lms.repo.IssueBookRepo;
import com.application.lms.repo.MemberRepo;
import com.application.lms.service.IssueBookService;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IssueBookServiceImpl implements IssueBookService {

    @Autowired
    private MemberRepo memberRepo;

    @Autowired
    private BookRepo bookRepo;

    @Autowired
    private BookCopiesRepo bookCopiesRepo;

    @Autowired
    private IssueBookRepo issueBookRepo;

    private final Timestamp timeStamp = new Timestamp(new Date().getTime());

    @Override
    public List<IssueBooks> getIssueBooks() {
        return issueBookRepo.findAll();
    }

    @Override
    public String addIssueBook(IssueBookRequest issueBookRequest) {

        Optional<Member> chMembers = memberRepo.findById(issueBookRequest.getMemberId());
        Books chBooks = bookRepo.findByBookId(issueBookRequest.getIsbnNo());
        System.out.println("ChBooks : "+ chBooks);
        System.out.println("ChBooks BOOKID: "+ chBooks.getBookId());
        int bookCopieId = 0;
        boolean flag = false;
        if (!chMembers.isEmpty() && chMembers.get().getMemberId() == issueBookRequest.getMemberId() && "Available".equals(chMembers.get().getMemberStatus())) {
            bookCopieId = chBooks.getBookCopies().iterator().next().getBookCopiesId();
            if (bookCopieId != 0 && "Available".equals(chBooks.getBookCopies().iterator().next().getBookStatus())) {
                flag = true;
            } else {
                return "The Book is not available";
            }
        } else {
            return "The Memebr is not registered";
        }
        System.out.println("flage " + flag);
        if (getIssueBooks().iterator().next().isReturned() == true && getIssueBooks().iterator().next().getMemberId() != issueBookRequest.getMemberId() && flag == true) {
            BookCopies bookCopies = BookCopies
                    .builder()
                    .bookCopiesId(bookCopieId)
                    .bookid(chBooks.getBookId())
                    .bookStatus("Issued")
                    .build();
            bookCopiesRepo.save(bookCopies);

            IssueBooks issueBook = IssueBooks
                    .builder()
                    .bookCopiesId(bookCopieId)
                    .outDate(timeStamp.toString())
                    .memberId(issueBookRequest.getMemberId())
                    .isReturned(false)
                    .build();
            issueBookRepo.save(issueBook);
            return "The Book is Issued Successfully";
        } else {
            return "Member is Already taken the book";
        }
    }
    
    public String collectBook(IssueBookRequest collectRequest){
        
        List<BookCopies> bc = bookRepo.findByBookId(collectRequest.getIsbnNo()).getBookCopies();
        if ("Issued".equals(bc.iterator().next().getBookStatus()) && issueBookRepo.findByMemberId(collectRequest.getMemberId()).getMemberId() == collectRequest.getMemberId()) {
            return "book is collected successfully";
        }else{
            return "book is not available";
        }
    }
}
