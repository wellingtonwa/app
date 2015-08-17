package br.com.empresa.app.controllers.seguranca;

import java.util.ResourceBundle;
import javax.inject.Inject;
import br.com.caelum.vraptor.Consumes;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.SimpleMessage;
import br.com.caelum.vraptor.validator.Validator;
import br.com.caelum.vraptor.view.Results;
import br.com.empresa.app.controllers.AbstractController;
import br.com.empresa.app.daos.seguranca.SegUsuarioDao;
import br.com.empresa.app.exceptions.ControllerException;
import br.com.empresa.app.interfaces.IKeys;
import br.com.empresa.app.models.seguranca.SegUsuario;
import br.com.empresa.app.utils.Crypto;

@Controller
@Path("/seguranca/usuario")
public class SegUsuarioController extends AbstractController<SegUsuario> {

    /**
     * @deprecated Construtor utilizado apenas pelo CDI
     */
    public SegUsuarioController() {
        this(null, null, null, null);
    }

    @Inject
    public SegUsuarioController(Result result, Validator validator, ResourceBundle bundle, SegUsuarioDao dao) {
        this.result = result;
        this.validator = validator;
        this.bundle = bundle;
        this.dao = dao;
    }

    @Override
    @Post
    @Consumes(value = "application/json")
    public void salvar(SegUsuario objeto) throws ControllerException {

        boolean isEmailEmUso = ((SegUsuarioDao) this.dao).isEmailEmUso(objeto.getEmail());
        String msgValidacao = bundle.getString(IKeys.APP_SEGURANCA_USUARIO_SALVAR_EMAIL_JA_EM_USO);

        validator.addIf(isEmailEmUso, new SimpleMessage("email", msgValidacao));
        validator.onErrorSendBadRequest();

        // Criptografando a senha para MD5
        objeto.setSenha(Crypto.md5(objeto.getSenha()));

        super.salvar(objeto);
    }

    @Post
    @Consumes(value = "application/json")
    public void login(SegUsuario objeto) throws ControllerException {

        // Criptografando a senha para MD5
        objeto.setSenha(Crypto.md5(objeto.getSenha()));

        SegUsuario usuario = ((SegUsuarioDao) this.dao).doLogin(objeto);

        boolean isLoginValido = usuario != null;
        String msgLoginSenhaNaoConferem = bundle.getString(IKeys.APP_SEGURANCA_USUARIO_LOGIN_EMAIL_SENHA_NAO_CONFEREM);

        validator.addIf(!isLoginValido, new SimpleMessage("login", msgLoginSenhaNaoConferem));
        validator.onErrorSendBadRequest();

        this.result.use(Results.json()).withoutRoot().from(usuario).serialize();

    }

}
