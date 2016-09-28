package br.com.projetoacademia.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Aluno extends Pessoa implements Serializable{
	
	private String profissao;
	@OneToMany
	private List<Medida> medidas;
	@OneToOne
	private Instrutor instrutor;

	public Aluno(String nome, String cpf, Endereco end) {
		super(nome, cpf, end);
		this.medidas = new ArrayList<Medida>();
	}
	
	public Aluno() {
	}

	public String getProfissao() {
		return profissao;
	}

	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}

	public List<Medida> getMedidas() {
		return medidas;
	}

	public void setMedidas(List<Medida> medidas) {
		this.medidas = medidas;
	}
	public void adicionarMedida(Medida medida) {
		this.medidas.add(medida);
	}

	public Instrutor getInstrutor() {
		return instrutor;
	}

	public void setInstrutor(Instrutor instrutor) {
		this.instrutor = instrutor;
	}
	
}
