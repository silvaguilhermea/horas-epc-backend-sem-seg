package com.ibepc.sishorasepc.service;

import com.ibepc.sishorasepc.exception.UsuarioCadastradoException;
import com.ibepc.sishorasepc.domain.Funcionario;
import com.ibepc.sishorasepc.repositories.UserRepository;
import com.ibepc.sishorasepc.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/* GUILHERME 20/04/2021 */

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository repository;

    public Funcionario salvar(Funcionario usuario){
        boolean exists = repository.existsByUsername(usuario.getUsername());
        if(exists){
            throw new UsuarioCadastradoException(usuario.getUsername());
        }
        return repository.save(usuario);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Funcionario usuario = repository
                                .findByUsername(username)
                                .orElseThrow(() -> new UsernameNotFoundException("Login não encontrado."));
        return User
                .builder()
                .username(usuario.getUsername())
                .password(usuario.getPassword())
                .roles("USER")
                .build();
    }
}
