package br.com.empresa.app.model;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import br.com.empresa.app.model.seguranca.SegUsuario;

@MappedSuperclass
public class Auditavel extends Persistivel {

    private static final long serialVersionUID = 1L;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ultimo_usuario")
    private SegUsuario ultimoUsuario;

    public SegUsuario getUltimoUsuario() {
        return ultimoUsuario;
    }

    public void setUltimoUsuario(SegUsuario ultimoUsuario) {
        this.ultimoUsuario = ultimoUsuario;
    }

}
