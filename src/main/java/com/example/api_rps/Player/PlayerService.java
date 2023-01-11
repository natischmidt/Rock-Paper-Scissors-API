package com.example.api_rps.Player;

import com.example.api_rps.Player.PlayerEntity;
import com.example.api_rps.Player.PlayerRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.stream.Stream;

@Service
@AllArgsConstructor

public class PlayerService {

    PlayerRepo playerRepo;


    public Stream<PlayerEntity> all() {
        return playerRepo.all();
    }



    public PlayerEntity createPlayer() {
        PlayerEntity playerEntity = new PlayerEntity(
                UUID.randomUUID()

        );
        playerRepo.save(playerEntity);
        return playerEntity;

}}
