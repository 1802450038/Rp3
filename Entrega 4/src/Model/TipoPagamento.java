package Model;

public enum TipoPagamento {
	DEBITO(0, "Cart�o de Cr�dito"), 
	CREDITO(1, "Cart�o de D�bito"), 
	DINHEIRO(2, "Dinheiro");

	public int id;

	public int valorCarta;
	
	public String nome;

	TipoPagamento(int id, String s) {
		this.id = id;
		this.nome = s;
	}
	
	
}
