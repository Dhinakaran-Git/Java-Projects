package com.bassure.learning.springmvc.lms.Service;

import com.bassure.learning.springmvc.lms.Repository.MemberRepository;
import com.bassure.learning.springmvc.lms.model.Member;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    public List<Member> getMembers() {
        return memberRepository.getMembers();
    }

    public String addMember(Member member) {
        if (memberRepository.addMember(member)) {
            return "member added";
        } else {
            return "something went worng";
        }
    }

    public void removeMember(int mid) {
        System.out.println(mid);
        memberRepository.deleteMember(mid);
    }

    public Boolean updateMember(Member member) {
        System.out.println(member +"in update service");
      return  memberRepository.updateMember(member);
    }

    public Member getMember(int mid) {
        return memberRepository.findMember(mid);
    }

}
