package com.ibepc.sishorasepc.repositories;

import com.ibepc.sishorasepc.domain.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ibepc.sishorasepc.domain.Usuario;

import java.util.Optional;


@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

}