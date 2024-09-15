package Model;

public enum TipoPagamento {
	DEBITO(0, "Cartão de Crédito"), 
	CREDITO(1, "Cartão de Débito"), 
	DINHEIRO(2, "Dinheiro");

	public int id;

	public int valorCarta;
	
	public String nome;

	TipoPagamento(int id, String s) {
		this.id = id;
		this.nome = s;
	}
	
	
}
