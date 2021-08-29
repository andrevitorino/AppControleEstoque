package br.com.auri.controleestoque.controle;

import br.com.auri.controleestoque.telas.TelaControleEstoqueMenuCadastroProdutos;

public class ControleEstoqueControleMenuCadastroProdutos {

	ControleEstoqueCadastroProduto cecp = new ControleEstoqueCadastroProduto();

	public Boolean gerenciaCadastroProdutos(int opc) throws Exception {
		Boolean b = false;
		switch (opc) {
		case 1:
			b = cecp.incluirProduto();
			break;
		case 2:
			b = cecp.alterarProdutoPorId();
			break;
		case 3:
			b = cecp.gerenciarFiltroConsultarProdutos();
			break;
		case 4:
			b = cecp.removerProdutoPorId();
			break;
		case 5:
			TelaControleEstoqueMenuCadastroProdutos.mensagemFinal();
			break;
		default:
			TelaControleEstoqueMenuCadastroProdutos.exibirMensagem("OPÇÃO INVÁLIDA!");
			break;
		}
		return b;
	}

}
