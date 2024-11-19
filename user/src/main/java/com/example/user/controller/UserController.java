package com.example.user.controller;

import com.example.user.model.User;
import com.example.user.repository.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private userRepository repository;

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return new ResponseEntity<>(repository.save(user), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        Optional<User> user = repository.findById(id);
        return new ResponseEntity<>(user.orElse(null), HttpStatus.OK);
    }

    @GetMapping
    public List<User> getAllUsers() {
        return repository.findAll();
    }
}