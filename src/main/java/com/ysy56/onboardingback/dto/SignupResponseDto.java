package com.ysy56.onboardingback.dto;

import lombok.Getter;

@Getter
public class SignupResponseDto {
    private String username;
    private String nickname;
    private String[] authorities;

    public SignupResponseDto(String username, String nickname, String[] authorities) {
        this.username = username;
        this.nickname = nickname;
        this.authorities = authorities;
    }

}
