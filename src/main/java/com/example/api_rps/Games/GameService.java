package com.example.api_rps.Games;

import com.example.api_rps.Player.PlayerRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import static com.example.api_rps.Games.GameStatus.*;
import java.util.Optional;
import java.util.stream.Stream;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class GameService {

    GameRepo gameRepo;
    PlayerRepo playerRepo;

    public Stream<GameEntity> all() {
        return gameRepo.all();
    }

    public GameEntity get(UUID uuid) throws GameNotFoundExeption {
        return gameRepo.get(uuid)
                .orElseThrow(() -> new GameNotFoundExeption(uuid));
    }

    public Optional <GameEntity> Start (UUID playerid) {
        GameEntity gameEntity = new GameEntity(
                UUID.randomUUID(),
                playerRepo.findById(playerid).get(),
                null,
                null,
                null,
                OPEN


        );
//
//        gameRepo.save(gameEntity);
//        playerRepo.getReferenceById(playerid).
//
//
//    }
//    public GameEntity createGame(UUID uuid) {
//        GameEntity gameEntity = new GameEntity(
//                UUID.randomUUID()
//
////        );
//        return gameRepo.save(gameEntity);
//    }
}
