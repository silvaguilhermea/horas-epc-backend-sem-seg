package com.ibepc.sishorasepc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ibepc.sishorasepc.domain.Setor;


@Repository
public interface SetorRepository extends JpaRepository<Setor, Integer>{

}