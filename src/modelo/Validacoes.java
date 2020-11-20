package modelo;

public class Validacoes {

	// int, string, double

	public static boolean validaEntradaDadosCadastro(String entradaUsuario[]) {

		boolean validaEntradaCadastro;

		int entradaInt = Integer.parseInt(entradaUsuario[0]);
		String entradaString = entradaUsuario[1];
		double entradaDouble = Double.parseDouble(entradaUsuario[2]);

		if (entradaInt < 0) { // codigo menor que zero ou seja negativo
			validaEntradaCadastro = false;
		} else if (entradaDouble <= 0) { // se o valor é igual ou menor que zero
			validaEntradaCadastro = false;
		} else if (entradaString.length() < 1) { // descrição menor que 1 
			validaEntradaCadastro = false;
		} else if (validaEntradaCadastroProdutoEstoque(entradaInt) == false) { // validação se ja existe o produto
			validaEntradaCadastro = false;
		} else {
			validaEntradaCadastro = true;
		}

		return validaEntradaCadastro;

	}

	public static boolean validaEntradaCadastroProdutoEstoque(int codigoProduto) {

		boolean validaEntradaNovoProduto = true;

		for (Produto produtos : Estoque.produtosCadastrados) {  // procura o produto
			if (codigoProduto == produtos.getCodigoProduto()) { // se houver coloca falso na validação e retorna
				validaEntradaNovoProduto = false; 
			}
		}
		
		return validaEntradaNovoProduto;
	}

	public static boolean validaQtEntraProdutoVendido(int qtProduto, String descricaoProduto) {
		boolean validaQtProduto = true;

		for (Produto produtos : Estoque.estoqueLoja) { // procura no estoque
			if (produtos.getDescricaoProduto().equals(descricaoProduto)) { // se tiver a mesma descrição entra no if e pega o produto do array
				if (qtProduto > produtos.getQuantidadeProduto()) { // verifica se a quantidade q deseja vender é maior que a qt de produto no estoque
					validaQtProduto = false;
				}
			}
		}

		return validaQtProduto;
	}

	public static boolean validaAbrirVenda() {
		int size = Estoque.getProdutosParaVenda().length; // validação pra ver se tem produto no estoque, verificando se o array esta zerado ou nao
		if (size > 0) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean validaAddProdutoEstoque() {

		int size = Estoque.getProdutosCadastrados().length;// validação pra ver se tem produtos cadastrados, verificando se o array esta zerado ou nao

		if (size > 0) {
			return true;
		} else {
			return false;
		}
	}

}
