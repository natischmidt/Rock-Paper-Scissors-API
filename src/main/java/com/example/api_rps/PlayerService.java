package com.example.api_rps;

import java.util.UUID;
import java.util.stream.Stream;

public class PlayerService {
    PlayerRepo playerRepo;
    public Stream<PlayerEntity> all() {
        return playerRepo.all();
    }
    public PlayerEntity createPlayer(UUID playerid) {
        PlayerEntity playerEntity = new PlayerEntity(
                UUID.randomUUID()

        );
        return playerRepo.save(playerEntity);
}}
