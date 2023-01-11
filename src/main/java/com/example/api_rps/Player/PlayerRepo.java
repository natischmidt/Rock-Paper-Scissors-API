package com.example.api_rps.Player;
import com.example.api_rps.Player.PlayerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Stream;

@Component
//getting error here wip
public class PlayerRepo  extends JpaRepository<PlayerEntity, UUID> {

    Map<String, PlayerEntity> players= new HashMap<>();

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
