package com.example.api_rps.Service;

import com.example.api_rps.model.Role;
import com.example.api_rps.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    User saveUser (User user);
    Role saveRole (Role role);
    User getUser (String username);
    public void assignRole(String username,String roleName);
    List<User> getUsers ();


}
