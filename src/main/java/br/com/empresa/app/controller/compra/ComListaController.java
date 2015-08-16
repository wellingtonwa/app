package br.com.empresa.app.controller.compra;

import javax.inject.Inject;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import br.com.empresa.app.controller.AbstractController;
import br.com.empresa.app.dao.compra.ComListaDao;
import br.com.empresa.app.model.compra.ComLista;

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
