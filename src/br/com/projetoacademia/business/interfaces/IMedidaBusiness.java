package br.com.projetoacademia.business.interfaces;

import java.util.List;

import br.com.projetoacademia.entidades.Medida;
import br.com.projetoacademia.excecoes.BusinessException;

public interface IMedidaBusiness {

	public void salvarOuAtualizar(Medida medida) throws BusinessException;
	
	public void remover(Medida medida) throws BusinessException;
	
	public List<Medida> listarTodas() throws BusinessException;
}
