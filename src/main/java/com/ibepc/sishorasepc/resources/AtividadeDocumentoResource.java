package com.ibepc.sishorasepc.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ibepc.sishorasepc.domain.AtividadeDocumento;
import com.ibepc.sishorasepc.services.AtividadeDocumentoService;

@RestController
@RequestMapping(value = "/atvdocs") /* Mapeia o endpoint no navegador */
public class AtividadeDocumentoResource {

	@Autowired
	public AtividadeDocumentoService service;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		AtividadeDocumento obj = service.buscar(id);
		return ResponseEntity.ok().body(obj);

	}

	@RequestMapping(value = "/usuario/{id}", method = RequestMethod.GET)
	public ResponseEntity<List<AtividadeDocumento>> findUsuarioId(@PathVariable Integer id) {
		List<AtividadeDocumento> obj = service.buscarUsuarioId(id);
		return ResponseEntity.ok().body(obj);

	}

	/* método GET para tratar as requisições feitas em /categoria */
	@RequestMapping(value = "/projeto/{projeto_id}", method = RequestMethod.GET)
	public ResponseEntity<List<AtividadeDocumento>> findProjeto(@PathVariable Integer projeto_id) {
		List<AtividadeDocumento> obj = service.buscarProjeto(projeto_id);
		return ResponseEntity.ok().body(obj);

	}
}