// package com.example.demo.security;

// import io.jsonwebtoken.*;
// import io.jsonwebtoken.security.Keys;
// import org.springframework.stereotype.Component;
// import javax.crypto.SecretKey;
// import java.util.Date;

// @Component
// public class JwtUtil {
//     private final SecretKey secretKey;
//     private final long jwtExpiration;
    
//     public JwtUtil() {
//         this.secretKey = Keys.hmacShaKeyFor("supplier-diversity-secret-key-1234567890".getBytes());
//         this.jwtExpiration = 3600000L;
//     }
    
//     public JwtUtil(byte[] secretBytes, long expiration) {
//         this.secretKey = Keys.hmacShaKeyFor(secretBytes);
//         this.jwtExpiration = expiration;
//     }
    
//     public String generateToken(Long userId, String email, String role) {
//         return Jwts.builder()
//                 .setSubject(email)
//                 .claim("userId", userId)
//                 .claim("role", role)
//                 .setIssuedAt(new Date())
//                 .setExpiration(new Date(System.currentTimeMillis() + jwtExpiration))
//                 .signWith(secretKey)
//                 .compact();
//     }
    
//     public String extractEmail(String token) {
//         return getClaims(token).getSubject();
//     }
    
//     public String extractRole(String token) {
//         return getClaims(token).get("role", String.class);
//     }
    
//     public Long extractUserId(String token) {
//         return getClaims(token).get("userId", Long.class);
//     }
    
//     public boolean validateToken(String token) {
//         try {
//             getClaims(token);
//             return true;
//         } catch (Exception e) {
//             return false;
//         }
//     }
    
//     private Claims getClaims(String token) {
//         return Jwts.parserBuilder()
//                 .setSigningKey(secretKey)
//                 .build()
//                 .parseClaimsJws(token)
//                 .getBody();
//     }
// }

package com.example.demo.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtUtil {

    private final String SECRET = "mysecretkey123";

    // REQUIRED BY TESTCASES
    public String generateToken(Long id, String email, String role) {
        return generateToken(email, role);
    }

    // USED INTERNALLY
    public String generateToken(String email, String role) {

        Map<String, Object> claims = new HashMap<>();
        claims.put("role", role.replace("ROLE_", ""));

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(email)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 86400000))
                .signWith(SignatureAlgorithm.HS256, SECRET)
                .compact();
    }

    public String extractEmail(String token) {
        return extractAllClaims(token).getSubject();
    }

    public String extractRole(String token) {
        return extractAllClaims(token).get("role", String.class);
    }

    public boolean validateToken(String token) {
        return extractAllClaims(token).getExpiration().after(new Date());
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET)
                .parseClaimsJws(token)
                .getBody();
    }
}
