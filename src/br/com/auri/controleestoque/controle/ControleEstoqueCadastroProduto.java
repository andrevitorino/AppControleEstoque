package br.com.auri.controleestoque.controle;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

import br.com.auri.controleestoque.crud.ControleEstoqueCRUD;
import br.com.auri.controleestoque.modelo.Produto;
import br.com.auri.controleestoque.telas.TelaControleEstoqueMenuCadastroProdutos;

public class ControleEstoqueCadastroProduto {

	Scanner sc = new Scanner(System.in);
	ControleEstoqueCRUD ce = new ControleEstoqueCRUD();

	public Boolean incluirProduto() throws Exception {
		int id = -1;
		do {
			System.out.println();
			System.out.print("Id         : ");
			try {
				id = sc.nextInt();
				sc.nextLine();
				if (id < 1 || id > 999) {
					TelaControleEstoqueMenuCadastroProdutos.exibirMensagem("ID FORA DO ESCOPO!");
					id = -1;
				}
				if (ce.verificarId(id)) {
					TelaControleEstoqueMenuCadastroProdutos.exibirMensagem("ID JÁ CADASTRADO!");
					id = -1;
				}
			} catch (Exception e) {
				sc.nextLine();
				TelaControleEstoqueMenuCadastroProdutos.exibirMensagem("ID INVÁLIDO!");
				id = -1;
			}
		} while (id == -1);

		System.out.print("Nome       : ");
		String nome;
		nome = sc.nextLine();
		double preco = -1;
		do {
			System.out.print("Preço      : ");
			try {
				preco = sc.nextDouble();
				sc.nextLine();
			} catch (Exception e) {
				sc.nextLine();
				TelaControleEstoqueMenuCadastroProdutos.exibirMensagem("PREÇO INVÁLIDO!");
				preco = -1;
			}
		} while (preco == -1);

		int quantidade = -1;
		do {
			System.out.print("Quantidade : ");
			try {
				quantidade = sc.nextInt();
				sc.nextLine();
			} catch (Exception e) {
				sc.nextLine();
				TelaControleEstoqueMenuCadastroProdutos.exibirMensagem("QUANTIDADE INVÁLIDA!");
				quantidade = -1;
			}
		} while (quantidade == -1);
		return ce.adicionar(new Produto(id, nome, preco, quantidade));
	}

	public Boolean gerenciarFiltroConsultarProdutos() throws Exception {
		Boolean b = false;
		int opc = -1;
		TelaControleEstoqueMenuCadastroProdutos.menuFiltroConsulta();

		do {
			System.out.print("Digite uma opção: ");
			try {
				opc = sc.nextInt();
				sc.nextLine();
				if (opc < 1 || opc > 3) {
					TelaControleEstoqueMenuCadastroProdutos.exibirMensagem("OPÇÃO INVÁLIDA!");
					opc = -1;
				}
			} catch (Exception e) {
				sc.nextLine();
				TelaControleEstoqueMenuCadastroProdutos.exibirMensagem("OPÇÃO INVÁLIDA!");
				opc = -1;
			}
		} while (opc == -1);

		switch (opc) {
		case 1:
			b = consultarProdutoPorId();
			break;
		case 2:
			b = consultarProdutoPorNome();
			break;
		case 3:
			b = consultarTodosProduto();
			break;
		default:
			TelaControleEstoqueMenuCadastroProdutos.exibirMensagem("OPÇÃO INVÁLIDA!");
			return false;
		}
		return b;
	}

	public Boolean consultarProdutoPorId() throws Exception {
		System.out.println();
		System.out.print("Pesquisar por Id: ");

		int id = -1;
		do {
			try {
				id = sc.nextInt();
				sc.nextLine();
				if (id < 1 || id > 999) {
					TelaControleEstoqueMenuCadastroProdutos.exibirMensagem("ID FORA DO ESCOPO!");
					id = -1;
				}
				if ((id >= 1 && id <= 999) && !ce.verificarId(id)) {
					TelaControleEstoqueMenuCadastroProdutos.exibirMensagem("ID NÃO CADASTRADO!");
					id = -1;
				}
			} catch (Exception e) {
				sc.nextLine();
				TelaControleEstoqueMenuCadastroProdutos.exibirMensagem("ID INVÁLIDO!");
				id = -1;
			}
		} while (id == -1);
		Produto p = ce.consultarFindById(id);
		System.out.println();
		System.out.println("-----------------------------");
		System.out.println("Nome       : " + p.getNome());
		System.out.println("Preço      : " + p.getPreco());
		System.out.println("Quantidade : " + p.getQuantidade());
		System.out.println("-----------------------------");
		return true;
	}

	public Boolean consultarProdutoPorNome() throws Exception {
		try {
			System.out.println();
			System.out.print("Pesquisar por Nome: ");
			String nome = sc.nextLine();
			Produto p = ce.consultarFindByNome(nome);
			if (!Objects.isNull(p)) {
				System.out.println();
				System.out.println("-----------------------------");
				System.out.println("Id         : " + p.getId());
				System.out.println("Nome       : " + p.getNome());
				System.out.println("Preço      : " + p.getPreco());
				System.out.println("Quantidade : " + p.getQuantidade());
				System.out.println("-----------------------------");
				return true;
			} else {
				TelaControleEstoqueMenuCadastroProdutos.exibirMensagem("PRODUTO NÃO ENCONTRADO!");
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}

	public Boolean consultarTodosProduto() throws Exception {
		try {
			ArrayList<Produto> produto = ce.consultarFindAll();
			for (Produto p : produto) {
				System.out.println();
				System.out.println("-----------------------------");
				System.out.println("Id         : " + p.getId());
				System.out.println("Nome       : " + p.getNome());
				System.out.println("Preço      : " + p.getPreco());
				System.out.println("Quantidade : " + p.getQuantidade());
				System.out.println("-----------------------------");
			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public Boolean removerProdutoPorId() throws Exception {
		System.out.println();
		System.out.print("Remover por Id: ");

		int id = -1;
		do {
			try {
				id = sc.nextInt();
				sc.nextLine();
				if (id < 1 || id > 999) {
					TelaControleEstoqueMenuCadastroProdutos.exibirMensagem("ID FORA DO ESCOPO!");
					id = -1;
				}
				if ((id >= 1 && id <= 999) && !ce.verificarId(id)) {
					TelaControleEstoqueMenuCadastroProdutos.exibirMensagem("ID NÃO CADASTRADO!");
					id = -1;
				}
			} catch (Exception e) {
				sc.nextLine();
				TelaControleEstoqueMenuCadastroProdutos.exibirMensagem("ID INVÁLIDO!");
				id = -1;
			}
		} while (id == -1);
		TelaControleEstoqueMenuCadastroProdutos.exibirMensagem("TEM CERTEZA S/N?");
		String r = sc.next();
		if (r.equalsIgnoreCase("S")) {
			return ce.remover(id);
		}
		return false;
	}

	public Boolean alterarProdutoPorId() throws Exception {
		Boolean b = false;
		System.out.println();
		System.out.print("Alterar por Id: ");

		int id = -1;
		do {
			try {
				id = sc.nextInt();
				sc.nextLine();
				if (id < 1 || id > 999) {
					TelaControleEstoqueMenuCadastroProdutos.exibirMensagem("ID FORA DO ESCOPO!");
					id = -1;
				}
				if ((id > 0 || id < 1000) && ce.verificarId(id)) {

					Produto produto = ce.consultarFindById(id);
					System.out.println();
					System.out.println("-----------------------------");
					System.out.println("1 - Nome       : " + produto.getNome());
					System.out.println("2 - Preço      : " + produto.getPreco());
					System.out.println("3 - Quantidade : " + produto.getQuantidade());
					System.out.println("-----------------------------");

					int opc = -1;
					System.out.println();

					do {
						System.out.print("Digite uma opção: ");
						try {
							opc = sc.nextInt();
							sc.nextLine();
							if (opc < 1 || opc > 3) {
								TelaControleEstoqueMenuCadastroProdutos.exibirMensagem("OPÇÃO INVÁLIDA!");
								opc = -1;
							}
						} catch (Exception e) {
							sc.nextLine();
							TelaControleEstoqueMenuCadastroProdutos.exibirMensagem("OPÇÃO INVÁLIDA!");
							opc = -1;
						}
					} while (opc == -1);

					switch (opc) {
					case 1:
						System.out.println();
						System.out.print("Nome       : ");
						String nomeAlterado;
						nomeAlterado = sc.nextLine();
						b = ce.alterar(produto, new Produto(produto.getId(), nomeAlterado, produto.getPreco(),
								produto.getQuantidade()));
						break;
					case 2:
						double precoAlterado = -1;
						do {
							System.out.println();
							System.out.print("Preço      : ");
							try {
								precoAlterado = sc.nextDouble();
								sc.nextLine();
								b = ce.alterar(produto, new Produto(produto.getId(), produto.getNome(), precoAlterado,
										produto.getQuantidade()));
							} catch (Exception e) {
								sc.nextLine();
								TelaControleEstoqueMenuCadastroProdutos.exibirMensagem("PREÇO INVÁLIDO!");
								precoAlterado = -1;
							}
						} while (precoAlterado == -1);
						break;
					case 3:
						int quantidadeAlterada = -1;
						do {
							System.out.println();
							System.out.print("Quantidade : ");
							try {
								quantidadeAlterada = sc.nextInt();
								sc.nextLine();
								b = ce.alterar(produto, new Produto(produto.getId(), produto.getNome(),
										produto.getPreco(), quantidadeAlterada));
							} catch (Exception e) {
								sc.nextLine();
								TelaControleEstoqueMenuCadastroProdutos.exibirMensagem("QUANTIDADE INVÁLIDA!");
								quantidadeAlterada = -1;
							}
						} while (quantidadeAlterada == -1);
						break;
					default:
						TelaControleEstoqueMenuCadastroProdutos.exibirMensagem("OPÇÃO INVÁLIDA!");
						return false;
					}
				}
			} catch (Exception e) {
				sc.nextLine();
				TelaControleEstoqueMenuCadastroProdutos.exibirMensagem("ID INVÁLIDO!");
				id = -1;
			}
		} while (id == -1);
		return b;
	}

}
