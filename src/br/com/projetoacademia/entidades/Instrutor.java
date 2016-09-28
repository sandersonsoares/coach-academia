package br.com.projetoacademia.entidades;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.Entity;

import br.com.projetoacademia.enums.RegiaoCREFEnum;

@Entity
public class Instrutor extends Funcionario implements Serializable {

	private String cref;
	private RegiaoCREFEnum regiaoCREF;
	
	public Instrutor(String nome, String cpf, Endereco end) {
	}
	
	public Instrutor(){}

	public String getCref() {
		return cref;
	}

	public void setCref(String cref) {
		this.cref = cref;
	}

	public RegiaoCREFEnum getRegiaoCREF() {
		return regiaoCREF;
	}

	public void setRegiaoCREF(RegiaoCREFEnum regiaoCREF) {
		this.regiaoCREF = regiaoCREF;
	}

}