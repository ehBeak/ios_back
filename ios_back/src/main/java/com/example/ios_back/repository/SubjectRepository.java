package com.example.ios_back.repository;

import com.example.ios_back.domain.Subject;

public interface SubjectRepository {
     /* CRUD */

    // 과목 저장
    void save(Subject subject);

    // id로 조회
    Subject findById(Long subjectId);
}
