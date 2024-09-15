package _Lixo;

import DAO.AcessoDados;

public abstract aspect Persistencia<Object> extends AcessoDados {
	abstract pointcut queroInserir(Object objeto);
	abstract pointcut queroLer();
	abstract pointcut queroExcluir(Object objeto);
	abstract pointcut queroAtualizar(Object objeto);
	
	public Persistencia () {
		super ();
	}
	
//	declare parents : Estoque;
	after() : queroLer() {
		ler();
	}
	
	before(Object objeto): queroInserir(objeto){
		inserir(objeto);
	}
	before(Object objeto): queroExcluir(objeto){
	}
	before(Object objeto): queroAtualizar(objeto){
	}
	
	
	
}
