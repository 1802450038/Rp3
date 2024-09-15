package Controler;

import DAO.FuncionarioDAO;
import Model.Funcionario;

public class LoginControler {

	public static Funcionario usuario;
	FuncionarioDAO daoFuncionario;

	public LoginControler() {
		daoFuncionario = new FuncionarioDAO();
		usuario = null;
	}

	public boolean logar(String usuario, String senha) {

		// usuario = new Funcionario();
		return true;

	}

}
