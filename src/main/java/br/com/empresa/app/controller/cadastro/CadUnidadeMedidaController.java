package br.com.empresa.app.controller.cadastro;

import javax.inject.Inject;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import br.com.empresa.app.controller.AbstractController;
import br.com.empresa.app.dao.cadastro.CadUnidadeMedidaDao;
import br.com.empresa.app.model.cadastro.CadUnidadeMedida;

@Controller
@Path("/cadastro/unidademedida")
public class CadUnidadeMedidaController extends AbstractController<CadUnidadeMedida> {

    /**
     * @deprecated Construtor utilizado apenas pelo CDI
     */
    public CadUnidadeMedidaController() {
        this(null, null);
    }

    @Inject
    public CadUnidadeMedidaController(Result result, CadUnidadeMedidaDao dao) {
        this.result = result;
        this.dao = dao;
    }

}
