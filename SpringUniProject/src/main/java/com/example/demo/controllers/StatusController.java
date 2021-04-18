package com.example.demo.controllers;

import com.example.demo.models.Status;
import com.example.demo.repositories.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("trello")
public class StatusController {
    private final StatusRepository statusRepository;

    @Autowired
    public StatusController(StatusRepository statusRepository) {
        this.statusRepository = statusRepository;
    }

    @GetMapping(value = "/AllAtatuses")
    private ResponseEntity<List<Status>> getAll(){
        final List<Status> statusList = statusRepository.findAll();
        if(!statusList.isEmpty()){
            return new ResponseEntity<>(statusList, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/status/id={id}")
    public ResponseEntity<Status> getStatus(@PathVariable Long id) {
        final Status currentStatus = statusRepository.findStatusByRowId(id);
        if (currentStatus != null){
            return new ResponseEntity<>(currentStatus, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(value="AddStatus")
    private ResponseEntity<?> create(@RequestBody Status status){
        Status newStatus = statusRepository.save(status);
        return new ResponseEntity<>(newStatus, HttpStatus.CREATED);
    }

    @PutMapping(value = "PutStatus")
    public ResponseEntity<?> put(@RequestBody Status status) {
        return new ResponseEntity<>(statusRepository.save(status),HttpStatus.OK);
    }

    @DeleteMapping(value = "status/id={id}")
    public ResponseEntity<Status> delete(@PathVariable long id) {
        statusRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}