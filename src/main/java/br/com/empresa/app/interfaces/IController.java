package br.com.empresa.app.interfaces;

import br.com.empresa.app.exceptions.ControllerException;
import br.com.empresa.app.models.Persistivel;

public interface IController<T extends Persistivel> extends ICrud<T, ControllerException> {

    public void listar(T objeto) throws ControllerException;

    public void listarTodos() throws ControllerException;

    public void listarTodosOrdenando(String columnName) throws ControllerException;

}
