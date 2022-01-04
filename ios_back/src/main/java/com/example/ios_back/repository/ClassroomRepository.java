package com.example.ios_back.repository;

import com.example.ios_back.domain.Classroom;

import java.util.Map;
import java.util.Optional;

public interface ClassroomRepository {

    /* 클래스룸 저장 */
    void save(Classroom classroom);

    /* 클래스룸 조회 */
    Optional<Classroom> findByTeacherId(Long teacherId);

    void clear();
}
