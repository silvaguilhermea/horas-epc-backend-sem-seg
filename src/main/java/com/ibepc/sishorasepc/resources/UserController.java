package com.ibepc.sishorasepc.resources;

import com.ibepc.sishorasepc.domain.Funcionario;
import com.ibepc.sishorasepc.exception.UsuarioCadastradoException;
import com.ibepc.sishorasepc.repositories.UserRepository;
import com.ibepc.sishorasepc.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

/* GUILHERME 20/04/21 */
@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/usuarios")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void salvar( @RequestBody Funcionario usuario ){
        try{
            service.salvar(usuario);
        }catch (UsuarioCadastradoException e) {
            throw new ResponseStatusException( HttpStatus.BAD_REQUEST, e.getMessage() );
        }

    }
}
