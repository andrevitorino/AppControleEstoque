package br.com.auri.controleestoque.crud;

import java.util.ArrayList;

import br.com.auri.controleestoque.modelo.Produto;

public class ControleEstoqueCRUD {

	ArrayList<Produto> produtoCRUD = new ArrayList<>();

	public Boolean adicionar(Produto produto) throws Exception {
		try {
			produtoCRUD.add(produto);
			return true;
		} catch (Exception e) {
			System.out.println("Erro no método adicionar: " + e);
		}
		return false;
	}

	public Boolean alterar(Produto produto, Produto alterado) throws Exception {
		try {
			int indice = consultarFindByIndice(produto.getId());
			Boolean b = remover(produto.getId());
			produtoCRUD.add(indice, alterado);
			return b;
		} catch (Exception e) {
			System.out.println("Erro no método alterar: " + e);
		}
		return false;
	}

	public ArrayList<Produto> consultarFindAll() throws Exception {
		return produtoCRUD;
	}

	public Produto consultarFindById(int id) throws Exception {
		try {
			for (int i = 0; i < produtoCRUD.size(); i++) {
				if (produtoCRUD.get(i).getId() == id) {
					return produtoCRUD.get(i);
				}
			}
		} catch (Exception e) {
			System.out.println("Erro no método consultar por id: " + e);
		}
		return null;
	}

	public Produto consultarFindByNome(String nome) throws Exception {
		try {
			for (int i = 0; i < produtoCRUD.size(); i++) {
				if (produtoCRUD.get(i).getNome().equals(nome)) {
					return produtoCRUD.get(i);
				}
			}
		} catch (Exception e) {
			System.out.println("Erro no método consultar por nome: " + e);
		}
		return null;
	}

	public Integer consultarFindByIndice(int id) throws Exception {
		try {
			for (int i = 0; i < produtoCRUD.size(); i++) {
				if (produtoCRUD.get(i).getId() == id) {
					return i;
				}
			}
		} catch (Exception e) {
			System.out.println("Erro no método consultar por índice: " + e);
		}
		return null;
	}

	public Boolean verificarId(int id) throws Exception {
		try {
			Produto produto = produtoCRUD.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
			return produto != null;
		} catch (Exception e) {
			System.out.println("Erro no método verificar id: " + e);
		}
		return false;
	}

	public Boolean remover(int id) throws Exception {
		try {
			produtoCRUD.removeIf(x -> x.getId() == id);
			return true;
		} catch (Exception e) {
			System.out.println("Erro no método remover: " + e);
		}
		return false;
	}

}
