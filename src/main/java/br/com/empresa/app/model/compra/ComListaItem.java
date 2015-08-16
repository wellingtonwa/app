package br.com.empresa.app.model.compra;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import br.com.empresa.app.model.Auditavel;
import br.com.empresa.app.model.cadastro.CadItem;

@XmlRootElement
@Entity
@Table(name = "com_lista_item")
public class ComListaItem extends Auditavel {

    private static final long serialVersionUID = 1L;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_lista")
    private ComLista comLista;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_item")
    private CadItem cadItem;

    @Column(name = "dc_quantidade", precision = 15, scale = 4)
    private Double quantidade;

    @Column(name = "bo_comprado")
    private Boolean isComprado;

    public ComLista getComLista() {
        return comLista;
    }

    public void setComLista(ComLista comLista) {
        this.comLista = comLista;
    }

    public CadItem getCadItem() {
        return cadItem;
    }

    public void setCadItem(CadItem cadItem) {
        this.cadItem = cadItem;
    }

    public Double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }

    public Boolean getIsComprado() {
        return isComprado;
    }

    public void setIsComprado(Boolean isComprado) {
        this.isComprado = isComprado;
    }

}
