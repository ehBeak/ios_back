package com.example.ios_back.service;

import com.example.ios_back.domain.Classroom;
import com.example.ios_back.domain.Subject;
import com.example.ios_back.domain.User;

public interface ClassroomService {

    // 클래스룸 생성
    Classroom createClassroom(String username);

    // 클래스 룸에 과목 추가
    Subject addSubject(Classroom classroom, User user, String subjectName);

}
