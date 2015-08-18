package br.com.empresa.app.controllers.compra;

import java.util.ResourceBundle;
import javax.inject.Inject;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.Validator;
import br.com.caelum.vraptor.view.Results;
import br.com.empresa.app.annotations.PrecisaEstarLogado;
import br.com.empresa.app.controllers.AbstractController;
import br.com.empresa.app.daos.compra.ComListaDao;
import br.com.empresa.app.exceptions.ControllerException;
import br.com.empresa.app.models.compra.ComLista;

@Controller
@Path("/compra/lista")
public class ComListaController extends AbstractController<ComLista> {

    /**
     * @deprecated Construtor utilizado apenas pelo CDI 
     */
    public ComListaController() {
        this(null, null, null, null);
    }

    @Inject
    public ComListaController(Result result, Validator validator, ResourceBundle bundle, ComListaDao dao) {
        this.result = result;
        this.validator = validator;
        this.bundle = bundle;
        this.dao = dao;
    }

    @Get("/listarTodos/{lista.segUsuarioProprietario.id}")
    @PrecisaEstarLogado
    public void listarTodos(ComLista lista) throws ControllerException {
        this.result.use(Results.json()).withoutRoot().from(((ComListaDao) this.dao).listarTodos(lista)).serialize();
    }
}
