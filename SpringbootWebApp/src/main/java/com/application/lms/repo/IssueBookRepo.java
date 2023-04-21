package com.application.lms.repo;

import com.application.lms.entity.IssueBooks;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IssueBookRepo extends JpaRepository<IssueBooks, Integer> {

    public IssueBooks findByMemberId(int memberid);

    @Query(value = "select * from lms_issuebooks where member_id = :memberId", nativeQuery = true)
    public List<IssueBooks> findByMember(int memberId);

    @Query(value = "select * from lms_issuebooks where member_id = ? and is_returned = false;", nativeQuery = true)
    public IssueBooks findByIssueBook(int mid);
}
