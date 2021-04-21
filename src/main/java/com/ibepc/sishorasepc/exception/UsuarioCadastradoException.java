package com.ibepc.sishorasepc.exception;

public class UsuarioCadastradoException extends RuntimeException {

    /* GUILHERME 20/04/2021 */

    public UsuarioCadastradoException( String login ){
        super("Usuário já cadastrado para o login " + login);
    }
}
