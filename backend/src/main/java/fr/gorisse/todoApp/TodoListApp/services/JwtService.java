package fr.gorisse.todoApp.TodoListApp.services;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.Map;

@Service
public class JwtService {

    @Value("${SECRET}")
    private String SECRET;
    public JwtService() {
    }
    private Key getKey() {
        final byte[] decoder = Decoders.BASE64.decode(SECRET);
        return Keys.hmacShaKeyFor(decoder);
    }

    public Map<String,String> generateJwt(String username) {
        final long currentTime = System.currentTimeMillis();
        final long EXPIRATION = 5 * 60 * 60 * 1000 + currentTime;
        final Map<String, Object> claims = Map.of(
                "firstName" ,username,
                Claims.EXPIRATION, new Date(EXPIRATION),
                Claims.SUBJECT, username
        );

        String bearer = Jwts.builder()
                .setIssuedAt(new Date(currentTime))
                .setExpiration(new Date(EXPIRATION))
                .setSubject(
                        username
                )
                .setClaims(claims)
                .signWith(getKey(), SignatureAlgorithm.HS256)
                .compact();
        return Map.of("bearer",bearer);
    }
    /*
    public void checkJwt(HttpServletRequest request) {
        final String authorization = request.getHeader("Authorization");
        if (authorization == null || !authorization.startsWith("Bearer ")) {
            throw new RuntimeException("JWT is missing");
        }
        final String token = authorization.substring(7);
        try {
            Jwts.parserBuilder()
                    .setSigningKey(getKey())
                    .build()
                    .parseClaimsJws(token);
        } catch (Exception e) {
            throw new RuntimeException("JWT is invalid");
        }
    }

     */
}
