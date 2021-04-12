package com.ibepc.sishorasepc.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

/*Implementação da classe Usuário*/

@Entity
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nm_usuario;
	private String tx_senha; /* corrigir depois usando chave ssh token */
	private String nm_completo;
	private String tx_email;
	
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date dt_inclusao; /* data de inclusão do usuário */
	
	@JsonIgnore
	@OneToMany (mappedBy = "usuario")
	private List<AtividadeDocumento> atividadeDocumento = new ArrayList<>();
	
	
	public Usuario () {
		
	}
		
	public Usuario(Integer id, String nm_usuario, String tx_senha, String nm_completo, String tx_email,
			Date dt_inclusao) {
		super();
		this.id = id;
		this.nm_usuario = nm_usuario;
		this.tx_senha = tx_senha;
		this.nm_completo = nm_completo;
		this.tx_email = tx_email;
		this.dt_inclusao = dt_inclusao;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNm_usuario() {
		return nm_usuario;
	}

	public void setNm_usuario(String nm_usuario) {
		this.nm_usuario = nm_usuario;
	}

	public String getTx_senha() {
		return tx_senha;
	}

	public void setTx_senha(String tx_senha) {
		this.tx_senha = tx_senha;
	}

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

	public List<AtividadeDocumento> getAtividadeDocumento() {
		return atividadeDocumento;
	}

	public void setAtividadeDocumento(List<AtividadeDocumento> atividadeDocumento) {
		this.atividadeDocumento = atividadeDocumento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

}
