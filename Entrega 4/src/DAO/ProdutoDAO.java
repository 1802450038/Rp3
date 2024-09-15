package DAO;

import Model.Produto;

import java.sql.*;
import java.util.ArrayList;

public class ProdutoDAO implements IDAO<Produto> {

	// AcessoDados ac = new AcessoDados<>();
	/**
	 * Recebe um produto e atualiza no banco de dados com base no id
	 *
	 * @param produto a ser atualizado
	 * @return true se atualizou com sucesso | false caso contrario
	 */
	@Override
	public boolean atualizar(Produto produto) {
		System.out.println("atualizar " + produto.getId() + " " + produto.getQuantidade());

		String sql = "UPDATE produto SET quantidade = " + produto.getQuantidade() + ", pro_nome = \'"
				+ produto.getNomeProduto() + "\'" + ", descricao = \'" + produto.getDescricao() + "\'" + ", valor ="
				+ produto.getValor() + " WHERE pro_id = " + produto.getId();
		System.out.println(sql);
		try {
			Statement s = AcessoDados.getInstancia().getConexao().createStatement();
			s.execute(sql);

			return true;
		} catch (SQLException throwables) {
			throwables.printStackTrace();
			return false;
		}

	}

	/**
	 * Recebe um produto e insere no banco de dados
	 *
	 * @param produto a ser inserido
	 * @return true se inseriu com sucesso | false caso contrario
	 */
	@Override
	public boolean adicionar(Produto produto) {
		String sql = "INSERT INTO produto (pro_nome,descricao,valor,quantidade)" + " VALUES (?,?,?,?)";
		try {
			// Connection conn = Conexao.conectar();
			Connection conn = AcessoDados.getInstancia().getConexao();
			PreparedStatement preparado = conn.prepareStatement(sql);
			preparado.setString(1, produto.getNomeProduto());
			preparado.setString(2, produto.getDescricao());
			preparado.setDouble(3, produto.getValor());
			preparado.setInt(4, produto.getQuantidade());
			preparado.executeUpdate();

			ResultSet rs = preparado.getGeneratedKeys();
			if (rs.next()) {
				produto.setId(rs.getInt(1));
			}
			return true;
		} catch (SQLException throwables) {
			throwables.printStackTrace();
			return false;
		}

	}

	/**
	 * Recebe um produto e o exclui do banco de dados
	 *
	 * @param produto a ser excluido
	 * @return true se excluiu com sucesso | false caso contrario
	 */
	@Override
	public boolean excluir(Produto produto) {
		// System.out.println("EXCLUIR "+produto.getId()+ " "+
		// produto.getNomeProduto());
		String sql = "DELETE FROM produto WHERE pro_id = ?";
		try {
			Connection conn = AcessoDados.getInstancia().getConexao();
			PreparedStatement preparado = conn.prepareStatement(sql);
			preparado.setInt(1, produto.getId());
			preparado.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	/**
	 * Realiza a consulta no banco de dados pelo id, monta o produto e retorna
	 *
	 * @param id consultado
	 * @return produto recuperado do banco | null se não existir
	 */
	@Override
	public Produto selecionarPorID(int id) {

		String sql;
		sql = "SELECT * FROM produto WHERE pro_id= " + id;

		try {
			Statement declaracao = AcessoDados.getInstancia().getConexao().createStatement();

			ResultSet rs = declaracao.executeQuery(sql);

			if (rs.next()) {
				return montar(rs);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * Recupera todos os produtos da tabela do banco de dados
	 *
	 * @return ArrayList do tipo de produto
	 */
	@Override
	public ArrayList<Produto> selecionarTudo() {
		ArrayList<Produto> produtos;
		produtos = new ArrayList<>();

		String sql;
		sql = "SELECT * FROM produto ";

		try {
			// Connection conn = Conexao.conectar();
			Connection conn = AcessoDados.getInstancia().getConexao();
			Statement declaracao = conn.createStatement();
			ResultSet rs = declaracao.executeQuery(sql);

			while (rs.next()) {
				produtos.add(montar(rs));
			}
			return produtos;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * Metodo transforma o retorno do banco de dados em um objeto produto
	 *
	 * @param rs - ResultSet
	 * @return uma instancia de produto
	 * @throws SQLException se ocorrer erro
	 */
	@Override
	public Produto montar(ResultSet rs) throws SQLException {
		String nomeProduto = rs.getString("pro_nome");
		String descricao = rs.getString("descricao");
		double valor = rs.getDouble("valor");
		int quantidade = rs.getInt("quantidade");
		int id = rs.getInt("pro_id");

		Produto produto;
		produto = new Produto(nomeProduto, descricao, valor, quantidade);
		produto.setId(id);
		return produto;
	}

}
