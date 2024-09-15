package Model;

public enum Pagamento {
	
	PENDENTE(0, "Sem pagamento"), 
	CREDITO(1, "Cartão de crédito"), 
	DEBITO(2, "Cartão de débito"), 
	DINHEIRO(3, "Dinheiro");

	public int id;

	public int valorCarta;
	
	public String status;

	Pagamento(int id, String s) {
		this.id = id;
		this.status = s;
	}
	
	
}
