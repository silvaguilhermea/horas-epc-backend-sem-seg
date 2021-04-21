package com.ibepc.sishorasepc.repositories;

import com.ibepc.sishorasepc.domain.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/* GUILHERME 20/04/21 */

public interface UserRepository extends JpaRepository<Funcionario, Integer> {
    Optional<Funcionario> findByUsername(String username);

    // select count (*) > 0 from usuario where username = :login
    boolean existsByUsername(String username);
}
