package com.example.api_rps.Player;

import com.example.api_rps.Game.GameEntity;
import com.example.api_rps.Game.Move;

public record PlayerContainer
    //Saving info about the player(s)
        (String name,
         Move playeroneMove,
         Move playertwoMove,
         GameEntity playerOneGame,
         GameEntity playerTwoGame)
{

}
