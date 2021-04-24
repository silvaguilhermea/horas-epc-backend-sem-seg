package com.ibepc.sishorasepc.resources;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import com.ibepc.sishorasepc.dto.CredenciaisDTO;
import com.ibepc.sishorasepc.dto.EmailDTO;
import com.ibepc.sishorasepc.security.JWTUtil;
import com.ibepc.sishorasepc.security.UsuarioSS;
import com.ibepc.sishorasepc.services.AuthService;
import com.ibepc.sishorasepc.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/auth")
public class AuthResource {
	
	@Autowired
	private JWTUtil jwtUtil;
	
	@Autowired
	private AuthService service;
	
	@RequestMapping(value = "/refresh_token", method = RequestMethod.POST)
	public ResponseEntity<String> refreshToken(HttpServletResponse response) {
		UsuarioSS user = UsuarioService.authenticated();
		String token = jwtUtil.generateToken(user.getUsername());
		response.addHeader("Authorization", "Bearer " + token);
		response.addHeader("access-control-expose-headers", "Authorization");
		return ResponseEntity.ok().body(user.toJson());
	}
	
	
	@RequestMapping(value = "/forgot", method = RequestMethod.POST)
	public ResponseEntity<Void> forgot(@Valid @RequestBody EmailDTO objDto) {
		service.sendNewPassword(objDto.getEmail());
		return ResponseEntity.noContent().build();
	}
	
	// ALTERAR SENHA
	@RequestMapping(value="/change_password", method=RequestMethod.PUT)
	public ResponseEntity<Void> change(@Valid @RequestBody CredenciaisDTO objDto)
	{		
		service.changePassword(objDto);
		return ResponseEntity.noContent().build();
	}
	
		

}
