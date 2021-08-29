package br.com.auri.controleestoque.controle;

import br.com.auri.controleestoque.telas.TelaControleEstoqueMenuCadastroProdutos;

public class ControleEstoqueControleMenuPrincipal {

	public ControleEstoqueControleMenuPrincipal() {
	}

	public Boolean gerenciaMenuPrincipal(int opc) throws Exception {
		Boolean b = false;
		switch (opc) {
		case 0:
			TelaControleEstoqueMenuCadastroProdutos.mensagemFinal();
			break;
		case 1:
			b = TelaControleEstoqueMenuCadastroProdutos.menuCadastroProdutos();
			break;
		case 2:
			System.out.println("Opção 2 selecionada!");
			break;
		case 3:
			System.out.println("Opção 3 selecionada!");
			break;
		case 4:
			System.out.println("Opção 4 selecionada!");
			break;
		default:
			TelaControleEstoqueMenuCadastroProdutos.exibirMensagem("OPÇÃO INVÁLIDA!");
			break;
		}
		return b;
	}

}
