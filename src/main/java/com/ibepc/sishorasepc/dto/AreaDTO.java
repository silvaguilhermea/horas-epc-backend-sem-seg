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
	private String nmArea;
	private List<Projeto> projeto = new ArrayList<>();


	public AreaDTO() {
	}

	public AreaDTO(Area area) {
		super();
		this.id = area.getId();
		this.nmArea = area.getNmArea();
	}


	public Integer getId() { return id; }

	public void setId(Integer id) { this.id = id; }


	public String getNmArea() {
		return nmArea;
	}

	public void setNmArea(String nmArea) {
		this.nmArea = nmArea;
	}

	/*
	 * public List<Projeto> getProjeto() { return projeto; }
	 *
	 * public void setProjeto(List<Projeto> projeto) { this.projeto = projeto; }
	 */

}
