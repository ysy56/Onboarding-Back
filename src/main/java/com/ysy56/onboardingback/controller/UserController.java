package com.ysy56.onboardingback.controller;

import com.ysy56.onboardingback.dto.SignupRequestDto;
import com.ysy56.onboardingback.dto.SignupResponseDto;
import com.ysy56.onboardingback.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<SignupResponseDto> signup(@RequestBody @Valid SignupRequestDto signupRequestDto) {
        SignupResponseDto signupResponseDto = userService.signup(signupRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(signupResponseDto);
    }

}
