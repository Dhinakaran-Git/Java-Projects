package com.application.lms.repo;

import com.application.lms.entity.Member;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MemberRepo extends JpaRepository<Member, Integer>{
    
    @Query(value = "select * from lms_members where member_id = :mid", nativeQuery = true)
    public Member findByMember(int mid);
    
    public Optional<Member> findByName(String username);
}
