package com.application.lms.controller;

import com.application.lms.entity.Member;
import com.application.lms.serviceImpl.MemberServiceImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberController {

    @Autowired
    private MemberServiceImpl memberServiceImpl;

    @GetMapping("/member")
    public List<Member> getAllMember() {
        return memberServiceImpl.getMembers();
    }

    @PostMapping(value = "/addmember")
    public Member addMembers(@RequestBody Member members) {
        return memberServiceImpl.saveMember(members);
    }

    @PutMapping("/update/{id}")
    public Member updateMember(@RequestBody Member members) {
        return memberServiceImpl.updateMember(members);
    }

    @DeleteMapping("/delete/{mid}")
    public String delMember(@PathVariable int mid) {
        memberServiceImpl.deleteMember(mid);
        return mid + " Member is deleted";
    }
}
