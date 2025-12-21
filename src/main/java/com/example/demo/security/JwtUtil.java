/*package com.example.barter.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;
import javax.crypto.SecretKey;
import java.util.Date;
import java.util.Map;

@Component
public class JwtUtil {
    
    private String secret = "mySecretKeyThatIsLongEnoughForHS512Algorithm";
    private long validityInMs = 86400000; // 24 hours
    private SecretKey key = Keys.hmacShaKeyFor(secret.getBytes());
    
    public JwtUtil() {}
    
    public JwtUtil(String secret, long validityInMs) {
        this.secret = secret;
        this.validityInMs = validityInMs;
        this.key = Keys.hmacShaKeyFor(secret.getBytes());
    }
    
    public String generateToken(Map<String, Object> claims, String subject) {
        return Jwts.builder()
            .setClaims(claims)
            .setSubject(subject)
            .setIssuedAt(new Date())
            .setExpiration(new Date(System.currentTimeMillis() + validityInMs))
            .signWith(key, SignatureAlgorithm.HS512)
            .compact();
    }
    
    public Map<String, Object> getAllClaims(String token) {
        return Jwts.parserBuilder()
            .setSigningKey(key)
            .build()
            .parseClaimsJws(token)
            .getBody();
    }
    
    public boolean validateToken(String token) {
        try {
            Claims claims = Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody();
            return !claims.getExpiration().before(new Date());
        } catch (Exception e) {
            return false;
        }
    }
    
    public String getEmail(String token) {
        return (String) getAllClaims(token).get("email");
    }
    
    public String getRole(String token) {
        return (String) getAllClaims(token).get("role");
    }
}
*/