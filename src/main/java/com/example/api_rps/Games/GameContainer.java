package com.example.api_rps.Games;
import com.example.api_rps.Player.PlayerEntity;
import java.util.UUID;

public record GameContainer(
    UUID uuid,
    PlayerEntity firstPlayer,
    Move playerMove,
    PlayerEntity secondPlayer,
    Move opponentMove,
    GameStatus gamestatus){

}


