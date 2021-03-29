package com.example.kontrol29_03.Controllers;

import com.example.kontrol29_03.Models.Cathegory;
import com.example.kontrol29_03.Repositories.CathegoryRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/Kr29")
public class CathegoryController {
    private final CathegoryRepository cathegoryRepository;


    public CathegoryController(CathegoryRepository cathegoryRepository) {
        this.cathegoryRepository=cathegoryRepository;
    }

    @PostMapping("/addCathegory")
    Cathegory createCathegory(@RequestBody Cathegory cathegory) {
        System.out.println(cathegory);
        return this.cathegoryRepository.save(cathegory);
    }

    @GetMapping("/getCathegory={id}")
    Cathegory getCathegory(@PathVariable Long id) {
        return this.cathegoryRepository.findCathegoryById(id);
    }

    @GetMapping("/AllCathegories")
    List<Cathegory> getCathegories() {
        return this.cathegoryRepository.findAll();
    }
}