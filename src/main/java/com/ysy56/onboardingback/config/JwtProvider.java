package com.ysy56.onboardingback.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import java.security.Key;
import java.util.Base64;
import java.util.Date;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JwtProvider {

    @Value("${jwt.secret_key}")
    private String secretKey;

    private final SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
    private Key key;

    @PostConstruct
    public void init() {
        byte[] bytes = Base64.getDecoder().decode(secretKey);

        key = Keys.hmacShaKeyFor(bytes);
    }

    public String generateToken(String username, String role, Date expirationDate) {
        return Jwts.builder()
            .setSubject(username)
            .claim("auth", role)
            .setExpiration(expirationDate)
            .setIssuedAt(new Date())
            .signWith(key, signatureAlgorithm)
            .compact();
    }

    public Claims validateToken(String token) {
        try {
            return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
        } catch (JwtException e) {
            throw new RuntimeException("잘못된 JWT Token입니다.");
        }
    }

}