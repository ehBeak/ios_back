package com.example.ios_back.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Data
public class SubjectDTO {
    private Long id;
    private String name;

    public SubjectDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
