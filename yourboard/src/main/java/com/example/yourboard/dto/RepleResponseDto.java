package com.example.yourboard.dto;

import com.example.yourboard.entity.Reple;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class RepleResponseDto {
    private Long id;
    private String reple;
    private String username;
    private LocalDateTime ModifiedAt;
    private LocalDateTime createdAt;

    public RepleResponseDto(Reple reple) {
        this.id = reple.getId();
        this.reple = reple.getReple();
        ModifiedAt = reple.getModifiedAt();
        this.createdAt = reple.getCreatedAt();
        this.username = reple.getUser().getUsername(); //욘석 이해몬했다
    }
}
