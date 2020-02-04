package com.alissondev.socialbooksapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/livros")
public class LivroController {

	@GetMapping
	public String listar() {
		return "Rest Aplicado, Git passo-a-passo";
	}
}
