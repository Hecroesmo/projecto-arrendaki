package com.example.testemarcos.utility;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtUtility {

    private final String SECRET = "576D5A7134743777217A24432646294A404E635266556A586E3272357538782F";

    public String gerarToken(String email){
        Map<String,Object> claims = new HashMap<>();
        return createToken(claims,email);
    }

    public String extrairUsername(String token){
        return extrairClaim(token,Claims::getSubject);
    }

    private String createToken(Map<String, Object> claims, String email) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(email)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+ 1000*60*24))
                .signWith(getSignKey(), SignatureAlgorithm.HS256).
                compact();
    }

    private Key getSignKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public Date extrairExpiracao(String token){
        return extrairClaim(token, Claims::getExpiration);
    }

    public Boolean etokenExpirado(String token){
        return extrairExpiracao(token).before(new Date());
    }

    public <T> T extrairClaim(String token, Function <Claims,T> claimsResolver){
        final Claims claims = extrairTodosClaims(token);
        return claimsResolver.apply(claims);
    }

    public Claims extrairTodosClaims(String token){
        return Jwts.parserBuilder()
                .setSigningKey(getSignKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public Boolean validarToken(String token, UserDetails userDetails){
        final String email = extrairUsername(token);
        return (email.equals(userDetails.getUsername()) && !etokenExpirado(token));
    }

}
