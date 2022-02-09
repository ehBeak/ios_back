package com.example.ios_back.controller.dto;

import com.example.ios_back.domain.Subject;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
public class HomeworkDTO {
    private Long id;
    private String name;
    private boolean complete;

    public HomeworkDTO(Long id, String name, boolean complete) {
        this.id = id;
        this.name = name;
        this.complete = complete;
    }
}
