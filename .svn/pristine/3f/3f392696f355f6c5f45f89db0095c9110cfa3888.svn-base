package br.com.projetoacademia.business;

import java.util.List;

import br.com.projetoacademia.business.interfaces.IEmpresaBusiness;
import br.com.projetoacademia.dao.EmpresaDAOImpl;
import br.com.projetoacademia.dao.interfaces.IEmpresaDAO;
import br.com.projetoacademia.entidades.Empresa;
import br.com.projetoacademia.excecoes.BusinessException;
import br.com.projetoacademia.excecoes.DAOException;

public class EmpresaBusinessImpl implements IEmpresaBusiness {

	private IEmpresaDAO empresaDAO;
		
	public EmpresaBusinessImpl() {
		empresaDAO = new EmpresaDAOImpl();
	}
	
	@Override
	public void salvarOuAtualizar(Empresa empresa) throws BusinessException {
		try{
		if(empresa == null){
			empresaDAO.save(empresa);
		} else {
			empresaDAO.update(empresa);
		}
		}catch(DAOException e){
			e.printStackTrace();
			throw new BusinessException(e.getMessage());
		}
	}

	@Override
	public void remover(Empresa empresa) throws BusinessException {
		try{
			empresaDAO.remove(empresa);
		}catch (DAOException e) {
			e.printStackTrace();
			throw new BusinessException(e.getMessage());
		}
	}

	@Override
	public List<Empresa> listarTodos() throws BusinessException {
		try{
			return empresaDAO.list();
		}catch (DAOException e) {
			e.printStackTrace();
			throw new BusinessException(e.getMessage());
		}
	}

}
