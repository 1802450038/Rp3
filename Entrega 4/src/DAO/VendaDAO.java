/**
 * 
 */
package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Controler.EstoqueControler;
import Model.Cliente;
import Model.ItemVenda;
import Model.Produto;
import Model.Venda;

/**
 * @author Flavia Amin
 *
 */
public class VendaDAO implements IDAO<Venda> {
	EstoqueControler estoque;

	/**
	 * 
	 */
	public VendaDAO() {
		estoque = new EstoqueControler();
	}

	/**
	 * Recebe uma venda e atualiza no banco de dados
	 *
	 * @param venda a ser atualizada
	 * @return true se atualizou com sucesso | false caso contrario
	 */

	@Override
	public boolean atualizar(Venda venda) {
		String sql = "UPDATE venda SET status_id = " + venda.getStatus().id + ", ven_data = \'"
				+ venda.getDataVenda().toString() + "\'" + ", ven_total = " + venda.getVendaTotal() + "" + ", cli_id = "
				+ venda.getCliente().getId() + ", pagamento = \'" + venda.getPagamentoRecebido() + "\', imposto = "
				+ venda.getImposto() + " WHERE ven_id = " + venda.getId();
		System.out.println(sql);
		Statement s = null;
		try {
			s = AcessoDados.getInstancia().getConexao().createStatement();
			// s.execute(sql);
			s.executeUpdate(sql);
			return true;
		} catch (SQLException throwables) {
			throwables.printStackTrace();
			return false;
		} finally {
			try {
				// rs.close();
				s.close();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e);
			}
		}
	}

	/**
	 * Recebe uma venda e insere no banco de dados
	 *
	 * @param venda a ser inserido
	 * @return true se inseriu com sucesso | false caso contrario
	 */
	@Override
	public boolean adicionar(Venda venda) {
		inserirCliente(venda.getCliente());

		String sql = "INSERT INTO venda (ven_data,ven_total,cli_id,pagamento.imposto)" + " VALUES (?,?,?,?,?)";
		try {
			// Connection conn = Conexao.conectar();
			Connection conn = AcessoDados.getInstancia().getConexao();
			PreparedStatement preparado = conn.prepareStatement(sql);
			preparado.setString(1, venda.getDataVenda().toString());
			preparado.setDouble(2, venda.getVendaTotal());
			preparado.setInt(3, venda.getCliente().getId());
			preparado.setString(4, venda.getPagamentoRecebido());
			preparado.setDouble(4, venda.getImposto());
			preparado.executeUpdate();

			ResultSet rs = preparado.getGeneratedKeys();
			if (rs.next()) {
				venda.setId(rs.getInt(1));
			}
			adicionarItensVenda(venda);
			rs.close();
			
			return true;
		} catch (SQLException throwables) {
			throwables.printStackTrace();
			return false;
		}

	}

	/**
	 * Responsável por registrar a relação da venda com seus respectivos produtos
	 * 
	 * @param Venda
	 * @return
	 */
	private boolean adicionarItensVenda(Venda venda) {
		String sql = "INSERT INTO venda_produto (ven_id,pro_id, pro_quantidade, pro_valor) VALUES (?,?,?,?)  ";
		
		Connection conn = AcessoDados.getInstancia().getConexao();
		PreparedStatement preparado;

		try {
			// Connection conn = Conexao.conectar();
			 conn = AcessoDados.getInstancia().getConexao();
			 preparado = conn.prepareStatement(sql);

			for (int i = 0; i < venda.getArrayItensVenda().size(); i++) {

				preparado.setInt(1, venda.getId());

				preparado.setInt(2, venda.getArrayItensVenda().get(i).getProduto().getId());
				preparado.setInt(3, venda.getArrayItensVenda().get(i).getQuantidadeVendida());
				preparado.setDouble(4, venda.getArrayItensVenda().get(i).getProduto().getValor());
				preparado.executeUpdate();
				preparado.close();
			}

			return true;
		} catch (SQLException throwables) {
			throwables.printStackTrace();
			return false;
		}

	}

	/**
	 * Recebe um cliente e adiciona um cliente na venda
	 * 
	 * @param c cliente
	 * @return true se adicionou com sucesso | false caso contrario
	 */
	public boolean inserirCliente(Cliente c) {
		String sql = "INSERT INTO cliente ( cli_nome,cpf) VALUES (?,?)";
		try {

			Connection conn = AcessoDados.getInstancia().getConexao();
			PreparedStatement preparado = conn.prepareStatement(sql);
			preparado.setString(1, c.getNome());
			preparado.setString(2, String.valueOf(c.getCpf()));
			preparado.executeUpdate();

			ResultSet rs = preparado.getGeneratedKeys();
			if (rs.next()) {
				c.setId(rs.getInt(1));
			}
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public boolean excluir(Venda obj) {

		return false;
	}

	@Override
	public Venda selecionarPorID(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Venda> selecionarTudo() {
		ArrayList<Venda> vendas;
		vendas = new ArrayList<>();

		String sql;
		sql = "SELECT * FROM venda ";

		try {
			// Connection conn = Conexao.conectar();
			Connection conn = AcessoDados.getInstancia().getConexao();
			Statement declaracao = conn.createStatement();
			ResultSet rs = declaracao.executeQuery(sql);
			ResultSet itemRs;
			ResultSet clienteRs;
			int cont = 0;

			// montar as vendas
			while (rs.next()) {
				cont++;
				Venda venda = montar(rs);
				vendas.add(venda);
			}

			// para cada venda
			for (Venda v : vendas) {

				// pegar cliente
				conn = AcessoDados.getInstancia().getConexao();
				declaracao = conn.createStatement();
				clienteRs = declaracao.executeQuery("SELECT * FROM cliente WHERE cli_id = " + v.getId());

				// clienteRs.next(); // ignorou cabecalho
				v.setCliente(montarCliente(clienteRs));

				// adicionar itensVendas
				conn = AcessoDados.getInstancia().getConexao();
				declaracao = conn.createStatement();
				sql = "SELECT * FROM venda_produto WHERE ven_id =  " + v.getId();
				itemRs = declaracao.executeQuery(sql);

				while (itemRs.next()) {
					v.getArrayItensVenda().add(montarItemVenda(itemRs));
				}

			}
			return vendas;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public Venda montar(ResultSet rs) throws SQLException {
		String ven_Data = rs.getString("ven_data");
		// System.out.println("antiga " + ven_Data.toString());
		// LocalDateTime dataVenda = new
		// java.sql.Timestamp(ven_Data.getTime()).toLocalDateTime();

		// System.out.println("Convertida "+ dataVenda.toString());
		double ven_total = rs.getDouble("ven_total");
		int id = rs.getInt("ven_id");
		String pagamento = rs.getString("pagamento");
		double imposto = rs.getDouble("imposto");

		Venda venda;
		venda = new Venda();
		venda.setDataVenda(venda.converterData(ven_Data));

		venda.setId(id);
		venda.setPagamentoRecebido(pagamento);
		venda.setImposto(imposto);
		return venda;

	}

	public Cliente montarCliente(ResultSet rs) throws SQLException {
		try {

			int cli_id = rs.getInt("cli_id");
			String cli_nome = rs.getString("cli_nome");
			long cpf = Long.parseLong(rs.getString("cpf"));
			Cliente c = new Cliente(cli_nome, cpf);
			c.setId(cli_id);
			return c;
		} catch (Exception e) {
			Cliente c = new Cliente("banana", 1);
			c.setId(55);
			e.printStackTrace();
			return c;

		}
	}

	public ItemVenda montarItemVenda(ResultSet rs) throws SQLException {
		int quantidade = rs.getInt("pro_quantidade");
		int id_produto = rs.getInt("pro_id");
		Produto produto = estoque.getProdutoPorId(id_produto);
		ItemVenda iv = new ItemVenda(produto, quantidade);

		return iv;

	}

}