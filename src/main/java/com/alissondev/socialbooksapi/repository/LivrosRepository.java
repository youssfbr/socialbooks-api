package com.alissondev.socialbooksapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alissondev.socialbooksapi.entity.Livro;

public interface LivrosRepository extends JpaRepository<Livro, Long> {

}
