package br.com.auri.controleestoque.aplicacao;

import br.com.auri.controleestoque.telas.TelaControleEstoqueMenuPrincipal;

public class Autoexec {

	public static void main(String[] args) throws Exception {		
		Boolean b = true;  
		while (b) {
			b = TelaControleEstoqueMenuPrincipal.menuPrincipal();
			if (!b) {
				b = true;
			}
		}
	}

}
