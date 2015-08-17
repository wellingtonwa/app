package br.com.empresa.app.interfaces;

import java.util.List;
import br.com.empresa.app.exceptions.DataAccessObjectException;
import br.com.empresa.app.models.Persistivel;

public interface IDataAccessObject<T extends Persistivel> extends ICrud<T, DataAccessObjectException> {

    public T listar(T objeto) throws DataAccessObjectException;

    public List<T> listarTodos() throws DataAccessObjectException;

    public List<T> listarTodosOrdenando(String columnName) throws DataAccessObjectException;

}
