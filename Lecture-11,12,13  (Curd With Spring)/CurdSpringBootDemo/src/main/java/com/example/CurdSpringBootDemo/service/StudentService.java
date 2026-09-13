package com.example.CurdSpringBootDemo.service;

import com.example.CurdSpringBootDemo.entity.Student;
import com.example.CurdSpringBootDemo.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    public Student createStudent(Student studentReq){
        // Business logic and refer to student repository
        Student studentResp = studentRepository.save(studentReq);
        return studentResp;
    }

    public Student getStudent(Long id){
        Optional<Student> studentResp = studentRepository.findByIdAndDeletedIsFalse(id);

        if(studentResp.isPresent()){
            return studentResp.get();
        }else{
            return null;
        }
    }

    public List<Student> getAllStudent(){
        List<Student> studentList =  studentRepository.findByDeletedIsFalse();
        return studentList;
    }

    public List<Student> getAllStudentWithSoftlyDeleted(){
        List<Student> studentList =  studentRepository.findAll();
        return studentList;
    }

    public Student updateStudent(Long id, Student studentReq){
        Optional<Student> existingStudent = studentRepository.findByIdAndDeletedIsFalse(id);

        if(existingStudent.isEmpty()){
            return null;
        }

        Student studentToSave = existingStudent.get();

        studentToSave.setRoll_no(studentReq.getRoll_no());
        studentToSave.setEmail(studentReq.getEmail());
        studentToSave.setName(studentReq.getName());
        studentToSave.setAge(studentReq.getAge());
        studentToSave.setSubject(studentReq.getSubject());
        studentToSave.setDeleted(false);

        return studentRepository.save(studentToSave);
    }

    public Boolean deleteStudent(Long id){
        Optional<Student> existingStudent = studentRepository.findById(id);

        if(existingStudent.isEmpty()){
            return false;
        }

        studentRepository.deleteById(id);

        return true;
    }

    public Boolean deleteStudentSoftly(Long id){
        Optional<Student> existingStudent = studentRepository.findById(id);

        if(existingStudent.isEmpty()){
            return false;
        }

        Student toSave = existingStudent.get();
        toSave.setDeleted(true);

        studentRepository.save(toSave);

        return true;
    }
}
