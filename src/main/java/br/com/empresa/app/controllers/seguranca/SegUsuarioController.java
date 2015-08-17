package br.com.empresa.app.controllers.seguranca;

import javax.inject.Inject;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import br.com.empresa.app.controllers.AbstractController;
import br.com.empresa.app.daos.seguranca.SegUsuarioDao;
import br.com.empresa.app.models.seguranca.SegUsuario;

@Controller
@Path("/seguranca/usuario")
public class SegUsuarioController extends AbstractController<SegUsuario> {

    /**
     * @deprecated Construtor utilizado apenas pelo CDI
     */
    public SegUsuarioController() {
        this(null, null);
    }

    @Inject
    public SegUsuarioController(Result result, SegUsuarioDao dao) {
        this.result = result;
        this.dao = dao;
    }

}
