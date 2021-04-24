package com.ibepc.sishorasepc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ibepc.sishorasepc.domain.Usuario;
import org.springframework.transaction.annotation.Transactional;


@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

    @Transactional(readOnly=true)
    Usuario findByEmail(String email);
}