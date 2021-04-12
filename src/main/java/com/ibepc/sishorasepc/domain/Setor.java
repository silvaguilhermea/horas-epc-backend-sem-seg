package com.ibepc.sishorasepc.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

/*Implementação da classe Área*/

@Entity
public class Setor implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nm_setor;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn (name= "projeto_id")
	private Projeto projeto;
	
	@OneToMany (mappedBy = "setor")
	private List<AtividadeDocumento> atividadeDocumentos = new ArrayList<>();
	
	public Setor() {
	}

	public Setor(Integer id, String nm_setor, Projeto projeto) {
		super();
		this.id = id;
		this.nm_setor = nm_setor;
		this.projeto = projeto;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNm_setor() {
		return nm_setor;
	}

	public void setNm_setor(String nm_setor) {
		this.nm_setor = nm_setor;
	}

	public Projeto getProjeto() {
		return projeto;
	}

	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}

	public List<AtividadeDocumento> getAtividadeDocumentos() {
		return atividadeDocumentos;
	}

	public void setAtividadeDocumentos(List<AtividadeDocumento> atividadeDocumentos) {
		this.atividadeDocumentos = atividadeDocumentos;
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
		Setor other = (Setor) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
