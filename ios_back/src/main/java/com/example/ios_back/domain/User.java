package com.example.ios_back.domain;

import java.util.ArrayList;
import java.util.List;

public class User {

    private Long id;
    private String name;
    private String phoneNumber;
    private String email;
    private String password;
    private String realName;
    private String school;
    private int grade;
    private String parentPhone;
    private List<User> friends = new ArrayList<>();
    private Authority Authority;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getParentPhone() {
        return parentPhone;
    }

    public void setParentPhone(String parentPhone) {
        this.parentPhone = parentPhone;
    }

    public List<User> getFriends() {
        return friends;
    }

    public void setFriends(List<User> friends) {
        this.friends = friends;
    }

    public com.example.ios_back.domain.Authority getAuthority() {
        return Authority;
    }

    public void setAuthority(com.example.ios_back.domain.Authority authority) {
        Authority = authority;
    }
}
