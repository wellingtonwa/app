package br.com.empresa.app.dao.seguranca;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import org.hibernate.Session;
import br.com.empresa.app.dao.AbstractDao;
import br.com.empresa.app.model.seguranca.SegUsuario;

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
