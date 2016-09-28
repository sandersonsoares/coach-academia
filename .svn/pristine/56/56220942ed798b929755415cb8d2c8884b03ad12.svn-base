package br.com.projetoacademia.dao.interfaces;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Criteria;

import br.com.projetoacademia.excecoes.DAOException;

public interface IGenericDAO<T> {

	public void save(T o) throws DAOException;
    public T update(T o) throws DAOException;
    public void remove(T o) throws DAOException;
    public T getById(Long id) throws DAOException;
    public List<T> list() throws DAOException;
    public CriteriaQuery getCriteriaQuery() throws DAOException;
    public CriteriaBuilder getCriteriaBuilder() throws DAOException;
    public EntityManager getEntityManager() throws DAOException;
}
