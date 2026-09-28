package com.example.jdbcRelationShip.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity(name = "StudentRelation")
public class Student {

    @Id
    @GeneratedValue(strategy =   GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(
            name="dept_id",
            nullable = false
    )
    private Department department;

//    private void addDepartment(Department department){
//        this.department = department;
//        this.department.getStudentList().add(this);
//    }
//
//    private void removeDepartment(Department department){
//        this.department = null;
//        this.department.remove(this);
//    }

}
