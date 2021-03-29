package com.example.kontrol29_03.Controllers;

import com.example.kontrol29_03.Models.Client;
import com.example.kontrol29_03.Repositories.ClientRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/Kr29")
public class ClientController {
    private final ClientRepository clientRepository;


    public ClientController(ClientRepository clientRepository) {
        this.clientRepository=clientRepository;
    }

    @PostMapping("/addClient")
    Client createClient(@RequestBody Client client) {
        System.out.println(client);
        return this.clientRepository.save(client);
    }

    @GetMapping("/getClient={id}")
    Client getClient(@PathVariable Long id) {
        return this.clientRepository.findClientById(id);
    }

    @GetMapping("/AllClients")
    List<Client> getClients() {
        return this.clientRepository.findAll();
    }
}
