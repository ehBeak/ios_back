package com.example.ios_back.config;

import com.example.ios_back.repository.ClassroomRepository;
import com.example.ios_back.repository.UserRepository;
import com.example.ios_back.repository.memoryRepository.MemoryClassroomRepository;
import com.example.ios_back.repository.memoryRepository.MemoryUserRepository;
import com.example.ios_back.service.AuthorityPolicy;
import com.example.ios_back.service.AuthorityPolicyImpl;
import com.example.ios_back.service.ClassroomService;
import com.example.ios_back.service.ClassroomServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public ClassroomService classroomService() {
        return new ClassroomServiceImpl(userRepository(), classroomRepository(), authorityPolicy());
    }

    @Bean
    public AuthorityPolicy authorityPolicy() {
        return new AuthorityPolicyImpl(userRepository());
    }

    @Bean
    public UserRepository userRepository() {
        return new MemoryUserRepository();
    }

    @Bean
    public ClassroomRepository classroomRepository() {
        return new MemoryClassroomRepository();
    }


}
