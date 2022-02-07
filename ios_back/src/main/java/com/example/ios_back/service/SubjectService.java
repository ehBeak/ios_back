package com.example.ios_back.service;

import com.example.ios_back.domain.Homework;

import java.util.List;

public interface SubjectService {
    /*
     * 과목 객체에 연결된 숙제객체 조회
     * */
    public List<Homework> findHomeworks(Long SubjectId);

}
