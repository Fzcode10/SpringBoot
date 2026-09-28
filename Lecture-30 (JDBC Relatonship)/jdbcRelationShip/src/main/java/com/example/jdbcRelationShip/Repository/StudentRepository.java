package com.example.jdbcRelationShip.Repository;

import com.example.jdbcRelationShip.Model.Department;
import com.example.jdbcRelationShip.Model.ExtraModel.Profile;
import com.example.jdbcRelationShip.Model.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(Student student){
        System.out.println("Student saved");
        entityManager.persist(student);
    }


    public Student findById(Long id) {
        Student s1 = entityManager.find(Student.class, id);

        System.out.println("Lazily fetched Student");

        Department d1 = s1.getDepartment();

        System.out.println("lazily fetch Department");

        Profile p1 = s1.getProfile();

        System.out.println("lazily fetch Profile");

        return s1;
    }

    @EntityGraph(attributePaths = {"dept", "profile"})
    public List<Student> findAll(){
        return new ArrayList<>();
    }
}
