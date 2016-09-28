package br.com.projetoacademia.entidades;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Pagamento implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private boolean status;
	private Calendar vencimento;
	private Calendar dataPagamento;
	@OneToOne
	private Aluno aluno;
	
	public Pagamento(boolean status,  Calendar dataVencimento) {
		
		this.status = status;
		this.vencimento = dataVencimento;

	}
	
	public Pagamento() {
		this.dataPagamento = Calendar.getInstance();
		this.vencimento = Calendar.getInstance();
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Calendar getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Calendar dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Calendar getVencimento() {
		return vencimento;
	}

	public void setVencimento(Calendar vencimento) {
		this.vencimento = vencimento;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public String toString() {
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		return df.format(vencimento.getTime()) + getStatus();
	}
}
