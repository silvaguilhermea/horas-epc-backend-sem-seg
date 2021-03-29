package com.ibepc.sishorasepc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ibepc.sishorasepc.domain.AtividadeDocumento;

@Repository
public interface AtividadeDocumentoRepository extends JpaRepository<AtividadeDocumento, Integer>{

}