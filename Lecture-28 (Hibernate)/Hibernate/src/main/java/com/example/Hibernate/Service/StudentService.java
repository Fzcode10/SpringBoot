package com.example.Hibernate.Service;

import com.example.Hibernate.Repository.StudentRepository;
import com.example.Hibernate.model.Student;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;


@Service
public class StudentService {

    StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    @Transactional
    public void createStudent(Student student) {
        studentRepository.save(student);
    }

//    public List<Student> getAllStudents() {
//        return new ArrayList<>();
//    }

    @Transactional
    public Student getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    @Transactional
    public void updateStudent(Student studentReq, long id) {
        Student student1 = studentRepository.findById(id);

        if(student1 == null){
            throw  new RuntimeException("Student not found");
        }

        student1.setName(studentReq.getName());
        student1.setEmail(studentReq.getEmail());
        student1.setAge(studentReq.getAge());

    }

    @Transactional
    public void deleteStudent(Long id) {

        Student student = studentRepository.findById(id);

        if(student == null){
            throw  new RuntimeException("Student not found");
        }

        studentRepository.remove(student);
    }
}
