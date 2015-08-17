package br.com.empresa.app.controllers;

import java.util.ResourceBundle;
import javax.inject.Inject;
import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;
import br.com.empresa.app.daos.AbstractDao;
import br.com.empresa.app.exceptions.ControllerException;
import br.com.empresa.app.interfaces.IController;
import br.com.empresa.app.interfaces.IKeys;
import br.com.empresa.app.models.Persistivel;

public abstract class AbstractController<T extends Persistivel> implements IController<T> {

	protected Result result;
	protected AbstractDao<T> dao;

	@Inject
	private ResourceBundle bundle;

	@Override
	@Post
	public void salvar(T objeto) throws ControllerException {
		throw new UnsupportedOperationException(bundle.getString(IKeys.APP_METODO_NAO_IMPLEMENTADO));
	}

	@Override
	@Put
	public void alterar(T objeto) throws ControllerException {
		throw new UnsupportedOperationException(bundle.getString(IKeys.APP_METODO_NAO_IMPLEMENTADO));
	}

	@Override
	@Delete
	public void excluir(T objeto) throws ControllerException {
		throw new UnsupportedOperationException(bundle.getString(IKeys.APP_METODO_NAO_IMPLEMENTADO));
	}

	@Override
	@Get("/{objeto.id}/listar")
	public void listar(T objeto) throws ControllerException {
		result.use(Results.json()).withoutRoot().from(dao.listar(objeto)).serialize();
	}

	@Override
	@Get("/listarTodos")
	public void listarTodos() throws ControllerException {
		result.use(Results.json()).withoutRoot().from(dao.listarTodos()).serialize();
	}

	@Override
	@Get("/listarTodosOrdenando/{columnName}")
	public void listarTodosOrdenando(String columnName) throws ControllerException {
		result.use(Results.json()).withoutRoot().from(dao.listarTodosOrdenando(columnName)).serialize();
	}

}
