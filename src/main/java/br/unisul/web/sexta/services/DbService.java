package br.unisul.web.sexta.services;

import java.text.ParseException;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.unisul.web.sexta.domain.Aluno;
import br.unisul.web.sexta.domain.Disciplina;
import br.unisul.web.sexta.repositories.AlunoRepository;
import br.unisul.web.sexta.repositories.DisciplinaRepository;

@Service
public class DbService {

	@Autowired
	private AlunoRepository ARep;

	@Autowired
	private DisciplinaRepository DRep;

	public void inicializaBancoDeDados() throws ParseException {

		Aluno a1 = new Aluno(null, "Lucas", "lucasemail1@hotmail.com");
								
		Aluno a2 = new Aluno(null, "Fabio", "fabioemail1@gmail.com");

		Disciplina d1 = new Disciplina(null, "POO", "10");
		Disciplina d2 = new Disciplina(null, "INTEGRAIS", "5");

		a1.getDisciplinas().addAll(Arrays.asList(d1, d2));
		a2.getDisciplinas().add(d1);
		
		d1.getAlunos().addAll(Arrays.asList(a1));
		d2.getAlunos().addAll(Arrays.asList(a1,a2));

		DRep.saveAll(Arrays.asList(d1, d2));
		ARep.saveAll(Arrays.asList(a1, a2));
	
		

	}
}