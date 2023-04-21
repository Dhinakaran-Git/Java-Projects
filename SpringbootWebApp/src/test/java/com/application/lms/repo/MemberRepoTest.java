package com.application.lms.repo;

import com.application.lms.entity.Member;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MemberRepoTest {
    
    @Autowired
    private MemberRepo memberRepo;
    
    @Test
    @DisplayName("get all member")
    void testAllMember(){
        List<Member> member = memberRepo.findAll();
        Assertions.assertNotNull(member);
        org.assertj.core.api.Assertions.assertThat(10).isEqualTo(member.size());
    }
    
    @Test
    @DisplayName("find by member")
    void testFindByMemberId(){
        Member m = new Member();
        Member ex = memberRepo.findByMember(101);
        Assertions.assertEquals("Dhinakaran", ex.getName());
        Assertions.assertEquals(101, ex.getMemberId());
    }
    
    @Test
    @DisplayName("find by member")
    void testFindByMemberName(){
        Member m = new Member();
        Member ex = memberRepo.findByName("Dhinakaran").get();
        Assertions.assertEquals(101, ex.getMemberId());
        Assertions.assertEquals("MEMBER", ex.getUserRole());
    }
}
