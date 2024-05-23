package com.avaliacao.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avaliacao.entities.Alunos;
import com.avaliacao.repository.AlunoRepository;

@Service
public class AlunoService {
    private final AlunoRepository alunoRepository;
    
    @Autowired
    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    public List<Alunos> getAllAlunos() {
        return alunoRepository.findAll();
    }

    public Alunos getAlunoById(Long id) {
        Optional<Alunos> aluno = alunoRepository.findById(id);
        return aluno.orElse(null);
    }
    //Query Method
    public List<Alunos> buscarAlunosPorRa(String ra) {
        return alunoRepository.findByRa(ra); 
      }
    //Query Method 
    public List<Alunos> buscarAlunosPorCidade(String cidade) {
        return alunoRepository.findByCidade(cidade); 
      }

    public Alunos salvarAluno(Alunos aluno) {
        return alunoRepository.save(aluno);
    }

    public Alunos updateAluno(Long id, Alunos updatedAluno) {
        Optional<Alunos> existingAluno = alunoRepository.findById(id);
        if (existingAluno.isPresent()) {
            updatedAluno.setId(id);
            return alunoRepository.save(updatedAluno);
        }
        return null;
    }

    public boolean deleteAluno(Long id) {
        Optional<Alunos> existingAluno = alunoRepository.findById(id);
        if (existingAluno.isPresent()) {
            alunoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}