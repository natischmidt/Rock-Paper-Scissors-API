package com.example.api_rps;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/auth/token")
@AllArgsConstructor

//aka PlayerController
public class Token {

    @GetMapping
    private static Player toDTO(PlayerEntity playerEntity) {
        return new Player(
        );
    }


}
