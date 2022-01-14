package com.example.ios_back.config;

import com.example.ios_back.repository.ClassroomRepository;
import com.example.ios_back.repository.MemoRepository;
import com.example.ios_back.repository.UserRepository;
import com.example.ios_back.repository.memoryRepository.MemoryClassroomRepository;
import com.example.ios_back.repository.memoryRepository.MemoryMemoRepository;
import com.example.ios_back.repository.SubjectRepository;
import com.example.ios_back.repository.UserRepository;
import com.example.ios_back.repository.memoryRepository.MemoryClassroomRepository;
import com.example.ios_back.repository.memoryRepository.MemorySubjectRepository;
import com.example.ios_back.repository.memoryRepository.MemoryUserRepository;
import com.example.ios_back.service.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public ClassroomService classroomService() {
        return new ClassroomServiceImpl(userRepository(), classroomRepository(), authorityPolicy(), subjectRepository());
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

    @Bean
    public MemoRepository memoRepository() {
        return new MemoryMemoRepository();
    }

    @Bean
    public MemoService memoService() {
        return new MemoService(memoRepository(), userRepository());
    }

    @Bean
    public SubjectRepository subjectRepository() {
        return new MemorySubjectRepository();
    }


}
