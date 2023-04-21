package com.application.lms.repo;

import com.application.lms.entity.IssueBooks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IssueBookRepo extends JpaRepository<IssueBooks, Integer> {

    public IssueBooks findByMemberId(int memberid); 
}
