package Model;

public interface IGerente {

    public void cadastrarProduto(Produto p);

    public void alterarProduto(int idProd);

    public void excluirProduto(int idProd);

    public void consultarProduto(int idProd);

    public void consultarCategoriaProdutos(String categoria);

    public void consultarTodosProdutos();

    public  void emitirRelatorioVendas();


}
