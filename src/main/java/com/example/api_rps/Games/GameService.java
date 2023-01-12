package com.example.api_rps.Games;

import com.example.api_rps.Player.PlayerEntity;
import com.example.api_rps.Player.PlayerRepo;
import lombok.AllArgsConstructor;
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


    public void setuserMove(String sign,GameContainer gameContainer, UUID playerid) {
        Optional<GameEntity> gameEntity = gameRepo.findById(playerid);
        if (gameRepo.existsById(gameContainer.uuid())) {
            gameEntity = Optional.of(gameRepo.findById(gameContainer.uuid()).get());
            (gameEntity.
                    .playerOne.getPlayerid().equals(playerid))
                    get().getPlayeruuid().equals(playerid)) {
                switch (sign) {
                    case "rock" -> {
                        gameEntity.get().setPlayerMove(Move.ROCK);
                        gameEntity.get().setPlayerMove(gameContainer.playerMove());
                        gameRepo.save(gameEntity.get());
                    }
                    case "paper" -> {
                        gameEntity.get().setPlayerMove(Move.PAPER);
                        gameEntity.get().setPlayerMove(gameContainer.playerMove());
                        gameRepo.save(gameEntity.get());
                    }
                    case "scissors" -> {
                        gameEntity.get().setPlayerMove(Move.SCISSOR);
                        gameEntity.get().setPlayerMove(gameContainer.playerMove());
                        gameRepo.save(gameEntity.get());
                    }

                }
            }
        }
    }
    //When starting a game I set all of the variabels to NULL so they can be filled in later because right now all i want to do is create a new empty game, i put the gamestatus OPEN
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


        //Saving gameentity to the repo
        gameRepo.save(gameEntity);
        playerRepo.getReferenceById(playerId).setP1Game(gameEntity);

        return Optional.of(gameEntity);
    }

    //return all open games
    public List<GameEntity> OpenGames() {
        return gameRepo.findAll();
    }

    //retrun info for a given game uuid
    public Optional<GameEntity> Info(UUID game_uuid) throws GameNotFoundExeption{
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
            //change satus here to active wip

            gameRepo.save(gameEntity);
        } else {
            throw new GameNotFoundExeption("Game does not excist");
        }

        playerRepo.getReferenceById(playerid).setP2Game(gameEntity);

        return Optional.of(gameEntity);
    }


//public void setMove(String sign,
//                                     UUID playerid,
//                                    GameContainer gameContainer) throws GameNotFoundExeption{
//    GameEntity gameEntity;
//    if
//    (gameRepo.existsById(gameContainer.uuid())) {
//        gameEntity = gameRepo.findById(gameContainer.uuid()).get();
//        if (gameEntity.playerOne.getPlayerid().equals(playerid)) {
//            switch (sign) {
//                case "rock" -> gameEntity.setPlayerMove(Move.ROCK);
//                case "paper" -> gameEntity.setPlayerMove(Move.PAPER);
//                case "scissors" -> gameEntity.setPlayerMove(Move.SCISSOR);
//            }
//        }
//        if (gameEntity.playerTwo.getPlayerid().equals(playerid)) {
//            switch (sign) {
//                case "rock" -> gameEntity.setOpponentMove(Move.ROCK);
//                case "paper" -> gameEntity.setOpponentMove(Move.PAPER);
//                case "scissors" -> gameEntity.setOpponentMove(Move.SCISSOR);
//            }
//        }
//    } else {
//        throw new GameNotFoundExeption("Game doesn exist");
//    }
//
//    gameRepo.save(gameEntity);
//
//    return Optional.of(gameEntity);
//}

    }

