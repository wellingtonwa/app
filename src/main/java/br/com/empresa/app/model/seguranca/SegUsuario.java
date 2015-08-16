package br.com.empresa.app.model.seguranca;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import br.com.empresa.app.model.Persistivel;

@XmlRootElement
@Entity
@Table(name = "seg_usuario")
public class SegUsuario extends Persistivel {

    private static final long serialVersionUID = 1L;

    @Column(name = "tx_nome_completo", length = 100)
    private String nomeCompleto;

    @Column(name = "tx_email", length = 100)
    private String email;

    @Column(name = "tx_senha", length = 255)
    private String senha;

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}