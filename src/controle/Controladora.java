package controle;

import javax.swing.JOptionPane;

import modelo.Estoque;
import modelo.Validacoes;
import visualizacao.EntradaSaida;

public class Controladora {

	public void iniciaMenu() { // Menu básico da controladora

		int escolhaUsuario; // "Cadastrar novo Produto", "Nova Venda", "Ver
							// Estoque", "Ver Cupons", "Sair"
		do {
			escolhaUsuario = EntradaSaida.entradaEscolhaUsuario();
			switch (escolhaUsuario) {
			case 0:
				cadastrarNovoProduto();
				break;
			case 1:
				novaVenda();
				break;
			case 2:
				verEstoque();
				break;
			case 3:
				verCupons();
				break;
			case 4:
				sairPrograma();
				break;
			}
		} while (escolhaUsuario != 4);

	}

	private void cadastrarNovoProduto() {
		int escolhaProduto = EntradaSaida.qstEscolhCadastroProduto();
		switch (escolhaProduto) {
		case 0:
			Estoque.adicionaProdutoCadastro(EntradaSaida.cadastroNovoProduto()); // Verificar com professores, se é
																					// valido o
			// esquema de validacao, direto modelo VIEW-MODEL
			break;
		case 1:
			if (Validacoes.validaAddProdutoEstoque() == true) {
				Estoque.adicionaProdutoEstoque(EntradaSaida.adicionaProdutoEstoque(Estoque.getProdutosCadastrados()),
						EntradaSaida.qstAddQtProduto());
			} else {
				JOptionPane.showMessageDialog(null, "Não há produtos cadastrados para adicionar ao estoque!");
			}
			break;
		}

	}

	private void novaVenda() {
		if (Validacoes.validaAbrirVenda() == true) {
			Estoque.vendaProduto(EntradaSaida.dadosVenda(Estoque.getProdutosParaVenda()), EntradaSaida.obterData());
		} else {
			EntradaSaida.msgNaoTemProduto();
		}

	}

	private void verEstoque() {
		EntradaSaida.verEstoque(Estoque.verEstoque());

	}

	private void verCupons() {
		EntradaSaida.verCupons(Estoque.verCupons());
	}

	private void sairPrograma() {
		EntradaSaida.msgSairPrograma();
		System.exit(0);
	}

}
