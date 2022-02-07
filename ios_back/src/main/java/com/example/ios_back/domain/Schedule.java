package com.example.ios_back.domain;

import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "schedule")
@Getter
public class Schedule {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "schedule_id")
    private Long id;

    @OneToMany(mappedBy = "schedule")
    private List<Memo> memoList = new ArrayList<>();

    @OneToMany(mappedBy = "schedule")
    private List<Subject> subjectList = new ArrayList<>();

    private String name; // 그룹 이름
    private LocalDateTime date;
    private String teacherName;

}
