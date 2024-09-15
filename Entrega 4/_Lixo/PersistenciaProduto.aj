package _Lixo;

import Model.Produto;

public aspect PersistenciaProduto extends Persistencia<Produto> {
	pointcut queroInserir(Produto p) : execution (**.adicionarProduto(produto));
	pointcut queroLer() : execution (**.consultar());
	pointcut queroExcluir() : execution (**.removerProduto());
	pointcut queroAtualizar() : execution (**.atualizar());
	
	public PersistenciaProduto() {
		super();
		
	}
}
