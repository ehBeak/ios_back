package com.example.ios_back.domain;

import java.util.Date;

public class Calendar {
    private Long id;
    private Date date;
    private Double compelete;
    private User user;
    private Memo memo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getCompelete() {
        return compelete;
    }

    public void setCompelete(Double compelete) {
        this.compelete = compelete;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Memo getMemo() {
        return memo;
    }

    public void setMemo(Memo memo) {
        this.memo = memo;
    }
}
