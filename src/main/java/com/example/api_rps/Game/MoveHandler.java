package com.example.api_rps.Game;


import org.springframework.stereotype.Component;

@Component
public class MoveHandler {

public GameStatus handlesMoves(Move playerOne,Move playerTwo) {

    GameStatus evaluatedMove = GameStatus.DRAW;

    if (playerOne.wins_over(playerTwo)){
        evaluatedMove = GameStatus.WIN;
    }

    else if ( playerTwo.wins_over(playerOne)){
        evaluatedMove = GameStatus.DRAW;
    }


    return evaluatedMove;
}}
