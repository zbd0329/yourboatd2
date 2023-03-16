package com.example.yourboard.controller;

import com.example.yourboard.dto.RepleRequestDto;
import com.example.yourboard.dto.RepleResponseDto;
import com.example.yourboard.service.RepleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/reple")
public class RepleController {

    private final RepleService repleService;

    @PostMapping("/{postId}")
    public RepleResponseDto createReply(@PathVariable Long postId, @RequestBody RepleRequestDto repleRequestDto, HttpServletRequest request) {
        return repleService.createReply(postId, repleRequestDto, request);
    }

    @PutMapping("/{replyId}")
    public RepleResponseDto updateReply(@PathVariable Long replyId, @RequestBody RepleRequestDto repleRequestDto, HttpServletRequest request) {
        return repleService.update(replyId, repleRequestDto, request);
    }

    @DeleteMapping("/{replyId}")
    public ResponseEntity<String> deleteReply(@PathVariable Long replyId, HttpServletRequest request) {
        return repleService.delete(replyId, request);
    }

//컨트롤러에서 아무것도 안하고 그대로 보낸다.




}
