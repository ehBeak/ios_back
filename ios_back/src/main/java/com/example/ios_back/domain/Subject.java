package com.example.ios_back.domain;

public class Subject {

    private Long id;
    private Classroom classroom;
    private String name;


    public Subject() {
    }

    public Subject(Classroom classroom, String name) {
        this.classroom = classroom;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Classroom getClassroom() {
        return classroom;
    }

    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
