package com.example.jwt.config;

import com.example.jwt.model.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

// TODO: why to write @Configuration annotation here? ;
// bcz when app started this class will initiated at once for beans, this class contains all the beans of our application
@Configuration
@RequiredArgsConstructor
public class ApplicationConfig {
    private final UserRepository repository;

    @Bean
    public UserDetailsService userDetailsService(){
        return username -> repository.findByEmail(username)
                .orElseThrow(()->new UsernameNotFoundException("User not found"));
    }
}
