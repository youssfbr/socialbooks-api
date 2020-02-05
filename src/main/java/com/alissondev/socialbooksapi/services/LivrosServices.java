package com.alissondev.socialbooksapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alissondev.socialbooksapi.entity.Livro;
import com.alissondev.socialbooksapi.repository.LivrosRepository;

@Service
public class LivrosServices {

	@Autowired
	private LivrosRepository livrosRepository;
	
	public List<Livro> listar() {
		return livrosRepository.findAll();
	}	
}
