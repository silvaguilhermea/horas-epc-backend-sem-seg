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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class AtividadeDocumento implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nmAtividadeDocumento;
	
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date dtFimPlanejado; /* data de Fim planejado para o documento */
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "projeto_id")
	private Projeto projeto;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "setor_id")
	private Setor setor;
	
	
	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;
		 
	public AtividadeDocumento() {

	  }	
	

	public AtividadeDocumento(Integer id, String nmAtividadeDocumento, Date dtFimPlanejado, Projeto projeto,
			Setor setor, Usuario usuario) {
		super();
		this.id = id;
		this.nmAtividadeDocumento = nmAtividadeDocumento;
		this.dtFimPlanejado = dtFimPlanejado;
		this.projeto = projeto;
		this.setor = setor;
		this.usuario = usuario;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getNmAtividadeDocumento() {
		return nmAtividadeDocumento;
	}

	public void setNmAtividadeDocumento(String nmAtividadeDocumento) {
		this.nmAtividadeDocumento = nmAtividadeDocumento;
	}
	
	public Date getDtFimPlanejado() {
		return dtFimPlanejado;
	}

	public void setDtFimPlanejado(Date dtFimPlanejado) {
		this.dtFimPlanejado = dtFimPlanejado;
	}


	public Projeto getProjeto() {
		return projeto;
	}

	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}
	
	
	public Setor getSetor() {
		return setor;
	}

	public void setSetor(Setor setor) {
		this.setor = setor;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
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
