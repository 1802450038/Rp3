package Aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import Controler.LoginControler;

import java.sql.*;

import javax.swing.JOptionPane;

import DAO.AcessoDados;
import DAO.ProdutoDAO;
import Model.Cargo;
import Model.Funcionario;
import Model.Sessao;;

@Aspect
public class AspectAutenticacao {


	
	
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
	

	


}
