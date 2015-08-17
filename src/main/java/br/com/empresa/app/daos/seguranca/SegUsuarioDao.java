package br.com.empresa.app.daos.seguranca;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import org.hibernate.Query;
import org.hibernate.Session;
import br.com.empresa.app.daos.AbstractDao;
import br.com.empresa.app.models.seguranca.SegUsuario;

@RequestScoped
public class SegUsuarioDao extends AbstractDao<SegUsuario> {

    /**
     * @deprecated Construtor utilizado apenas pelo CDI
     */
    public SegUsuarioDao() {
        this(null);
    }

    @Inject
    public SegUsuarioDao(Session session) {
        this.session = session;
    }

    public Boolean isEmailEmUso(String email) {

        StringBuilder hql = new StringBuilder("from SegUsuario u where 1 = 1 ");
        hql.append("and upper(u.email) like :email ");

        Query query = session.createQuery(hql.toString());
        query.setParameter("email", email.toUpperCase());

        SegUsuario retorno = (SegUsuario) query.uniqueResult();

        return retorno != null && retorno.getEmail().toUpperCase().equals(email.toUpperCase());
    }

}
