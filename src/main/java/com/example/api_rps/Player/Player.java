package com.example.api_rps.Player;


import com.example.api_rps.Move;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;

import java.util.UUID;

@Entity
public class Player {
    @Id
    private UUID playerid;
    private  String userName;
    @Enumerated(EnumType.STRING)
    private Move playerMove;


    //constructor
    public Player(UUID playerid, String userName, Move playerMove) {
        this.playerid = playerid;
        this.userName = userName;
        this.playerMove = playerMove;
    }

    //The username cant be empty or null so it throws an exception
    Player(String name) throws IllegalArgumentException{
        if (name != null && !name.isEmpty())
            this.userName = name;
        else {
            throw new IllegalArgumentException("Username cant be empty");
        }
    }

    public Player() {

    }

    public UUID getPlayerid() {
        return playerid;
    }

    public void setPlayerid(UUID playerid) {
        this.playerid = playerid;
    }
    String getPlayername(){
        return userName;
    }

    Move getPlayerMove(){
        return playerMove;
    }

    public String getUserName() {
        return userName;
    }

    public void setPlayerMove(Move playerMove) {
        this.playerMove = playerMove;
    }

}
