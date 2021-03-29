package com.example.kontrol29_03.Repositories;

import com.example.kontrol29_03.Models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
@Service
public interface ClientRepository extends JpaRepository<Client, Integer> {
    public List<Client> findAll();

    public Client findClientById(Long id);
}
