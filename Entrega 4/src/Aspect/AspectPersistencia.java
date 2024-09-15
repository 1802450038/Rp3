package Aspect;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import java.sql.*;

import DAO.AcessoDados;
import DAO.ProdutoDAO;;


@Aspect
public class AspectPersistencia {
	@Pointcut("execution(* DAO.*.atualizar(..))"
			+ " || execution(* DAO.*.adicionar(..))"
			+ " || execution(* DAO.*.excluir (..))"
			+ " || execution(* DAO.*.selecionarPorId(..))"
			+ " || execution(* DAO.*.selecionarTudo(..))")
	public void operacao() {
	}
	
	@Pointcut("call(Connection AcessoDados.conectar(..))")
	public void obterConexao() {
	}
	
	@Before ("execution(* DAO.*.atualizar(..))"
			+ " || execution(* DAO.*.adicionar(..))"
			+ " || execution(* DAO.*.excluir (..))"
			+ " || execution(* DAO.*.selecionarPorId(..))"
			+ " || execution(* DAO.*.selecionarTudo(..))")
	public void checarConexao() {
		try {
			if(AcessoDados.getInstancia().getConexao()==null) {
				AcessoDados.getInstancia().conectar();
				System.out.println("checando: conexao null");
			}else if (AcessoDados.getInstancia().getConexao().isClosed()) {
				AcessoDados.getInstancia().conectar();
				System.out.println("checando: conexao fechada");
			}else {
				System.out.println("checando: conexao OK");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@After ("execution(* DAO.*.atualizar(..))"
			+ " || execution(* DAO.*.adicionar(..))"
			+ " || execution(* DAO.*.excluir (..))"
			+ " || execution(* DAO.*.selecionarPorId(..))"
			+ " || execution(* DAO.*.selecionarTudo(..))")
	public void encerrarConexao() throws SQLException {
		
		if(AcessoDados.getInstancia().getConexao()==null) {
			System.out.println("fechando: conexao null");
		}else if (AcessoDados.getInstancia().getConexao().isClosed()) {
			System.out.println("fechando: conexao já fechada");
		}else {

	//		AcessoDados.getInstancia().fecharConexao();
			System.out.println("fechando:  OK");
		}
	}
	
	
	//protected pointcut obterConexao():call (Connection AcessoDados)
	
	
	
	
			
	 
	
}
	