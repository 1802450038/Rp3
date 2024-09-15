package DAO;

import Model.Funcionario;
import Model.Produto;

import java.sql.*;
import java.util.ArrayList;
public class FuncionarioDAO implements IDAO<Funcionario> {

	
	/**
	 * Metodo transforma o retorno do banco de dados em um objeto produto
	 *
	 * @param rs - ResultSet
	 * @return uma instancia de produto
	 * @throws SQLException se ocorrer erro
	 */
	@Override
	public Funcionario montar(ResultSet rs) throws SQLException {
		
		return null;
	}

	@Override
	public boolean atualizar(Funcionario obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean adicionar(Funcionario obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean excluir(Funcionario obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Funcionario selecionarPorID(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Funcionario> selecionarTudo() {
		
		return null;
	}

}
