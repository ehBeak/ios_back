package com.example.ios_back.repository;

import com.example.ios_back.domain.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    /*
     * 해당 날짜에 따른 스케쥴 객체 조회
     * */
    Optional<Schedule> findByDate(LocalDate date);

    /*
     * 스케쥴 객체 저장
     * */
    @Override
    <S extends Schedule> S save(S entity);
}
