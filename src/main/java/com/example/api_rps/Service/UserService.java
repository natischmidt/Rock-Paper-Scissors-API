package com.example.api_rps.Service;

import com.example.api_rps.domain.Role;
import com.example.api_rps.domain.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    User saveUser (User user);
    Role saveRole (Role role);

    public void assignRole(String username,String roleName);

}
