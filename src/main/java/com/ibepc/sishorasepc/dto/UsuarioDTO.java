package com.ibepc.sishorasepc.dto;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ibepc.sishorasepc.domain.Usuario;

/*Implementação da classe UsuárioDTO*/


public class UsuarioDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String nmUsuario;
	private String txSenha; /* corrigir depois usando chave ssh token */
	private String nmCompleto;
	private String txEmail;
	
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date dtInclusao; /* data de inclusão do usuário */
	
	public UsuarioDTO () {
		
	}
		
	public UsuarioDTO (Usuario usuario) {
		super();
		this.id = usuario.getId(); 
		this.nmUsuario = usuario.getNmUsuario();
		this.txSenha = usuario.getTxSenha();
		this.nmCompleto = usuario.getNmCompleto();
		this.txEmail = usuario.getTxEmail();
		this.dtInclusao = usuario.getDtInclusao();
	}

	
	public Integer getId() { return id; }
	  
	public void setId(Integer id) { this.id = id; }
	 

	public String getNmUsuario() {
		return nmUsuario;
	}

	public void setNmUsuario(String nmUsuario) {
		this.nmUsuario = nmUsuario;
	}


	 public String getTxSenha() { return txSenha; }

	public String getNmCompleto() {
		return nmCompleto;
	}

	public void setNmCompleto(String nmCompleto) {
		this.nmCompleto = nmCompleto;
	}

	public String getTxEmail() {
		return txEmail;
	}

	public void setTxEmail(String txEmail) {
		this.txEmail = txEmail;
	}

	public Date getDtInclusao() {
		return dtInclusao;
	}

	public void setDtInclusao(Date dtInclusao) {
		this.dtInclusao = dtInclusao;
	}



	/*
	 * public List<AtividadeDocumento> getAtividadeDocumento() { return
	 * atividadeDocumento; }
	 * 
	 * public void setAtividadeDocumento(List<AtividadeDocumento>
	 * atividadeDocumento) { this.atividadeDocumento = atividadeDocumento; }
	 */
}
