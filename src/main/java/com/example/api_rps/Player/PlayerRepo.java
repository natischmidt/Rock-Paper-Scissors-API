package com.example.api_rps.Player;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Stream;

//getting error here wip
public interface PlayerRepo extends JpaRepository<PlayerEntity, UUID> {

    Map<String, PlayerEntity> players= new HashMap<>();

//    public default Stream<PlayerEntity> all() {
//        return players.values().stream();
//    }
//    public PlayerEntity save(PlayerEntity playerEntity) {
//        players.put(String.valueOf(playerEntity.getPlayerid()), playerEntity);
//        return playerEntity;
//    }
//    public Optional<PlayerEntity> get(UUID playerid) {
//        return Optional.ofNullable(players.get(playerid));
//    }

}
