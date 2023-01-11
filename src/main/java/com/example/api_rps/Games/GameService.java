package com.example.api_rps.Games;

import com.example.api_rps.Games.GameEntity;
import com.example.api_rps.Games.GameNotFoundExeption;
import com.example.api_rps.Games.GameRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.stream.Stream;

@Service
@AllArgsConstructor
public class GameService {

    GameRepo gameRepo;

    public Stream<GameEntity> all() {
        return gameRepo.all();
    }

    public GameEntity get(UUID uuid) throws GameNotFoundExeption {
        return gameRepo.get(uuid)
                .orElseThrow(() -> new GameNotFoundExeption(uuid));
    }

    public GameEntity createGame(UUID uuid) {
        GameEntity gameEntity = new GameEntity(
                UUID.randomUUID()

        );
        return gameRepo.save(gameEntity);
    }
}
