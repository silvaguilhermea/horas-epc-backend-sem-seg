package com.ibepc.sishorasepc.dto;

import com.ibepc.sishorasepc.domain.Setor;

import java.io.Serializable;

public class SetorDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String nmSetor;

    public SetorDTO(Setor obj) {
    }

    public SetorDTO(Integer id, String nmSetor) {
        this.id = id;
        this.nmSetor = nmSetor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNmSetor() {
        return nmSetor;
    }

    public void setNmSetor(String nmSetor) {
        this.nmSetor = nmSetor;
    }
}
