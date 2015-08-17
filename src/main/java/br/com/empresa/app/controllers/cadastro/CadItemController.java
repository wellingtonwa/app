package br.com.empresa.app.controllers.cadastro;

import java.util.ResourceBundle;
import javax.inject.Inject;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.Validator;
import br.com.empresa.app.controllers.AbstractController;
import br.com.empresa.app.daos.cadastro.CadItemDao;
import br.com.empresa.app.models.cadastro.CadItem;

@Controller
@Path("/cadastro/item")
public class CadItemController extends AbstractController<CadItem> {

    /**
     * @deprecated Construtor utilizado apenas pelo CDI
     */
    public CadItemController() {
        this(null, null, null, null);
    }

    @Inject
    public CadItemController(Result result, Validator validator, ResourceBundle bundle, CadItemDao dao) {
        this.result = result;
        this.validator = validator;
        this.bundle = bundle;
        this.dao = dao;
    }

}
