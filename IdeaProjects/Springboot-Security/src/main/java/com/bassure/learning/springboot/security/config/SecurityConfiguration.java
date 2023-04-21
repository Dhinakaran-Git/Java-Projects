package com.bassure.learning.springboot.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;


@Configuration
@EnableWebSecurity(debug = true)
public class SecurityConfiguration {

/*
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests()
                .requestMatchers("/user")
                .permitAll()
                .and()
                .authorizeHttpRequests()
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
        return http.build();
    }
    
    
INMEMORYCONFIGURATION METHOD
    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager() {
        UserDetails user = User.withDefaultPasswordEncoder().username("user").password("user").roles("USER").build();
        UserDetails admin = User.withDefaultPasswordEncoder().username("admin").password("admin").roles("ADMIN").build();
        System.out.println(user);
        System.out.println(admin);
        return new InMemoryUserDetailsManager(user, admin);
    }
    
    
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
        
METHOD 1
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests()
                .requestMatchers("/").permitAll()
                .and()
                .authorizeHttpRequests().requestMatchers("/user").hasRole("USER")
                .and()
                .authorizeHttpRequests().requestMatchers("/admin").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .httpBasic(Customizer.withDefaults()).formLogin();


METHOD 2 USING LAMBDA
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(
                        authorizationManagerRequestMatcherRegistry -> {
                            authorizationManagerRequestMatcherRegistry.requestMatchers("/").permitAll();
                            authorizationManagerRequestMatcherRegistry.requestMatchers("/user").hasRole("USER");
                            authorizationManagerRequestMatcherRegistry.requestMatchers("/admin").hasRole("ADMIN");
                        }
                )
                .authorizeHttpRequests()
                .anyRequest()
                .authenticated().and()
                .httpBasic(Customizer.withDefaults()).formLogin();
    return http.build();
    }
*/

}
