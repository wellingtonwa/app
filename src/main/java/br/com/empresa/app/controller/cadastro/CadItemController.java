package br.com.empresa.app.controller.cadastro;

import javax.inject.Inject;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import br.com.empresa.app.controller.AbstractController;
import br.com.empresa.app.dao.cadastro.CadItemDao;
import br.com.empresa.app.model.cadastro.CadItem;

@Controller
@Path("/cadastro/item")
public class CadItemController extends AbstractController<CadItem> {

    /**
     * @deprecated Construtor utilizado apenas pelo CDI
     */
    public CadItemController() {
        this(null, null);
    }

    @Inject
    public CadItemController(Result result, CadItemDao dao) {
        this.result = result;
        this.dao = dao;
    }

}
