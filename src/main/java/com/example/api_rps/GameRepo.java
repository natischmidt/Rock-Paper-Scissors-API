package com.example.api_rps;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Stream;

@Component
public class GameRepo {

    Map<String,GameEntity> games= new HashMap<>();

    public Stream<GameEntity> all() {
        return games.values().stream();
    }
    public GameEntity save(GameEntity gameEntity) {
        games.put(String.valueOf(gameEntity.getUuid()), gameEntity);
        return gameEntity;
    }
    public Optional<GameEntity> get(UUID uuid) {
        return Optional.ofNullable(games.get(uuid));
    }

}
