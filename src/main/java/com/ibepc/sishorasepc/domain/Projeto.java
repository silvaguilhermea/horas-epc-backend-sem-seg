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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

/*Implementação da classe Projeto*/

@Entity
public class Projeto implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nmProjeto;
	
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date dtInicio; /* data de abertura do projeto */
	
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date dtFimPlanejado; /* data planejada de fim do projeto */
	
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date dtFimReal; /* data real de fim do projeto */
		
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "area_id") /*cria a chave estrangeira*/
	private Area area;
	
	@OneToMany (mappedBy = "projeto")
	private List<Setor> setores = new ArrayList<>();
	
	@OneToMany (mappedBy = "projeto")
	private List<AtividadeDocumento> atividadeDocumentos = new ArrayList<>();
	
	public Projeto() {
	}

	public Projeto(Integer id, String nmProjeto, Area area, Date dtInicio, Date dtFimPlanejado, Date dtFimReal) {
		super();
		this.id = id;
		this.nmProjeto = nmProjeto;
		this.dtInicio = dtInicio;
		this.dtFimPlanejado = dtFimPlanejado;
		this.dtFimReal = dtFimReal;
		this.area = area;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNmProjeto() {
		return nmProjeto;
	}

	public void setNm_projeto(String nmProjeto) {
		this.nmProjeto = nmProjeto;
	}
	
	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public Date getDtInicio() {
		return dtInicio;
	}

	public void setDtInicio(Date dtInicio) {
		this.dtInicio = dtInicio;
	}

	public Date getDtFimPlanejado() {
		return dtFimPlanejado;
	}

	public void setDtFimPlanejado(Date dtFimPlanejado) {
		this.dtFimPlanejado = dtFimPlanejado;
	}

	public Date getDtFimReal() {
		return dtFimReal;
	}

	public void setDtFimReal(Date dtFimReal) {
		this.dtFimReal = dtFimReal;
	}
	
	public List<Setor> getSetores() {
		return setores;
	}

	public void setSetores(List<Setor> setores) {
		this.setores = setores;
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
		Projeto other = (Projeto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
