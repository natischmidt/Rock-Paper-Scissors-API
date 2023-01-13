package com.example.api_rps.Games;

import com.example.api_rps.Player.PlayerContainer;
import com.example.api_rps.Player.PlayerEntity;
import com.example.api_rps.Player.PlayerRepo;
import com.example.api_rps.Player.PlayerService;
import lombok.AllArgsConstructor;
import org.hibernate.Hibernate;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import static com.example.api_rps.Games.GameStatus.*;
import java.util.Optional;
import java.util.List;
import java.util.UUID;
import static com.example.api_rps.Games.GameStatus.*;
@Service
@AllArgsConstructor
public class GameService {

    GameRepo gameRepo;
    PlayerRepo playerRepo;
    PlayerService playerService;


    /*
    When starting a game I set all the variables to NULL, so they can be filled in
    later because right now all I want to do is create a new empty game aka  gamestatus OPEN
     */
    public Optional<GameEntity> Start(UUID playerId) {
        GameEntity gameEntity = new GameEntity
                (
                        UUID.randomUUID(),
                        playerRepo.findById(playerId).get(),
                        null,
                        OPEN,
                        null,
                        null,
                        null
                );


        //Saving game entity to the repo
        gameRepo.save(gameEntity);
        playerRepo.getReferenceById(playerId).setP1Game(gameEntity);

        return Optional.of(gameEntity);
    }

    //return all open games
    public List<GameEntity> OpenGames() {
        return gameRepo.findAll();
    }

    //return info for a given game via the game uuid
    public Optional<GameEntity> Info(UUID game_uuid) throws GameNotFoundExeption {
        GameEntity gameEntity;

        if (gameRepo.existsById(game_uuid)) {
            gameEntity = gameRepo.findById(game_uuid).get();

        } else {
            throw new GameNotFoundExeption("Game doesnt exist");
        }
        return Optional.of(gameEntity);

    }

    public Optional<GameEntity> Join(UUID playerid, UUID game_uuid) throws GameNotFoundExeption {
        GameEntity gameEntity;

        if (gameRepo.existsById(game_uuid)) {
            gameEntity = gameRepo.findById(game_uuid).get();

            gameEntity.setPlayerTwo(playerRepo.getReferenceById(playerid));
            gameEntity.setGamestatus(ACTIVE);
            //Now that another player has joined the status changes from open to active

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
            if (gameEntity.playerOne.getPlayerid().equals(playerid)) {
                switch (sign) {
                    case "rock" -> gameEntity.setPlayerMove(Move.ROCK);
                    case "paper" -> gameEntity.setPlayerMove(Move.PAPER);
                    case "scissor" -> gameEntity.setPlayerMove(Move.SCISSOR);

                }
            }
            //Same for player2
            if (gameEntity.playerTwo.getPlayerid().equals(playerid)) {
                switch (sign) {
                    case "rock" -> gameEntity.setPlayerMove(Move.ROCK);
                    case "paper" -> gameEntity.setPlayerMove(Move.PAPER);
                    case "scissor" -> gameEntity.setPlayerMove(Move.SCISSOR);
                }
            }

        } else {
                throw new GameNotFoundExeption("Move not possible");
            }

                gameRepo.save(gameEntity);
                return Optional.of(gameEntity);
            }
        }



