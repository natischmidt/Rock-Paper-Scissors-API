package com.example.api_rps;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/games")
@AllArgsConstructor

public class GameController {

    GameService gameService;
    private static List<Game> games = new ArrayList<>();

    @GetMapping
    public List<Game> all() {
        return gameService.all()
                .map(GameController::toDTO)
                .collect(Collectors.toList());
    }
    //testing
//    public List<Game> all() {
//        return List.of(
//                new Game(),
//                new Game()
//
//        );
   // }


    private static Game toDTO(GameEntity gameEntity) {
        return new Game(
        );
    }

    @GetMapping("/games/start")
    public Game createGame(@RequestBody CreateGame createGame) {
        return toDTO(
                gameService.createGame(
                        createGame.getUuid()));

    }



}
