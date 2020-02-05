package com.alissondev.socialbooksapi.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.alissondev.socialbooksapi.entity.Livro;
import com.alissondev.socialbooksapi.repository.LivrosRepository;

@RestController
@RequestMapping("/livros")
public class LivroController {
	
	@Autowired
	private LivrosRepository livrosRepository;
 
	@GetMapping
	public ResponseEntity<List<Livro>> listar() {		
		return ResponseEntity.ok().body(livrosRepository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Livro> buscar(@PathVariable Long id) {
		Optional<Livro> livro = livrosRepository.findById(id);
		
		if (livro.isEmpty()) 
			return ResponseEntity.notFound().build();		
		
		return ResponseEntity.ok(livro.get());
	}
	
	@PostMapping	
	public ResponseEntity<Void> salvar(@RequestBody Livro livro) {
		livro = livrosRepository.save(livro);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(livro.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id) {
		try {
			livrosRepository.deleteById(id);	
		} 
		catch (EmptyResultDataAccessException e) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.noContent().build();
	}	
	
	@PutMapping("/{id}")
	public void atualizar(@RequestBody Livro livro, @PathVariable Long id) {
		livro.setId(id);
		livrosRepository.save(livro);
	}
}
