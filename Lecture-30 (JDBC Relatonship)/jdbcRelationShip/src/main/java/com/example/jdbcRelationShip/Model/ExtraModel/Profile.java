package com.example.jdbcRelationShip.Model.ExtraModel;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Entity
@Setter
@NoArgsConstructor
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    private String bio;

//    @OneToOne
//    @JoinColumn(name = "user_id")
//    private User user;
}
