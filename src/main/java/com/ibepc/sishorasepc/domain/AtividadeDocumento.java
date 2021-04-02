package com.ibepc.sishorasepc.domain;

import java.io.Serializable;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class AtividadeDocumento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nm_atividade_documento;

	  @JsonBackReference
	  @ManyToOne
	  @JoinColumn(name = "setor_id") /* cria a chave estrangeira */
	  private Setor setor;
	  
	  @JsonBackReference
	  @ManyToOne
	  @JoinColumn(name = "projeto_id") /* cria a chave estrangeira */
	  private Projeto projeto;
	 
	  public AtividadeDocumento() {

	  }	

	public AtividadeDocumento(Integer id, String nm_atividade_documento, Setor setor, Projeto projeto) {
		super();
		this.id = id;
		this.nm_atividade_documento = nm_atividade_documento;
		this.setor = setor;
		this.projeto = projeto;
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

	public Setor getSetor() {
		return setor;
	}

	public void setSetor(Setor setor) {
		this.setor = setor;
	}

	public Projeto getProjeto() {
		return projeto;
	}

	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
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
