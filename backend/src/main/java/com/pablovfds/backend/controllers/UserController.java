package com.pablovfds.backend.controllers;

import com.pablovfds.backend.exceptions.ResourceNotFoundException;
import com.pablovfds.backend.model.User;
import com.pablovfds.backend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("")
    public ResponseEntity getAll(Pageable pageable) {
        return ResponseEntity.ok(this.userService.find(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getById(@PathVariable(value = "id") String id) throws ResourceNotFoundException {
        return ResponseEntity.ok().body(this.userService.findOne(id));
    }

    @PostMapping("")
    public ResponseEntity create(UriComponentsBuilder builder, @Valid @RequestBody User user) {

        user = this.userService.save(user);

        UriComponents uriComponents =
                builder.path("/user/{id}").buildAndExpand(user.getId());

        return ResponseEntity.created(uriComponents.toUri()).body(user);
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity update(@Valid @RequestBody User user) throws ResourceNotFoundException {
        return ResponseEntity.ok(this.userService.edit(user));
    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity deleteEmployee(@PathVariable(value = "id") String id)
            throws ResourceNotFoundException {
        this.userService.remove(id);
        return ResponseEntity.ok().build();
    }
}
