package com.example.ios_back.domain;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "memo")
public class Memo {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "memo_id")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "schedule_id")
    private Schedule schedule;

    private String content;
}
