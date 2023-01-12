package com.example.api_rps.Games;

import com.example.api_rps.Player.PlayerContainer;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;
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
//tested working, u can join games
    @PostMapping("/join/{gameId}")
    public GameContainer joinGame(@RequestHeader(value = "token") UUID playerId,
                               @PathVariable("gameId") UUID gameId) throws GameNotFoundExeption {

        return gameService.Join(playerId, gameId)
                .map(this::GametoDTO)
                .orElse(null);
    }




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
    //calling  info  from gameserivce
    //tested and working
@GetMapping("/games/{gameId}")
public GameContainer Info(@PathVariable("gameId") UUID gameId) throws GameNotFoundExeption {
    return gameService.Info(gameId)
            .map(this::GametoDTO)
            .orElse(null);
}


@PostMapping("/games/move/{sign}")
public void setPlayerMove(@PathVariable("sign") String sign,@RequestBody GameContainer gameContainer,
                          @RequestHeader(value = "token") UUID playerId)  {
    gameService.setuserMove(gameContainer, playerId);
}



//public GameContainer Move(@PathVariable("sign") String sign,
//                           @RequestHeader(value = "token") UUID playerId,
//                           @RequestBody GameContainer gameContainer) throws GameNotFoundExeption {
//    return gameService.choseSign(sign, playerId, gameContainer)
//            .map(this::GametoDTO)
//            .orElse(null);
//}


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
