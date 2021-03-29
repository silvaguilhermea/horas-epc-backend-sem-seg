package com.ibepc.sishorasepc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibepc.sishorasepc.domain.Usuario;
import com.ibepc.sishorasepc.repositories.UsuarioRepository;

@Service
public class UsuarioService{
	
	@Autowired
	public UsuarioRepository repo;
	
	public Usuario buscar(Integer id) {
		 Optional<Usuario> obj = repo.findById(id);
		return obj.orElse(null); 
	}
}