package com.example.demo.repositories;

import com.example.demo.models.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StatusRepository extends JpaRepository<Status, Long> {
    List<Status> findAll();
    Status findStatusByRowId(long id);
}
