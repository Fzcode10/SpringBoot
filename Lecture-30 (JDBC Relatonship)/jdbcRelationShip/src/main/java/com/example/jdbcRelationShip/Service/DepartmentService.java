package com.example.jdbcRelationShip.Service;

import com.example.jdbcRelationShip.Model.Department;
import com.example.jdbcRelationShip.Model.Student;
import com.example.jdbcRelationShip.Repository.DepartmentRepository;
import com.example.jdbcRelationShip.Repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentService {
    DepartmentRepository departmentRepository;
    StudentRepository studentRepository;

    public DepartmentService(DepartmentRepository departmentRepository,
                             StudentRepository studentRepository){
        this.departmentRepository = departmentRepository;
        this.studentRepository = studentRepository;
    }

    @Transactional
    public void createDepartment(Department department){

//        department.setStudentList(new ArrayList<>());
//        System.out.println(department.getStudentList());

        // Day 2

        Student s1 = new Student();
        s1.setName("Aditya");
        s1.setDepartment(department);


        Student s2 = new Student();
        s2.setName("Rohan");
        s2.setDepartment(department);


        Student s3 = new Student();
        s3.setName("Aarya");
        s3.setDepartment(department);


        Student s4 = new Student();
        s4.setName("Arnav");
        s4.setDepartment(department);


        Student s5 = new Student();
        s5.setName("Riya");
        s5.setDepartment(department);


//        department.getStudentList().addAll(List.of(s1, s2, s3, s4, s5));

//        departmentRepository.save(department);
//        studentRepository.save(s1);
//        studentRepository.save(s2);
//        studentRepository.save(s3);
//        studentRepository.save(s4);
//        studentRepository.save(s5);

        departmentRepository.save(department);
    }

    @Transactional
    public void createDepartment(Department department,
                                 String studentName){

        System.out.println("Student call"+ studentName);

        Student student = new Student();
        student.setName(studentName);
        student.setDepartment(department);

        departmentRepository.save(department);

//        department.getStudentList().add(student);

        studentRepository.save(student);
    }

    // Day 2

    @Transactional
    public boolean removeDepartment(Long dept_id){
        Department department = departmentRepository.findById(dept_id);
        departmentRepository.removeDept(department);
        return true;
    }
}
