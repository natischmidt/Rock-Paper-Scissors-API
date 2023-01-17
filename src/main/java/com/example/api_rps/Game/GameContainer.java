package com.example.api_rps.Game;
import com.example.api_rps.Player.PlayerEntity;
import java.util.UUID;

public record GameContainer(
        //Saving info about the game(s)
    UUID uuid,
    PlayerEntity firstPlayer,
    Move playerMove,
    PlayerEntity secondPlayer,
    Move opponentMove,
    GameStatus p1gamestatus,
         GameStatus p2gamestatus
)
{

}


