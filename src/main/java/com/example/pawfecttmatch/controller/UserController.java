package com.example.pawfecttmatch.controller;

import java.util.concurrent.ExecutionException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.pawfecttmatch.models.User;
import com.example.pawfecttmatch.service.UserService;

@RestController
public class UserController {
    public UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }
    
    @PostMapping("/create")
    public String createUser(@RequestBody User user) throws InterruptedException, ExecutionException{
        return UserService.createUser(user);
    }
        
    
    @GetMapping("/get")
    public User getUser(@RequestParam String documentId) throws InterruptedException, ExecutionException{
        return UserService.getUser(documentId);
    }

    @PutMapping("/update")
    public String updateUser(@RequestBody User user) throws InterruptedException, ExecutionException{
        return UserService.updateUser(user);
    }

    @PutMapping("/delete")
    public String deleteUser(@RequestBody String documentId) throws InterruptedException, ExecutionException{
        return UserService.deleteUser(documentId);
    }

    @GetMapping("/test")
    public ResponseEntity<String> testGetEndpoint(){
        return ResponseEntity.ok("Succesfully got endpoint. Test successful");
    }
}
