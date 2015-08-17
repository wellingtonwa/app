package br.com.empresa.app.daos.seguranca;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
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

}
