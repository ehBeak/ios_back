package com.example.ios_back.controller.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemoDTO {
    private Long id;
    private String content;

    public MemoDTO(Long id, String content) {
        this.id = id;
        this.content = content;
    }
}
