package com.example.api_rps;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/auth/token")
@AllArgsConstructor

//aka PlayerController
public class Token {

    PlayerService playerService;
    private static List<Game> players = new ArrayList<>();


    @GetMapping
//    public List<Player> all() {
//        return playerService.all()
//                .map(Token::toDTO)
//                .collect(Collectors.toList());
//    }

//    @GetMapping

    private static Player toDTO(PlayerEntity playerEntity) {
        return new Player(
        );
    }


}
