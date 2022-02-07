package com.example.ios_back.service.Impl;

import com.example.ios_back.domain.Memo;
import com.example.ios_back.domain.Schedule;
import com.example.ios_back.repository.MemoRepository;
import com.example.ios_back.repository.ScheduleRepository;
import com.example.ios_back.service.MemoService;
import com.example.ios_back.service.ScheduleService;
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
class MemoServiceImplTest {

    @Autowired ScheduleService scheduleService;
    @Autowired ScheduleRepository scheduleRepository;
    @Autowired MemoService memoService;
    @Autowired MemoRepository memoRepository;

    @Test
    @DisplayName("메모 저장_content")
    void saveMemo_content() {
        //given
        Schedule schedule = Schedule.createSchedule(LocalDate.now());
        Schedule saveSchedule = scheduleRepository.save(schedule);
        Schedule findSchedule = scheduleService.findSchedule(LocalDate.now());

        //when
        memoService.saveMemo(findSchedule.getId(), "메모메모메모메모");

        //then
        assertThat(memoRepository.findBySchedule(findSchedule).get().getContent()).isEqualTo("메모메모메모메모");
    }

    @Test
    @DisplayName("메모 저장_schedule")
    void saveMemo_schedule() {

    }

}