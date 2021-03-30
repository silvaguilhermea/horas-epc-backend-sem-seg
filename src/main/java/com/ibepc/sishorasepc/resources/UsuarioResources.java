package com.ibepc.sishorasepc.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ibepc.sishorasepc.domain.Usuario;
import com.ibepc.sishorasepc.services.UsuarioService;

@RestController
@RequestMapping(value = "/Usuarios") /* Mapeia o endpoint no navegador */
public class UsuarioResources {

	@Autowired /* instância objetos automaticamente */
	public UsuarioService service;
	
	/* método GET para tratar as requisições feitas em /categoria */
	@RequestMapping(value = "/{id}",method = RequestMethod.GET) 
	
	/* @PathVariable para conectar o id da requisição com id da classe */
	public ResponseEntity<?> find(@PathVariable Integer id) { 
	Usuario obj = service.buscar(id);
	return ResponseEntity.ok().body(obj);	
	
	}
}