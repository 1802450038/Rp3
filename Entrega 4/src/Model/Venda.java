package Model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Venda {
	private ArrayList<ItemVenda> arrayItensVenda;
	private Cliente cliente;
	private Status status;
	private int id;
	private LocalDateTime dataVenda;
	private double vendaTotal;
	private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
	private String pagamentoRecebido;
	private double imposto;

	public double getImposto() {
		return imposto;
	}

	public void setImposto(double imposto) {
		this.imposto = imposto;
	}

	public String getPagamentoRecebido() {
		return pagamentoRecebido;
	}

	public void setPagamentoRecebido(String pagamentoRecebido) {
		this.pagamentoRecebido = pagamentoRecebido;
	}

	public Venda() {
		arrayItensVenda = new ArrayList<ItemVenda>();
		status = Status.ANDAMENTO;
		vendaTotal = 0;
		this.imposto = 18.0;

		this.dataVenda = LocalDateTime.now();
	}

	public Venda(ArrayList<ItemVenda> itensVenda, Cliente cliente) {
		this.arrayItensVenda = itensVenda;
		this.cliente = cliente;
		status = Status.ANDAMENTO;
		vendaTotal = calcularValor();

		this.dataVenda = LocalDateTime.now();
	}

	public boolean realizarVenda(Cliente c, ArrayList<ItemVenda> prod) {
		if (!prod.isEmpty()) {
			this.setCliente(c);
			this.setArrayItensVenda(prod);
			this.dataVenda = LocalDateTime.now();
			return true;
		}
		return false;
	}

	/**
	 * Valida se o produto está em estoque
	 * 
	 * @param itemVenda
	 * @return
	 */
	public boolean isQuantidadeValida(ItemVenda itemVenda) {
		int quantidadeEstoque;
		int quantidadeVendida;
		quantidadeEstoque = itemVenda.getProduto().getQuantidade();
		quantidadeVendida = itemVenda.getQuantidadeVendida();
		if (quantidadeEstoque > quantidadeVendida) {
			return true;
		} else {
			return false;
		}

	}

	/**
	 * Se houver (valida) produto em estoque, adiciona.
	 * 
	 * @param itemVenda
	 * @return
	 */
	public boolean adicionarItem(ItemVenda itemVenda) {
		// Validar quantidade
		if (isQuantidadeValida(itemVenda)) {
			arrayItensVenda.add(itemVenda);
			vendaTotal += itemVenda.getQuantidadeVendida() * itemVenda.getProduto().getValor();
			return true;
		}
		return false;
	}

	/**
	 * Se o produto estive no array, remove.
	 * 
	 * @param itemVenda
	 * @return
	 */
	public boolean removerItem(ItemVenda itemVenda) {
		if (arrayItensVenda.contains(itemVenda)) {
			vendaTotal -= itemVenda.getQuantidadeVendida() * itemVenda.getProduto().getValor();

			arrayItensVenda.remove(itemVenda);
			return true;
		}
		return false;
	}

	/**
	 * Formata uma string com atributos de uma venda
	 * 
	 * @return
	 */
	public String itensToString() {
		String todosItens = "";
		for (int i = 0; i < arrayItensVenda.size(); i++) {
			ItemVenda itemVenda = arrayItensVenda.get(i);
			Produto p = itemVenda.getProduto();
			// todosItens+=itemVenda.getProduto().getNomeProduto()+"\n";
			todosItens += String.format(
					"Model.ItemVenda: %s %n Quantidade: %d %n " + "Valor unitario: %f %n Valor Total: %f %n%n",
					p.getNomeProduto(), itemVenda.getQuantidadeVendida(), p.getValor(),
					p.getValor() * itemVenda.getQuantidadeVendida());
		}

		return todosItens;
	}

	/**
	 * 
	 * @return
	 */
	public double calcularValor() {
		double valor = 0.0;
		for (ItemVenda item : arrayItensVenda) {
			valor += item.getProduto().getValor() * item.getQuantidadeVendida();
		}
		return valor;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public ArrayList<ItemVenda> getArrayItensVenda() {
		return arrayItensVenda;
	}

	public void setArrayItensVenda(ArrayList<ItemVenda> arrayItensVenda) {
		this.arrayItensVenda = arrayItensVenda;
	}

	public String converterData(LocalDateTime dt) {
		String formattedDateTime = dt.format(formatter);

		return formattedDateTime;
	}

	public LocalDateTime converterData(String dt) {
//		String formattedDateTime = dt.format(formatter);
		LocalDateTime dateTime = LocalDateTime.parse(dt, formatter);
		return dateTime;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDataVenda() {
		return dataVenda.format(formatter);
	}

	public Status getStatus() {
		System.out.println(status.id);
		return this.status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public void setDataVenda(LocalDateTime dataVenda) {
		this.dataVenda = dataVenda;
	}

	public double getVendaTotal() {

		return calcularValor();
	}

	public void setVendaTotal(double vendaTotal) {
		this.vendaTotal = vendaTotal;
	}

	public int getStatusId() {
		System.out.println("STATUS ID " + status.id + " " + status);
		return this.status.id;
	}

}
