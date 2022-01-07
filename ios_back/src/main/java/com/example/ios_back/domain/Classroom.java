package com.example.ios_back.domain;

import java.util.ArrayList;
import java.util.List;

public class Classroom {
    private Long id;
    private Long teacherId;

    private List<Subject> subjectList = new ArrayList<>();

    public Classroom() {
    }

    public Classroom(Long teacherId) {
        this.teacherId = teacherId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }

    public List<Subject> getSubjectList() {
        return subjectList;
    }

    public void setSubjectList(List<Subject> subjectList) {
        this.subjectList = subjectList;
    }
}
