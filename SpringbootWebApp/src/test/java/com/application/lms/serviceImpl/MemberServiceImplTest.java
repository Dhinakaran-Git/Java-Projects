package com.application.lms.serviceImpl;

import com.application.lms.apirequest.MemberRequest;
import com.application.lms.entity.Member;
import com.application.lms.repo.MemberRepo;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MemberServiceImplTest {

    @Mock
    private MemberRepo memberRepo;

    @InjectMocks
    private MemberServiceImpl memberServiceImpl;

    Member member;
    List<Member> members = new ArrayList<>();

    @BeforeEach
    public void init() {

        member = new Member(10, "dhina", 2, "male", 234234234);

        members.add(member);
        members.add(new Member(11, "dhina1", 2, "male", 234234234));
    }

    @Test
    public void checkMemberById() {

        Mockito.when(memberRepo.findByMember(ArgumentMatchers.any(Integer.class))).thenReturn(member);

        Member findMember = memberServiceImpl.getMember(member.getMemberId());
        Assertions.assertNotNull(findMember);
        Assertions.assertEquals(member.getMemberId(), findMember.getMemberId());
    }

    @Test
    public void getMemberTest() {
        Mockito.when(memberRepo.findAll()).thenReturn(members);
        List<Member> allMembers = memberServiceImpl.getMembers();
        Assertions.assertNotNull(allMembers);
        Assertions.assertEquals(allMembers.size(), members.size());
    }

    @Test
    public void addMemberTest() {
        Mockito.when(memberRepo.save(ArgumentMatchers.any(Member.class))).thenReturn(member);

        MemberRequest memberRequest = new MemberRequest(0, "dhina", "1234", 2, "male", 234234234, "USER");

        Member member1 = memberServiceImpl.saveMember(memberRequest);
        Assertions.assertNotNull(member1);
        Assertions.assertEquals(memberRequest.getName(), member1.getName());
    }

}
