package com.ibepc.sishorasepc.dto;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ibepc.sishorasepc.domain.AtividadeDocumento;
import com.ibepc.sishorasepc.domain.Projeto;
import com.ibepc.sishorasepc.domain.Setor;
import com.ibepc.sishorasepc.domain.Usuario;

public class AtividadeDocumentoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String nmAtividadeDocumento;
	
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date dtFimPlanejado; /* data de Fim planejado para o documento */
	
	private Projeto projeto;
	private Setor setor; 
	private Usuario usuario;

	public AtividadeDocumentoDTO() {

	}

	public AtividadeDocumentoDTO(AtividadeDocumento atividadeDocumento) {
		super();
		this.id = atividadeDocumento.getId();
		this.nmAtividadeDocumento = atividadeDocumento.getNmAtividadeDocumento();
		this.dtFimPlanejado = atividadeDocumento.getDtFimPlanejado();
		this.projeto = atividadeDocumento.getProjeto();
		this.setor = atividadeDocumento.getSetor(); 
		this.usuario = atividadeDocumento.getUsuario();

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNmAtividadeDocumento() {
		return nmAtividadeDocumento;
	}

	public void setNmAtividadeDocumento(String nmAtividadeDocumento) {
		this.nmAtividadeDocumento = nmAtividadeDocumento;
	}

	public Date getDtFimPlanejado() {
		return dtFimPlanejado;
	}

	public void setDtFimPlanejado(Date dtFimPlanejado) {
		this.dtFimPlanejado = dtFimPlanejado;
	}

	public String getProjeto() {
		return projeto.getNmProjeto();
	}

	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}

		 
	public String getSetor() {
		return setor.getNmSetor();
	}

	public void setSetor(Setor setor) {
		this.setor = setor;
	}

	public String getUsuario() {
		return usuario.getNmUsuario();
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
