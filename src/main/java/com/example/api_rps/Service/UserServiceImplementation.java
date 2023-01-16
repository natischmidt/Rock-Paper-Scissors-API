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
        return userRepo.save(user);
    }


    @Override
    public Role saveRole(Role role) {
        return roleRepo.save(role);
    }

    @Override
    public User getUser(String username) {
        return userRepo.findByUsername(username);
    }

    @Override
    public void assignRole(String username, String roleName) {
     User user = userRepo.findByUsername(username);
     Role role = roleRepo.findByName(roleName);
     user.getRoles().add(role);
     // using @transactional which 'autosaves' here

    }

    @Override
    public List<User> getUsers() {
        return userRepo.findAll();
    }
}
