package com.example.ios_back.repository;

import com.example.ios_back.domain.User;

public interface UserRepository {
    // 회원가입
    void join();
    // 로그인
    void login();
    // 회원탈퇴
    void withdraw();
    // 친구 저장
    void addFriend();
    // 친구 삭제
    void removeFriend();

    // 둘이 같이(카카오톡처럼)

}
