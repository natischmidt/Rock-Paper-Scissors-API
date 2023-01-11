package com.example.api_rps.Player;
import com.example.api_rps.Games.Move;
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
    private UUID playerid;
    private  String userName;

    @Enumerated(EnumType.STRING)
    private Move playerMove;

}
