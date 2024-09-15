package Aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import Controler.LoginControler;

import java.sql.*;

import DAO.AcessoDados;
import DAO.ProdutoDAO;
import Model.Sessao;
import Model.Cargo;
import Model.Funcionario;

@Aspect
public class AspectAcesso {

	@Before("execution(* View.*.exibir(..))")
	public void validarAcesso() {
		Funcionario funcionario = LoginControler.usuario;
		if (funcionario != null) {
			Enum cargoFuncionario = funcionario.getCargo();

			if (cargoFuncionario == Cargo.GERENTE) {
				System.out.println("GERENTE EXIBINDO");
			} else if (cargoFuncionario == Cargo.CAIXA) {
				System.out.println("VENDEDOR EXIBINDO");
			} else if (cargoFuncionario == Cargo.ATENDENTE) {
				System.out.println("CAIXA EXIBINDO");
			}
		}
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

}
