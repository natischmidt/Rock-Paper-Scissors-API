package com.example.api_rps.Games;
import com.example.api_rps.Player.PlayerService;
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
    public GameContainer startGame(@RequestHeader(value = "token") UUID playerId) {

        return gameService.Start(playerId)
                .map(this::GametoDTO)
                .orElse(null);
    }
    /*
    //Join Game
    Similar as above, though now im joining an open game with a player uuid
     */
    @PostMapping("/join/{gameId}")
    public GameContainer joinGame(@RequestHeader(value = "token") UUID playerId,
                               @PathVariable("gameId") UUID gameId) throws GameNotFoundExeption {

        return gameService.Join(playerId, gameId)
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
                .filter(games -> games.getGamestatus().
                        equals(GameStatus.OPEN))
                .collect(Collectors.toList());
    }


    /*Game info
    Calling all saved game info for a game via game uuid from Gameservice
   */
@GetMapping("/games/{gameId}")
public GameContainer Info(@PathVariable("gameId") UUID gameId) throws GameNotFoundExeption {
    return gameService.Info(gameId)
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
                gameEntity.getGamestatus()
        );
    }

    /* Make Move
    This request takes the Game move via the url (Pathvariabel), the game id in the request body, and the
    player uuid as a token, to map a move rock paper, scissor to a specific game and player
     */
    @PostMapping("/games/move/{sign}")
    public GameContainer addPlayerMove( @PathVariable( name = "sign") String sign,
                                        @RequestBody GameContainer gameContainer,
                                        @RequestHeader(value = "token") UUID playerId) throws GameNotFoundExeption
    {
        return
                gameService.setuserMove(sign,gameContainer, playerId)
                        .map(this::GametoDTO)
                        .orElse(null);

    }



}
