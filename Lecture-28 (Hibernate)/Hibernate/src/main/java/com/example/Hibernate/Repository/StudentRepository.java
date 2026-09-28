package com.example.Hibernate.Repository;

import com.example.Hibernate.model.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class StudentRepository {

    @PersistenceContext
    private EntityManager entityManager;


    // Create
    public void save(Student student){
        entityManager.persist(student);
    }

    // Update
    public void update(){

    }

    // Read
    public Student findById(Long id){
        Student s1 = entityManager.find(Student.class, id);

        Student s2 = entityManager.find(Student.class, id);

        return s2;
    }

    // Delete
    public void remove(Student student){
        entityManager.remove(student);
    }
}
