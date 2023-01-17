package com.example.api_rps.Service;


import com.example.api_rps.Security.Authenticstion.AuthenticationRequest;
import com.example.api_rps.Security.Authenticstion.AuthenticationResponse;
import com.example.api_rps.Security.Authenticstion.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class AuthenticationService {

    public AuthenticationResponse register(RegisterRequest request) {
        return null;
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        return null;
    }
}
