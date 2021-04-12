package com.ibepc.sishorasepc.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibepc.sishorasepc.domain.AtividadeDocumento;
import com.ibepc.sishorasepc.domain.Projeto;
import com.ibepc.sishorasepc.repositories.AtividadeDocumentoRepository;

@Service
public class AtividadeDocumentoService{
	
	@Autowired
    EntityManager entityManager;
	
	@Autowired
	public AtividadeDocumentoRepository repo;
	
	public AtividadeDocumento buscar(Integer id) {
		 Optional<AtividadeDocumento> obj = repo.findById(id);
		return obj.orElse(null); 
	}

	public List<AtividadeDocumento>  buscarProjeto(Integer projeto_id) {
		Projeto prj = new Projeto();
		prj.setId(projeto_id);
		
		List<AtividadeDocumento> atividadeDocumento = repo.findByProjeto(prj);
		return atividadeDocumento; 
	}
	
	public List <AtividadeDocumento> buscarUsuarioId(Integer usuario_id) {
		return repo.findByUsuarioId(usuario_id);
		 
		
	}
	
}
