package com.example.SpringSecurityDemo.Service;

import com.example.SpringSecurityDemo.Entity.CustomUserDetails;
import com.example.SpringSecurityDemo.Entity.User;
import com.example.SpringSecurityDemo.Repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {

        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(
                        "user not Found"
                ));

        return new CustomUserDetails(user);
    }
}
