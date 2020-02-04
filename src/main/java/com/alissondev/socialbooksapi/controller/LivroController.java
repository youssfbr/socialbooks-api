package com.alissondev.socialbooksapi.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alissondev.socialbooksapi.entity.Livro;

@RestController
@RequestMapping("/livros")
public class LivroController {

	@GetMapping
	public List<Livro> listar() {
		Livro livro1 = new Livro("Rest Aplicado");
		Livro livro2 = new Livro("Git passo-a-passo");
		
		Livro[] livros = { livro1, livro2 };
		return Arrays.asList(livros);
	}
}
