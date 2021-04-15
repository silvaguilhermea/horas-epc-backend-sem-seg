package com.ibepc.sishorasepc.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.ibepc.sishorasepc.domain.Projeto;
import com.ibepc.sishorasepc.dto.ProjetoDTO;
import com.ibepc.sishorasepc.repositories.ProjetoRepository;

@Service
public class ProjetoService{
	
	@Autowired
	public ProjetoRepository repo;
	
	public Projeto buscar(Integer id) {
		 Optional<Projeto> obj = repo.findById(id);
		return obj.orElse(null); 
	}
	
	public List<Projeto>  buscarTudo() {
		 List<Projeto> projetos = repo.findAll();
		return projetos; 
	}
	
	public List<ProjetoDTO> converteDTO(List<Projeto> projetos) {
		List<ProjetoDTO> listDto = projetos.stream().map(obj -> new ProjetoDTO(obj)).collect(Collectors.toList());
		return listDto;
	}
	
	public Page<Projeto> buscarPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction),orderBy);
		return repo.findAll(pageRequest);

	}
}