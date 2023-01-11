package com.example.api_rps.Games;


import lombok.Value;

import java.util.UUID;
@Value

public class CreateGame {
    UUID uuid = UUID.randomUUID();
}
