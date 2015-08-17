package br.com.empresa.app.daos.cadastro;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import org.hibernate.Session;
import br.com.empresa.app.daos.AbstractDao;
import br.com.empresa.app.models.cadastro.CadUnidadeMedida;

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
