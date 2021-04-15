package com.ibepc.sishorasepc.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ibepc.sishorasepc.domain.Area;
import com.ibepc.sishorasepc.domain.Usuario;
import com.ibepc.sishorasepc.dto.AreaDTO;
import com.ibepc.sishorasepc.dto.UsuarioDTO;
import com.ibepc.sishorasepc.services.UsuarioService;

@RestController
@RequestMapping(value = "/usuarios") /* Mapeia o endpoint no navegador */
public class UsuarioResources {

	@Autowired /* instância objetos automaticamente */
	public UsuarioService service;

	/* método GET para tratar as requisições feitas em /categoria */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Usuario obj = service.buscar(id);
		return ResponseEntity.ok().body(obj);
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<UsuarioDTO>> buscarTudo() {
		List<UsuarioDTO> obj = service.converteDTO(service.buscarTudo());
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(value = "/page",method = RequestMethod.GET)
	public ResponseEntity<Page<UsuarioDTO>> buscarPage(
			@RequestParam(value = "page", defaultValue="0") Integer page, 
			@RequestParam(value = "linesPerPage", defaultValue="24")Integer linesPerPage, 
			@RequestParam(value = "orderBy", defaultValue="nmUsuario")String orderBy, 
			@RequestParam(value = "direction", defaultValue="ASC")String direction) {
		Page<Usuario> listPage = service.buscarPage(page,linesPerPage,orderBy,direction);
		Page<UsuarioDTO> listPageDto = listPage.map(obj -> new UsuarioDTO(obj));
		return ResponseEntity.ok().body(listPageDto);

	}
}