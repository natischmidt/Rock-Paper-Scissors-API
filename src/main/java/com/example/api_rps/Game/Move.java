package com.example.api_rps.Game;

//an enum to determinate chosen move by the players
public enum Move {
    ROCK {
        @Override
        public boolean wins_over(Move opposed) {
            return opposed == SCISSOR;
        }

    },
    PAPER {
        @Override
        public boolean wins_over(Move opposed) {
            return opposed == ROCK;
        }
    },
    SCISSOR {
        @Override
        public boolean wins_over(Move opposed) {
            return opposed == PAPER;
        }
    };


    public static Boolean validMove(String move) {
        return move != null;
    }

    //abstract so that I can override it
    public abstract boolean wins_over(Move opposed);



}
