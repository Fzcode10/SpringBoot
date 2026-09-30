package com.example.SpringSecurityDemo.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(
            nullable = false,
            unique = true
    )
    private String username;

    @Column(
            nullable = false
    )
    private String password;


    private Boolean isEnabled = true;

    @ManyToMany
    @JoinTable(
            name = "Users_Role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles = new HashSet<>();
}
