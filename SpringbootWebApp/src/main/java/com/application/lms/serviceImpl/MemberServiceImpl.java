package com.application.lms.serviceImpl;

import com.application.lms.apirequest.MemberRequest;
import com.application.lms.entity.Member;
import com.application.lms.repo.MemberRepo;
import com.application.lms.service.MemberService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired(required = true)
    private MemberRepo memberRepo;

    @Override
    public List<Member> getMembers() {
        return memberRepo.findAll();
    }

    @Override
    public Member getMember(int mid) {
        return memberRepo.findByMember(mid);
    }

    @Override
    public Member saveMember(MemberRequest memberRequest) {
        Member member = new Member(
                memberRequest.getName(),
                memberRequest.getPassword(),
                memberRequest.getAge(),
                memberRequest.getGender(),
                memberRequest.getNum(),
                memberRequest.getUserRole(),
                "Available"
        );
        Member member1 = memberRepo.save(member);
        return member1;
    }

    @Override
    public void removeMember(int member) {
        memberRepo.deleteById(member);
    }

    @Override
    public Member updateMember(MemberRequest memberRequest, int id) {
        Member mem = new Member(
                memberRequest.getName(),
                memberRequest.getPassword(),
                memberRequest.getAge(),
                memberRequest.getGender(),
                memberRequest.getNum(),
                memberRequest.getUserRole(),
                "Available"
        );
        System.out.println(mem);
        mem.setMemberId(id);
        return memberRepo.save(mem);
    }

    public Optional<Member> findByMemberName(String name) {
        return memberRepo.findByName(name);
    }
}
