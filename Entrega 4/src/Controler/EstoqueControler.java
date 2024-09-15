package Controler;

import DAO.ProdutoDAO;
import Model.Produto;

import java.util.ArrayList;

public class EstoqueControler {

    ProdutoDAO produtoDAO;
    private ArrayList<Produto> estoque;

    public EstoqueControler() {
        produtoDAO = new ProdutoDAO();
        estoque = produtoDAO.selecionarTudo();
    }

    public boolean adicionarProduto(Produto produto, int quantidade) {
        //  getEstoque().add(produto);
        estoque = produtoDAO.selecionarTudo();
        produto.setQuantidade(produto.getQuantidade() + quantidade);
        return produtoDAO.adicionar(produto);
    }

    public boolean removerUmaUnidadeProduto(Produto produto) {
        if (produto.getQuantidade() > 0) {
            produto.setQuantidade(produto.getQuantidade() - 1);
            //getEstoque().remove(produto);
            produtoDAO.atualizar(produto);
            atualizar(produto);
            return true;
        }

        return false;
    }

    public boolean removerProduto(Produto produto) {
        estoque.remove(produto);
        return produtoDAO.excluir(produto);
    }

    public String consultar() {
        String prodQt = "";
        StringBuilder tmp = new StringBuilder();

        ArrayList<Produto> jaFoi = new ArrayList<Produto>();
        for (Produto p : getEstoque()) {
            if (!jaFoi.contains(p)) {
                prodQt = String.format("Model.Produto: %s %n Descricão: %s %n Quantidade: %s %n%n ", p.getNomeProduto(), p.getDescricao(), p.getQuantidade());
                tmp.append(prodQt);
                jaFoi.add(p);
            }
        }
        return tmp.toString();
    }

    public String consultar(int id) {
        for (Produto p : estoque) {
            if (p.getId() == id) {
                return String.format("Model.Produto: %s %n Descricão: %s %n Quantidade: %s %n%n ", p.getNomeProduto(), p.getDescricao(), p.getQuantidade());
            }
        }
        return "Model.Produto não encontrado";
    }

    public String consultar(String nome) {
        for (Produto p : estoque) {
            if (p.getNomeProduto().contains(nome)) {
                return String.format("Model.Produto: %s %n Descricão: %s %n Quantidade: %s %n%n ", p.getNomeProduto(), p.getDescricao(), p.getQuantidade());
            }
        }
        return "Model.Produto n�o encontrado";
    }
    
    public Produto getProdutoPorId(int id) {
    	for(int i=0; i<estoque.size();i++) {
    		if(estoque.get(i).getId()==id) {
    			return estoque.get(i);
    		}
    	}
    	
    	return null;
    }
    
    
    public void atualizar(Produto produto) {
    	System.out.println("atualizando produto");
    }

    public ArrayList<Produto> getEstoque() {
        return estoque;
    }

    public void setEstoque(ArrayList<Produto> estoque) {
        this.estoque = estoque;
    }
}
