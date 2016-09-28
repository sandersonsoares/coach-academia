package br.com.projetoacademia.comumEnums;

public enum Privilegios {
	ADMINISTRADOR("Administrador"), 
	USUARIO("Usu�rio"), 
	GERENTE("Gerente");

	private String privilegio;

	private Privilegios(String privilegio) {
	        this.privilegio = privilegio;
	    }

	public String getConsulta() {
		return privilegio;
	}
}
