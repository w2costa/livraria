package com.example.livraria.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.livraria.model.Autor;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Integer> {
    
}
