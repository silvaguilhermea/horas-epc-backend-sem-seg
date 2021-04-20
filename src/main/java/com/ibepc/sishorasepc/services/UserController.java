package com.ibepc.sishorasepc.services;

import com.ibepc.sishorasepc.domain.User;
import com.ibepc.sishorasepc.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/* GUILHERME 20/04/21 */

@RestController
@RequestMapping("/api/usuarios")
@RequiredArgsConstructor
public class UserController {

    private final UserRepository repository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void salvar( @RequestBody User usuario ){
        repository.save(usuario);
    }
}
