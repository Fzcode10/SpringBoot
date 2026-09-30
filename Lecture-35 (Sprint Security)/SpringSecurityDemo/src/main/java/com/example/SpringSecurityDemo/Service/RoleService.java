package com.example.SpringSecurityDemo.Service;

import com.example.SpringSecurityDemo.Entity.Role;
import com.example.SpringSecurityDemo.Repository.RoleRepository;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository){
        this.roleRepository = roleRepository;
    }

    public void setRole(Role role) {
        System.out.println(role.getName());
        roleRepository.save(role);
    }
}
