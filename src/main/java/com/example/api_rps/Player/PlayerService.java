package com.example.api_rps.Player;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;


@Service
@AllArgsConstructor

public class PlayerService {

    PlayerRepo playerRepo;


    //Creating a Player, gives a random uuid
    public PlayerEntity createPlayer() {
        PlayerEntity playerEntity = new PlayerEntity(
                UUID.randomUUID()
        );

        playerRepo.save(playerEntity);
        return playerEntity;
    }


    //Checks if the gives uuid matches a player, if yes the name username can be added
    public void setuserName(PlayerContainer playerContainer, UUID playerid ) {
        Optional<PlayerEntity> playerEntity = playerRepo.findById(playerid);

        if (playerEntity.isPresent()) {
            playerEntity.get().setUserName(playerContainer.name());
            playerRepo.save(playerEntity.get());


    }

}
}



