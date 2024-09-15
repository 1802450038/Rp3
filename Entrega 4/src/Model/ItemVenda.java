package Model;

public class ItemVenda {
	private Produto produto;
	private int quantidadeVendida;

	public ItemVenda(Produto produto, int quantidadeVendida) {
		this.produto = produto;
		this.quantidadeVendida = quantidadeVendida;
	}

	public ItemVenda(Produto produto) {
		this.produto = produto;
		this.quantidadeVendida = 1;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public int getQuantidadeVendida() {
		return quantidadeVendida;
	}

	public void setQuantidadeVendida(int quantidadeVendida) {
		this.quantidadeVendida = quantidadeVendida;
	}

}
