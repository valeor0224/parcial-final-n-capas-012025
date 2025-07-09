package com.uca.parcialfinalncapas.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtTokenProvider {
    @Value("${app.jwt-secret}")
    private String secret;

    @Value("${app.jwt-expiration-time}")
    private String expirationTime;

    public String generateToken(Authentication auth) {
        String username = auth.getName();
        Date now = new Date();
        Date expirationDate = new Date(now.getTime() + Long.parseLong(expirationTime));

        String token = Jwts.builder()
                .setSubject(username)
                .setIssuedAt(now)
                .setExpiration(expirationDate)
                .signWith(getKey())
                .compact();
        return token;
    }

    // Retrieves the secret key for signing and validating the JWT
    private Key getKey() {
        return Keys.hmacShaKeyFor(
                Decoders.BASE64.decode(secret)
        );
    }

    // Extracts the username from the provided JWT token
    public String getUsernameFromToken(String token) {
        String username = Jwts.parser() // Parse the JWT token
                .setSigningKey(getKey()) // Use the secret key for validation
                .build()
                .parseClaimsJws(token) // Parse the claims from the token
                .getBody()
                .getSubject(); // Retrieve the subject (username) from the claims
        return username; // Return the extracted username
    }

    // Validates the provided JWT token
    public boolean validateToken(String token) {
        Jwts.parser() // Parse the JWT token
                .setSigningKey(getKey()) // Use the secret key for validation
                .build()
                .parse(token); // Validate the token structure and signature
        return true; // Return true if the token is valid
    }
}
