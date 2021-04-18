package com.example.demo.controllers;

import com.example.demo.models.User;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("trello")
public class UserController {
    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping(value = "/AllUsers")
    private ResponseEntity<List<User>> getAll(){
        final List<User> userList = userRepository.findAll();
        if (!userList.isEmpty()){
            return new ResponseEntity<>(userList, HttpStatus.OK);
        }else{
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/user/id={id}")
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        final User currentUser = userRepository.findUserByRowId(id);
        if (currentUser != null){
            return new ResponseEntity<>(currentUser, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(value="AddUser")
    private ResponseEntity<?> create(@RequestBody User user){
        User newUser = userRepository.save(user);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    @PutMapping(value = "PutUser")
    public ResponseEntity<?> put(@RequestBody User user) {
        return new ResponseEntity<>(userRepository.save(user),HttpStatus.OK);
    }

    @DeleteMapping(value = "user/id={id}")
    public ResponseEntity<User> delete(@PathVariable long id) {
        userRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
