package modelo;

import java.util.ArrayList;

import javax.swing.JOptionPane;



public class Estoque {

	static ArrayList<Produto> estoqueLoja = new ArrayList<Produto>();
	static ArrayList<Produto> produtosCadastrados = new ArrayList<Produto>();
	static ArrayList<Cupom> produtosVendidos = new ArrayList<Cupom>();

	public static void vendaProduto(String dadosVendaProduto[], String dataVenda) {

		Cupom cupom = new Cupom();
		cupom.setDataVenda(dataVenda);
		int qtVendido = Integer.parseInt(dadosVendaProduto[1]);
		double valorVenda;
		boolean removeCheck = false;
		
		for (Produto produtos : estoqueLoja) {
			
			if (dadosVendaProduto[0].equals(produtos.getDescricaoProduto())) {
				
				cupom.setQtVendida(qtVendido);
				valorVenda = qtVendido*produtos.getPrecoProduto();
				cupom.setValorTotal(valorVenda);
				cupom.setProdutoVendido(produtos);
				produtos.setQuantidadeProduto((produtos.getQuantidadeProduto()-qtVendido));
				
				if (produtos.getQuantidadeProduto() == 0) {
					removeCheck = true;
				}
			}
			
		}
		
		if(removeCheck == true) {
			estoqueLoja.remove(cupom.getProdutoVendido());
		}
		
		produtosVendidos.add(cupom);
	}

	public static void adicionaProdutoCadastro(String[] cadastroNovoProduto) {

		int codigoProduto = Integer.parseInt(cadastroNovoProduto[0]);
		double precoProduto = Double.parseDouble(cadastroNovoProduto[2]);

		Produto novoProduto = new Produto();
		novoProduto.setCodigoProduto(codigoProduto);
		novoProduto.setDescricaoProduto(cadastroNovoProduto[1]);
		novoProduto.setPrecoProduto(precoProduto);

		produtosCadastrados.add(novoProduto);

	}

	public static String verEstoque() {

		String EstoqueProdutos = "Produtos em estoque\n";

		if (estoqueLoja.size() == 0) {
			EstoqueProdutos += "Não há produtos em estoque !";
		} else {

			for (Produto produtos : estoqueLoja) {
				EstoqueProdutos += "\n Produto:" + produtos.getDescricaoProduto() + "| Código :"
						+ produtos.getCodigoProduto() + "| Valor Unitario :" + produtos.getPrecoProduto()
						+ "| Quantidade em estoque:" + produtos.getQuantidadeProduto() + "\n";

				System.out.println("teste verestoque produtosgetqt:    " + produtos.getQuantidadeProduto());
			}
		}

		return EstoqueProdutos;
	}

	public static String verCupons() {
		String retornaCupons = "Cupons de vendas";
		double valorTotalCupons=0;

		if (produtosVendidos.size() == 0) {
			retornaCupons += "\n Não há cupons no sistema";
		} else {
			for (Cupom cupons : produtosVendidos) {
				retornaCupons += "\n Data:" + cupons.getDataVenda() + "| Produto:"
						+ cupons.getProdutoVendido().getDescricaoProduto() + "| Quantidade vendida:"
						+ cupons.getQtVendida() + "| Valor Total: " + cupons.getValorTotal() + "\n";
				valorTotalCupons = valorTotalCupons+cupons.getValorTotal(); 
			}
		}
		
		retornaCupons +="\n\n\nValor total de todos os cupons: "+valorTotalCupons;

		return retornaCupons;
	}

	public static void adicionaProdutoEstoque(String nameProduto, int qtEntradaNovoProduto) {
		
		for (Produto produtos : produtosCadastrados) {
			if (nameProduto.equals(produtos.getDescricaoProduto())) {
				if(!estoqueLoja.contains(produtos)) {
					produtos.setQuantidadeProduto(qtEntradaNovoProduto);
					estoqueLoja.add(produtos);
				}else {
					int indexProduto = estoqueLoja.indexOf(produtos);
					produtos.setQuantidadeProduto(produtos.getQuantidadeProduto()+qtEntradaNovoProduto);
					estoqueLoja.set(indexProduto, produtos);
				}
			}
		}
	}

	public static String[] getProdutosCadastrados() {
		String produtosCadastradosString[] = new String[produtosCadastrados.size()];
		int i = 0;
		for (Produto produtos : produtosCadastrados) {
			produtosCadastradosString[i] = produtos.getDescricaoProduto();
			i++;
		}
		return produtosCadastradosString;
	}

	public static String[] getProdutosParaVenda() {
		String produtosCadastradosVenda[] = new String[estoqueLoja.size()];
		int i = 0;
		for (Produto produtos : estoqueLoja) {
			produtosCadastradosVenda[i] = produtos.getDescricaoProduto();
			i++;
		}
		return produtosCadastradosVenda;
	}

}
