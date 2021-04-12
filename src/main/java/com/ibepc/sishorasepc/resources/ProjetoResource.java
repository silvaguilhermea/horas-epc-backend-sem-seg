package com.ibepc.sishorasepc.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ibepc.sishorasepc.domain.Projeto;
import com.ibepc.sishorasepc.dto.ProjetoDTO;
import com.ibepc.sishorasepc.services.ProjetoService;

@RestController
@RequestMapping(value = "/projetos") /* Mapeia o endpoint no navegador */
public class ProjetoResource {

	@Autowired /* instância objetos automaticamente */
	public ProjetoService service;

	/* método GET para tratar as requisições feitas em /categoria */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Projeto obj = service.buscar(id);
		return ResponseEntity.ok().body(obj);
	}

	/* método GET para tratar as requisições feitas em /categoria */
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<ProjetoDTO>> buscarTudo() {
		List<ProjetoDTO> obj = service.converteDTO(service.buscarTudo());
		return ResponseEntity.ok().body(obj);

	}
	
}