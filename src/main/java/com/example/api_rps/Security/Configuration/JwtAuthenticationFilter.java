package com.example.api_rps.Security.Configuration;


import com.example.api_rps.Service.JwtService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    private final JwtService jwtService;
    private final UserDetailsService userDetailsService;

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
        //If the username is not null and the user has not been authenticated yet then
        if(userName != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails userDetails = this.userDetailsService.loadUserByUsername(userName);
            //If the token is valid
            if(jwtService.isTokenValid(JwtToken, userDetails)){
                //then create a new authenticantoken with the userdetails & authorities in order to update
                UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                        userDetails,
                        null,
                        userDetails.getAuthorities()

                )
            }
        }

    }
}
