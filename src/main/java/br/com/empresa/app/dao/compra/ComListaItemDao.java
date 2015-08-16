package br.com.empresa.app.dao.compra;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import org.hibernate.Session;
import br.com.empresa.app.dao.AbstractDao;
import br.com.empresa.app.model.compra.ComListaItem;

@RequestScoped
public class ComListaItemDao extends AbstractDao<ComListaItem> {

    /**
     * @deprecated Construtor utilizado apenas pelo CDI
     */
    public ComListaItemDao() {
        this(null);
    }

    @Inject
    public ComListaItemDao(Session session) {
        this.session = session;
    }

}
