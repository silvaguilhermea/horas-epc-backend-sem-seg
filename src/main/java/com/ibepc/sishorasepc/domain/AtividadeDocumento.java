package com.ibepc.sishorasepc.domain;

import java.io.Serializable;

public class AtividadeDocumento implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nm_atividade_documento;
	
	public AtividadeDocumento() {
		
	}
	
	public AtividadeDocumento(Integer id, String nm_atividade_documento) {
		super();
		this.id = id;
		this.nm_atividade_documento = nm_atividade_documento;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNm_atividade_documento() {
		return nm_atividade_documento;
	}

	public void setNm_atividade_documento(String nm_atividade_documento) {
		this.nm_atividade_documento = nm_atividade_documento;
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
		AtividadeDocumento other = (AtividadeDocumento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}