package com.example.api_rps.Game;
import com.example.api_rps.Player.PlayerEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
        @Column(name = "gameid")
        private UUID uuid;

        //create a foreign key linking this with the primary key from the player-entity.
        @OneToOne
        @JoinColumn(name = "Gamep1")
        PlayerEntity playerOne;

        //By setting the enum type to String, it will look cleaner when printing to the tables
        @Column (name = "player_move")
        @Enumerated(EnumType.STRING)
        private Move playerMove;

        @OneToOne
        @JoinColumn(name = "Gamep2")
        PlayerEntity playerTwo;

        @Column (name = "opponent_move")
        @Enumerated(EnumType.STRING)
        private Move opponentMove;

        @Column(name = "game_status")
        @Enumerated(EnumType.STRING)
        GameStatus gameStatus;

        public void setPlayerOneMove(Move playerMove) {
            this.playerMove = playerMove;
        }

        public void setPlayerTwoMove(Move playerMove){
            this.opponentMove = playerMove;
        }

        public Move getPlayerOneMove() {
            return playerMove;
        }

        public Move getPlayerTwoMove() {
            return opponentMove;
        }

    }
