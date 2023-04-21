package com.application.lms.serviceImpl;

import com.application.lms.entity.Member;
import com.application.lms.repo.MemberRepo;
import com.application.lms.service.MemberService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {
    
    @Autowired
    private MemberRepo memberRepo;
    
    @Override
    public List<Member> getMembers() {
        return memberRepo.findAll();
    }
    
    @Override
    public Member saveMember(Member m) {
        return memberRepo.save(m);
    }
    
    @Override
    public Member updateMember(Member m) {
        Member mem = memberRepo.findById(m.getMemberId()).orElse(null);
        mem.setName(m.getName());
        mem.setAge(m.getAge());
        mem.setGender(m.getGender());
        mem.setNumber(m.getNumber());
        mem.setMemberStatus(m.getMemberStatus());
        return memberRepo.save(mem);
    }

    @Override
    public void deleteMember(int m) {
        memberRepo.deleteById(m);
    }
}
