package br.com.empresa.app.daos.compra;

import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import org.hibernate.Query;
import org.hibernate.Session;
import br.com.empresa.app.daos.AbstractDao;
import br.com.empresa.app.exceptions.DataAccessObjectException;
import br.com.empresa.app.models.compra.ComListaItem;

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

    public List<ComListaItem> listarTodos(ComListaItem comListaItem) throws DataAccessObjectException {

        StringBuilder hql = new StringBuilder("from ComListaItem c where 1 = 1 ");
        hql.append("and c.comLista.id = :id ");

        Query query = session.createQuery(hql.toString());
        query.setParameter("id", comListaItem.getComLista().getId());

        return (List<ComListaItem>) query.list();

    }

}
