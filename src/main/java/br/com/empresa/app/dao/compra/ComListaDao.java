package br.com.empresa.app.dao.compra;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import org.hibernate.Session;
import br.com.empresa.app.dao.AbstractDao;
import br.com.empresa.app.model.compra.ComLista;

@RequestScoped
public class ComListaDao extends AbstractDao<ComLista> {

    /**
     * @deprecated Construtor utilizado apenas pelo CDI
     */
    public ComListaDao() {
        this(null);
    }

    @Inject
    public ComListaDao(Session session) {
        this.session = session;
    }

}