package Model;

public enum Status {
	PAGA(0, "Aguardando retirada"), 
	ANDAMENTO(1, "Pagamento pendente"), 
	CANCELADA(2, "Cancelada"), 
	CONCLUIDA(3, "Concluída");

	public int id;

	public int valorCarta;
	
	public String nome;

	Status(int id, String s) {
		this.id = id;
		this.nome = s;
	}
	
	
}
