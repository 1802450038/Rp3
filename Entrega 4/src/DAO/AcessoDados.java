package DAO;
import java.sql.*;
import java.util.ArrayList;

import Model.Produto;

public class AcessoDados<Object> {

	private static AcessoDados<?> instancia;
	private Connection conn;
	
	private AcessoDados () {
		   try {
	            Class.forName("org.sqlite.JDBC");
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        }
	}
	
	public static AcessoDados getInstancia() {
        if(instancia==null) {
        	instancia=new AcessoDados();
        }
        return instancia;
    }

public  Connection getConexao() {
       return conn;
  }
	public Connection conectar() {
         // SQLite connection string
        String url = "jdbc:sqlite:C:\\SQLiteStudio/lojaEsportiva.db3";
        
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

	
	  public  void fecharConexao() {
		  try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  }
	
	  }

