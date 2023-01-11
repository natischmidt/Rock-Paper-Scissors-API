package com.example.api_rps.Games;
import com.example.api_rps.Move;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

//firstly building the class with properties

    @Entity
    @Getter
    @Setter
    @AllArgsConstructor


    public class GameEntity {
        @Id
        private UUID uuid;
        private String userName;
        @Enumerated(EnumType.STRING)
        private Move playerMove;
        @Enumerated(EnumType.STRING)
        private GameStatus gamestatus;
        private String opponentName;
        @Enumerated(EnumType.STRING)
        private Move opponentMove;

        public GameEntity(UUID uuid, String userName, String playerMove, String gamestatus, String opponentName, String opponentMove) {
            this.uuid = uuid;
            this.userName = userName;
            this.playerMove = Move.valueOf(playerMove);
            this.gamestatus = GameStatus.valueOf(gamestatus);
            this.opponentName = opponentName;
            this.opponentMove = Move.valueOf(opponentMove);
        }

        public GameEntity() {

        }



}
