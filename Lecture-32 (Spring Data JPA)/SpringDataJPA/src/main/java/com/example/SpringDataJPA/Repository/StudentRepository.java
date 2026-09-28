package com.example.SpringDataJPA.Repository;

import com.example.SpringDataJPA.Model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;


public interface StudentRepository extends JpaRepository<Student, Long> {

    Page<Student> findByName(String name, Pageable pageable);

    @Query(value = """
            select * from student
            where email = :email
            """, nativeQuery = true)
    Optional<Student> findByEmail(@Param("email") String email);

}
