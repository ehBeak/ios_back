package com.example.ios_back.domain;

public class Subject {

    private Long id;
    private Subject subject;

    public Long getId() {
        return id;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }
}
