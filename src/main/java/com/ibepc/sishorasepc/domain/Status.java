package com.ibepc.sishorasepc.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Status implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nm_status;
	
	public Status() {
		
	}
	
	public Status(Integer id, String nm_status) {
		super();
		this.id = id;
		this.nm_status = nm_status;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNm_status() {
		return nm_status;
	}

	public void setNm_status(String nm_status) {
		this.nm_status = nm_status;
	}

	
}
