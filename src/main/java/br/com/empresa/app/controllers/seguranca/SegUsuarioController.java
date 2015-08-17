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
import br.com.empresa.app.controllers.AbstractController;
import br.com.empresa.app.daos.seguranca.SegUsuarioDao;
import br.com.empresa.app.exceptions.ControllerException;
import br.com.empresa.app.interfaces.IKeys;
import br.com.empresa.app.models.seguranca.SegUsuario;
import com.auth0.jwt.internal.org.apache.commons.codec.digest.DigestUtils;

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
        objeto.setSenha(DigestUtils.md5(objeto.getSenha()).toString());

        super.salvar(objeto);
    }
}
