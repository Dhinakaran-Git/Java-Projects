package com.application.lms.service;

import com.application.lms.apirequest.MemberRequest;
import com.application.lms.entity.Member;
import java.util.List;

public interface MemberService {

    public List<Member> getMembers();

    public Member getMember(int mid);

    public Member saveMember(MemberRequest memberRequest);
    
    public void removeMember(int m);
    
    public Member updateMember(MemberRequest memberRequest, int id);
}
