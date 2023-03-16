package com.example.yourboard.service;

import com.example.yourboard.dto.RepleRequestDto;
import com.example.yourboard.dto.RepleResponseDto;
import com.example.yourboard.entity.Board;
import com.example.yourboard.entity.Reple;
import com.example.yourboard.entity.User;
import com.example.yourboard.entity.UserRoleEnum;
import com.example.yourboard.jwt.JwtUtil;
import com.example.yourboard.repository.BoardRepository;
import com.example.yourboard.repository.RepleRepository;
import com.example.yourboard.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;

@Service
@RequiredArgsConstructor
public class RepleService {

    private final RepleRepository repleRepository;
    private final BoardRepository boardRepository;
    private final UserRepository userRepository;
    private final JwtUtil jwtUtil; //컨트롤쪽으로 주입

    @Transactional
    public RepleResponseDto createReply(Long boardId, RepleRequestDto repleRequestDto, HttpServletRequest request) {
        User user = jwtUtil.getUser(request); // 토큰이 있는 경우 사용자의 정보를 받아온다. >>> 컨트롤러에서 처리를 해서 서비스로 줘야한다. 유저 네임이 필요.
        Board board = getBoard(boardId);  // 게시글이 존재하는지 확인 후 가져온다

        Reple reple = new Reple(repleRequestDto); // 이제 리플에 넣어주면 됨
        reple.setBoard(board);
        reple.setUser(user);
        repleRepository.saveAndFlush(reple);

        return new RepleResponseDto(reple);
    }

    @Transactional
    public RepleResponseDto update(Long repleId, RepleRequestDto repleRequestDto, HttpServletRequest request) {
        User user = jwtUtil.getUser(request); // 토큰이 있는 경우 사용자의 정보를 받아온다.
        Reple reply = getReple(repleId); // 댓글이 존재하는지 확인 후 가져온다.
        checkRepleRole(repleId, user);  // 권한을 확인한다 (자신이 쓴 댓글인지 확인)
        reply.update(repleRequestDto);
        return new RepleResponseDto(reply);
    }

    @Transactional
    public ResponseEntity<String> delete(Long repleId, HttpServletRequest request) {
        User user = jwtUtil.getUser(request);      // 토큰이 있는 경우 사용자의 정보를 받아온다.
        getReple(repleId); // 댓글이 존재하는지 확인 후 가져온다.
        checkRepleRole(repleId, user);  // 권한을 확인한다 (자신이 쓴 댓글인지 확인)
        repleRepository.deleteById(repleId);
        return ResponseEntity.status(HttpStatus.OK).body("댓글 삭제 완료");
    }

    private Reple getReple(Long repleId){
        return repleRepository.findById(repleId).orElseThrow(
                () -> new IllegalArgumentException("댓글이 존재하지 않습니다.")
        );
    }

    private Board getBoard(Long boardId) {
        return boardRepository.findById(boardId).orElseThrow(
                () -> new IllegalArgumentException("게시글이 존재하지 않습니다.")
        );
    }
    private void checkRepleRole(Long repleId, User user) {
        if (user.getRole() == UserRoleEnum.ADMIN) return;
        repleRepository.findByIdAndUser(repleId, user).orElseThrow(
                () -> new IllegalArgumentException("권한이 없습니다.")
        );
    }
}

//리턴 부분에서는 엔터 한번.
//HttpServletRequest는 서비스에서 정제를해서 유저네임을 넣어줘야지 서비스로 넘어오면 안된다. 정제해서 보내주자.
//구조를 머릿속으로 그려놔야한다.
//1. HttpServletRequest는 매개변수로 넘어오면 안된다. 컨트롤러단에 있어야 한다.
//세터 대신에 생성자로 해도된다.
//총평 : 제네릭스


