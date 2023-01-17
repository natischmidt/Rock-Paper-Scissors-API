package com.example.api_rps.Service;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.function.Function;

@Service
public class JwtService {

    
    private static final String SECRET_KEY = "404E635266556A586E3272357538782F413F4428472B4B6250645367566B5970";

    //Using the method to extract a specific claim here you can extract the username
    public String extractUserName(String token) {
        return extractClaim(token,Claims::getSubject);
    }

    //This method is able to extract a specif claim
    public <T> T extractClaim(String token, Function <Claims,T> claimResolver){

        final Claims claims = extractAllClaims(token);
        return claimResolver.apply(claims);
    }

    //Method to extract ALL claims
    private Claims extractAllClaims(String token) {
        return Jwts.parserBuilder().setSigningKey(getSigningKey()).build().parseClaimsJwt(token)
                .getBody();
    }

    private Key getSigningKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
