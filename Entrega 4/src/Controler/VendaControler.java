package Controler;

import java.util.ArrayList;

import DAO.VendaDAO;
import Model.Status;
import Model.Venda;
import View.TelaFaturarVenda;
import View.TelaInicialCaixa;
import View.TelaInicialGerente;
import View.TelaRelatorio;
import View.TelaVendasPendentes;

public class VendaControler {
	TelaInicialGerente telaGerente;
	TelaInicialCaixa telaCaixa;
	TelaFaturarVenda telaFaturarVenda;
	TelaVendasPendentes telaVendasPendentes;
	TelaRelatorio telaRelatorio;

	VendaDAO daoVenda;

	ArrayList<Venda> arrayVenda;

	public VendaControler() {

		daoVenda = new VendaDAO();
		arrayVenda = daoVenda.selecionarTudo();
		System.out.println("N Vendas: " + arrayVenda.size());
	}

	public void relatorioData() {
		String data = telaGerente.getCampoData().getText();
		ArrayList<Venda> vendasDia = new ArrayList();
		for (Venda venda : arrayVenda) {

			if (venda.getDataVenda().contains(data)) {
				vendasDia.add(venda);
				// System.out.println("venda encontrada id: "+ venda.getId());
			}
		}
		telaRelatorio = new TelaRelatorio(vendasDia);
		telaRelatorio.exibir();
	}

	public void exibirVendasPendentes() {

		ArrayList<Venda> vendasPendentes = new ArrayList();
		arrayVenda = daoVenda.selecionarTudo();

		for (Venda venda : arrayVenda) {
			System.out.println("DATA VENDA " + venda.getDataVenda());
			if (venda.getStatus() == Status.ANDAMENTO) {
				vendasPendentes.add(venda);
				System.out.println("venda encontrada id: " + venda.getId());
			}
		}
		TelaVendasPendentes tvp = new TelaVendasPendentes(vendasPendentes);
		tvp.setControlerVenda(this);
		tvp.exibir();
	}

	public void exibirVendaAFaturar(Venda venda) {
		
		telaFaturarVenda = new TelaFaturarVenda(venda);
		telaFaturarVenda.exibir();
	}

	public void faturarVenda(Venda venda) {
		daoVenda.atualizar(venda);
		if (telaFaturarVenda != null) {
			telaFaturarVenda.fechar();
		}
		// TelaVendasPendentes tv = new TelaVendasPendentes(daoVenda.selecionarTudo());
		// tv.exibir();
		exibirVendasPendentes();

	}

	public void setTelaGerente(TelaInicialGerente telaGerente) {
		this.telaGerente = telaGerente;
	}

	public void setTelaCaixa(TelaInicialCaixa telaCaixa) {
		this.telaCaixa = telaCaixa;
	}

	public void setTelaFaturarVenda(TelaFaturarVenda telaFaturarVenda) {
		this.telaFaturarVenda = telaFaturarVenda;
	}

	public void setTelaVendasPendentes(TelaVendasPendentes telaVendasPendentes) {
		this.telaVendasPendentes = telaVendasPendentes;
	}

}
