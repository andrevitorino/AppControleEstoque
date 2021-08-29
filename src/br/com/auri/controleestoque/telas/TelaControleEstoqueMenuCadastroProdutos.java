package br.com.auri.controleestoque.telas;

import java.util.Scanner;

import br.com.auri.controleestoque.controle.ControleEstoqueControleMenuCadastroProdutos;

public final class TelaControleEstoqueMenuCadastroProdutos {

	static Scanner sc = new Scanner(System.in);
	static ControleEstoqueControleMenuCadastroProdutos cecmcp = new ControleEstoqueControleMenuCadastroProdutos();

	public static boolean menuCadastroProdutos() throws Exception {
		System.out.println();
		System.out.println("*-----------------------------------*");
		System.out.println("|      [ CADASTRO DE PRODUTOS ]     |");
		System.out.println("*-----------------------------------*");
		System.out.println("|   [ 1 ] INCLUIR PRODUTOS          |");
		System.out.println("|   [ 2 ] ALTERAR PRODUTOS          |");
		System.out.println("|   [ 3 ] CONSULTAR PRODUTOS        |");
		System.out.println("|   [ 4 ] EXCLUIR PRODUTOS          |");
		System.out.println("|   [ 5 ] VOLTAR MENU               |");
		System.out.println("*-----------------------------------*");
		System.out.println();

		int opc = -1;
		do {
			System.out.print("Digite uma opção: ");
			try {
				opc = sc.nextInt();
				sc.nextLine();
				if (opc < 1 || opc > 5) {
					TelaControleEstoqueMenuCadastroProdutos.exibirMensagem("OPÇÃO INVÁLIDA!");
					opc = -1;
				}
			} catch (Exception e) {
				sc.nextLine();
				TelaControleEstoqueMenuCadastroProdutos.exibirMensagem("OPÇÃO INVÁLIDA!");
				opc = -1;
			}
		} while (opc == -1);
		return cecmcp.gerenciaCadastroProdutos(opc);
	}

	public static void menuFiltroConsulta() {
		System.out.println();
		System.out.println("*-----------------------------------*");
		System.out.println("|  [ FILTRO CONSULTA DE PRODUTOS ]  |");
		System.out.println("*-----------------------------------*");
		System.out.println("|   [ 1 ] POR ID                    |");
		System.out.println("|   [ 2 ] POR NOME                  |");
		System.out.println("|   [ 3 ] TODOS                     |");
		System.out.println("*-----------------------------------*");
		System.out.println();
	}

	public static void mensagemInicial() {
		System.out.println();
		System.out.println("\nEMPRESA DE IMPORTAÇÃO DE PRODUTOS LTDA.");
		System.out.println("   SISTEMA DE CONTROLE DE ESTOQUE        ");
		System.out.println("          SEJA BEM VINDO(A)!             ");
		System.out.println();
	}

	public static void mensagemFinal() {
		System.out.println();
		System.out.println("\nEMPRESA DE IMPORTAÇÃO DE PRODUTOS LTDA.");
		System.out.println("     SISTEMA DE CONTROLE DE ESTOQUE      ");
		System.out.println("              VOLTE SEMPRE!              ");
		System.out.println();
	}

	public static void exibirMensagem(String msg) {
		int tamtotal = 37;
		int tamstring = msg.length();
		int tamcalculado = (tamtotal - tamstring) / 2;
		System.out.println();
		System.out.println("*-----------------------------------*");
		for (int i = 1; i <= tamcalculado; i++) {
			System.out.print(" ");
		}
		System.out.print(msg);
		for (int i = 1; i <= tamcalculado; i++) {
			System.out.print(" ");
		}
		System.out.println();
		System.out.println("*-----------------------------------*");
		System.out.println();
	}

	public static void menuMovimentacao() {
		System.out.println();
		System.out.println("*-----------------------------------*");
		System.out.println("|  [ MOVIMENTAÇÃO DE PRODUTOS ]     |");
		System.out.println("*-----------------------------------*");
		System.out.println("|   [ 1 ] ENTRADA DE PRODUTOS       |");
		System.out.println("|   [ 2 ] SAIDA DE PRODUTOS         |");
		System.out.println("|   [ 3 ] VOLTAR MENU               |");
		System.out.println("*-----------------------------------*");
		System.out.println();
	}

}
