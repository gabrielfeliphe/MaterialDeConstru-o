package visualizacao;

import java.util.Calendar;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import modelo.Validacoes;

public class EntradaSaida {

	public static int entradaEscolhaUsuario() { // MENU BASICOS DE BOTOEZINHOS LINDOS 

		String[] options = { "Cadastrar novo Produto", "Nova Venda", "Ver Estoque", "Ver Cupons", "Sair" }; // 0,1,2,3

		int selecao = JOptionPane.showOptionDialog(null, "Selecione a opção", "Material de Construção",
				JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

		return selecao; // Retorno da posição da string no array 0,1,2,3
	}

	public static String[] cadastroNovoProduto() { 

		String dadosNovoProduto[] = new String[3]; // Vetor string

		dadosNovoProduto[0] = JOptionPane.showInputDialog("Digite o código do produto"); // OBTEMOS OS 3 DADOS
		dadosNovoProduto[1] = JOptionPane.showInputDialog("Digite a descrição do produto");
		dadosNovoProduto[2] = JOptionPane.showInputDialog("Digite o valor do produto");
 
		boolean validacaoEntradaCadastro = Validacoes.validaEntradaDadosCadastro(dadosNovoProduto); // Manda para validação

		while (validacaoEntradaCadastro == false) { // faz loop caso ter algo errado
			JOptionPane.showMessageDialog(null, "Houve um erro no cadastro do produto, por favor refaça a operação");
			dadosNovoProduto[0] = JOptionPane.showInputDialog("Digite o código do produto");
			dadosNovoProduto[1] = JOptionPane.showInputDialog("Digite a descrição do produto");
			dadosNovoProduto[2] = JOptionPane.showInputDialog("Digite o valor do produto");
			validacaoEntradaCadastro = Validacoes.validaEntradaDadosCadastro(dadosNovoProduto);
		}

		return dadosNovoProduto; // retorna para controladora

	}

	public static String obterData() { // obtem a data

		Calendar dataAtual = Calendar.getInstance();
		Integer ano = dataAtual.get(Calendar.YEAR);
		Integer mes = dataAtual.get(Calendar.MONTH);
		Integer diaDoMes = dataAtual.get(Calendar.DAY_OF_MONTH);

		if (mes == 12) {
			mes = 1;
		} else {
			mes += 1;
		}

		String dataHoje = diaDoMes + "/" + mes + "/" + ano;

		return dataHoje;
	}

	public static void msgSairPrograma() {
		JOptionPane.showMessageDialog(null, "Encerrando programa!");
	}

	public static void verEstoque(String verEstoque) {
		JOptionPane.showMessageDialog(null, verEstoque);
	}

	public static void verCupons(String verCupons) {
		JOptionPane.showMessageDialog(null, verCupons);
	}

	public static int qstEscolhCadastroProduto() { // menu basico ja apresentado
		String[] options = { "Cadastrar novo Produto", "Adicionar Produto no Estoque" }; // 0,1

		int selecao = JOptionPane.showOptionDialog(null, "Selecione a opção", "Material de Construção",
				JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

		return selecao;
	}

	public static String adicionaProdutoEstoque(String produtosEstoque[]) {
		

		JComboBox<String> opcaoProdutos = new JComboBox<String>(produtosEstoque); // criação de jocombobox menu flutuante
		
		int option = JOptionPane.showConfirmDialog(null, opcaoProdutos, "Selecione a opção desejada",
				JOptionPane.OK_CANCEL_OPTION); // colocamnos o menu flutuante no joptionpane

		while (option != 0) {
			option = JOptionPane.showConfirmDialog(null, opcaoProdutos, "Selecione a opção desejada",
					JOptionPane.OK_CANCEL_OPTION); // revalida caso apertar errado
		}

		return (String) opcaoProdutos.getSelectedItem(); // retorna o item como string

	}

	public static String[] dadosVenda(String[] produtosParaVenda) {
		
		String retornoDadosVenda[] = new String[2]; // vetor 2 posiçoes
		

		JComboBox<String> opcaoProdutos = new JComboBox<String>(produtosParaVenda); // criamos o jcombobox
		
		int option = JOptionPane.showConfirmDialog(null, opcaoProdutos, "Selecione a opção desejada",
				JOptionPane.OK_CANCEL_OPTION); // ensirimos o jcombbox
 
		while (option != 0) {
			option = JOptionPane.showConfirmDialog(null, opcaoProdutos, "Selecione a opção desejada",
					JOptionPane.OK_CANCEL_OPTION);
		}


		retornoDadosVenda[0] = (String) opcaoProdutos.getSelectedItem(); // colocamos a informação que foi escolhida em um vetor
		retornoDadosVenda[1] = JOptionPane.showInputDialog("Quantas unidades deseja vender ?"); // adicionamos na 2 posição a quantidade q o user deseja
		
		boolean validaQtVendas = Validacoes.validaQtEntraProdutoVendido(Integer.parseInt(retornoDadosVenda[1]),retornoDadosVenda[0]); // valida
		while (validaQtVendas == false) { // refaz caso dar algo errado
			JOptionPane.showMessageDialog(null, "Erro ! , o valor excede a quantidade do estoque");
			retornoDadosVenda[1] = JOptionPane.showInputDialog("Quantas unidades deseja vender ?");
			validaQtVendas = Validacoes.validaQtEntraProdutoVendido(Integer.parseInt(retornoDadosVenda[1]),retornoDadosVenda[0]);
		}
		return retornoDadosVenda; // retorno controladora
	}

	public static int qstAddQtProduto() {  // pede a quantidade de produto 
		int numProduto = Integer
				.parseInt(JOptionPane.showInputDialog("Qual a quantidade que deseja adicionar ao estoque ?"));
		while (numProduto <= 0) {
			JOptionPane.showMessageDialog(null, "O valor informado é invalido, o mesmo deve ser maior ou iguala 1");
			numProduto = Integer
					.parseInt(JOptionPane.showInputDialog("Qual a quantidade que deseja adicionar ao estoque ?"));
		}
		return numProduto;
	}

	public static void msgNaoTemProduto() { // hmmmm não tem produto
		JOptionPane.showMessageDialog(null, "Não há produtos no estoque para venda!");
	}

}
