package com.example.kontrol29_03.Repositories;

import com.example.kontrol29_03.Models.Cathegory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
@Service
public interface CathegoryRepository extends JpaRepository<Cathegory, Integer> {
    public List<Cathegory> findAll();

    public Cathegory findCathegoryById(Long id);
}
