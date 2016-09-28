package br.com.projetoacademia.business.interfaces;

import java.util.List;

import br.com.projetoacademia.entidades.Instrutor;
import br.com.projetoacademia.excecoes.BusinessException;

public interface IInstrutorBusiness {
	
	public void salvarOuAtualizar(Instrutor instrutor) throws BusinessException;
	
	public void remover(Instrutor instrutor) throws BusinessException;
	
	public List<Instrutor> listarTodos() throws BusinessException;
}
