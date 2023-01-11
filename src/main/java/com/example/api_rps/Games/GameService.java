package com.example.api_rps.Games;

import com.example.api_rps.Games.GameEntity;
import com.example.api_rps.Games.GameNotFoundExeption;
import com.example.api_rps.Games.GameRepo;
import com.example.api_rps.Player.PlayerRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;
import java.util.stream.Stream;

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





        )

    }
    public GameEntity createGame(UUID uuid) {
        GameEntity gameEntity = new GameEntity(
                UUID.randomUUID()

        );
        return gameRepo.save(gameEntity);
    }
}
