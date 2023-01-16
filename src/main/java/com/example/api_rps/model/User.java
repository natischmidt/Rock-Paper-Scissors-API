package com.example.api_rps.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collection;

import static jakarta.persistence.GenerationType.AUTO;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class User {

    @Id @GeneratedValue(strategy = AUTO)
    private Long id;
    private String username;
    private String password;
    @ManyToMany (fetch = FetchType.EAGER)
    //When loading the users I always want to load the roles as well
    private Collection<Role> roles = new ArrayList<>();


}
