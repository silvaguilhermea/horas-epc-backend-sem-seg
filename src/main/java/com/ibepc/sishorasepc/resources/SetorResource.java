package com.ibepc.sishorasepc.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ibepc.sishorasepc.domain.Setor;
import com.ibepc.sishorasepc.services.SetorService;


@RestController
@RequestMapping(value = "/setores") /* Mapeia o endpoint no navegador */
public class SetorResource {

	@Autowired /* instância objetos automaticamente */
	public SetorService service;

	/* método GET para tratar as requisições feitas em /categoria */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Setor obj = service.buscar(id);
		return ResponseEntity.ok().body(obj);

	}

	
}
