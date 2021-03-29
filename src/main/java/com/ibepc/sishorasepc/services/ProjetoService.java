package com.ibepc.sishorasepc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibepc.sishorasepc.domain.Projeto;
import com.ibepc.sishorasepc.repositories.ProjetoRepository;

@Service
public class ProjetoService{
	
	@Autowired
	public ProjetoRepository repo;
	
	public Projeto buscar(Integer id) {
		 Optional<Projeto> obj = repo.findById(id);
		return obj.orElse(null); 
	}
}
