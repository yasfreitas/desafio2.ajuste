package com.avaliacao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.avaliacao.entities.Turma;

public interface TurmaRepository extends JpaRepository<Turma, Long> {
	
}