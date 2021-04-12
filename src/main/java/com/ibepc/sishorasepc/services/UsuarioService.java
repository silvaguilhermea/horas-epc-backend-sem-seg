package com.ibepc.sishorasepc.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibepc.sishorasepc.domain.Usuario;
import com.ibepc.sishorasepc.dto.UsuarioDTO;
import com.ibepc.sishorasepc.repositories.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	public UsuarioRepository repo;

	public Usuario buscar(Integer id) {
		Optional<Usuario> obj = repo.findById(id);
		return obj.orElse(null);
	}

	public List<Usuario> buscarTudo() {
		List<Usuario> usuarios = repo.findAll();
		return usuarios;
	}

	public List<UsuarioDTO> converteDTO(List<Usuario> usuarios) {
		List<UsuarioDTO> listDto = usuarios.stream().map(obj -> new UsuarioDTO(obj)).collect(Collectors.toList());
		return listDto;
	}
}