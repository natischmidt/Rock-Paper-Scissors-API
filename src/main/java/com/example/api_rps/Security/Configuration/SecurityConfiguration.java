package com.example.api_rps.Security.Configuration;


import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
     httpSecurity
             .csrf()
             .disable()
             .authorizeHttpRequests()
             //These will be whitelisted
             .requestMatchers("")
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
             .addFilterBefore(JwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

     return httpSecurity.build();
    }



}
