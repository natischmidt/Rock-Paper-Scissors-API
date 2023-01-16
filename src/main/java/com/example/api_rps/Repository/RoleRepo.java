package com.example.api_rps.Repository;
import com.example.api_rps.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository <Role,Long>{
    Role findByName(String name);

}
