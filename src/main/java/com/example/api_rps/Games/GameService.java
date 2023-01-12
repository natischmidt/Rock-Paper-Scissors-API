package com.example.api_rps.Games;

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

    public Optional <GameEntity> Info (UUID )
}
