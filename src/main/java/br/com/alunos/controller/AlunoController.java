package br.com.alunos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alunos.model.Alunos;
import br.com.alunos.respository.AlunoRepository;

@RestController
@RequestMapping(value = "/api")
public class AlunoController {
	
	@Autowired
	AlunoRepository alunoRepository;
	
	@GetMapping("/alunos")
	public List<Alunos> listaAluno(){
		return alunoRepository.findAll();
	}
	
	@GetMapping("/aluno/{id}")
	public Alunos listaAlunos(@PathVariable(value="id") long id) {
		return alunoRepository.findById(id);
	}
	
	@PostMapping("/aluno")
	public Alunos salvaAluno(@RequestBody Alunos alunos) {
		return alunoRepository.save(alunos);
	}
	
	@DeleteMapping("/aluno")
	public void deletaAluno(@RequestBody Alunos alunos) { // void pois não deve me retornar nada
		alunoRepository.delete(alunos);						//passar ID para delet
	}
	
	@PutMapping("/aluno")
	public Alunos atualizaAluno(@RequestBody Alunos alunos) {
		return alunoRepository.save(alunos);				
	}
	
	
	
}
