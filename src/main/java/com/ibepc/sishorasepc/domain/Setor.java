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

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

/*Implementação da classe Área*/

@Entity
public class Setor implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nm_setor;
	
	@JsonBackReference 
	@ManyToMany
	@JoinTable(name = "SETOR_PROJETO", /* nome da tabela extra do relacionamento muitos para muitos */
		joinColumns = @JoinColumn(name = "setor_id"), /* nome da primeira coluna da tabela */
		inverseJoinColumns = @JoinColumn (name = "projeto_id")/* nome da segunda coluna da tabela */
			) 
	private List<Projeto> projeto = new ArrayList<>();
	
	@JsonManagedReference
	@OneToMany(mappedBy = "setor")
	private List<AtividadeDocumento> atividadeDocumento = new ArrayList<>();
	
	public Setor() {
	}

	public Setor(Integer id, String nm_setor) {
		super();
		this.id = id;
		this.nm_setor = nm_setor;

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
	
	public List<Projeto> getProjeto() {
		return projeto;
	}

	public void setProjeto(List<Projeto> projeto) {
		this.projeto = projeto;
	}

	public List<AtividadeDocumento> getAtividadeDocumento() {
		return atividadeDocumento;
	}

	public void setAtividadeDocumento(List<AtividadeDocumento> atividadeDocumento) {
		atividadeDocumento = atividadeDocumento;
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
