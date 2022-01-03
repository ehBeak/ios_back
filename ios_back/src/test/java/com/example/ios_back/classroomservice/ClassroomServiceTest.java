package com.example.ios_back.classroomservice;

import com.example.ios_back.config.AppConfig;
import com.example.ios_back.domain.Authority;
import com.example.ios_back.domain.Classroom;
import com.example.ios_back.domain.User;
import com.example.ios_back.repository.UserRepository;
import com.example.ios_back.repository.memoryRepository.MemoryUserRepository;
import com.example.ios_back.service.ClassroomService;
import com.example.ios_back.service.ClassroomServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;

public class ClassroomServiceTest {

    ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("선생님이 클래스를 생성한다.")
    void createClassroomTest() {
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
}
