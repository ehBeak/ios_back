package com.example.ios_back.domain;

import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "schedule")
@Getter
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "schedule_id")
    private Long id;

    @OneToMany(mappedBy = "schedule")
    private List<Memo> memoList = new ArrayList<>();

    @OneToMany(mappedBy = "schedule")
    private List<Subject> subjectList = new ArrayList<>();

    private LocalDate date;

    //==생성 메소드==//
    public static Long createSchedule(LocalDate date) {
        Schedule schedule = new Schedule();
        schedule.date = date;
        return schedule.id;
    }
}
