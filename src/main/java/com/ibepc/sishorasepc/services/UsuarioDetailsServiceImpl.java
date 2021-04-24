package com.ibepc.sishorasepc.services;

import com.ibepc.sishorasepc.domain.Usuario;
import com.ibepc.sishorasepc.repositories.UsuarioRepository;
import com.ibepc.sishorasepc.security.UsuarioSS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class UsuarioDetailsServiceImpl implements UserDetailsService{
	
	@Autowired
	UsuarioRepository repo;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {		
		Usuario user = repo.findByEmail(email);
		if(user == null) {
			throw new UsernameNotFoundException(email);
		}		
		return new UsuarioSS(user.getId(), user.getEmail(), user.getSenha(), user.getPerfis());
	}

}
