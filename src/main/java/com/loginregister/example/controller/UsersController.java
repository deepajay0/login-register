package com.loginregister.example.controller;

import com.loginregister.example.entity.Users;
import com.loginregister.example.request.LoginRequest;
import com.loginregister.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsersController {

    @Autowired
    private UserService userService;

    @PostMapping("/add-user")
    @CrossOrigin(origins = "http://localhost:4200/")
    public ResponseEntity<Users> addUser(@RequestBody Users user){
      return ResponseEntity.ok(userService.addUser(user));
    }

    @PostMapping("/login-user")
    @CrossOrigin(origins = "http://localhost:4200/")
    public Boolean loginUser(@RequestBody LoginRequest loginRequest){
        return userService.loginUser(loginRequest);
    }
}
