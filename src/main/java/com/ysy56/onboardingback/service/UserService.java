package com.ysy56.onboardingback.service;

import com.ysy56.onboardingback.entity.UserAuthority;
import com.ysy56.onboardingback.repository.AuthorityRepository;
import com.ysy56.onboardingback.repository.UserAuthorityRepository;
import com.ysy56.onboardingback.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final AuthorityRepository authorityRepository;
    private final UserAuthorityRepository userAuthorityRepository;
    private final PasswordEncoder passwordEncoder;


}
