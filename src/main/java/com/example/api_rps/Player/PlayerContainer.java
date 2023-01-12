package com.example.api_rps.Player;

import com.example.api_rps.Games.GameEntity;
import com.example.api_rps.Games.Move;

public record PlayerContainer
        (String name,
         Move playeroneMove,
         Move playertwoMove,
         GameEntity playerOneGame,
         GameEntity playerTwoGame)
{

}
