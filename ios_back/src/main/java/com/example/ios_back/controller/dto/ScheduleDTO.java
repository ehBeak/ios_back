package com.example.ios_back.controller.dto;

import com.example.ios_back.domain.Homework;
import com.example.ios_back.domain.Memo;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter @Setter
public class ScheduleDTO {

    private Map<String, Homework> homeworkMap = new HashMap<>();
    private Memo memo;

}
