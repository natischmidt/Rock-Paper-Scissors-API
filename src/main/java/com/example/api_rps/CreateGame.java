package com.example.api_rps;


import lombok.Value;

import java.util.UUID;
@Value

public class CreateGame {
    UUID uuid = UUID.randomUUID();
}
