package br.com.empresa.app.controllers.compra;

import javax.inject.Inject;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import br.com.empresa.app.controllers.AbstractController;
import br.com.empresa.app.daos.compra.ComListaDao;
import br.com.empresa.app.models.compra.ComLista;

@Controller
@Path("/compra/lista")
public class ComListaController extends AbstractController<ComLista> {

    /**
     * @deprecated Construtor utilizado apenas pelo CDI
     */
    public ComListaController() {
        this(null, null);
    }

    @Inject
    public ComListaController(Result result, ComListaDao dao) {
        this.result = result;
        this.dao = dao;
    }

}
