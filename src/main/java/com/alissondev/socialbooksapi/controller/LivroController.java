package com.alissondev.socialbooksapi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@GetMapping("/{id}")
	public ResponseEntity<Livro> buscar(@PathVariable Long id) {
		Optional<Livro> livro = livrosRepository.findById(id);
		
		if (livro.isEmpty()) 
			return ResponseEntity.notFound().build();		
		
		return ResponseEntity.ok(livro.get());
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Livro salvar(@RequestBody Livro livro) {
		return livrosRepository.save(livro);
	}
	
	@DeleteMapping("/{id}")
	public void deletar(@PathVariable Long id) {
		livrosRepository.deleteById(id);
	}	
}
