package com.example.api_rps;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TEST {

private Player TestPlayer;

@BeforeEach
void createtestplayer(){
    TestPlayer = new Player("test");

}
@Test
void getPlayerName() {
    assertEquals("test",TestPlayer.getUserName());
}




}
