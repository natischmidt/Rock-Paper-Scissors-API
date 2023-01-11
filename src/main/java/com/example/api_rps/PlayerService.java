package com.example.api_rps;

import java.util.UUID;

public class PlayerService {
    PlayerRepo playerRepo;

    public PlayerEntity createPlayer(UUID playerid) {
        PlayerEntity playerEntity = new PlayerEntity(
                UUID.randomUUID()

        );
        return playerRepo.save(playerEntity);
}}
