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

/*Implementação da classe Projeto*/

@Entity
public class Projeto implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nm_projeto;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "area_id") /*cria a chave estrangeira*/
	private Area area;
	
	@JsonManagedReference
	@ManyToMany (mappedBy = "projeto")
	private List<AtividadeDocumento> atividadeDocumento = new ArrayList<>();
	
	
	public Projeto() {
	}
	

	public Projeto(Integer id, String nm_projeto, Area area) {
		super();
		this.id = id;
		this.nm_projeto = nm_projeto;
		this.area = area;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNm_projeto() {
		return nm_projeto;
	}

	public void setNm_projeto(String nm_projeto) {
		this.nm_projeto = nm_projeto;
	}
	
	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
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
		Projeto other = (Projeto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
