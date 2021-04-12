package com.ibepc.sishorasepc.dto;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ibepc.sishorasepc.domain.Usuario;

/*Implementação da classe UsuárioDTO*/


public class UsuarioDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nm_usuario;
	private String tx_senha; /* corrigir depois usando chave ssh token */
	private String nm_completo;
	private String tx_email;
	
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date dt_inclusao; /* data de inclusão do usuário */
	
	public UsuarioDTO () {
		
	}
		
	public UsuarioDTO (Usuario usuario) {
		super();
		/* this.id = usuario.getId(); */
		this.nm_usuario = usuario.getNm_usuario();
		/* this.tx_senha = usuario.getTx_senha(); */
		this.nm_completo = usuario.getNm_completo();
		this.tx_email = usuario.getTx_email();
		this.dt_inclusao = usuario.getDt_inclusao();
	}

	/*
	 * public Integer getId() { return id; }
	 * 
	 * public void setId(Integer id) { this.id = id; }
	 */

	public String getNm_usuario() {
		return nm_usuario;
	}

	public void setNm_usuario(String nm_usuario) {
		this.nm_usuario = nm_usuario;
	}

	/*
	 * public String getTx_senha() { return tx_senha; }
	 * 
	 * public void setTx_senha(String tx_senha) { this.tx_senha = tx_senha; }
	 */

	public String getNm_completo() {
		return nm_completo;
	}

	public void setNm_completo(String nm_completo) {
		this.nm_completo = nm_completo;
	}

	public String getTx_email() {
		return tx_email;
	}

	public void setTx_email(String tx_email) {
		this.tx_email = tx_email;
	}

	public Date getDt_inclusao() {
		return dt_inclusao;
	}

	public void setDt_inclusao(Date dt_inclusao) {
		this.dt_inclusao = dt_inclusao;
	}

	/*
	 * public List<AtividadeDocumento> getAtividadeDocumento() { return
	 * atividadeDocumento; }
	 * 
	 * public void setAtividadeDocumento(List<AtividadeDocumento>
	 * atividadeDocumento) { this.atividadeDocumento = atividadeDocumento; }
	 */
}
