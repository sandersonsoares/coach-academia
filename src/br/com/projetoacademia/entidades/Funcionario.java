package br.com.projetoacademia.entidades;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class Funcionario extends Pessoa {

	private BigDecimal salario;
	
	public Funcionario() {
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}
}
