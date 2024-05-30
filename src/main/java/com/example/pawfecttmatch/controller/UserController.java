package com.example.pawfecttmatch.controller;

import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.pawfecttmatch.models.User;
import com.example.pawfecttmatch.service.UserService;

import jakarta.servlet.http.HttpSession;

@RestController
public class UserController {
    
    @Autowired
    public UserService userService;
    @Autowired
    private HttpSession httpSession;


    public UserController(UserService userService){
        this.userService = userService;
    }

  @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/create-user")
    public String createUser(@RequestBody User user) throws InterruptedException, ExecutionException {
        // Log the user object for debugging
        System.out.println("Received user: " + user);
        return UserService.createUser(user);
    }
    
    @GetMapping("/get-user")
    public User getUser(@RequestParam String documentId) throws InterruptedException, ExecutionException{
        return UserService.getUser(documentId);
    }

    @PutMapping("/update-user")
    public String updateUser(@RequestBody User user) throws InterruptedException, ExecutionException{
        return UserService.updateUser(user);
    }

    @DeleteMapping("/delete-user")
    public String deleteUser(@RequestBody String documentId) throws InterruptedException, ExecutionException{
        return UserService.deleteUser(documentId);
    }

    @GetMapping("/test")
    public ResponseEntity<String> testGetEndpoint(){
        return ResponseEntity.ok("Succesfully got endpoint. Test successful");
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user) {
        try {
            // Perform authentication logic
            User authenticatedUser = userService.getUserByEmailAndPassword(user.getEmail(), user.getPassword());
            if (authenticatedUser != null) {
                // User authenticated successfully
                // Store userId in session
                httpSession.setAttribute("userId", authenticatedUser.getUserId());
                return ResponseEntity.ok("Login successful for user: " + authenticatedUser.getDisplayName());
            } else {
                // Authentication failed
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
            }
        } catch (InterruptedException | ExecutionException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error during authentication");
        }
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/get-user-id")
    public ResponseEntity<String> getUserId() {
        // Retrieve userId from session
        String userId = (String) httpSession.getAttribute("userId");
        if (userId != null) {
            return ResponseEntity.ok(userId);
        } else {
            // User not logged in
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("User not logged in");
        }
    }

}