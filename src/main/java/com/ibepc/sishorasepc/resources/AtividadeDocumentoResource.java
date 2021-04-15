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
import com.ibepc.sishorasepc.domain.AtividadeDocumento;
import com.ibepc.sishorasepc.dto.AreaDTO;
import com.ibepc.sishorasepc.dto.AtividadeDocumentoDTO;
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
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<AtividadeDocumentoDTO>> buscarTudo() {
		List<AtividadeDocumentoDTO> obj = service.converteDTO(service.buscarTudo());
		return ResponseEntity.ok().body(obj);

	}
	
	@RequestMapping(value = "/page",method = RequestMethod.GET)
	public ResponseEntity<Page<AtividadeDocumentoDTO>> buscarPage(
			@RequestParam(value = "page", defaultValue="0") Integer page, 
			@RequestParam(value = "linesPerPage", defaultValue="24")Integer linesPerPage, 
			@RequestParam(value = "orderBy", defaultValue="nmAtividadeDocumento")String orderBy, 
			@RequestParam(value = "direction", defaultValue="ASC")String direction) {
		Page<AtividadeDocumento> listPage = service.buscarPage(page,linesPerPage,orderBy,direction);
		Page<AtividadeDocumentoDTO> listPageDto = listPage.map(obj -> new AtividadeDocumentoDTO(obj));
		return ResponseEntity.ok().body(listPageDto);

	}
	
	
}