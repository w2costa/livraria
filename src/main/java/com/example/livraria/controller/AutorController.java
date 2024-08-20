package com.example.livraria.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
    List<Autor> listarAutores() {
        return autorRepository.findAll();
    }

    @GetMapping("/autor/{id}")
    Optional<Autor> getById(@PathVariable Integer id) {
        return autorRepository.findById(id);
    }

    @PostMapping("/autor")
    Autor createNew(@RequestBody Autor novoAutor) {
        novoAutor.setId(null);
        return autorRepository.save(novoAutor);
    }

    @DeleteMapping("/autor/{id}")
    void delete(@PathVariable Integer id) {
        autorRepository.deleteById(id);
    }

    @PutMapping("/autor/{id}")
    Autor updateOrCreate(@RequestBody Autor novoAutor, @PathVariable Integer id) {

        return autorRepository.findById(id)
                .map(autor -> {
                    autor.setNome(novoAutor.getNome());
                    autor.setDataNascimento(novoAutor.getDataNascimento());
                    return autorRepository.save(autor);
                })
                .orElseGet(() -> {
                    novoAutor.setId(id);
                    return autorRepository.save(novoAutor);
                });
    }

}
