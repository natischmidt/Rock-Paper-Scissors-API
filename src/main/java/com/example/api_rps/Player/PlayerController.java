package com.example.api_rps.Player;

import com.example.api_rps.Games.GameEntity;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor

public class PlayerController {

    PlayerService playerService;

    private static List<GameEntity> players = new ArrayList<>();

    /*Get token
    Here a Player is created via playerService and their playerid(uuid) is returned
    */
    @GetMapping("auth/token")
    public UUID createPlayer(){
        return playerService.createPlayer().getPlayerid();
    }

    /*Set name
    A name is mapped to a player whose id is given as a token(via playerservice)
    */
    @PostMapping("/user/name")
    public void setPlayerName(@RequestBody PlayerContainer playerContainer,
                              @RequestHeader(value = "token") UUID playerId)  {
        playerService.setuserName(playerContainer, playerId);
    }




}
