package com.example.api_rps.Player;

import com.example.api_rps.Games.GameEntity;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor

public class PlayerController {

    PlayerService playerService;

    private static List<GameEntity> players = new ArrayList<>();


    @GetMapping("auth/token")
    public UUID createPlayer(){
        return playerService.createPlayer().getPlayerid();
    }
//    public List<Player> all() {
//        return playerService.all()
//                .map(Token::toDTO)
//                .collect(Collectors.toList());
//    }

//    @GetMapping

//    private static Player toDTO(PlayerEntity playerEntity) {
//        return new Player(
//        );
//    }



}
