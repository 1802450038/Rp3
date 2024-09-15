package Model;

public class Produto {
    private String nomeProduto;
    private String descricao;
    private double valor;
    private int quantidade;
    private int id;

    public Produto(String nomeProduto, String descricao, double valor, int quantidade) {
        this.nomeProduto = nomeProduto;
        this.descricao = descricao;
        this.valor = valor;
        this.quantidade = quantidade;
    }


    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getQuantidade() {
        return this.quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
