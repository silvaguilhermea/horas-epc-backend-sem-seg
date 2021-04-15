package com.ibepc.sishorasepc.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ibepc.sishorasepc.domain.Area;
import com.ibepc.sishorasepc.dto.AreaDTO;
import com.ibepc.sishorasepc.services.AreaService;

@RestController
@RequestMapping(value = "/areas") /* Mapeia o endpoint no navegador */
public class AreaResource {

	@Autowired /* instância objetos automaticamente */
	public AreaService service;

	/* Método Inserir */
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Area obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().
				path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	/* Método Atualizar */
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Area obj,@PathVariable Integer id) {
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	/* Método Deletar */
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		 service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	/* método GET para tratar as requisições  */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Area obj = service.buscar(id);
		return ResponseEntity.ok().body(obj);
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<AreaDTO>> buscarTudo() {
		List<AreaDTO> obj = service.converteDTO(service.buscarTudo());
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(value = "/page",method = RequestMethod.GET)
	public ResponseEntity<Page<AreaDTO>> buscarPage(
			@RequestParam(value = "page", defaultValue="0") Integer page, 
			@RequestParam(value = "linesPerPage", defaultValue="24")Integer linesPerPage, 
			@RequestParam(value = "orderBy", defaultValue="nmArea")String orderBy, 
			@RequestParam(value = "direction", defaultValue="ASC")String direction) {
		Page<Area> listPage = service.buscarPage(page,linesPerPage,orderBy,direction);
		Page<AreaDTO> listPageDto = listPage.map(obj -> new AreaDTO(obj));
		return ResponseEntity.ok().body(listPageDto);
	}
}
