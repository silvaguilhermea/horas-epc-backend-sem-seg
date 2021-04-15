package com.ibepc.sishorasepc.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ibepc.sishorasepc.domain.Projeto;

public class ProjetoDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nmProjeto;	
	
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date dtInicio; /* data de abertura do projeto */
	
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date dtFimPlanejado; /* data planejada de fim do projeto */	
	
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date dtFimReal; /* data real de fim do projeto */		
	
	private String area;	
	private List<String> setor;
	

	public ProjetoDTO() {
		
	}
	
	public ProjetoDTO( Projeto projeto) {
		super();
		this.id = projeto.getId();
		this.nmProjeto = projeto.getNmProjeto();
		this.dtInicio = projeto.getDtInicio();
		this.dtFimPlanejado = projeto.getDtFimPlanejado();
		this.dtFimReal = projeto.getDtFimReal();
		this.area = projeto.getArea().getNmArea();
				
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNm_projeto() {
		return nmProjeto;
	}

	public void setNmprojeto(String nmProjeto) {
		this.nmProjeto = nmProjeto;
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

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public List<String> getSetor() {
		return setor;
	}

	public void setSetor(List<String> setor) {
		this.setor = setor;
	}

 
	

}
