package com.example.SpringDataJPA.Service;

import com.example.SpringDataJPA.Model.Student;
import com.example.SpringDataJPA.Repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    @Transactional
    public void createStudent(Student student){
        studentRepository.save(student);
    }

    public List<Student> fetchAll(int age){
        Sort sort = Sort.by("age");

        List<Student> studentList =
                studentRepository.findAll(sort);

        for(Student s : studentList){
            System.out.println(s);
        }

        return studentList;
    }

    @Transactional
    public Student fetchStudentById(Long id){
        Optional<Student> studentOptional = studentRepository.findById(id);
        return studentOptional.get();
    }

    public List<Student> fetchAll(String name) {

        Sort sort = Sort.by("name").ascending()
                .and(
                        Sort.by("age").descending()
                );

        Pageable pageable = PageRequest.of(1, 2);

        Page<Student> studentList =
                studentRepository.findByName(name, pageable);

        for(Student s : studentList.getContent()) {
            System.out.println(s);
        }

        return studentList.getContent();
    }

}
