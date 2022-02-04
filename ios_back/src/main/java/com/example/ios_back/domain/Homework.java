package com.example.ios_back.domain;

import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "homework")
@Getter
public class Homework {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "homework")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subject_id")
    private Subject subject;

    private LocalDateTime date;
    private String name;
    private boolean complete;
}
