package com.ysy56.onboardingback.repository;

import com.ysy56.onboardingback.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
