package com.example.api_rps;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;
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

    @PostMapping("/games/start")
    public Game createGame(@RequestBody CreateGame createGame) {
        return toDTO(
                gameService.createGame(
                        createGame.getUuid()));

    }
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
