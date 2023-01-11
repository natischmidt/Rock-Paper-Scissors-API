package com.example.api_rps;


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


    //abstract so that I can override it
    public abstract boolean wins_over(Move opposed);

    public static Boolean validMove(String turn) {
        return turn != null;
    }

}
