package br.com.projetoacademia.entidades;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Medida implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private double torax;
	private double cintura;
	private double abdomem;
	private double quadril;
	private double coxaDireita;
	private double coxaEsquerda;
	private double panturrilhaDireita;
	private double panturrilhaEsquerda;
	private double bracoDireito;
	private double bracoEsquerdo;
	private double antebracoDireito;
	private double antebracoEsquerdo;
	private double ombro;
	private double altura;
	private double peso;
	private Calendar dataMedidas;
	
	public Medida(double d, double e) {
		this.altura = d;
		this.peso = e;
		dataMedidas = Calendar.getInstance();
		
	}
	public Medida() {}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Calendar getDataMedidas() {
		return dataMedidas;
	}
	public void setDataMedidas(Calendar dataMedidas) {
		this.dataMedidas = dataMedidas;
	}
	public void setAltura(double altura) {
		this.altura = altura;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	public double getTorax() {
		return torax;
	}
	public void setTorax(double torax) {
		this.torax = torax;
	}
	public double getCintura() {
		return cintura;
	}
	public void setCintura(double cintura) {
		this.cintura = cintura;
	}
	public double getAbdomem() {
		return abdomem;
	}
	public void setAbdomem(double abdomem) {
		this.abdomem = abdomem;
	}
	public double getQuadril() {
		return quadril;
	}
	public void setQuadril(double quadril) {
		this.quadril = quadril;
	}
	public double getCoxaDireita() {
		return coxaDireita;
	}
	public void setCoxaDireita(double coxaDireita) {
		this.coxaDireita = coxaDireita;
	}
	public double getCoxaEsquerda() {
		return coxaEsquerda;
	}
	public void setCoxaEsquerda(double coxaEsquerda) {
		this.coxaEsquerda = coxaEsquerda;
	}
	public double getPanturrilhaDireita() {
		return panturrilhaDireita;
	}
	public void setPanturrilhaDireita(double panturrilhaDireita) {
		this.panturrilhaDireita = panturrilhaDireita;
	}
	public double getPanturrilhaEsquerda() {
		return panturrilhaEsquerda;
	}
	public void setPanturrilhaEsquerda(double panturrilhaEsquerda) {
		this.panturrilhaEsquerda = panturrilhaEsquerda;
	}
	public double getBracoDireito() {
		return bracoDireito;
	}
	public void setBracoDireito(double bracoDireito) {
		this.bracoDireito = bracoDireito;
	}
	public double getBracoEsquerdo() {
		return bracoEsquerdo;
	}
	public void setBracoEsquerdo(double bracoEsquerdo) {
		this.bracoEsquerdo = bracoEsquerdo;
	}
	public double getAntebracoDireito() {
		return antebracoDireito;
	}
	public void setAntebracoDireito(double antebracoDireito) {
		this.antebracoDireito = antebracoDireito;
	}
	public double getAntebracoEsquerdo() {
		return antebracoEsquerdo;
	}
	public void setAntebracoEsquerdo(double antebracoEsquerdo) {
		this.antebracoEsquerdo = antebracoEsquerdo;
	}
	public double getAltura() {
		return altura;
	}
	public void setAltura(float altura) {
		this.altura = altura;
	}
	public double getPeso() {
		return peso;
	}
	public void setPeso(float peso) {
		this.peso = peso;
	}
	public Calendar getDataMedida() {
		return dataMedidas;
	}
	public double getImc() {
		double imc;
		imc = peso/(altura*altura); 
		return imc;
	}
	
	public double getOmbro() {
		return ombro;
	}
	public void setOmbro(double ombro) {
		this.ombro = ombro;
	}
	
	@Override
	public String toString() {
		return "Medidas [altura=" + altura + ", peso=" + peso + ", imc=" + getImc()
				+ "]"+"\n";
	}
	
}
