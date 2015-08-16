package br.com.empresa.app.model.cadastro;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import br.com.empresa.app.model.Auditavel;

@XmlRootElement
@Entity
@Table(name = "cad_item")
public class CadItem extends Auditavel {

    private static final long serialVersionUID = 1L;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_unidade_medida")
    private CadUnidadeMedida cadUnidadeMedida;

    @Column(name = "tx_descricao", length = 100)
    private String descricao;

    @Column(name = "dc_valor", precision = 15, scale = 2)
    private Double valor;

    @Lob
    @Column(name = "bl_imagem")
    private Byte[] imagem;

    public CadUnidadeMedida getCadUnidadeMedida() {
        return cadUnidadeMedida;
    }

    public void setCadUnidadeMedida(CadUnidadeMedida cadUnidadeMedida) {
        this.cadUnidadeMedida = cadUnidadeMedida;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Byte[] getImagem() {
        return imagem;
    }

    public void setImagem(Byte[] imagem) {
        this.imagem = imagem;
    }

}
