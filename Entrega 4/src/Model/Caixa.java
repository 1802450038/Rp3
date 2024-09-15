package Model;
import java.util.ArrayList;

public class Caixa extends Funcionario implements ICaixa{
    Caixa(int id, String nome, boolean isAdmin, String cargo) {
        super(id, nome, isAdmin, cargo);
    }

    @Override
    public void realizarFaturamento() {

    }

    @Override
    public boolean finalizarVenda(Venda v, ArrayList<Produto> ap, Cliente c) {
        return false;
    }
}
