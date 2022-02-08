package com.example.ios_back.service.Impl;

import com.example.ios_back.domain.Schedule;
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

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
class SubjectServiceImplTest {

    @Autowired
    SubjectService subjectService;
    @Autowired
    SubjectRepository subjectRepository;
    @Autowired
    ScheduleRepository scheduleRepository;
    @Autowired
    ScheduleService scheduleService;

    @Test
    @DisplayName("과목 추가")
    void addSubject() {
        //given
        Schedule schedule = Schedule.createSchedule(LocalDate.now());
        Schedule saveSchedule = scheduleRepository.save(schedule);
        Schedule findSchedule = scheduleService.findSchedule(saveSchedule.getDate());

        //when
        Long subjectId = subjectService.addSubject(findSchedule.getId(), "수학");

        //then
        Assertions.assertThat(subjectRepository.findById(subjectId).get().getName()).isEqualTo("수학");
    }
}