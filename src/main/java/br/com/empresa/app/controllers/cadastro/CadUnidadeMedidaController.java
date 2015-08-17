package br.com.empresa.app.controllers.cadastro;

import java.util.ResourceBundle;
import javax.inject.Inject;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.Validator;
import br.com.empresa.app.controllers.AbstractController;
import br.com.empresa.app.daos.cadastro.CadUnidadeMedidaDao;
import br.com.empresa.app.models.cadastro.CadUnidadeMedida;

@Controller
@Path("/cadastro/unidademedida")
public class CadUnidadeMedidaController extends AbstractController<CadUnidadeMedida> {

    /**
     * @deprecated Construtor utilizado apenas pelo CDI
     */
    public CadUnidadeMedidaController() {
        this(null, null, null, null);
    }

    @Inject
    public CadUnidadeMedidaController(Result result, Validator validator, ResourceBundle bundle, CadUnidadeMedidaDao dao) {
        this.result = result;
        this.validator = validator;
        this.bundle = bundle;
        this.dao = dao;
    }

}
