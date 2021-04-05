package com.ibepc.sishorasepc.domain;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class AtividadeDocumento implements Serializable {
	private static final long serialVersionUID = 1L;
	

	@JsonIgnore
	@EmbeddedId
	private AtividadeDocumentoPK idt = new AtividadeDocumentoPK();
	
	private String nm_atividade_documento;
	 
	public AtividadeDocumento() {

	  }	

	public AtividadeDocumento(Setor setor,Projeto projeto, String nm_atividade_documento) {
		super();
		idt.setSetor(setor);
		idt.setProjeto(projeto);
		this.nm_atividade_documento = nm_atividade_documento;
	
	}
	
	/*
	 * public Integer getId() { return id; }
	 * 
	 * public void setId(Integer id) { this.id = id; }
	 */

	@JsonManagedReference
	public Setor getSetor() {
		return idt.getSetor();
	}
	
	@JsonIgnore
	public Projeto getProjeto() {
		return idt.getProjeto();
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
		result = prime * result + ((idt == null) ? 0 : idt.hashCode());
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
		if (idt == null) {
			if (other.idt != null)
				return false;
		} else if (!idt.equals(other.idt))
			return false;
		return true;
	}
	
	

	

}
