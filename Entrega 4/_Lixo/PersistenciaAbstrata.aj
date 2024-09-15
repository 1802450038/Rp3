package _Lixo;

import com.sun.jdi.connect.spi.Connection;

public abstract aspect  PersistenciaAbstrata {
	PersistenciaAbstrata(){

		
	}
	private Connection conn;
	
	protected abstract pointcut operacaoBD();
	protected abstract pointcut obterConexao();
}
