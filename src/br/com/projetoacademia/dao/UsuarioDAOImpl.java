package br.com.projetoacademia.dao;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.criterion.Restrictions;

import br.com.projetoacademia.dao.interfaces.IUsuarioDAO;
import br.com.projetoacademia.entidades.Usuario;
import br.com.projetoacademia.excecoes.DAOException;

public class UsuarioDAOImpl extends GenericDAOImpl<Usuario> implements IUsuarioDAO {

	@Override
	public Usuario login(String username, String password) throws DAOException {
		try{
			CriteriaBuilder criteriaBuilder = getCriteriaBuilder();
			CriteriaQuery<Usuario> criteriaQuery = criteriaBuilder.createQuery(Usuario.class);
			Root<Usuario> root = criteriaQuery.from(Usuario.class);
			criteriaQuery.select(root);
			criteriaQuery.where(criteriaBuilder.and(criteriaBuilder.equal(root.get("login"), username)), criteriaBuilder.and(criteriaBuilder.equal(root.get("senha"), password)));
			TypedQuery<Usuario> query = getEntityManager().createQuery(criteriaQuery);
			try{
				return query.getSingleResult();
			}catch(NoResultException nre){
				// Nesse caso, a query não retornou nenhum resultado.
				return null;
			} catch (Exception e) {
				e.printStackTrace();
				throw new DAOException(e.getMessage());
			}
		}catch(Exception e){
			e.printStackTrace();
			throw new DAOException(e.getMessage()); 
		}
	}

}
