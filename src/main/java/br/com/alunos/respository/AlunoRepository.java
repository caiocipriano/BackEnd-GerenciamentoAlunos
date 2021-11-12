package br.com.alunos.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.alunos.model.Alunos;

public interface AlunoRepository extends JpaRepository <Alunos, Long>{
		
	Alunos findById(long id);
}
