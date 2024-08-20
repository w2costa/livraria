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

import com.example.livraria.dao.LivroRepository;
import com.example.livraria.model.Livro;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/livraria")
public class LivroController {

    @Autowired
    LivroRepository livroRepository;

    @GetMapping("/livro")
    List<Livro> all() {
        return livroRepository.findAll();
    }

    @GetMapping("/livro/{id}")
    Optional<Livro> getById(@PathVariable Integer id) {
        return livroRepository.findById(id);
    }

    @PostMapping("/livro")
    Livro createNew(@Valid @RequestBody Livro novoLivro) {
        novoLivro.setId(null);
        return livroRepository.save(novoLivro);
    }

    @DeleteMapping("/livro/{id}")
    void delete(@PathVariable Integer id) {
        livroRepository.deleteById(id);
    }

    @PutMapping("/livro/{id}")
    Livro updateOrCreate(@RequestBody Livro novoLivro, @PathVariable Integer id) {

        return livroRepository.findById(id)
                .map(livro -> {
                    livro.setAnoDePublicacao(novoLivro.getAnoDePublicacao());
                    livro.setAutores(novoLivro.getAutores());
                    livro.setEditora(novoLivro.getEditora());
                    livro.setNome(novoLivro.getNome());
                    livro.setResumo(novoLivro.getResumo());
                    livro.setDataDeCriacao(novoLivro.getDataDeCriacao());
                    return livroRepository.save(livro);
                })
                .orElseGet(() -> {
                    novoLivro.setId(id);
                    return livroRepository.save(novoLivro);
                });
    }
}
