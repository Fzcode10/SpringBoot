package com.example.CurdSpringBootDemo.repository;

import com.example.CurdSpringBootDemo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

//@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findByDeletedIsFalse();

    // findBy + fieldName + condition
    Optional<Student> findByIdAndDeletedIsFalse(Long id);
}
