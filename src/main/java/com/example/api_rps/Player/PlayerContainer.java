package com.example.api_rps.Player;

import com.example.api_rps.Games.GameEntity;

public record PlayerContainer
        (String name,
         GameEntity playerOneGame,
         GameEntity playerTwoGame)
{

}
