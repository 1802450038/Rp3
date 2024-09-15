package Model;

public class Vendedor extends Funcionario implements IVendedor {


    Vendedor(int id, String nome, boolean isAdmin, String cargo) {
        super(id, nome, isAdmin, cargo);
    }

    @Override
    public void realizarVenda() {

    }

    @Override
    public void calculaValorAtual() {

    }

    @Override
    public void trocarProduto() {

    }


}