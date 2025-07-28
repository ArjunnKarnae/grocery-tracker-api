package com.grocerytracker.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.token.Token;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JwtService {

    @Value("${jwt.security.key}")
    private String securityKey;

    public String extractUserName(String authToken) {
        return Jwts.parser().verifyWith(generateKey()).build().parseSignedClaims(authToken).getPayload().get("userName").toString();
    }

    public String generateToken(String userName){
        Map<String, Object> claimsMap = new HashMap<>();
        claimsMap.put("userName", userName);
        return Jwts.builder().claims().add(claimsMap)
                .subject(userName)
                .issuer("Arjunn Karnae")
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + 60 * 1000 * 5))
                .and()
                .signWith(generateKey(), Jwts.SIG.HS256)
                .compact();
        }

    private SecretKey generateKey(){
        byte[] decodedKey = Decoders.BASE64.decode(securityKey);
        return Keys.hmacShaKeyFor(decodedKey);
    }

    public boolean isTokenValid(String authToken) {
       return Jwts.parser()
               .verifyWith(generateKey()).build()
               .parseSignedClaims(authToken).getPayload()
               .getExpiration().after(new Date(System.currentTimeMillis()));
    }
}
