package br.com.projetoacademia.entidades;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.projetoacademia.comumEnums.Privilegios;

@Entity
public class Usuario implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String login;
	private Privilegios privilegio;
	private String senha;
	
	public Usuario(String login, char[] senha){
		this.login = login;
		this.senha = senha.toString();
	}
	
	public Usuario() {}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Privilegios getPrivilegio() {
		return privilegio;
	}

	public void setPrivilegio(Privilegios privilegio) {
		this.privilegio = privilegio;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String toString() {
		return login;
	}
}
