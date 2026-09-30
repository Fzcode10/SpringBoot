package com.example.SpringSecurityDemo.Service;

import com.example.SpringSecurityDemo.Dto.UserRegisterRequestDto;
import com.example.SpringSecurityDemo.Dto.UserRegisterResponseDto;
import com.example.SpringSecurityDemo.Entity.Role;
import com.example.SpringSecurityDemo.Entity.User;
import com.example.SpringSecurityDemo.Repository.RoleRepository;
import com.example.SpringSecurityDemo.Repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    private RoleRepository roleRepository;

    public AuthService(UserRepository userRepository,
                       RoleRepository roleRepository,
                       PasswordEncoder passwordEncoder
                      ){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
    }

    public UserRegisterResponseDto registerUser(UserRegisterRequestDto userRegisterRequestDto){
        User user = new User();

        user.setUsername(userRegisterRequestDto.getUsername());
        String encodedPassword =
                passwordEncoder.encode(userRegisterRequestDto.getPassword());
        user.setPassword(encodedPassword);

        user.setIsEnabled(true);

        Role role =  roleRepository.findByName("ROLE_USER").get();

        user.getRoles().add(role);

        userRepository.save(user);

        UserRegisterResponseDto responseDto = new UserRegisterResponseDto();

        responseDto.setUsername(user.getUsername());
        responseDto.setMessage("User Saved");

        return responseDto;
    }


}
