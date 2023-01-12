package com.example.api_rps.Games;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor

public class GameController {

    GameService gameService;


   // private static List<GameEntity> gameEntities = new ArrayList<>();
    //problem det att testa detta
    @PostMapping("/start")
    public GameContainer startGame(@RequestHeader(value = "token") UUID playerId) {

        return gameService.Start(playerId)
                .map(this::GametoDTO)
                .orElse(null);
    }

    @GetMapping("/games")
    public List<GameEntity> OpenGames() {
        return gameService.OpenGames()
                .stream()
                .filter(games -> games.getGamestatus().
                        equals(GameStatus.OPEN))
                .collect(Collectors.toList());
    }




//
//    @GetMapping
//    public List<Game> all() {
//        return gameService.all()
//                .map(GameController::toDTO)
//                .collect(Collectors.toList());
  //  }
    //testing
//    public List<Game> all() {
//        return List.of(
//                new Game(),
//                new Game()
//
//        );
   // }


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

//    @PostMapping("/games/start")
//    public GameEntity Start(@RequestBody CreateGame createGame) {
//        return toDTO(
//                gameService.Start(
//                        createGame.getUuid()));
//
//    }

    //@PostMapping("/start")

//wip

//    @PostMapping("/games/start") // Create new game
//    public String createGame(@RequestBody Map<UUID, String> body) {
//        Game newGame = new Game();
//        //error here wip
//        UUID uuid = newGame.getUuid();
//        String playerUsername = body.get("name");
//
//        if (playerUsername != null && !playerUsername.isEmpty()) {
//            newGame.addPlayer(playerUsername);
//            games.add(newGame);
//            return
//
//        }
//       return
//    }

    //    @PostMapping
//    Game createGame(@RequestBody CreateGame createGame) {
//        return new Game(
//                createGame.getUUID(),
//                createGame.getSessionName()
//
//        );




}
