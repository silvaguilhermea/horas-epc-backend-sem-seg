package com.ibepc.sishorasepc.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ibepc.sishorasepc.domain.AtividadeDocumento;
import com.ibepc.sishorasepc.domain.Projeto;
import com.ibepc.sishorasepc.domain.Setor;

@Repository
public interface AtividadeDocumentoRepository extends JpaRepository<AtividadeDocumento, Integer>{
	
	@Transactional (readOnly = true)
	List<AtividadeDocumento> findByProjeto(Projeto projeto);

	
	@Transactional (readOnly = true)
	List<AtividadeDocumento> findByUsuarioId(Integer usuario_id);
}