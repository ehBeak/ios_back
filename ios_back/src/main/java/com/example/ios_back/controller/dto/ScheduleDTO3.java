package com.example.ios_back.controller.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
public class ScheduleDTO3 {
    private Long id;
    private LocalDate date;
    private boolean complete;

    public ScheduleDTO3(Long id, LocalDate date, boolean complete) {
        this.id = id;
        this.date = date;
        this.complete = complete;
    }
}
