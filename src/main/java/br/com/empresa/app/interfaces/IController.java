package br.com.empresa.app.interfaces;

import br.com.empresa.app.exception.ControllerException;
import br.com.empresa.app.model.Persistivel;

public interface IController<T extends Persistivel> extends ICrud<T, ControllerException> {

    public void listar(T objeto) throws ControllerException;

    public void listarTodos() throws ControllerException;

    public void listarTodosOrdenando(String columnName) throws ControllerException;

}
