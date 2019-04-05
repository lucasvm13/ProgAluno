package br.unisul.web.sexta.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.unisul.web.sexta.domain.Aluno;
import br.unisul.web.sexta.repositories.AlunoRepository;

@Service
public class AlunoService {

	@Autowired
	private AlunoRepository rep;

	// BUSCA POR ID
	public Aluno find(Integer id) {
		Optional<Aluno> obj = rep.findById(id);
		return obj.orElse(null);
	}

	// FAZ INSERÇÃO
	public Aluno insert(Aluno obj) {
		obj.setId(null);
		return rep.save(obj);
	}

	// ATUALIZAR
	public Aluno update(Aluno obj) {
		find(obj.getId());
		return rep.save(obj);
	}

	// DELETAR
	public void delete(Integer id) {
		find(id);
		rep.deleteById(id);
	}

	// LISTAR TODAS
	public List<Aluno> findAll() {
		return rep.findAll();
	}
}
