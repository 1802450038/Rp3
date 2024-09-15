package Model;

public enum Pagamento {
	
	PENDENTE(0, "Sem pagamento"), 
	CREDITO(1, "Cart�o de cr�dito"), 
	DEBITO(2, "Cart�o de d�bito"), 
	DINHEIRO(3, "Dinheiro");

	public int id;

	public int valorCarta;
	
	public String status;

	Pagamento(int id, String s) {
		this.id = id;
		this.status = s;
	}
	
	
}
