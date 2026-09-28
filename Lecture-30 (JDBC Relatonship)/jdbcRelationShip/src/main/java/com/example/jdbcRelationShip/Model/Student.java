package com.example.jdbcRelationShip.Model;

import com.example.jdbcRelationShip.Model.ExtraModel.Profile;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.context.annotation.Lazy;


import java.util.List;


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

    @ManyToOne(fetch = FetchType.LAZY)
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

    // Day 2
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profile_id")
    private Profile profile;

}
