package com.example.SpringSecurityDemo.Controller;

import com.example.SpringSecurityDemo.Dto.UserRegisterRequestDto;
import com.example.SpringSecurityDemo.Dto.UserRegisterResponseDto;
import com.example.SpringSecurityDemo.Entity.User;
import com.example.SpringSecurityDemo.Service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    AuthService authService;

//    @Autowired
//    private PasswordEncoder passwordEncoder;

    public UserController(AuthService authService){
        this.authService = authService;
    }

    @GetMapping("/hello")
    public String sayHello(){
        return "Hello";
    }

    @PostMapping("/register")
    public ResponseEntity<UserRegisterResponseDto> registerUser(
            @RequestBody UserRegisterRequestDto userRegisterRequestDto ) {
        UserRegisterResponseDto responseDto = authService.registerUser(userRegisterRequestDto);

        return ResponseEntity.ok(responseDto);
    }

//    @GetMapping("/token")
//    public CsrfToken getToken(CsrfToken csrfToken){
//        return csrfToken;
//    }


}
