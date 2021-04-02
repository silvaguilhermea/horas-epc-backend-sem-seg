package com.ibepc.sishorasepc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibepc.sishorasepc.domain.Setor;
import com.ibepc.sishorasepc.repositories.SetorRepository;

@Service
public class SetorService {
	
	@Autowired
	public SetorRepository repo;
	
	public Setor buscar(Integer id) {
		 Optional<Setor> obj = repo.findById(id);
		return obj.orElse(null); 
	}
}
