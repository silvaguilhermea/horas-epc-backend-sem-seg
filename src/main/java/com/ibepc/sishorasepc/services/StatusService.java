package com.ibepc.sishorasepc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibepc.sishorasepc.domain.Area;
import com.ibepc.sishorasepc.domain.Status;
import com.ibepc.sishorasepc.repositories.StatusRepository;
import com.ibepc.sishorasepc.services.exceptions.ObjectNotFoundException;

@Service
public class StatusService{
	
	@Autowired
	public StatusRepository repo;
	
	public Status buscar(Integer id) {
		Optional<Status> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
		 "Objeto não encontrado! Id: " + id + ", Tipo: " + Status.class.getName()));
	}
}
