package com.ibepc.sishorasepc.service;

/* GUILHERME 20/04/2021 */
/*
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
}*/
