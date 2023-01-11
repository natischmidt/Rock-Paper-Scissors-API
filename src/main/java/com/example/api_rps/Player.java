package com.example.api_rps;


import java.util.UUID;

public class Player {
    private UUID playerid;
    private final String userName;
    private Move playerMove;

    //The username cant be empty or null so it throws an exception
    Player(String name) throws IllegalArgumentException{
        if (name != null && !name.isEmpty())
            this.userName = name;
        else {
            throw new IllegalArgumentException("Username cant be empty");
        }
    }

    String getPlayername(){
        return userName;
    }

    Move getPlayerMove(){
        return playerMove;
    }

}
