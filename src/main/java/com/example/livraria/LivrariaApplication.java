package com.example.livraria;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.livraria.dao.AutorRepository;
import com.example.livraria.dao.LivroRepository;
import com.example.livraria.model.Autor;
import com.example.livraria.model.Livro;

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

		List<Autor> autores = new ArrayList<>();

		autores.add(autorRepository.save(new Autor(null, "Adriano Almeida", new Date())));
		autores.add(autorRepository.save(new Autor(null, "Paulo Silveira", new Date())));

		Livro livro = new Livro(null, 2012,
				autores, "Casa do Código",
				"Guia do Programador", "Vá do \"nunca programei\" ...",
				new Date());

		livroRepository.save(livro);

		autores = new ArrayList<>();

		autores.add(autorRepository.save(new Autor(null, "Vinicius Baggio Fuentes", new Date())));

		livroRepository.save(new Livro(null, 2012,
				autores, "Casa do Código",
				"Ruby on Rails", "Crie rapidamente aplicações web",
				new Date()));

	}

}
