package com.example.api_rps;

import java.util.UUID;

public class GameNotFoundExeption extends Exception{
    public GameNotFoundExeption(UUID uuid) {super(String.valueOf(uuid));}
}
