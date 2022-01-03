package com.example.ios_back.domain;

public class Classroom {
    private Long id;
    private Long teacherId;

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
}
