package com.ibepc.sishorasepc.services;

import java.util.Random;

import com.ibepc.sishorasepc.domain.Usuario;
import com.ibepc.sishorasepc.dto.CredenciaisDTO;
import com.ibepc.sishorasepc.enums.Perfil;
import com.ibepc.sishorasepc.repositories.UsuarioRepository;
import com.ibepc.sishorasepc.services.exceptions.AuthorizationException;
import com.ibepc.sishorasepc.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private BCryptPasswordEncoder pe;
	
	//@Autowired
	//private EmailService emailService;
	
	private Random rand = new Random();
	
	public void sendNewPassword(String email) {
		
		Usuario usuario = usuarioRepository.findByEmail(email);
		if (usuario == null) {
			throw new ObjectNotFoundException("Email não encontrado");
		}
		if (usuario.getPerfis().contains(Perfil.BLOQUEADO)) {
			throw new AuthorizationException("Usuário Bloqueado");
		}	
		
		String newPass = newPassword();
		usuario.setSenha(pe.encode(newPass));
		usuarioRepository.save(usuario);		
		//emailService.sendNewPasswordEmail(usuario, newPass);
	}
	
	
	public void changePassword(CredenciaisDTO dto) {
		Usuario usuario = usuarioService.findByEmail(dto.getEmail());
		usuario.setSenha(pe.encode(dto.getSenha()));
		usuarioRepository.save(usuario);
		//emailService.sendNewPasswordEmail(usuario, newPass);
	}	

	public String newPassword() {
		char[] vet = new char[10];
		for (int i=0; i<10; i++) {
			vet[i] = randomChar();
		}
		return new String(vet);
	}

	private char randomChar() {
		int opt = rand.nextInt(3);
		if (opt == 0) { // gera um digito
			return (char) (rand.nextInt(10) + 48);
		}
		else if (opt == 1) { // gera letra maiuscula
			return (char) (rand.nextInt(26) + 65);
		}
		else { // gera letra minuscula
			return (char) (rand.nextInt(26) + 97);
		}
	}
	

}
