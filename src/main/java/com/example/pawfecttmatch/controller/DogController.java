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

import com.example.pawfecttmatch.models.Dog;
import com.example.pawfecttmatch.service.DogService;

@RestController
public class DogController {
    
    @Autowired
    public DogService dogService;

    public DogController(DogService dogService){
        this.dogService = dogService;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/create-dog")
    public String createDog(@RequestBody Dog Dog) throws InterruptedException, ExecutionException {
        // Log the Dog object for debugging
        System.out.println("Received Dog: " + Dog);
        return DogService.createDog(Dog);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/get-dog")
    public Dog getDog(@RequestParam String documentId) throws InterruptedException, ExecutionException{
        return DogService.getDog(documentId);
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping("/update-dog")
    public String updateDog(@RequestBody Dog Dog) throws InterruptedException, ExecutionException{
        return DogService.updateDog(Dog);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("/delete-dog")
    public String deleteDog(@RequestBody String documentId) throws InterruptedException, ExecutionException{
        return DogService.deleteDog(documentId);
    }
}
