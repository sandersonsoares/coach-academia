package br.com.projetoacademia.business;

import java.util.List;

import br.com.projetoacademia.business.interfaces.IFuncionarioBusiness;
import br.com.projetoacademia.dao.FuncionarioDAOImpl;
import br.com.projetoacademia.dao.interfaces.IFuncionarioDAO;
import br.com.projetoacademia.entidades.Funcionario;
import br.com.projetoacademia.excecoes.BusinessException;
import br.com.projetoacademia.excecoes.DAOException;

public class FuncionarioBusinessImpl implements IFuncionarioBusiness {

	private IFuncionarioDAO funcionarioDAO;
	
	public FuncionarioBusinessImpl() {
		funcionarioDAO = new FuncionarioDAOImpl();
	}
	
	@Override
	public void salvarOuAtualizar(Funcionario funcionario) throws BusinessException {
		try{
		if(funcionario.getId() == null){
			funcionarioDAO.save(funcionario);
		} else {
			funcionarioDAO.update(funcionario);
		}
		}catch (DAOException e) {
			e.printStackTrace();
			throw new BusinessException(e.getMessage());
		}
	}

	@Override
	public void remover(Funcionario funcionario) throws BusinessException {
		try {
			funcionarioDAO.remove(funcionario);
		} catch (DAOException e) {
			e.printStackTrace();
			throw new BusinessException(e.getMessage());
		}
	}

	@Override
	public List<Funcionario> listarTodos() throws BusinessException {
		try {
			return funcionarioDAO.list();
		} catch (DAOException e) {
			e.printStackTrace();
			throw new BusinessException(e.getMessage());
		}
	}

}
