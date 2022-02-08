package com.example.ios_back.service.Impl;

import com.example.ios_back.domain.Schedule;
import com.example.ios_back.domain.Subject;
import com.example.ios_back.repository.HomeworkRepository;
import com.example.ios_back.repository.ScheduleRepository;
import com.example.ios_back.repository.SubjectRepository;
import com.example.ios_back.service.HomeworkService;
import com.example.ios_back.service.ScheduleService;
import com.example.ios_back.service.SubjectService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
class HomeworkServiceImplTest {

    @Autowired
    HomeworkService homeworkService;
    @Autowired
    HomeworkRepository homeworkRepository;
    @Autowired
    ScheduleService scheduleService;
    @Autowired
    ScheduleRepository scheduleRepository;
    @Autowired
    SubjectService subjectService;
    @Autowired
    SubjectRepository subjectRepository;

    @Test
    @DisplayName("과목 추가")
    void addHomeworkTest() {
        //given
        Schedule schedule = Schedule.createSchedule(LocalDate.now());
        Schedule saveSchedule = scheduleRepository.save(schedule);
        Schedule findSchedule = scheduleService.findSchedule(saveSchedule.getDate());

        Long subjectId1 = subjectService.addSubject(findSchedule.getId(), "수학");
        Long subjectId2 = subjectService.addSubject(findSchedule.getId(), "과학");

        //when
        homeworkService.addHomework(subjectId1, "p.100");
        homeworkService.addHomework(subjectId2, "p.300");
        homeworkService.addHomework(subjectId1, "p.123");

        //then
        Subject subject1 = subjectRepository.findById(subjectId1).get();
        Subject subject2 = subjectRepository.findById(subjectId2).get();

        assertThat(subject1.getHomeworkList().size()).isEqualTo(2);
        assertThat(subject2.getHomeworkList().size()).isEqualTo(1);
    }
}