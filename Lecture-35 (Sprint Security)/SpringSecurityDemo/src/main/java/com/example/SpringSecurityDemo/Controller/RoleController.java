package com.example.SpringSecurityDemo.Controller;


import com.example.SpringSecurityDemo.Entity.Role;
import com.example.SpringSecurityDemo.Service.RoleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/role")
public class RoleController {

    RoleService roleService;

    public RoleController(RoleService roleService){
        this.roleService = roleService;
    }

    @PostMapping
    public ResponseEntity<String> setRole(@RequestBody Role role){
        roleService.setRole(role);
        return ResponseEntity.ok("dome");
    }

}
