package com.example.api_rps;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/games")
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

    private static Game toDTO(GameEntity gameEntity) {
        return new Game(
        );
    }



}
