package com.example.jdbcRelationShip.Repository;

import com.example.jdbcRelationShip.Model.ExtraModel.Profile;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class ProfileRepository {

    @PersistenceContext
    private EntityManager entityManager;


    public void save(Profile profile){
        System.out.println("Profile saved");
        entityManager.persist(profile);
    }
}
