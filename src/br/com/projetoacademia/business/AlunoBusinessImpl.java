package br.com.projetoacademia.business;

import java.util.List;

import br.com.projetoacademia.business.interfaces.IAlunoBusiness;
import br.com.projetoacademia.dao.AlunoDAOImpl;
import br.com.projetoacademia.dao.interfaces.IAlunoDAO;
import br.com.projetoacademia.entidades.Aluno;
import br.com.projetoacademia.excecoes.BusinessException;
import br.com.projetoacademia.excecoes.DAOException;


public class AlunoBusinessImpl implements IAlunoBusiness {

	private IAlunoDAO alunoDAO;
	
	public AlunoBusinessImpl() {
		this.alunoDAO = new AlunoDAOImpl();
	}
	
	@Override
	public void salvarOuAtualizar(Aluno aluno) throws BusinessException {
		try{
			if (aluno.getId() == null) {
				alunoDAO.save(aluno);
			} else {
				alunoDAO.update(aluno);
			}
		}catch(Exception e){
			e.printStackTrace();
			throw new BusinessException(e.getMessage());
		}
	}

	@Override
	public void remover(Aluno aluno) throws BusinessException {
		try {
			alunoDAO.remove(aluno);
		} catch (DAOException e) {
			e.printStackTrace();
			throw new BusinessException(e.getMessage());
		}
	}

	@Override
	public List<Aluno> listarTodos() throws BusinessException {
		try {
			return alunoDAO.list();
		} catch (DAOException e) {
			e.printStackTrace();
			throw new BusinessException(e.getMessage());
		}
	}

}
