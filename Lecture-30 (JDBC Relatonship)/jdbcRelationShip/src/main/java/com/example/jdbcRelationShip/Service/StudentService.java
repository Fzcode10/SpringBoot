package com.example.jdbcRelationShip.Service;


import com.example.jdbcRelationShip.Model.Department;
import com.example.jdbcRelationShip.Model.Student;
import com.example.jdbcRelationShip.Repository.DepartmentRepository;
import com.example.jdbcRelationShip.Repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;


@Service
public class StudentService {

    StudentRepository studentRepository;
    DepartmentRepository departmentRepository;

    public StudentService(StudentRepository studentRepository,
                          DepartmentRepository departmentRepository){
        this.studentRepository = studentRepository;
        this.departmentRepository = departmentRepository;
    }

    @Transactional
    public void createStudent(Student student, Long id){
        Department department = departmentRepository.getDepartmentById(id);

        student.setDepartment(department);
        department.getStudentList().add(student);

        studentRepository.save(student);
    }

    @Transactional
    public void createStudent(Student student, String deptName){

        Department department = new Department();
        department.setName(deptName);

        student.setDepartment(department);
        department.getStudentList().add(student);

        departmentRepository.save(department);
        studentRepository.save(student);
    }
}
