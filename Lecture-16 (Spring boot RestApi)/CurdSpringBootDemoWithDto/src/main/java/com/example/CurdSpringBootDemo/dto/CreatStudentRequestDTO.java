package com.example.CurdSpringBootDemo.dto;

import jakarta.validation.constraints.*;

public class CreatStudentRequestDTO {

    @NotBlank(message = "Name can't blank")
    @Size(min = 2, max = 50, message = "student name must be 50 character long")
    private String name;

    @Email(message = "Email address should be valid")
    @NotBlank(message = "Email can't blank")
    private String email;

    @Min(value = 18, message = "Age must be atLeast 18 years old.")
    private int age;

    @NotNull(message = "Roll no is required")
    private Integer roll_no;

    @NotBlank(message = "Subject is required")
    private String subject;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getRoll_no() {
        return roll_no;
    }

    public void setRoll_no(int roll_no) {
        this.roll_no = roll_no;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
