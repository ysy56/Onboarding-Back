package com.ysy56.onboardingback.service;

import com.ysy56.onboardingback.dto.SignupRequestDto;
import com.ysy56.onboardingback.dto.SignupResponseDto;
import com.ysy56.onboardingback.entity.Authority;
import com.ysy56.onboardingback.entity.User;
import com.ysy56.onboardingback.entity.UserAuthority;
import com.ysy56.onboardingback.repository.AuthorityRepository;
import com.ysy56.onboardingback.repository.UserAuthorityRepository;
import com.ysy56.onboardingback.repository.UserRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final AuthorityRepository authorityRepository;
    private final UserAuthorityRepository userAuthorityRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public SignupResponseDto signup(SignupRequestDto requestDto) {
        // 기본 권한 설정 (ROLE_USER)
        Authority authority = authorityRepository.findByAuthorityName("ROLE_USER")
            .orElseThrow(() -> new RuntimeException("기본 권한을 찾을 수 없습니다."));

        String encryptedPassword = passwordEncoder.encode(requestDto.getPassword());

        // User 객체 생성 및 저장
        User user = new User(requestDto.getUsername(), encryptedPassword, requestDto.getNickname());

        // UserAuthority 객체 생성 및 User 객체에 추가
        UserAuthority userAuthority = new UserAuthority(user, authority);
        user.getUserAuthorities().add(userAuthority); // User에 UserAuthority 추가

        // User 객체 저장
        userRepository.save(user); // User 객체 저장 시 UserAuthority도 자동으로 저장됨

        // 권한 목록 생성
        List<String> authorities = user.getUserAuthorities().stream()
            .map(ua -> ua.getAuthority().getAuthorityName())
            .collect(Collectors.toList());

        // SignupResponseDto 반환
        return new SignupResponseDto(user.getUsername(), user.getNickname(), authorities);
    }

}
