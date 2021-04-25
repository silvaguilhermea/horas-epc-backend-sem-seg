package com.ibepc.sishorasepc.services;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import com.ibepc.sishorasepc.domain.Usuario;
import com.ibepc.sishorasepc.dto.SetorDTO;
import com.ibepc.sishorasepc.dto.UsuarioDTO;
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

	public List<Setor> buscarTudo() {
		List<Setor> setor = repo.findAll();
		return setor;
	}

	public List<SetorDTO> converteDTO(List<Setor> setores) {
		List<SetorDTO> listDto = setores.stream().map(obj -> new SetorDTO(obj)).collect(Collectors.toList());
		return listDto;
	}
}
