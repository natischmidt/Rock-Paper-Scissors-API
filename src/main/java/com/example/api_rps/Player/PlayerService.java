package com.example.api_rps.Player;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;


@Service
@AllArgsConstructor

public class PlayerService {

    PlayerRepo playerRepo;


    public PlayerEntity createPlayer() {
        PlayerEntity playerEntity = new PlayerEntity(
                UUID.randomUUID()
        );
        playerRepo.save(playerEntity);
        return playerEntity;
    }

    public void setuserName(PlayerContainer playerContainer, UUID playerid ) {
        Optional<PlayerEntity> playerEntity = playerRepo.findById(playerid);

        if (playerEntity.isPresent()) {
            playerEntity.get().setUserName(playerContainer.name());
            playerRepo.save(playerEntity.get());


    }

}

    public void setuserMove(PlayerContainer playerContainer, UUID playerid ) {
        Optional<PlayerEntity> playerEntity = playerRepo.findById(playerid);

        String move;
        if (playerEntity.isPresent())) {
            playerEntity.get().setPlayerMove(playerContainer.playeroneMove());
            switch (move) {

                case "rock" -> playerEntity.setPlayerMove(Move.ROCK);
                case "paper" -> gameEntity.setPlayerMove(Move.PAPER);
               case "scissors" -> gameEntity.setPlayerMove(Move.SCISSOR);

            }

            playerRepo.save(playerEntity.get());

            if


        }


}}
