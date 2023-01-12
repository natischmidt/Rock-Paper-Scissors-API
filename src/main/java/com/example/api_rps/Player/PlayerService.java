package com.example.api_rps.Player;

import com.example.api_rps.Player.PlayerEntity;
import com.example.api_rps.Player.PlayerRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;
import java.util.stream.Stream;

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


}
