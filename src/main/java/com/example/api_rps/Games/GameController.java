package com.example.api_rps.Games;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor

public class GameController {

    GameService gameService;


    //Start Game
// im using the gamecontainer to start a game with the token given som auth/token, starting a game
    //with gameservice and mapping it to the DTO
    //tested and working
    @PostMapping("/games/start")
    public GameContainer startGame(@RequestHeader(value = "token") UUID playerId) {

        return gameService.Start(playerId)
                .map(this::GametoDTO)
                .orElse(null);
    }

    //Join Game
    @PostMapping("/join/{gameId}")





    // Game list
    //here i list games, using stream and filter to get only the ones with the gamestatus open
    //tested,working
    @GetMapping("/games")
    public List<GameEntity> OpenGames() {
        return gameService.OpenGames()
                .stream()
                .filter(games -> games.getGamestatus().
                        equals(GameStatus.OPEN))
                .collect(Collectors.toList());
    }

// Game info
@GetMapping("/games/{gameId}")



    //Make move
@PostMapping("/games/move/{sign}")

    private GameContainer GametoDTO(GameEntity gameEntity) {
        return new GameContainer(
                gameEntity.getUuid(),
                gameEntity.getPlayerOne(),
                gameEntity.getPlayerMove(),
                gameEntity.getPlayerTwo(),
                gameEntity.getOpponentMove(),
                gameEntity.getGamestatus()
        );
    }



}
