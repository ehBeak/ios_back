package com.example.ios_back.classroomservice;

import com.example.ios_back.config.AppConfig;
import com.example.ios_back.domain.Authority;
import com.example.ios_back.domain.Classroom;
import com.example.ios_back.domain.User;
import com.example.ios_back.repository.ClassroomRepository;
import com.example.ios_back.repository.UserRepository;
import com.example.ios_back.repository.memoryRepository.MemoryUserRepository;
import com.example.ios_back.service.ClassroomService;
import com.example.ios_back.service.ClassroomServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;

public class ClassroomServiceTest {

    ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @BeforeEach
    void beforeEach() {
        ClassroomService classroomService = ac.getBean(ClassroomService.class);
        UserRepository userRepository = ac.getBean(UserRepository.class);
        ClassroomRepository classroomRepository = ac.getBean(ClassroomRepository.class);

        userRepository.clear();
        classroomRepository.clear();


    }

    @Test
    @DisplayName("클래스룸 추가_선생님")
    void createClassroomTest_TEACHER() {
        //given
        User user = new User();
        user.setAuthority(Authority.TEACHER);
        user.setName("teacherA");

        UserRepository userRepository = ac.getBean(UserRepository.class);
        userRepository.save(user);

        //when
        ClassroomService classroomService = ac.getBean(ClassroomService.class);
        Classroom newClassroom = classroomService.createClassroom("teacherA");

        //then
        assertThat(newClassroom.getTeacherId()).isEqualTo(user.getId());
    }

    @Test
    @DisplayName("클래스룸 추가_학생")
    void createClassroomTest_STUDNET() {
        //given
        User user = new User();
        user.setAuthority(Authority.STUDENT);
        user.setName("teacherA");

        UserRepository userRepository = ac.getBean(UserRepository.class);
        userRepository.save(user);

        //when
        ClassroomService classroomService = ac.getBean(ClassroomService.class);
        Classroom newClassroom = classroomService.createClassroom("teacherA");

        //then
        assertThat(newClassroom).isNull();
    }

}
