package com.example.jdbcRelationShip.Service;

import com.example.jdbcRelationShip.Model.Department;
import com.example.jdbcRelationShip.Model.Student;
import com.example.jdbcRelationShip.Repository.DepartmentRepository;
import com.example.jdbcRelationShip.Repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

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

        department.getStudentList().add(student);

        studentRepository.save(student);
    }
}
