package com.example.api_rps.Security.Configuration;


import jakarta.servlet.Filter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {

    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private final AuthenticationProvider authenticationProvider;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
     httpSecurity
             .csrf()
             .disable()
             .authorizeHttpRequests()
             //These will be whitelisted
             .requestMatchers("/auth/register", "/auth/authenticate")
             .permitAll()
             //any other request will be authenticated
             .anyRequest()
             .authenticated()
             .and()
             .sessionManagement()
             //Because im using once per request filter, the authentication state should not be stored
             .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
             .and()
             .authenticationProvider(authenticationProvider)
             //This filter before the usernamepassword filter
             .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

     return httpSecurity.build();
    }



}
