package com.example.api_rps.Controller;
import com.example.api_rps.GameNotFoundExeption;
import com.example.api_rps.Game.*;
import com.example.api_rps.Service.GameService;
import com.example.api_rps.Service.PlayerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


@RestController
@AllArgsConstructor

public class GameController {


    GameService gameService;
    PlayerService playerService;

    /*Start Game
   I'm using the game container to start a game with the token given in earlier step auth/token.
   I use my gameserive to invoke Start and map it to the DTO
    */
    @PostMapping("/games/start")
    public GameContainer startGame(@RequestHeader(value = "token") UUID player_uuid) {

        return gameService.Start(player_uuid)
                .map(this::GametoDTO)
                .orElse(null);
    }

    /*
    //Join Game
    Similar as above, though now im joining an open game with a player uuid
     */
    @PostMapping("/join/{gameId}")
    public GameContainer joinGame(@RequestHeader(value = "token") UUID player_uuid,
                                  @PathVariable("gameId") UUID game_uuid) throws GameNotFoundExeption {

        return gameService.Join(player_uuid, game_uuid)
                .map(this::GametoDTO)
                .orElse(null);
    }

    /* Game list
    //Here I list games, using stream and filter to get only the ones with the gamestatus open
    //tested,working
    */

    @GetMapping("/games")
    public List<GameEntity> OpenGames() {
        return gameService.OpenGames()
                .stream()
                .filter(games -> games.getPlayergameStatus().
                        equals(GameStatus.OPEN))
                .collect(Collectors.toList());
    }


    /*Game info
    Calling all saved game info for a game via game uuid from Gameservice
   */
    @GetMapping("/games/{gameId}")
    public GameContainer Info(@PathVariable("gameId") UUID game_uuid) throws GameNotFoundExeption {
        return gameService.Info(game_uuid)
                .map(this::GametoDTO)
                .orElse(null);
    }


    private GameContainer GametoDTO(GameEntity gameEntity) {
        return new GameContainer(
                gameEntity.getUuid(),
                gameEntity.getPlayerOne(),
                gameEntity.getPlayerMove(),
                gameEntity.getPlayerTwo(),
                gameEntity.getOpponentMove(),
                gameEntity.getGameStatus()

        );
    }

    /* Make Move
    This request takes the Game move via the url (Pathvariabel), the game id in the request body, and the
    player uuid as a token, to map a move rock paper, scissor to a specific game and player
     */
    @PostMapping("/games/move/{sign}")
    public GameContainer addPlayerMove(@PathVariable(name = "sign") String sign,
                                       @RequestBody GameContainer gameContainer,
                                       @RequestHeader(value = "token") UUID player_uuid) throws GameNotFoundExeption {
        return
                gameService.setuserMove(sign, gameContainer, player_uuid)
                        .map(this::GametoDTO)
                        .orElse(null);

    }


    //with the url/pathvariabel i set the gameid the token is the playerid
    @GetMapping("/games/result/{gameId}")
    public GameContainer showResult(@PathVariable("gameId") UUID gameId,
                                     @RequestHeader(value = "token") UUID playerId) throws GameNotFoundExeption {


        return gameService.Results(gameId, playerId)
                .map(this::GametoDTO)
                .orElse(null);


    }
}

