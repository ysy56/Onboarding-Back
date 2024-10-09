package com.ysy56.onboardingback.dto;

import java.util.List;
import lombok.Getter;

@Getter
public class SignupResponseDto {
    private String username;
    private String nickname;
    private List<String> authorities;

    public SignupResponseDto(String username, String nickname, List<String> authorities) {
        this.username = username;
        this.nickname = nickname;
        this.authorities = authorities;
    }

}
