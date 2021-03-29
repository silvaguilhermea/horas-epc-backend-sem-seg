package com.ibepc.sishorasepc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ibepc.sishorasepc.domain.Projeto;

@Repository
public interface ProjetoRepository extends JpaRepository<Projeto, Integer>{

}