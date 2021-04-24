package com.ibepc.sishorasepc.domain;

import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ibepc.sishorasepc.enums.Perfil;

/*Implementação da classe Usuário*/

@Entity
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nmUsuario;
	private String senha; /* corrigir depois usando chave ssh token */
	private String nmCompleto;
	private String email;

	// EAGER serve para forçar a vinda da lista de perfil na busca do objeto
	@ElementCollection(fetch=FetchType.EAGER)
	@CollectionTable(name="PERFIS")
	private Set<Integer> perfis = new HashSet<>();
	
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date dtInclusao; /* data de inclusão do usuário */
	
	@JsonIgnore
	@OneToMany (mappedBy = "usuario")
	private List<AtividadeDocumento> atividadeDocumento = new ArrayList<>();
	
	
	public Usuario () {
		addPerfil(Perfil.USUARIO);
	}
		
	public Usuario(Integer id, String nmUsuario, String txSenha, String nmCompleto, String txEmail,
			Date dtInclusao) {
		super();
		this.id = id;
		this.nmUsuario = nmUsuario;
		this.senha = txSenha;
		this.nmCompleto = nmCompleto;
		this.email = txEmail;
		this.dtInclusao = dtInclusao;
		addPerfil(Perfil.USUARIO);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNmUsuario() {
		return nmUsuario;
	}

	public void setNmUsuario(String nmUsuario) {
		this.nmUsuario = nmUsuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNmCompleto() {
		return nmCompleto;
	}

	public void setNmCompleto(String nmCompleto) {
		this.nmCompleto = nmCompleto;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDtInclusao() {
		return dtInclusao;
	}

	public void setDtInclusao(Date dtInclusao) {
		this.dtInclusao = dtInclusao;
	}

	public List<AtividadeDocumento> getAtividadeDocumento() {
		return atividadeDocumento;
	}

	public void setAtividadeDocumento(List<AtividadeDocumento> atividadeDocumento) {
		this.atividadeDocumento = atividadeDocumento;
	}

	public Set<Perfil> getPerfis()
	{
		return perfis.stream().map(x -> Perfil.toEnum(x)).collect(Collectors.toSet());
	}

	public void addPerfil(Perfil perfil)
	{
		perfis.add(perfil.getCod());
	}

	public void alterarPerfil(Perfil perfil) {
		perfis.clear();
		perfis.add(perfil.getCod());
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
		Usuario other = (Usuario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Usuario{" +
				"id=" + id +
				", nmUsuario='" + nmUsuario + '\'' +
				", senha='" + senha + '\'' +
				", nmCompleto='" + nmCompleto + '\'' +
				", email='" + email + '\'' +
				", perfis=" + perfis +
				", dtInclusao=" + dtInclusao +
				", atividadeDocumento=" + atividadeDocumento +
				'}';
	}


}
