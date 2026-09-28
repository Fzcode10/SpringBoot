package com.example.jdbcRelationShip.Controller;

import com.example.jdbcRelationShip.Model.Department;
import com.example.jdbcRelationShip.Service.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/dept")
public class DepartmentController {

    DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService){
        this.departmentService = departmentService;
    }

    @PostMapping
    public ResponseEntity<String> createDepartment(
            @RequestBody Department department){
        System.out.println(" controller 1");
        departmentService.createDepartment(department);
        return ResponseEntity.ok("Done");
    }

    @PostMapping("/withStudent")
    public ResponseEntity<String> createDepartment(
            @RequestBody Department department,
            @RequestParam String studentName){
        System.out.println(studentName+" controller 2");
        departmentService.createDepartment(department, studentName);
        return ResponseEntity.ok("Done");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDepartment(@PathVariable Long id) {
        boolean isDeleted = departmentService.removeDepartment(id);
        if (!isDeleted) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Department not found with ID: " + id);
        }
        return ResponseEntity.ok("Department deleted successfully");
    }

}
