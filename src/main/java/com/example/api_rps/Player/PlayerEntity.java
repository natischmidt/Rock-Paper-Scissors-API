package com.example.api_rps.Player;
import com.example.api_rps.Games.GameEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity (name = "players")
@Table (name = "Players ")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class PlayerEntity {

    @Id
    @Column(name = "player_id")
    private UUID playerid;

    @Column(name = "username")
    private String userName;

    @OneToOne(mappedBy = "playerOne")
    @JsonIgnore
    private GameEntity p1Game;

    @OneToOne(mappedBy = "playerTwo")
    @JsonIgnore
    private GameEntity p2Game;

    public PlayerEntity(UUID playerid) {
        this.playerid = playerid;
    }

}
