package com.alissondev.socialbooksapi.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.alissondev.socialbooksapi.entity.Livro;
import com.alissondev.socialbooksapi.repository.LivrosRepository;

@RestController
@RequestMapping("/livros")
public class LivroController {
	
	@Autowired
	private LivrosRepository livrosRepository;
 
	@GetMapping
	public List<Livro> listar() {		
		return livrosRepository.findAll();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Livro salvar(@RequestBody Livro livro) {
		return livrosRepository.save(livro);
	}
}
