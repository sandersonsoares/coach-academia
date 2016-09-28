package br.com.projetoacademia.business;

import java.util.List;

import br.com.projetoacademia.business.interfaces.IUsuarioBusiness;
import br.com.projetoacademia.dao.UsuarioDAOImpl;
import br.com.projetoacademia.dao.interfaces.IUsuarioDAO;
import br.com.projetoacademia.entidades.Usuario;
import br.com.projetoacademia.excecoes.BusinessException;
import br.com.projetoacademia.excecoes.DAOException;

public class UsuarioBusinessImpl implements IUsuarioBusiness {

	private IUsuarioDAO usuarioDAO;
	
	public UsuarioBusinessImpl() {
		this.usuarioDAO = new UsuarioDAOImpl();
	}
	
	@Override
	public void salvarOuAtualizar(Usuario usuario) throws BusinessException {
		try{
			if(usuario.getId()==null){
				usuarioDAO.save(usuario);
			} else {
				usuarioDAO.update(usuario);
			}
		} catch (DAOException e) {
			e.printStackTrace();
			throw new BusinessException(e.getMessage());
		}
	}
	
	@Override
	public Usuario login(String username, String password) throws BusinessException{
		try{
			return usuarioDAO.login(username, password);
		}catch(DAOException e){
			e.printStackTrace();
			throw new BusinessException(e.getMessage());
		}
	}

	@Override
	public List<Usuario> listarTodos() throws BusinessException {
		try{
			return usuarioDAO.list();
		}catch(DAOException e){
			e.printStackTrace();
			throw new BusinessException(e.getMessage());
		}
	}

	@Override
	public void remover(Usuario usuario) throws BusinessException {
		try{
			usuarioDAO.remove(usuario);
		}catch(DAOException e){
			e.printStackTrace();
			throw new BusinessException(e.getMessage());
		}
	}

}
