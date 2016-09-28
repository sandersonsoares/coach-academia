package br.com.projetoacademia.business.interfaces;

import java.util.List;

import br.com.projetoacademia.entidades.Pagamento;
import br.com.projetoacademia.excecoes.BusinessException;

public interface IPagamentoBusiness {

	public void salvarOuAtualizar(Pagamento pagamento) throws BusinessException;
	
	public void remover(Pagamento pagamento) throws BusinessException;
	
	public List<Pagamento> listaTodos() throws BusinessException;
	
}
