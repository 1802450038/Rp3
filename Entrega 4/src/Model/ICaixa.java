package Model;

import java.util.ArrayList;

public interface ICaixa {

    public void realizarFaturamento();

    public boolean finalizarVenda(Venda v, ArrayList<Produto> ap, Cliente c);


}
