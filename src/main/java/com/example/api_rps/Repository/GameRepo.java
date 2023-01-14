package com.example.api_rps.Repository;
import com.example.api_rps.Game.GameEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;


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
