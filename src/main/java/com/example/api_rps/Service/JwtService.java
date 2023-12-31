package com.example.api_rps.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;


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

    //This method will generate an usertoken
    public String generateToken(UserDetails userDetails){
        return generateToken(new HashMap<>(), userDetails);
    }


    public String generateToken(Map<String,Object> extraClaims, UserDetails userDetails){
        /*
         This method takes a map of string and object as an inparameter,
         the map containing a map of extra claims that I want to add,
         passing my user details to generate a token. */
        return Jwts
                .builder()
                .setClaims(extraClaims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 24))
                .signWith(getSigningKey(), SignatureAlgorithm.HS256)
                .compact();
        //The expiration time is set to 24 hours

    }

    //To validate if this token belongs to the userdetails
    public boolean isTokenValid(String token,UserDetails userDetails){
        final String username = extractUserName(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    //In order to validate if this token is expired I need to extract its expiration
    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    // Using extractClaim I can verify the expiration date
    private Date extractExpiration(String token) {
        return extractClaim(token,Claims::getExpiration);
    }


    //Method to extract ALL claims
    private Claims extractAllClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    private Key getSigningKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
