package br.com.empresa.app.controller.compra;

import javax.inject.Inject;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import br.com.empresa.app.controller.AbstractController;
import br.com.empresa.app.dao.compra.ComListaItemDao;
import br.com.empresa.app.model.compra.ComListaItem;

@Controller
@Path("/compra/listaitem")
public class ComListaItemController extends AbstractController<ComListaItem> {

    /**
     * @deprecated Construtor utilizado apenas pelo CDI
     */
    public ComListaItemController() {
        this(null, null);
    }

    @Inject
    public ComListaItemController(Result result, ComListaItemDao dao) {
        this.result = result;
        this.dao = dao;
    }

}
