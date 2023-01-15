package com.example.api_rps.Repository;

import com.example.api_rps.Player.PlayerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Stream;

//getting error here wip
public interface PlayerRepo extends JpaRepository<PlayerEntity, UUID> {

}
