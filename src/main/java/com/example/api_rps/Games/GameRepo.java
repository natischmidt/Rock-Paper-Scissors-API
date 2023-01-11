package com.example.api_rps.Games;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Stream;


public interface GameRepo extends JpaRepository<GameEntity, UUID> {

//    Map<String, GameEntity> games= new HashMap<>();
//
//    public Stream<GameEntity> all() {
//        return games.values().stream();
//    }
//    public GameEntity save(GameEntity gameEntity) {
//        games.put(String.valueOf(gameEntity.getUuid()), gameEntity);
//        return gameEntity;
//    }
//    public Optional<GameEntity> get(UUID uuid) {
//        return Optional.ofNullable(games.get(uuid));
//    }

}
