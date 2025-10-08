package com.dcl.accommodate.security.jwt;

import com.dcl.accommodate.config.AppEnv;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.time.Duration;
import java.util.Base64;
import java.util.Date;
import java.util.Map;

//the class is responsible to generate tokens when required

@Service
public class JwtService {

    //must be encoded base 64 string
    private Key key;

    public JwtService(AppEnv env){
        this.key = Keys.hmacShaKeyFor(Base64.getDecoder().decode(env.getJwt().getSecret()));
    }

    public String generateToken(Map<String , Object> claims, String subject , Duration ttl) {
        //implement the logic to generate token
        var systemMillis = System.currentTimeMillis();
        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(new Date(systemMillis))
                .setExpiration(new Date(systemMillis + ttl.toMillis()))
                .setSubject(subject)
                .signWith(key , SignatureAlgorithm.HS256)
                .compact(); // alternative to build method, that returns encoded jwt string

    }


    public Claims extractClaims (String token){
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build() // returns a parser to parse jwt
                .parseClaimsJws(token)
                .getBody();
    }




}
