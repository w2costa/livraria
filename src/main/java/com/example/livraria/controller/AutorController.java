package com.example.livraria.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.livraria.dao.AutorRepository;
import com.example.livraria.model.Autor;




@RestController
@RequestMapping("/livraria")
public class AutorController {

    @Autowired
    AutorRepository autorRepository;

    @GetMapping("/autor")
    public List<Autor> listarAutores() {
        return autorRepository.findAll();
    }
    

    @GetMapping("/autor/{id}")
    Optional<Autor> getById(@PathVariable Integer id) {
        return autorRepository.findById(id);
    }

    @PostMapping("/autor")
    Autor createNew(@RequestBody Autor novoAutor) {
        return autorRepository.save(novoAutor);
    }
    
    
}
