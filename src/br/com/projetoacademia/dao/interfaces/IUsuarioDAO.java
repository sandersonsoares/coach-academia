package br.com.projetoacademia.dao.interfaces;

import br.com.projetoacademia.entidades.Usuario;
import br.com.projetoacademia.excecoes.DAOException;

public interface IUsuarioDAO extends IGenericDAO<Usuario> {

	public Usuario login(String username, String password) throws DAOException;
}