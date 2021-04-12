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
	private String nm_projeto;	
	
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date dt_inicio; /* data de abertura do projeto */
	
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date dt_fim_planejado; /* data planejada de fim do projeto */	
	
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date dt_fim_real; /* data real de fim do projeto */		
	
	private String area;	
	private List<String> setor;
	
	/*
	 * private List<AtividadeDocumento> atividadeDocumento = new ArrayList<>();
	 * private List<Setor> setor = new ArrayList<>();
	 */
	
	public ProjetoDTO() {
		
	}
	
	public ProjetoDTO( Projeto projeto) {
		super();
		this.id = projeto.getId();
		this.nm_projeto = projeto.getNm_projeto();
		this.dt_inicio = projeto.getDt_inicio();
		this.dt_fim_planejado = projeto.getDt_fim_planejado();
		this.dt_fim_real = projeto.getDt_fim_real();
		this.area = projeto.getArea().getNm_area();
		
				
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

	public Date getDt_inicio() {
		return dt_inicio;
	}

	public void setDt_inicio(Date dt_inicio) {
		this.dt_inicio = dt_inicio;
	}

	public Date getDt_fim_planejado() {
		return dt_fim_planejado;
	}

	public void setDt_fim_planejado(Date dt_fim_planejado) {
		this.dt_fim_planejado = dt_fim_planejado;
	}

	public Date getDt_fim_real() {
		return dt_fim_real;
	}

	public void setDt_fim_real(Date dt_fim_real) {
		this.dt_fim_real = dt_fim_real;
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
