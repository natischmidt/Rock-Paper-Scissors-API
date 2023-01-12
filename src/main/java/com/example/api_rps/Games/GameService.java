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


        gameRepo.save(gameEntity);
        playerRepo.getReferenceById(playerId).setP1Game(gameEntity);

        return Optional.of(gameEntity);
    }

//    public Stream<GameEntity> all() {
//        return gameRepo.all();
//    }
//
//    public GameEntity get(UUID uuid) throws GameNotFoundExeption {
//        return gameRepo.get(uuid)
//                .orElseThrow(() -> new GameNotFoundExeption(uuid));
//    }



//    public GameEntity createGame(UUID uuid) {
//        GameEntity gameEntity = new GameEntity(
//                UUID.randomUUID()
//
////        );
//        return gameRepo.save(gameEntity);
//    }

    //return all open games
    public List<GameEntity> OpenGames() {
        return gameRepo.findAll();
    }
}
