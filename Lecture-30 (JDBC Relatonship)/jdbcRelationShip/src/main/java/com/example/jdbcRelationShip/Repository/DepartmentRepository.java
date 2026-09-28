package com.example.jdbcRelationShip.Repository;

import com.example.jdbcRelationShip.Model.Department;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class DepartmentRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(Department department){
        System.out.println("Department created");
//        System.out.println(department.getName());
        entityManager.persist(department);
    }

    public Department getDepartmentById(Long dept_id){
        return entityManager.find(Department.class, dept_id);
    }


    // day 2
    public void removeDept(Department department){
        entityManager.remove(department);
    }

    public Department findById(Long dept_id){
        return entityManager.find(Department.class, dept_id);
    }
}
