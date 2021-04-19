package com.example.demo.controllers;

import com.example.demo.models.Role;
import com.example.demo.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("trello")
public class RoleController {
    private final RoleRepository roleRepository;

    @Autowired
    public RoleController(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @GetMapping(value = "/AllRoles")
    private ResponseEntity<List<Role>> getAll(){
        final List<Role> roles = roleRepository.findAll();
        if (!roles.isEmpty()){
            return new ResponseEntity<>(roles, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/role/id={id}")
    public ResponseEntity<Role> getRole(@PathVariable Long id) {
        final Role found = roleRepository.findRoleByRowId(id);
        if (found != null){
            return new ResponseEntity<>(found, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(value="AddRole")
    private ResponseEntity<?> create(@RequestBody Role role){
        Role newRole = roleRepository.save(role);
        return new ResponseEntity<>(newRole, HttpStatus.CREATED);
    }

    @PutMapping(value = "PutRole")
    public ResponseEntity<?> put(@RequestBody Role role) {
        return new ResponseEntity<>(roleRepository.save(role),HttpStatus.OK);
    }

    @DeleteMapping(value = "role/id={id}")
    public ResponseEntity<Role> delete(@PathVariable long id) {
        roleRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
