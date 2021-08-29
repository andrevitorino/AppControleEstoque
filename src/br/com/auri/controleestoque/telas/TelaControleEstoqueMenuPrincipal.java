package br.com.auri.controleestoque.telas;

import java.util.Scanner;

import br.com.auri.controleestoque.controle.ControleEstoqueControleMenuPrincipal;

public final class TelaControleEstoqueMenuPrincipal {

	static Scanner sc = new Scanner(System.in);
	static ControleEstoqueControleMenuPrincipal cecmp = new ControleEstoqueControleMenuPrincipal();

	public static Boolean menuPrincipal() throws Exception {
		System.out.println();
		System.out.println("*-----------------------------------*");
		System.out.println("|          [ MENU PRINCIPAL ]       |");
		System.out.println("*-----------------------------------*");
		System.out.println("|   [ 1 ] CADASTRO DE PRODUTOS      |");
		System.out.println("|   [ 2 ] MOVIMENTA��O DE PRODUTOS  |");
		System.out.println("|   [ 3 ] REAJUSTE DE PRE�OS        |");
		System.out.println("|   [ 4 ] RELAT�RIO DE PRODUTOS     |");
		System.out.println("|   [ 0 ] FINALIZAR PROGRAMA        |");
		System.out.println("*-----------------------------------*");
		System.out.println();

		int opc = -1;
		do {
			System.out.print("Digite uma op��o: ");
			try {
				opc = sc.nextInt();
				sc.nextLine();
				if (opc < 0 || opc > 4) {
					TelaControleEstoqueMenuCadastroProdutos.exibirMensagem("OP��O INV�LIDA!");
					opc = -1;
				}
			} catch (Exception e) {
				sc.nextLine();
				TelaControleEstoqueMenuCadastroProdutos.exibirMensagem("OP��O INV�LIDA!");
				opc = -1;
			}
		} while (opc == -1);
		return cecmp.gerenciaMenuPrincipal(opc);
	}

	public static void mensagemSuporte() {
		System.out.println();
		System.out.println("*-----------------------------------*");
		System.out.println("|        [ CONTATE O SUPORTE ]      |");
		System.out.println("*-----------------------------------*");
		System.out.println();
	}

}
