package com.example.yourboard.controller;


import com.example.yourboard.dto.BoardRequestDto;
import com.example.yourboard.dto.BoardResponseDto;
import com.example.yourboard.dto.StatusCodeDto;
import com.example.yourboard.entity.Board;
import com.example.yourboard.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService; //서비스 변수는 여기서 왜 필요한가?

    @PostMapping("/api/post") //게시글 저장
    public BoardResponseDto writeBoard(@RequestBody BoardRequestDto boardDto, HttpServletRequest requestDto) {

        return boardService.writeBoard(boardDto,requestDto);
    }


    @GetMapping("/api/posts") //게시글 전체 조회
    public List<BoardResponseDto> getBoard(){
        return boardService.getBoard();
    } //복수형 추천

    @GetMapping("/api/post/{id}") //게시글 세부조회 //주소변경
    public BoardResponseDto findBoard(@PathVariable Long id) {
        return boardService.findBoard(id); //소대문자 구문잘해서 쓰자
    }

    @PutMapping("/api/post/{id}") //비밀번호 조회 후 게시글 수정
    public BoardResponseDto updateBoard(@PathVariable Long id,@RequestBody BoardRequestDto boardRequestDto, HttpServletRequest requestDto)
    {
       return boardService.updateBoard(id,boardRequestDto,requestDto);
    }

    @DeleteMapping("/api/post/{id}")
    public ResponseEntity<StatusCodeDto> deleteBoard(@PathVariable Long id, HttpServletRequest requestDto) {

        return boardService.deleteBoard(id, requestDto);
    }
}




