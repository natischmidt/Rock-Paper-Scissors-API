package com.example.api_rps;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.UUID;

//firstly building the class with properties


    @Entity
    public class Game {
        @Id
        private UUID uuid;
        private String userName;
        private Move playerMove;
        private GameStatus gamestatus;
        private String opponentName;
        private Move opponentMove;

        public Game(UUID uuid, String userName, Move playerMove, GameStatus gamestatus, String opponentName, Move opponentMove) {
            this.uuid = uuid;
            this.userName = userName;
            this.playerMove = playerMove;
            this.gamestatus = gamestatus;
            this.opponentName = opponentName;
            this.opponentMove = opponentMove;
        }

        public Game() {

        }


        //Getters and setters
        public UUID getUuid() {
            return uuid;
        }

        public void setUuid(UUID uuid) {
            this.uuid = uuid;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public Move getPlayerMove() {
            return playerMove;
        }

        public void setPlayerMove(Move playerMove) {
            this.playerMove = playerMove;
        }

        public GameStatus getGamestatus() {
            return gamestatus;
        }

        public void setGamestatus(GameStatus gamestatus) {
            this.gamestatus = gamestatus;
        }

        public String getOpponentName() {
            return opponentName;
        }

        public void setOpponentName(String opponentName) {
            this.opponentName = opponentName;
        }

        public Move getOpponentMove() {
            return opponentMove;
        }

        public void setOpponentMove(Move opponentMove) {
            this.opponentMove = opponentMove;
        }

}
