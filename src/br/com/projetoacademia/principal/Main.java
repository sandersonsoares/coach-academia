package br.com.projetoacademia.principal;

import br.com.projetoacademia.excecoes.BusinessException;
import br.com.projetoacademia.gui.Inicio;

public class Main {

	public static void main(String[] args) throws BusinessException {
		Inicio in = new Inicio();
		in.setVisible(true);
	}

}
