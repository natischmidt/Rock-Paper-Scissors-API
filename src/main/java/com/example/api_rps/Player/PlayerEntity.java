package com.example.api_rps.Player;
import com.example.api_rps.Games.GameEntity;
import com.example.api_rps.Games.Move;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
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
//
//    @Enumerated(EnumType.STRING)
//    private Move playerMove;

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
