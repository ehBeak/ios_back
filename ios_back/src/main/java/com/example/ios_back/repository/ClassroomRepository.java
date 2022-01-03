package com.example.ios_back.repository;

import com.example.ios_back.domain.Classroom;

import java.util.Optional;

public interface ClassroomRepository {

    /* 클래스룸 생성 */
    Classroom createClassroom(Long teacherId);

    /* 클래스룸 조회 */
    Optional<Classroom> findByTeacherId(Long teacherId);
}
