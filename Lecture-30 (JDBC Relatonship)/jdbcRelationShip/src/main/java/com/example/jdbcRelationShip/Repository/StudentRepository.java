package com.example.jdbcRelationShip.Repository;

import com.example.jdbcRelationShip.Model.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class StudentRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(Student student){
        System.out.println("Student saved");
        entityManager.persist(student);
    }
}
