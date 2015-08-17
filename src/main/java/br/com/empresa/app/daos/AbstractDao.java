package br.com.empresa.app.daos;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import br.com.empresa.app.exceptions.DataAccessObjectException;
import br.com.empresa.app.interfaces.IDataAccessObject;
import br.com.empresa.app.models.Persistivel;

@SuppressWarnings("unchecked")
public abstract class AbstractDao<T extends Persistivel> implements IDataAccessObject<T> {

    protected Session session;

    @Transactional
    @Override
    public void salvar(T objeto) throws DataAccessObjectException {
        this.session.save(objeto);
    }

    @Transactional
    @Override
    public void alterar(T objeto) throws DataAccessObjectException {
        this.session.update(objeto);
    }

    @Transactional
    @Override
    public void excluir(T objeto) throws DataAccessObjectException {
        this.session.delete(objeto);
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
