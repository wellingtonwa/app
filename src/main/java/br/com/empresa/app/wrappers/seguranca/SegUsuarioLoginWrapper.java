package br.com.empresa.app.wrappers.seguranca;

import br.com.empresa.app.models.seguranca.SegUsuario;

public class SegUsuarioLoginWrapper {

    private String token;
    private SegUsuario usuario;

    public SegUsuarioLoginWrapper(String token, SegUsuario segUsuario) {
        this.token = token;
        this.usuario = segUsuario;
    }

    public String getToken() {
        return token;
    }

    public SegUsuario getUsuario() {
        return usuario;
    }

}
