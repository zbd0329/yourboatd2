package com.example.yourboard.controller;

import com.example.yourboard.dto.LoginRequestDto;
import com.example.yourboard.dto.SignupRequestDto;
import com.example.yourboard.dto.StatusCodeDto;
import com.example.yourboard.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth") //공통된 주소
public class UserController {

    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<StatusCodeDto> signup(@RequestBody SignupRequestDto signupRequestDto) {
        userService.signup(signupRequestDto);
        return ResponseEntity.ok(new StatusCodeDto( HttpStatus.OK.value(),"회원가입 성공"));
    }

    //관리자 가입 주소 따로 만들기

    @ResponseBody
    @PostMapping("/login")
    public ResponseEntity<StatusCodeDto> login(@RequestBody LoginRequestDto loginRequestDto, HttpServletResponse response) {
        userService.login(loginRequestDto, response);
        return ResponseEntity.ok(new StatusCodeDto(HttpStatus.OK.value(),"로그인 성공"));
    }


}





