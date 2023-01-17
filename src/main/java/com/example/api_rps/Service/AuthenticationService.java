package com.example.api_rps.Service;


import com.example.api_rps.Repository.GameRepo;
import com.example.api_rps.Repository.UserRepo;
import com.example.api_rps.Security.Authenticstion.AuthenticationRequest;
import com.example.api_rps.Security.Authenticstion.AuthenticationResponse;
import com.example.api_rps.Security.Authenticstion.RegisterRequest;
import com.example.api_rps.User.Role;
import com.example.api_rps.User.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class AuthenticationService {

    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest request) {
        //Creating a user, save to the database and return the generated token
        var user = User.builder()
                .username(request.getUsername())
                //Encode the password before saving it
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();
        userRepo.save(user);
        var jwtToken = jwtService.generateToken(user);
        //returning the generated token
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );
        //If username and password were authenticated:
        var user = userRepo.findByUsername(request.getUsername()).orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        //returning the generated token
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
}
