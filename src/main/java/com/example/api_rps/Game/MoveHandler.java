package com.example.api_rps.Game;


import org.springframework.stereotype.Component;

@Component
public class MoveHandler {

public GameStatus handelMoves(Move playerOne,Move playerTwo) {

    GameStatus evaluatedMove;

    if (playerOne.wins_over(playerTwo)){
        evaluatedMove = GameStatus.WIN;
    }
    if (playerTwo.wins_over(playerOne))
    {
        evaluatedMove = GameStatus.LOSE;
    }
    else
        evaluatedMove = GameStatus.DRAW;


    return evaluatedMove;
}}
