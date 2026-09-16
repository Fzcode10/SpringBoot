package com.example.CurdSpringBootDemo.service;

import com.example.CurdSpringBootDemo.dto.*;
import com.example.CurdSpringBootDemo.entity.Student;
import com.example.CurdSpringBootDemo.exception.DuplicateResourceException;
import com.example.CurdSpringBootDemo.exception.ResourceNotFound;
import com.example.CurdSpringBootDemo.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    public CreateStudentResponseDTO createStudent(CreatStudentRequestDTO studentReqDto){
        Student student = mapToEntity(studentReqDto);

        if(emailExist(student.getEmail())){
            throw new DuplicateResourceException("Student with email "+ student.getEmail()+" already exist");
        }

        Student studentResp = studentRepository.save(student);

        return mapToDto(studentResp);
    }

    public GetStudentResponse getStudent(Long id){
       Student studentResp = studentRepository
                .findByIdAndDeletedIsFalse(id)
               .orElseThrow(() ->
                       new ResourceNotFound("Student with "+ id +" not found"));
//                .orElse(null);

//        if(studentResp.isPresent()){
//            GetStudentResponse studentResponseDTO = mapGetStudentDto(studentResp.get());
//            return studentResponseDTO;
//        }else{
//            return null;
//        }

        return mapGetStudentDto(studentResp);
    }

    public List<GetStudentResponse> getAllStudent(){
        List<Student> studentList =  studentRepository.findByDeletedIsFalse();

        List<GetStudentResponse> studentResponseList = new ArrayList<>();

        for (Student student : studentList) {
            studentResponseList.add(mapGetStudentDto(student));
        }

        return studentResponseList;
    }

    public List<Student> getAllStudentWithSoftlyDeleted(){
        List<Student> studentList =  studentRepository.findAll();
        return studentList;
    }

    public UpdateStuResponseDTO updateStudent(Long id, UpdateStuRequestDTO studentReq){

        Student existingStudent = studentRepository
                .findByIdAndDeletedIsFalse(id)
                .orElseThrow(() ->
                        new ResourceNotFound("Student with "+ id +" not found"));

//        if(existingStudent.isEmpty()){
//            return null;
//        }

//        Student studentToSave = existingStudent.get();

        Student updatedStudent = studentRepository.save(mapToUpdate(studentReq, existingStudent));

        return mapToUpdatedResponse(updatedStudent);
    }

    public void deleteStudent(Long id){
       Student existingStudent = studentRepository.findById(id)
               .orElseThrow(() ->
                       new ResourceNotFound("Student with "+ id +" not found"));

//        if(existingStudent.isEmpty()){
//            return false;
//        }

        studentRepository.delete(existingStudent);

//        return true;
    }

    public void deleteStudentSoftly(Long id){
        Student existingStudent = studentRepository.findByIdAndDeletedIsFalse(id)
                .orElseThrow(() ->
                        new ResourceNotFound("Student with "+ id +" not found"));

//        if(existingStudent.isEmpty()){
//            return false;
//        }
//        Student toSave = existingStudent.get();

        existingStudent.setDeleted(true);

        studentRepository.save(existingStudent);

//        return true;
    }


    // These functions are implement at DTO's file later
    private Student mapToEntity(CreatStudentRequestDTO creatStudentRequestDTO){
        Student student = new Student();

        student.setName(creatStudentRequestDTO.getName());
        student.setAge(creatStudentRequestDTO.getAge());
        student.setEmail(creatStudentRequestDTO.getEmail());
        student.setRoll_no(creatStudentRequestDTO.getRoll_no());
        student.setSubject(creatStudentRequestDTO.getSubject());
        student.setCreateAt(LocalDateTime.now());
        student.setUpdatedAt(LocalDateTime.now());

        student.setDeleted(false);

        return student;
    }

    private CreateStudentResponseDTO mapToDto(Student student){
        CreateStudentResponseDTO createStudentResponseDTO = new CreateStudentResponseDTO();

        createStudentResponseDTO.setId(student.getId());
        createStudentResponseDTO.setName(student.getName());
        createStudentResponseDTO.setAge(student.getAge());
        createStudentResponseDTO.setEmail(student.getEmail());
        createStudentResponseDTO.setRoll_no(student.getRoll_no());
        createStudentResponseDTO.setSubject(student.getSubject());
        createStudentResponseDTO.setCreatedAt(student.getCreateAt());
        createStudentResponseDTO.setUpdatedAt(student.getUpdatedAt());
        createStudentResponseDTO.setMessage("Student added successfully");

        return createStudentResponseDTO;
    }

    private GetStudentResponse mapGetStudentDto(Student student) {
        GetStudentResponse createStudentResponseDTO = new GetStudentResponse();

        createStudentResponseDTO.setId(student.getId());
        createStudentResponseDTO.setName(student.getName());
        createStudentResponseDTO.setAge(student.getAge());
        createStudentResponseDTO.setEmail(student.getEmail());
        createStudentResponseDTO.setRoll_no(student.getRoll_no());
        createStudentResponseDTO.setCreatedAt(student.getCreateAt());
        createStudentResponseDTO.setUpdatedAt(student.getUpdatedAt());

        return createStudentResponseDTO;
    }

    private Student mapToUpdate(UpdateStuRequestDTO updateStuRequestDTO, Student student){

        student.setRoll_no(updateStuRequestDTO.getRoll_no());
        student.setName(updateStuRequestDTO.getName());
        student.setAge(updateStuRequestDTO.getAge());
        student.setSubject(updateStuRequestDTO.getSubject());
        student.setDeleted(false);
        student.setUpdatedAt(LocalDateTime.now());

        return student;
    }

    private UpdateStuResponseDTO mapToUpdatedResponse(Student student){

        UpdateStuResponseDTO updatedStudentResponse = new UpdateStuResponseDTO();

        updatedStudentResponse.setName(student.getName());
        updatedStudentResponse.setAge(student.getAge());
        updatedStudentResponse.setId(student.getId());
        updatedStudentResponse.setRoll_no(student.getRoll_no());
        updatedStudentResponse.setUpdatedAt(student.getUpdatedAt());
        updatedStudentResponse.setEmail(student.getEmail());
        updatedStudentResponse.setSubject(student.getSubject());
        updatedStudentResponse.setMessage("Data updated");

        return updatedStudentResponse;
    }

    private Boolean emailExist(String email){
        Student isExist = studentRepository.findByEmail(email);

        return isExist != null;
    }

}
