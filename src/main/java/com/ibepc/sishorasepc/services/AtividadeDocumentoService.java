package com.ibepc.sishorasepc.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.ibepc.sishorasepc.domain.Area;
import com.ibepc.sishorasepc.domain.AtividadeDocumento;
import com.ibepc.sishorasepc.domain.Projeto;
import com.ibepc.sishorasepc.dto.AreaDTO;
import com.ibepc.sishorasepc.dto.AtividadeDocumentoDTO;
import com.ibepc.sishorasepc.repositories.AtividadeDocumentoRepository;
import com.ibepc.sishorasepc.services.exceptions.ObjectNotFoundException;

@Service
public class AtividadeDocumentoService{
	
	@Autowired
    EntityManager entityManager;
	
	@Autowired
	public AtividadeDocumentoRepository repo;
	
	public AtividadeDocumento buscar(Integer id) {
		Optional<AtividadeDocumento> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + AtividadeDocumento.class.getName()));
	}
	
	public List<AtividadeDocumento> buscarTudo() {
		List<AtividadeDocumento> atividadesDocumentos = repo.findAll();
		return atividadesDocumentos;
	}

	public List<AtividadeDocumento>  buscarProjeto(Integer projeto_id) {
		Projeto prj = new Projeto();
		prj.setId(projeto_id);
		
		List<AtividadeDocumento> atividadeDocumento = repo.findByProjeto(prj);
		return atividadeDocumento; 
	}
	
	public List <AtividadeDocumento> buscarUsuarioId(Integer usuario_id) {
		return repo.findByUsuarioId(usuario_id);
		 
		
	}
	
	public List<AtividadeDocumentoDTO> converteDTO(List<AtividadeDocumento> areas) {
		List<AtividadeDocumentoDTO> listDto = areas.stream().map(obj -> new AtividadeDocumentoDTO(obj)).collect(Collectors.toList());
		return listDto;
	}
	
	public Page<AtividadeDocumento> buscarPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction),orderBy);
		return repo.findAll(pageRequest);

	}
	
}
