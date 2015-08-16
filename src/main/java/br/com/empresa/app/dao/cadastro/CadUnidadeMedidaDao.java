package br.com.empresa.app.dao.cadastro;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import org.hibernate.Session;
import br.com.empresa.app.dao.AbstractDao;
import br.com.empresa.app.model.cadastro.CadUnidadeMedida;

@RequestScoped
public class CadUnidadeMedidaDao extends AbstractDao<CadUnidadeMedida> {

    /**
     * @deprecated Construtor utilizado apenas pelo CDI
     */
    public CadUnidadeMedidaDao() {
        this(null);
    }

    @Inject
    public CadUnidadeMedidaDao(Session session) {
        this.session = session;
    }

}
