package com.example.api_rps.Security.Configuration;


import com.example.api_rps.Service.JwtService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    private final JwtService jwtService;

    @Override
    protected void doFilterInternal(
           @NonNull HttpServletRequest request,
           @NonNull  HttpServletResponse response,
           @NonNull  FilterChain filterChain)
            throws ServletException, IOException {

        final String authenticationHeader = request.getHeader("Authorization");
        final String JwtToken;
        final String userName;
        //Adding a check
        if (authenticationHeader!= null && authenticationHeader.startsWith("Bearer ")) {
            filterChain.doFilter(request,response);
            return;
        }
        //Index 7 because of "bearer"
        JwtToken = authenticationHeader.substring(7);
        userName = jwtService.extractUserName(JwtToken);

    }
}
