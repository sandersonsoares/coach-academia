package br.com.projetoacademia.business.interfaces;

import java.util.List;

import br.com.projetoacademia.entidades.Usuario;
import br.com.projetoacademia.excecoes.BusinessException;

public interface IUsuarioBusiness {

	public void salvarOuAtualizar(Usuario usuario) throws BusinessException;
	
	public void remover(Usuario usuario) throws BusinessException;
	
	public List<Usuario> listarTodos() throws BusinessException;
	
	public Usuario login(String username, String password) throws BusinessException;
}
