package modelo;

public class Cupom extends Produto {
	
	private String dataVenda;
	private int qtVendida;
	private double valorTotal;
	private Produto produtoVendido = new Produto();
	
	
	public String getDataVenda() {
		return dataVenda;
	}
	public void setDataVenda(String dataVenda) {
		this.dataVenda = dataVenda;
	}
	public int getQtVendida() {
		return qtVendida;
	}
	public void setQtVendida(int qtVendida) {
		this.qtVendida = qtVendida;
	}
	public double getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}
	public Produto getProdutoVendido() {
		return produtoVendido;
	}
	public void setProdutoVendido(Produto produtoVendido) {
		this.produtoVendido = produtoVendido;
	}
	
}
