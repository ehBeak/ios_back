package com.example.ios_back.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class TodoDTO {
    private SubjectDTO subjectDTO;
    private List<HomeworkDTO> homeworkDTOS;

    public TodoDTO(SubjectDTO subjectDTO, List<HomeworkDTO> homeworkDTOS) {
        this.subjectDTO = subjectDTO;
        this.homeworkDTOS = homeworkDTOS;
    }
}
