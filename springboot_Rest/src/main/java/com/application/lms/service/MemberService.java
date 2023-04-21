package com.application.lms.service;

import com.application.lms.entity.Member;
import java.util.List;

public interface MemberService {

    public List<Member> getMembers();
    
    public Member saveMember(Member m);
    
    public Member updateMember(Member m);

    public void deleteMember(int m);
}
