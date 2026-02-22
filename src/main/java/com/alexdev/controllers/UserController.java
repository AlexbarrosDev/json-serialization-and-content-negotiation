package com.alexdev.controllers;

import com.alexdev.dtos.request.UserCreateDTO;
import com.alexdev.dtos.response.UserDTO;
import com.alexdev.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll() {

        return ResponseEntity.ok().body(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable Long id) {

        return ResponseEntity.ok().body(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<UserDTO> create(@RequestBody UserCreateDTO user) {

        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(user));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> update(@PathVariable Long id, @RequestBody UserCreateDTO user) {

        return ResponseEntity.ok().body(service.update(id, user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {

        service.delete(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
