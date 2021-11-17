package br.com.alunos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/api")
@Api(value="Gerenciamento de Alunos")
@CrossOrigin(origins="*")
public class AlunoController {
	
	@Autowired
	AlunoRepository alunoRepository;
	
	@GetMapping("/alunos")
	@ApiOperation(value="Retorna a lista de Alunos")
	public List<Alunos> listaAluno(){
		return alunoRepository.findAll();
	}
	
	@GetMapping("/aluno/{id}")
	@ApiOperation(value="Retorna um Aluno específico")

	public Alunos listaAlunos(@PathVariable(value="id") long id) {
		return alunoRepository.findById(id);
	}
	
	@PostMapping("/aluno")
	@ApiOperation(value="Salva um aluno no sistema")
	public Alunos salvaAluno(@RequestBody Alunos alunos) {
		return alunoRepository.save(alunos);
	}
	
	@DeleteMapping("/aluno")
	@ApiOperation(value="Deleta aluno do sistema")
	public void deletaAluno(@RequestBody Alunos alunos) { // void pois não deve me retornar nada
		alunoRepository.delete(alunos);						//passar ID para deleta
	}
	
	@PutMapping("/aluno")
	@ApiOperation(value="Atuliza dados cadastrais do Aluno")
	public Alunos atualizaAluno(@RequestBody Alunos alunos) {
		return alunoRepository.save(alunos);				
	}
	
	
	
}
