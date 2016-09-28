package br.com.projetoacademia.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import br.com.projetoacademia.dao.interfaces.IGenericDAO;
import br.com.projetoacademia.excecoes.DAOException;

/***
 * @author Marcelo S. de Azevedo (marceloazvedo1@gmail.com)
 * */
public class GenericDAOImpl<T> implements IGenericDAO<T> {

	private Class<?> clazz;
	private EntityManagerFactory entityManagerFactory;
	private EntityManager manager;
	
	@SuppressWarnings("unchecked")
	public GenericDAOImpl() {
		this.entityManagerFactory = Persistence.createEntityManagerFactory("derby");
		this.clazz = (Class<T>) ((ParameterizedType) getClass().
                getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	@Override
	public void save(T entity) throws DAOException {
		manager = getEntityManager();
		try {
            manager.getTransaction().begin();
            manager.persist(entity);
            manager.getTransaction().commit();
        } catch (Exception e) {
            manager.getTransaction().rollback();
            e.printStackTrace();
            // Mudar para arquivos de Propriedades
            throw new DAOException("Erro ao salvar objeto no banco de dados.");
        } finally {
            manager.close();
        }
	}

	@Override
	public T update(T entity) throws DAOException {
		manager = getEntityManager();
        try {
            manager.getTransaction().begin();
            entity = manager.merge(entity);
            manager.getTransaction().commit();
        } catch (Exception e) {
            manager.getTransaction().rollback();
            e.printStackTrace();
            // Mudar para arquivos de Propriedades
            throw new DAOException("Erro ao atualizar objeto no banco de dados.");
        } finally {
            manager.close();
        }
        return entity;
	}

	@Override
	public void remove(T entity) throws DAOException {
		manager = getEntityManager();
        try {
            manager.getTransaction().begin();
            manager.remove(entity);
            manager.getTransaction().commit();
        } catch (Exception e) {
            manager.getTransaction().rollback();
            e.printStackTrace();
            // Mudar para arquivos de Propriedades
            throw new DAOException("Erro ao remover objeto no banco de dados.");
        } finally {
            manager.close();
        }
	}

	@Override
	public T getById(Long id) throws DAOException {
		T c = null;
        manager = getEntityManager();
        try {
        	CriteriaBuilder cb = getCriteriaBuilder();
            CriteriaQuery<T> cQuery = (CriteriaQuery<T>) cb.createQuery(clazz);
            Root<T> root = (Root<T>) cQuery.from(clazz);
            cQuery.select(root);
            cQuery.where(cb.equal(root.get("id"),id));
            TypedQuery<T> result = manager.createQuery(cQuery);
            c = result.getSingleResult();
        } catch (Exception e) {
            manager.getTransaction().rollback();
            e.printStackTrace();
            // Mudar para arquivos de Propriedades
            throw new DAOException("Erro ao buscar objeto no banco de dados.");
        }
        return c;
	}

	@Override
	public List<T> list() throws DAOException {
        manager = getEntityManager();
        try {
            CriteriaQuery<T> criteria = getCriteriaQuery();
            Root<T> root = (Root<T>) criteria.from(clazz);
            criteria.select(root);
            TypedQuery<T> query =  manager.createQuery(criteria);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            // Mudar para arquivos de Propriedades
            throw new DAOException("Erro ao listar objetos no banco de dados.");
        }
	}

	@Override
	public CriteriaQuery<T> getCriteriaQuery() throws DAOException {
        try{
        	CriteriaBuilder criteriaBuilder = manager.getCriteriaBuilder();
            return (CriteriaQuery<T>) criteriaBuilder.createQuery(clazz);
        } catch(Exception e){
            e.printStackTrace();
            throw new DAOException("Erro ao tentar criar CriteriaQuery");
        }
	}
	
	@Override
	public EntityManager getEntityManager() throws DAOException {
        try{
			if (manager == null || !manager.isOpen()) {
        		manager = entityManagerFactory.createEntityManager();
        	}
        } catch (Exception e){
            e.printStackTrace();
            throw new DAOException("Erro ao criar EntityManager");
        }
        return manager;
	}

	@Override
	public CriteriaBuilder getCriteriaBuilder() throws DAOException {
		try{
			return manager.getCriteriaBuilder();
		}catch(Exception e){
			e.printStackTrace();
            throw new DAOException("Erro ao tentar criar CriteriaBuilder");
		}
	}

}
