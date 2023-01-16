package com.example.api_rps.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.security.core.UserDetails;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")

public class User implements UserDetails{

        @Id
        @GeneratedValue (strategy = GenerationType.SEQUENCE)
        private Integer id;
        private String username;
        private String password;


}