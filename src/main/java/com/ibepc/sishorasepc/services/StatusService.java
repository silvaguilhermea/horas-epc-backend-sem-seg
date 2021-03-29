package com.ibepc.sishorasepc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibepc.sishorasepc.domain.Status;
import com.ibepc.sishorasepc.repositories.StatusRepository;

@Service
public class StatusService{
	
	@Autowired
	public StatusRepository repo;
	
	public Status buscar(Integer id) {
		 Optional<Status> obj = repo.findById(id);
		return obj.orElse(null); 
	}
}
