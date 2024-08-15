package com.example.livraria.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.livraria.model.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Integer> {
    
}
