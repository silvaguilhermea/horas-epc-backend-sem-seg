package com.ibepc.sishorasepc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibepc.sishorasepc.domain.Area;
import com.ibepc.sishorasepc.repositories.AreaRepository;

@Service
public class AreaService {
	
	@Autowired
	public AreaRepository repo;
	
	public Area buscar(Integer id) {
		 Optional<Area > obj = repo.findById(id);
		return obj.orElse(null); 
	}
}
