package com.ysy56.onboardingback.repository;

import com.ysy56.onboardingback.entity.Authority;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {

    Optional<Authority> findByAuthorityName(String roleUser);

}
