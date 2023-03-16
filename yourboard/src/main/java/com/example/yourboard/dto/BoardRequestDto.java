package com.example.yourboard.dto;

import com.example.yourboard.entity.Board;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class BoardRequestDto {
    private Long id;
    private String title;
    private String comment;
    private String username;
    private LocalDateTime ModifiedAt;
    private LocalDateTime createdAt;


}
