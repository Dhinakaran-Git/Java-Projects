package com.application.lms.serviceImpl;

import com.application.lms.entity.Member;
import com.application.lms.entity.MyUserDetails;
import com.application.lms.repo.MemberRepo;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private MemberRepo memberRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Member> userInfo = memberRepo.findByName(username);
        return userInfo.map(MyUserDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException("User is not found" + username));
    }

}
