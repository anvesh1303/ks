package com.proj1.ks.controller;

import com.proj1.ks.dtos.LoginRequest;
import com.proj1.ks.dtos.SignupRequest;
import com.proj1.ks.model.User;
import com.proj1.ks.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/api")
public class LoginController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest){
        User user = userRepository.findByUsername(loginRequest.getUsername());
        if(user!=null && user.getPassword().equals(loginRequest.getPassword())){
            return ResponseEntity.ok("Login successful");
        }
        else{
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
        }
    }

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody SignupRequest signupRequest){
        User user = userRepository.findByUsername(signupRequest.getUsername());
        if(user!=null){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Username already exists");
        }
        else{
            User newUser = new User();
            newUser.setUsername(signupRequest.getUsername());
            newUser.setPassword(signupRequest.getPassword());
            userRepository.save(newUser);
            return ResponseEntity.ok("Signup successful");
        }
    }
}
