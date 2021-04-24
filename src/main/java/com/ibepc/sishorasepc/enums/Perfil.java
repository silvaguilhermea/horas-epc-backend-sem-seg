package com.ibepc.sishorasepc.enums;

import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Set;
import java.util.stream.Collectors;

public enum Perfil {

    BLOQUEADO(0,"ROLE_BLOQUEADO"),
    ADMIN(1, "ROLE_ADMIN"),
    USUARIO(2, "ROLE_USUARIO");

    private int cod;
    private String descricao;

    private Perfil(int cod, String descricao) {
        this.cod = cod;
        this.descricao = descricao;
    }

    public int getCod() {
        return cod;
    }
    public void setCod(int cod) {
        this.cod = cod;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @JsonValue
    public static Perfil toEnum(Integer cod)
    {
        if(cod == null) {
            return null;
        }

        for (Perfil x : Perfil.values())
        {
            if(cod.equals(x.getCod()))
            {
                return x;
            }
        }

        throw new IllegalArgumentException("Id inválido:" + cod);
    }
}
