package com.ibepc.sishorasepc.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/* GUILHERME 20/04/21 */

@Entity
@Data
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true)
    private String username;

    @Column
    private String password;
}
