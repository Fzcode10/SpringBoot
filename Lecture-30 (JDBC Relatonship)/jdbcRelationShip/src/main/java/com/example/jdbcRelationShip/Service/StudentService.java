package com.example.jdbcRelationShip.Service;


import com.example.jdbcRelationShip.Model.Department;
import com.example.jdbcRelationShip.Model.ExtraModel.Profile;
import com.example.jdbcRelationShip.Model.Student;
import com.example.jdbcRelationShip.Repository.DepartmentRepository;
import com.example.jdbcRelationShip.Repository.ProfileRepository;
import com.example.jdbcRelationShip.Repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;


@Service
public class StudentService {

    StudentRepository studentRepository;
    DepartmentRepository departmentRepository;
    ProfileRepository profileRepository;

    public StudentService(StudentRepository studentRepository,
                          DepartmentRepository departmentRepository,
                          ProfileRepository profileRepository){
        this.studentRepository = studentRepository;
        this.departmentRepository = departmentRepository;
        this.profileRepository = profileRepository;
    }

    @Transactional
    public void createStudent(Student student, Long id){
        Department department = departmentRepository.getDepartmentById(id);

        student.setDepartment(department);
//        department.getStudentList().add(student);

        studentRepository.save(student);
    }

    @Transactional
    public void createStudent(Student student, String deptName){

        Department department = new Department();
        department.setName(deptName);

        Profile profile = new Profile();
        profile.setBio("Simple bio");

        student.setDepartment(department);
//        department.getStudentList().add(student);
        student.setProfile(profile);


        profileRepository.save(profile);
        departmentRepository.save(department);
        studentRepository.save(student);
    }

    public Student fetchStudentById(Long id){
        return studentRepository.findById(id);
    }
}
