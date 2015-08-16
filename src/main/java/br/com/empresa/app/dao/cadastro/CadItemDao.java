package br.com.empresa.app.dao.cadastro;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import org.hibernate.Session;
import br.com.empresa.app.dao.AbstractDao;
import br.com.empresa.app.model.cadastro.CadItem;

@RequestScoped
public class CadItemDao extends AbstractDao<CadItem> {

    /**
     * @deprecated Construtor utilizado apenas pelo CDI
     */
    public CadItemDao() {
        this(null);
    }

    @Inject
    public CadItemDao(Session session) {
        this.session = session;
    }

}
