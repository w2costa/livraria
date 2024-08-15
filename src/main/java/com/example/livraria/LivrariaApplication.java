package com.example.livraria;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.livraria.dao.AutorRepository;
import com.example.livraria.dao.LivroRepository;
import com.example.livraria.model.Autor;

@SpringBootApplication
public class LivrariaApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(LivrariaApplication.class, args);
	}

	@Autowired
	AutorRepository autorRepository;

	@Autowired
	LivroRepository livroRepository;

	@Override
	public void run(String... args) throws Exception {

		autorRepository.save(new Autor(null, "Adriano Almeida", new Date()));
		autorRepository.save(new Autor(null, "Paulo Silveira", new Date()));
		autorRepository.save(new Autor(null, "Vinicius Baggio Fuentes", new Date()));

	}

}
