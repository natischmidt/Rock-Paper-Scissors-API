package com.example.api_rps.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

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


        /**
         * @return
         */
        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
                return null;
        }

        /**
         * @return
         */
        @Override
        public boolean isAccountNonExpired() {
                return false;
        }

        /**
         * @return
         */
        @Override
        public boolean isAccountNonLocked() {
                return false;
        }

        /**
         * @return
         */
        @Override
        public boolean isCredentialsNonExpired() {
                return false;
        }

        /**
         * @return
         */
        @Override
        public boolean isEnabled() {
                return false;
        }
}