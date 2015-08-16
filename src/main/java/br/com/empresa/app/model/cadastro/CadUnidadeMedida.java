package br.com.empresa.app.model.cadastro;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import br.com.empresa.app.model.Persistivel;

@XmlRootElement
@Entity
@Table(name = "cad_unidade_medida")
public class CadUnidadeMedida extends Persistivel {

    private static final long serialVersionUID = 1L;

    @Column(name = "tx_descricao", length = 100)
    private String descricao;

    @Column(name = "tx_simbolo", length = 5)
    private String simbolo;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }

}
