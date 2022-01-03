package com.example.ios_back.service;

import com.example.ios_back.domain.Classroom;
import com.example.ios_back.domain.User;

public interface ClassroomService {
    // 클래스룸 생성
    Classroom createClassroom(String username);

    // 클래스 룸에 사용자 추가
    User addUserToClassroom(User user);

    // 클래스 룸에 사용자 탈퇴
    void deleteUserInClassroom(User user);
}
