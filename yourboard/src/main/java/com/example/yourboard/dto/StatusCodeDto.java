package com.example.yourboard.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class StatusCodeDto {
    private int statusCode;
    private String msg;

    public StatusCodeDto(int statusCode, String msg) {
        this.statusCode = statusCode;
        this.msg = msg;

    }
}

//이게 현타 갑자기 오는 순간
//와 나 코드 좀 치게 된듯?
//과제를 받고나서?
//아닌듯?
//응애인듯