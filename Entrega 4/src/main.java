import Controler.EstoqueControler;
import DAO.AcessoDados;
import DAO.ProdutoDAO;
import DAO.VendaDAO;
import Model.Cliente;
import Model.ItemVenda;
import Model.Produto;
import Model.Sessao;
import Model.Venda;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Scanner;
import View.TelaLogin;
import View.TelaProdutos;
import View.TelaInicialGerente;
import View.TelaRealizarVenda;


public class main {
	public static void main(String[] args) {
		//main m = new main();
		//m.testeFlavia();
		//TelaLogin t = new TelaLogin(); 
		//t.getFrame().setVisible(true);
		//TelaSelecao ts = new TelaSelecao();
		//ts.getFrame().setVisible(true);
		//TelaProdutos tp = new TelaProdutos();
		//tp.getFrame().setVisible(true);
		TelaRealizarVenda tv = new TelaRealizarVenda();
		//tv.getFrame() = new TelaVenda();
		
	}

	public void testeFlavia() {

		ProdutoDAO pd = new ProdutoDAO();
		VendaDAO vd = new VendaDAO();
		Cliente c = new Cliente("roberto", 345235454);
		Scanner entrada = new Scanner(System.in);
		Produto produto = new Produto(" tenis", "Luva para luta", 40, 30);
		EstoqueControler estoque = new EstoqueControler();
		Produto p1 = estoque.getEstoque().get(1);
		Produto p2 = estoque.getEstoque().get(2);
		// estoque.adicionarProduto(produto,0);

		Venda venda = new Venda();
		ItemVenda i1 = new ItemVenda(p1);
		ItemVenda i2 = new ItemVenda(p2);
		venda.adicionarItem(i2);
		venda.adicionarItem(i1);
		venda.setCliente(c);
		vd.adicionar(venda);
		// System.out.print("staus: "+venda.getStatus().valueOf(venda.getStatus()));
		produto.setNomeProduto("bicicleta");
		// estoque.removerProduto(produto);
		pd.selecionarTudo();
		// System.
		System.out.println("erro remover");
		estoque.removerUmaUnidadeProduto(produto);
		estoque.removerUmaUnidadeProduto(produto);
		produto = pd.selecionarPorID(1);
		System.out.println(produto.getNomeProduto() + ' ' + produto.getQuantidade());
	}
	/**
	 * public void testeAllisson() { Cliente cliente = new Cliente("Joao", 123);
	 * Produto produto = new Produto("faca", "Corta", 10.23, 10); Produto produto2 =
	 * new Produto("serra", "Corta rapido", 50.23, 10); Venda venda = new Venda(p,
	 * cliente);
	 * 
	 * 
	 * 
	 * venda.addCarrinho(produto); venda.addCarrinho(produto2);
	 * venda.addCarrinho(produto2);
	 * 
	 * venda.realizarVenda(cliente, p); System.out.println(venda.getDataVenda());
	 * 
	 * System.out.println("Teste de sessao"); String facil = Sessao.digitos +
	 * "ACEFGHJKLMNPQRUVWXYabcdefhijkprstuvwx"; Sessao tickets = new Sessao(23, new
	 * SecureRandom(), facil);
	 * 
	 * System.out.println(tickets.getChaveSessao());
	 * System.out.println(tickets.getChaveSessao());
	 * System.out.println(tickets.getChaveSessao());
	 * Sessao.classificaSessao(tickets); Sessao.finalizaSessao(tickets);
	 * Sessao.classificaSessao(tickets);
	 * System.out.println(tickets.getChaveSessao());
	 * 
	 * }
	 * 
	 */

}

//    Cada grupo deve desenvolver um programa para o gerenciamento de uma loja de artigos esportivos. O conjunto de histórias de usuário abaixo define o escopo do produto:
//
//        Como Model.Gerente, eu quero manter (incluir, alterar, excluir e consultar)
//        o estoque de produtos oferecidos pela loja, informando: produto, descrição, valor e quantidade.

//        Como Model.Gerente, eu quero emitir um relatório de vendas diárias contendo:
//        produto vendido, preço unitário, quantidade vendida, valor da venda.
//        O relatório deve totalizar as vendas do dia.

//        Como Model.Vendedor, eu quero realizar a venda de produtos da loja, informando:
//        nome do cliente, cpf do cliente, produtos vendidos e quantidade de cada produto.

//        Como Model.Vendedor, eu quero informar o Model.Cliente sobre o valor parcial ou total durante a
//        realização da venda.

//        Como Model.Vendedor, eu quero realizar a troca de produtos da loja, emitindo um cupom de
//        troca ao Model.Cliente.

//        Como Model.Caixa, eu quero realizar o faturamento das vendas realizadas calculando os
//        impostos da venda e informando a forma de pagamento.

//        Como Model.Caixa, eu quero finalizar a venda entregando os produtos comprados ao cliente.

//        Complementarmente, define-se os seguintes observações complementares:
//
//        O programa tem que ser desenvolvido em paradigma orientado a aspectos com linguagem AspectJ.
//        O programa tem que ser para desktop (não é web ou móvel) com interface gráfica.
//        Todas as operações devem ser autenticadas, ou seja, somente usuários autenticados podem operar o programa.
//        Todas as operações devem ser autorizadas, ou seja, somente usuários autorizados pode operar o programa.
//        Todas as operações dever ser persistidas, ou seja, os dados devem ser salvos em bancos de dados SQLite.