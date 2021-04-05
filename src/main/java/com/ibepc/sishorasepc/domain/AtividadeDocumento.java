package com.ibepc.sishorasepc.domain;

import java.io.Serializable;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class AtividadeDocumento implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private Integer id;

	@JsonIgnore
	@Embedded
	private AtividadeDocumentoPK idt = new AtividadeDocumentoPK();
	
	private String nm_atividade_documento;
	 
	public AtividadeDocumento() {

	  }	

	public AtividadeDocumento(Integer id, Setor setor,Projeto projeto, String nm_atividade_documento) {
		super();
		this.id = id;
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
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
