package com.example.api_rps;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Stream;

@Component
public class PlayerRepo {

    Map<String,PlayerEntity> players= new HashMap<>();

    public Stream<PlayerEntity> all() {
        return players.values().stream();
    }
    public PlayerEntity save(PlayerEntity playerEntity) {
        players.put(String.valueOf(playerEntity.getPlayerid()), playerEntity);
        return playerEntity;
    }
    public Optional<PlayerEntity> get(UUID playerid) {
        return Optional.ofNullable(players.get(playerid));
    }
}
