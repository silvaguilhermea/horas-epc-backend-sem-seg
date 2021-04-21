package com.ibepc.sishorasepc.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
//import javax.validation.constraints.NotEmpty;

/* GUILHERME 20/04/21 */

@Entity
@Data
@NoArgsConstructor
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true)
    //@NotEmpty(message = "{campo.login.obrigatorio}")
    private String username;

    @Column
    //@NotEmpty(message = "{campo.senha.obrigatorio}")
    private String password;
}
