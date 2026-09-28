package com.example.jdbcRelationShip.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity(name = "Dept")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dept_id;

    private String name;

//    @OneToMany(
//            mappedBy = "department",
//            cascade = CascadeType.ALL
//    )
//    private List<Student> studentList = new ArrayList<>();
}
