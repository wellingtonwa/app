package br.com.empresa.app.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.ResourceBundle;
import javax.inject.Inject;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import br.com.empresa.app.exception.DataAccessObjectException;
import br.com.empresa.app.interfaces.IDataAccessObject;
import br.com.empresa.app.interfaces.IKeys;
import br.com.empresa.app.model.Persistivel;

@SuppressWarnings("unchecked")
public abstract class AbstractDao<T extends Persistivel> implements IDataAccessObject<T> {

    protected Session session;

    @Inject
    private ResourceBundle bundle;

    @Override
    public void salvar(T objeto) throws DataAccessObjectException {
        throw new UnsupportedOperationException(bundle.getString(IKeys.APP_METODO_NAO_IMPLEMENTADO));
    }

    @Override
    public void alterar(T objeto) throws DataAccessObjectException {
        throw new UnsupportedOperationException(bundle.getString(IKeys.APP_METODO_NAO_IMPLEMENTADO));
    }

    @Override
    public void excluir(T objeto) throws DataAccessObjectException {
        throw new UnsupportedOperationException(bundle.getString(IKeys.APP_METODO_NAO_IMPLEMENTADO));
    }

    @Override
    public T listar(T objeto) throws DataAccessObjectException {

        Class<T> entidade = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];

        StringBuilder hql = new StringBuilder("from " + entidade.getName() + " e where 1 = 1 ");
        hql.append("and e.id = :id ");

        Query query = session.createQuery(hql.toString());
        query.setParameter("id", objeto.getId());

        return (T) query.uniqueResult();

    }

    @Override
    public List<T> listarTodos() throws DataAccessObjectException {

        Class<T> entidade = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        return session.createQuery("from " + entidade.getName()).list();

    }

    @Override
    public List<T> listarTodosOrdenando(String columnName) throws DataAccessObjectException {

        Class<T> entidade = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];

        Criteria criteria = session.createCriteria(entidade);
        criteria.addOrder(Order.asc(columnName));

        return (List<T>) criteria.list();

    }

}
