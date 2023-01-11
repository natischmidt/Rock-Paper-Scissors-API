package com.example.api_rps;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/games")
@AllArgsConstructor

public class GameController {

    private static List<Game> games = new ArrayList<>();



}
