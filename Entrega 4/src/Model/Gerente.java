package Model;

public class Gerente extends Funcionario implements  IGerente{

    Gerente(int id, String nome, boolean isAdmin, String cargo) {
        super(id, nome, isAdmin, cargo);
    }

    @Override
    public void cadastrarProduto(Produto p){

    }
    @Override
    public void alterarProduto(int idProd){

    }
    @Override
    public void excluirProduto(int idProd){

    }
    @Override
    public void consultarProduto(int idProd){

    }
    @Override
    public void consultarCategoriaProdutos(String categoria){

    }
    @Override
    public void consultarTodosProdutos(){

    }
    @Override
    public  void emitirRelatorioVendas(){

    }



}
