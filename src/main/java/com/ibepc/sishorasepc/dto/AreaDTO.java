package com.ibepc.sishorasepc.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.ibepc.sishorasepc.domain.Area;
import com.ibepc.sishorasepc.domain.Projeto;

/*Implementação da classe ÁreaDTO*/

public class AreaDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nm_area;
	private List<Projeto> projeto = new ArrayList<>();
	

	public AreaDTO() {
	}
	
	public AreaDTO(Area area) {
		super();
		/* this.id = area.getId(); */
		this.nm_area = area.getNm_area();
	}

	/*
	 * public Integer getId() { return id; }
	 * 
	 * public void setId(Integer id) { this.id = id; }
	 */

	public String getNm_area() {
		return nm_area;
	}

	public void setNm_area(String nm_area) {
		this.nm_area = nm_area;
	}

	/*
	 * public List<Projeto> getProjeto() { return projeto; }
	 * 
	 * public void setProjeto(List<Projeto> projeto) { this.projeto = projeto; }
	 */
	
}
