package View;

import Controler.EstoqueControler;

public class RepositorioVariaveis {

	private static EstoqueControler estoqueControler;
	
	public RepositorioVariaveis() {		
	}
	
	public EstoqueControler getEstoqueControler() {
		if(estoqueControler == null) {
			estoqueControler = new EstoqueControler();			
		}
		return estoqueControler;
	}

}
