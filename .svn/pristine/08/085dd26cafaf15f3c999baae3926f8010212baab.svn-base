package br.com.projetoacademia.business;

import java.util.List;

import br.com.projetoacademia.business.interfaces.IInstrutorBusiness;
import br.com.projetoacademia.dao.InstrutorDAOImpl;
import br.com.projetoacademia.dao.interfaces.IInstrutorDAO;
import br.com.projetoacademia.entidades.Instrutor;
import br.com.projetoacademia.excecoes.BusinessException;
import br.com.projetoacademia.excecoes.DAOException;

public class InstrutorBusinessImpl implements IInstrutorBusiness {

	private IInstrutorDAO instrutorDAO;
	
	public InstrutorBusinessImpl() {
		instrutorDAO = new InstrutorDAOImpl();
	}
	
	@Override
	public void salvarOuAtualizar(Instrutor instrutor) throws BusinessException {
		try {
			if (instrutor.getId() == null) {
				instrutorDAO.save(instrutor);
			} else {
				instrutorDAO.update(instrutor);
			}
		} catch (DAOException e) {
			e.printStackTrace();
			throw new BusinessException(e.getMessage());
		}
	}

	@Override
	public void remover(Instrutor instrutor) throws BusinessException {
		try {
			instrutorDAO.remove(instrutor);
		} catch (DAOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Instrutor> listarTodos() throws BusinessException {
		try {
			return instrutorDAO.list();
		} catch (DAOException e) {
			e.printStackTrace();
			throw new BusinessException(e.getMessage());
		}
	}

}
