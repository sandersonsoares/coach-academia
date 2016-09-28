package br.com.projetoacademia.business;

import java.util.List;

import br.com.projetoacademia.business.interfaces.IPagamentoBusiness;
import br.com.projetoacademia.dao.PagamentoDAOImpl;
import br.com.projetoacademia.dao.interfaces.IPagamentoDAO;
import br.com.projetoacademia.entidades.Pagamento;
import br.com.projetoacademia.excecoes.BusinessException;
import br.com.projetoacademia.excecoes.DAOException;

public class PagamentoBusinessImpl implements IPagamentoBusiness {

	private IPagamentoDAO pagamentoDAO;
	
	public PagamentoBusinessImpl() {
		pagamentoDAO = new PagamentoDAOImpl();
	}
	
	@Override
	public void salvarOuAtualizar(Pagamento pagamento) throws BusinessException {
		try {
			if (pagamento == null) {
				pagamentoDAO.save(pagamento);
			} else {
				pagamentoDAO.update(pagamento);
			}
		} catch (DAOException e) {
			e.getMessage();
			throw new BusinessException(e.getMessage());
		}
	}

	@Override
	public void remover(Pagamento pagamento) throws BusinessException {
		try{
			pagamentoDAO.remove(pagamento);
		}catch (DAOException e) {
			e.getMessage();
			throw new BusinessException(e.getMessage());
		}
	}

	@Override
	public List<Pagamento> listaTodos() throws BusinessException {
		try{
			return pagamentoDAO.list();
		}catch (DAOException e) {
			e.printStackTrace();
			throw new BusinessException(e.getMessage());
		}
	}

}
