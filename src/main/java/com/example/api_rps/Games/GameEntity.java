package com.example.api_rps.Games;
import com.example.api_rps.Player.PlayerEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Optional;
import java.util.UUID;

//firstly building the class with properties

    @Entity(name= "game")
    @Table(name= "Game")
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor


    public class GameEntity {

        @Id
        @Column(name = "game_uuid")
        private UUID uuid;

        @OneToOne
        @JoinColumn(name = "Gamep1")
        PlayerEntity playerOne;

        @Column (name = "player_move")
        @Enumerated(EnumType.STRING)
        private Move playerMove;

        @Column (name = "game_status")
        @Enumerated(EnumType.STRING)
        private GameStatus gamestatus;

        private String opponentName;

        @OneToOne
        @JoinColumn(name = "Gamep2")
        PlayerEntity playerTwo;

        @Column (name = "opponent_move")
        @Enumerated(EnumType.STRING)
        private Move opponentMove;



    }
