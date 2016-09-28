package br.com.projetoacademia.facade;

import java.util.List;

import br.com.projetoacademia.business.AlunoBusinessImpl;
import br.com.projetoacademia.business.UsuarioBusinessImpl;
import br.com.projetoacademia.business.interfaces.IAlunoBusiness;
import br.com.projetoacademia.business.interfaces.IUsuarioBusiness;
import br.com.projetoacademia.entidades.Aluno;
import br.com.projetoacademia.entidades.Usuario;
import br.com.projetoacademia.excecoes.BusinessException;

public class Facade {

	private IUsuarioBusiness usuarioBusiness;
	private IAlunoBusiness alunoBusiness;
	
	private static Facade instance = null;
	
	private Facade() {
		usuarioBusiness = new UsuarioBusinessImpl();
		alunoBusiness = new AlunoBusinessImpl();
	}
	
	public static Facade getInstance(){
		if(instance == null){
			Facade.instance = new Facade();
		}
		return Facade.instance;
	}
	
	public void salvarOuAtualizarAluno(Aluno aluno) throws BusinessException{
		alunoBusiness.salvarOuAtualizar(aluno);
	}
	
	public void removerAluno(Aluno aluno) throws BusinessException{
		alunoBusiness.remover(aluno);
	}
	
	public List<Aluno> listarTodosAlunos() throws BusinessException{
		return alunoBusiness.listarTodos();
	}
	
	public List<Usuario> listarTodosUsuarios() throws BusinessException {
		return usuarioBusiness.listarTodos();
	}
	
	public Usuario logar(String username, String password) throws BusinessException{
		return usuarioBusiness.login(username, password);
	}
	
	public void salvarOuAtualizarUsuario(Usuario usuario) throws BusinessException{
		usuarioBusiness.salvarOuAtualizar(usuario);
	}
	
}
