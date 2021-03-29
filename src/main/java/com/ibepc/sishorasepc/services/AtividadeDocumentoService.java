package com.ibepc.sishorasepc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibepc.sishorasepc.domain.AtividadeDocumento;
import com.ibepc.sishorasepc.repositories.AtividadeDocumentoRepository;

@Service
public class AtividadeDocumentoService{
	
	@Autowired
	public AtividadeDocumentoRepository repo;
	
	public AtividadeDocumento buscar(Integer id) {
		 Optional<AtividadeDocumento> obj = repo.findById(id);
		return obj.orElse(null); 
	}
}
