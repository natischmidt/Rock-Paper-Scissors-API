package com.example.api_rps.Controller;

import com.example.api_rps.Game.GameEntity;
import com.example.api_rps.Player.PlayerContainer;
import com.example.api_rps.Service.PlayerService;
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
    @CrossOrigin
    @GetMapping("auth/token")
    public UUID createPlayer(){
        return playerService.createPlayer().getPlayerid();
    }

    /*Set name
    A name is mapped to a player whose id is given as a token(via playerservice)
    */
    @CrossOrigin
    @PostMapping("/user/name")
    public void setPlayerName(@RequestBody PlayerContainer playerContainer,
                              @RequestHeader(value = "token") UUID playerId)  {
        playerService.setuserName(playerContainer, playerId);
    }

}
