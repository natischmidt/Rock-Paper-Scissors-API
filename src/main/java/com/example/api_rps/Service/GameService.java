package com.example.api_rps.Service;

import com.example.api_rps.GameNotFoundExeption;
import com.example.api_rps.Game.*;
import com.example.api_rps.Game.Move;
import com.example.api_rps.Repository.GameRepo;
import com.example.api_rps.Repository.PlayerRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import static com.example.api_rps.Game.GameStatus.*;
import java.util.Optional;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class GameService {

    GameRepo gameRepo;
    PlayerRepo playerRepo;
    PlayerService playerService;
    MoveHandler moveHandler;


    /*
    When starting a game I set all the variables to NULL, so they can be filled in
    later because right now all I want to do is create a new empty game aka  gamestatus OPEN
     */
    public Optional<GameEntity> Start(UUID playerid) {
        GameEntity gameEntity = new GameEntity
                (
                        UUID.randomUUID(),
                        playerRepo.findById(playerid).get(),
                        null,
                      null,
                        null,
                       OPEN

                );


        //Saving game entity to the repo
        gameRepo.save(gameEntity);
        playerRepo.getReferenceById(playerid).setP1Game(gameEntity);

        return Optional.of(gameEntity);
    }

    //return all open games
    public List<GameEntity> OpenGames() {
        return gameRepo.findAll();
    }

    public Optional<GameEntity> Results(UUID gameid, UUID playerid) throws GameNotFoundExeption {
        GameEntity gameEntity;
        // checking result of game for p1
        if (gameRepo.existsById(gameid)) {
            gameEntity = gameRepo.findById(gameid).get();
            if (gameEntity.getPlayerOne().getPlayerid().equals(playerid)) {
                if (gameEntity.getPlayerMove().wins_over(gameEntity.getOpponentMove())) {
                    gameEntity.setGameStatus(WIN);
                } else if (gameEntity.getOpponentMove().wins_over(gameEntity.getPlayerMove())) {
                    gameEntity.setGameStatus(LOSE);
                } else {
                    gameEntity.setGameStatus(DRAW);
                }

            }
        }
        // checking result of game for p2
        if (gameRepo.existsById(gameid)) {
            gameEntity = gameRepo.findById(gameid).get();
            if (gameEntity.getPlayerTwo().getPlayerid().equals(playerid)) {
                if (gameEntity.getPlayerMove().wins_over(gameEntity.getOpponentMove())) {
                    gameEntity.setGameStatus(WIN);
                } else if (gameEntity.getOpponentMove().wins_over(gameEntity.getPlayerMove())) {
                    gameEntity.setGameStatus(LOSE);
                } else {
                    gameEntity.setGameStatus(DRAW);
                }

            }
        } else {
            throw new GameNotFoundExeption("Game doesnt exist");
        }
        //saving
        gameRepo.save(gameEntity);
        return Optional.of(gameEntity);
    }


    //return info for a given game via the game uuid
    public Optional<GameEntity> Info(UUID gameid) throws GameNotFoundExeption {
        GameEntity gameEntity;

        if (gameRepo.existsById(gameid)) {
            gameEntity = gameRepo.findById(gameid).get();

        } else {
            throw new GameNotFoundExeption("Game doesnt exist");
        }
        return Optional.of(gameEntity);

    }

    public Optional<GameEntity> Join(UUID playerid, UUID gameid) throws GameNotFoundExeption {
        GameEntity gameEntity;


        //If the game exists
        if (gameRepo.existsById(gameid))  {
            gameEntity = gameRepo.findById(gameid).get();
            //and is open, then you can join
            if(gameEntity.getGameStatus()== GameStatus.OPEN) {
                gameEntity.setPlayerTwo(playerRepo.getReferenceById(playerid));
                gameEntity.setGameStatus(ACTIVE);
                //Now that another player has joined the status changes from open to active
            }
               gameRepo.save(gameEntity);
        } else {
            throw new GameNotFoundExeption("Game does not exist");
        }

        playerRepo.getReferenceById(playerid).setP2Game(gameEntity);

        return Optional.of(gameEntity);
    }



    public Optional<GameEntity> setuserMove(String sign, GameContainer gameContainer, UUID playerid) throws GameNotFoundExeption {
        GameEntity gameEntity;
        // If a game with the given uuid exists, and the given player-id is found in the existing players,
        // the sign is matched to the corresponding Move enum
        if (gameRepo.existsById(gameContainer.uuid())) {
            gameEntity = gameRepo.findById(gameContainer.uuid()).get();
            //players are not able to set a move if one already exists
            if (gameEntity.getPlayerOne().getPlayerid().equals(playerid) && gameEntity.getPlayerOneMove() == null) {
                switch (sign) {
                    case "rock" -> gameEntity.setPlayerOneMove(Move.ROCK);
                    case "paper" -> gameEntity.setPlayerOneMove(Move.PAPER);
                    case "scissor" -> gameEntity.setPlayerOneMove(Move.SCISSOR);

                }
            }
            //Same for player2
            if (gameEntity.getPlayerTwo().getPlayerid().equals(playerid) && gameEntity.getPlayerTwoMove() == null) {
                switch (sign) {
                    case "rock" -> gameEntity.setPlayerTwoMove(Move.ROCK);
                    case "paper" -> gameEntity.setPlayerTwoMove(Move.PAPER);
                    case "scissor" -> gameEntity.setPlayerTwoMove(Move.SCISSOR);
                }
            }

        } else {
                throw new GameNotFoundExeption("Move not possible");
            }

        if (gameEntity.getOpponentMove() != null
                && gameEntity.getPlayerMove() != null) {
           GameStatus gameStatus = moveHandler.handlesMoves(gameEntity.getPlayerMove(), gameEntity.getOpponentMove());
            gameEntity.setGameStatus(gameStatus);
        }

        gameRepo.save(gameEntity);
        return Optional.of(gameEntity);

    }
}






