package com.example.api_rps.Repository;

import com.example.api_rps.User.User;
import org.springframework.data.jpa.repository.JpaRepository;



public interface UserRepo extends JpaRepository <User,Integer> {



}
