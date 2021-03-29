package com.ibepc.sishorasepc.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/*Implementação da classe Usuário*/

@Entity
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nm_usuario;
	private String tx_senha; /* corrigir depois usando chave ssh token */
	
	public Usuario () {
		
	}
	
	public Usuario(Integer id, String nm_usuario, String tx_senha) {
		super();
		this.id = id;
		this.nm_usuario = nm_usuario;
		this.tx_senha = tx_senha;
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
