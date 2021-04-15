package com.ibepc.sishorasepc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibepc.sishorasepc.domain.Area;
import com.ibepc.sishorasepc.domain.Setor;
import com.ibepc.sishorasepc.repositories.SetorRepository;
import com.ibepc.sishorasepc.services.exceptions.ObjectNotFoundException;

@Service
public class SetorService {
	
	@Autowired
	public SetorRepository repo;
	
	public Setor buscar(Integer id) {
		Optional<Setor> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
		 "Objeto não encontrado! Id: " + id + ", Tipo: " + Setor.class.getName()));
	}
}
