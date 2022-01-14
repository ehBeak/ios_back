package com.example.ios_back.repository;

import com.example.ios_back.domain.User;

import java.util.Optional;

public interface UserRepository {
    // 조회
    Optional<User> findUserByUsername(String Username);

    Optional<User> findUserById(Long userId);

    // 회원가입
    User save(User user);

    // 로그인
    void login();

    // 회원탈퇴
    void withdraw();

    // 친구 저장
    void addFriend();

    // 친구 삭제
    void removeFriend();

    void clear();

}
