package com.ibepc.sishorasepc.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.ibepc.sishorasepc.security.UsuarioSS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ibepc.sishorasepc.domain.Usuario;
import com.ibepc.sishorasepc.dto.UsuarioDTO;
import com.ibepc.sishorasepc.repositories.UsuarioRepository;
import com.ibepc.sishorasepc.services.exceptions.DataIntegrityException;
import com.ibepc.sishorasepc.services.exceptions.ObjectNotFoundException;

@Service
public class UsuarioService {

	@Autowired
	public UsuarioRepository repo;

	@Autowired
	private BCryptPasswordEncoder pe;

	public Usuario insert(Usuario obj) {
		obj.setId(null);
		obj.setSenha(pe.encode(obj.getSenha()));
		return repo.save(obj);
	}
	
	public Usuario update(Usuario obj) {
		buscar(obj.getId());
		return repo.save(obj);
	}
	
	public void delete(Integer id) {
		buscar(id);
		try {
			repo.deleteById(id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir uma usuário que possuí documentos");
		}
	}

	public Usuario buscar(Integer id) {
		Optional<Usuario> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
		 "Objeto não encontrado! Id: " + id + ", Tipo: " + Usuario.class.getName()));
	}

	public List<Usuario> buscarTudo() {
		List<Usuario> usuarios = repo.findAll();
		return usuarios;
	}

	public List<UsuarioDTO> converteDTO(List<Usuario> usuarios) {
		List<UsuarioDTO> listDto = usuarios.stream().map(obj -> new UsuarioDTO(obj)).collect(Collectors.toList());
		return listDto;
	}
	
	public Page<Usuario> buscarPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction),orderBy);
		return repo.findAll(pageRequest);

	}

	public static UsuarioSS authenticated() {
		try {
			return (UsuarioSS) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		}
		catch(Exception e) {
			return null;
		}
	}


	public Usuario findByEmail(String email) {
		Usuario obj = repo.findByEmail(email);
		if(obj == null) {
			throw new ObjectNotFoundException("Usuario não encontrado! " + email + ", Classe:" + Usuario.class.getName());
		}
		return obj;
	}
}