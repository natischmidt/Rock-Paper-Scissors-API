package com.example.api_rps.Player;
import lombok.Value;

import java.util.UUID;

@Value
public class CreatePlayer {
    UUID playerid = UUID.randomUUID();

}
