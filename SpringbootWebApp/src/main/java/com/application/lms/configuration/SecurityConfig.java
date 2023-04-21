package com.application.lms.configuration;

import com.application.lms.serviceImpl.UserDetailsServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final String[] ALLOWEDACCESS = {"/login"};
    private final String[] USERACCESS = {""};
    private final String[] ANYACCESS = {
        "/",
        "/book/api/issuelist",
        "/book/api/viewbooks",
        "/book/api/viewbook",
        "/book/api/books",
        "/book/api/book/{bid}",
        "/member/api/viewMembers",
        "/member/api/memberbyid/{mid}"
    };
    private final String[] ADMINACCESS = {
        "/book/api/issuebook",
        "/book/api/collectbook",
        "/book/api/newbook",
        "/book/api/updatebook/{bid}",
        "/book/api/updatebook",
        "/book/api/delbook/{bid}",
        "/member/api/register",
        "/member/api/delmember/{mid}",
        "/member/api/updatemember/{mid}",
        "/member/api/updatemember"
    };

    @Bean
    public UserDetailsService userDetailsService() {
        return new UserDetailsServiceImpl();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .cors().disable()
                .csrf().disable()
                .authorizeHttpRequests(authorizeHttpRequestsCustomizer -> {
                    authorizeHttpRequestsCustomizer.requestMatchers(ALLOWEDACCESS)
                            .permitAll();
                })
                .authorizeHttpRequests()
                .requestMatchers(USERACCESS).hasAuthority("MEMBER")
                .requestMatchers(ADMINACCESS).hasAuthority("ADMIN")
                .requestMatchers(ANYACCESS).hasAnyAuthority("MEMBER", "ADMIN")
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic().and()
                .formLogin(Customizer.withDefaults());
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}
