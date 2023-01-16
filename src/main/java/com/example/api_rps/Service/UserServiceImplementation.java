package com.example.api_rps.Service;


import com.example.api_rps.Repository.RoleRepo;
import com.example.api_rps.Repository.UserRepo;
import com.example.api_rps.model.Role;
import com.example.api_rps.model.User;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
//for logging
@Slf4j
public class UserServiceImplementation implements UserService{
    private final UserRepo userRepo;
    private final RoleRepo roleRepo;

    @Override
    public User saveUser(User user) {
        return null;
    }


    @Override
    public Role saveRole(Role role) {
        return null;
    }

    @Override
    public User getUser(String username) {
        return null;
    }

    @Override
    public void assignRole(String username, String roleName) {

    }

    @Override
    public List<User> getUsers() {
        return null;
    }
}
