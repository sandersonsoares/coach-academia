package br.com.projetoacademia.entidades;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class Pessoa implements Serializable {
	
	public static final String MASCULINO = "MASCULINO";
	public static final String FEMININO = "FEMININO";
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String nome;
	private String cpf;
	private String sexo;
	@OneToOne
	private Endereco endereco;
	private Calendar dataNascimento;
	private String email;
	private Calendar dataCadastro;
	private boolean statusCadastro;
	private String Obs;

	public Pessoa(String nome, String cpf, Endereco end) {
		this.nome = nome;
		this.cpf = cpf;
		this.endereco = end;
		this.setStatusCadastro(true);
		dataCadastro = Calendar.getInstance();
	}
	
	public Pessoa() {
		this.endereco = new Endereco();
		this.dataCadastro = Calendar.getInstance();
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Calendar getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean getStatusCadastro() {
		return statusCadastro;
	}

	public void setStatusCadastro(boolean statusCadastro) {
		this.statusCadastro = statusCadastro;
	}
	
	public Calendar getDataCadastro() {
		return dataCadastro;
	}
	
	public void setDataCadastro(Calendar dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public String getObs() {
		return Obs;
	}

	public void setObs(String obs) {
		Obs = obs;
	}
	
	
	
	/*
	 * public String toString() { SimpleDateFormat df = new
	 * SimpleDateFormat("dd/MM/yyyy"); return "Pessoa [nome=" + nome + ", cpf="
	 * + cpf + ", dataMatricula=" + df.format(dataMatricula.getTime()) +
	 * ", statusCadastro=" + statusCadastro + "Data de vencimento=" +
	 * listarPagamento() + "]" + "\n"; }
	 */



	public String toString() {
		return nome;
	}

}
