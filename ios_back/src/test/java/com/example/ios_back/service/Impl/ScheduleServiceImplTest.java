package com.example.ios_back.service.Impl;

import com.example.ios_back.domain.Schedule;
import com.example.ios_back.domain.Subject;
import com.example.ios_back.repository.ScheduleRepository;
import com.example.ios_back.repository.SubjectRepository;
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
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
class ScheduleServiceImplTest {

    @Autowired
    ScheduleRepository scheduleRepository;
    @Autowired
    ScheduleService scheduleService;
    @Autowired
    SubjectService subjectService;
    @Autowired
    SubjectRepository subjectRepository;

    @Test
    @DisplayName("일정 조회")
    void findScheduleTest() {
        //given
        Schedule schedule1 = Schedule.createSchedule(LocalDate.now());
        Schedule schedule2 = Schedule.createSchedule(LocalDate.of(2021, 9, 20));
        Schedule schedule3 = Schedule.createSchedule(LocalDate.of(2022, 2, 21));

        Schedule saveSchedule1 = scheduleRepository.save(schedule1);
        Schedule saveSchedule2 = scheduleRepository.save(schedule2);
        Schedule saveSchedule3 = scheduleRepository.save(schedule3);

        //when
        Schedule findSchedule1 = scheduleService.findSchedule(LocalDate.now());
        Schedule findSchedule2 = scheduleService.findSchedule(LocalDate.of(2021, 9, 20));
        Schedule findSchedule3 = scheduleService.findSchedule(LocalDate.of(2022, 2, 21));

        //then
        assertThat(findSchedule1).isEqualTo(saveSchedule1);
        assertThat(findSchedule2).isEqualTo(saveSchedule2);
        assertThat(findSchedule3).isEqualTo(saveSchedule3);
    }

    @Test
    @DisplayName("일정 조회_저장한 값이 없을 때")
    void findScheduleTest_null() {
        //given
        //when
        //then
        assertThrows(NoSuchElementException.class, () -> scheduleService.findSchedule(LocalDate.now()));
    }

    @Test
    @DisplayName("일정에 있는 과목리스트 조회")
    void findSubjectsTest() {
        //given
        Schedule schedule = Schedule.createSchedule(LocalDate.now());
        Schedule saveSchedule = scheduleRepository.save(schedule);
        Schedule findSchedule = scheduleService.findSchedule(saveSchedule.getDate());

        subjectService.addSubject(findSchedule.getId(), "수학");
        subjectService.addSubject(findSchedule.getId(), "과학");

        //when
        List<Subject> subjects = scheduleService.findSubjects(findSchedule.getId());

        //then
        assertThat(subjects.size()).isEqualTo(2);
    }
}