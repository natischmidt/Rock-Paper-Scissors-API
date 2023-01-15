package com.example.api_rps.Repository;
import com.example.api_rps.Game.GameEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;


public interface GameRepo extends JpaRepository<GameEntity, UUID> {
}
