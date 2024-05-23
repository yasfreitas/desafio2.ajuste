package com.avaliacao.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.avaliacao.entities.Alunos;

public interface AlunoRepository extends JpaRepository<Alunos, Long> {
	//Query Methods
	List<Alunos> findByCidade(String cidade);
	List<Alunos> findByRa(String ra);

}