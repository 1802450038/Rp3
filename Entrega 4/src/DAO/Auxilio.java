package DAO;

import java.util.ArrayList;

import Model.Produto;
import Model.Venda;

public class Auxilio {
	public static  String inserir(Object objeto) {
		if(objeto instanceof Produto) {
			Produto produto= (Produto) objeto;
			String sql = "UPDATE produto SET quantidade = " + produto.getQuantidade()
	        + ", pro_nome = \'" + produto.getNomeProduto() + "\'"
	        + ", descricao = \'" + produto.getDescricao() + "\'"
	        + ", valor =" + produto.getValor()
	        + " WHERE pro_id = " + produto.getId();
			return sql;
		}
		return null;
		
		
	}
	
	public static String excluir(Object objeto) {
		if(objeto instanceof Produto) {	
			Produto produto= (Produto) objeto;
			String sql = "DELETE FROM produto WHERE pro_id = "+ produto.getId();
			return sql;
			}
		return null;
		
		
	}
	public static String atualizar(Object objeto) {
		if(objeto instanceof Produto) {	
			Produto produto= (Produto) objeto;
			String sql = "UPDATE produto SET quantidade = " + produto.getQuantidade()
	        + ", pro_nome = \'" + produto.getNomeProduto() + "\'"
	        + ", descricao = \'" + produto.getDescricao() + "\'"
	        + ", valor =" + produto.getValor()
	        + " WHERE pro_id = " + produto.getId();
			return sql;
		}
		return null;
	}
	
	public static String selecionarPorID(int id, String tabela) {
		String sql;
        sql = "SELECT * FROM "+tabela+ " WHERE pro_id= " + id;
		return sql;
		
	}
	
	public static String selecionarTudo(String tabela) {
		
        String sql;
        return sql = "SELECT * FROM  "+tabela;

	}
}
