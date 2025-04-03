package br.com.compras.model;

public class Compra {
    private double limiteDoCartao;
    private String produto;
    private String descricaoDoProduto;
    private double valorDaCompra;

    public Compra(double limiteDoCartao, String produto) {
        this.limiteDoCartao = limiteDoCartao;
        this.produto = produto;
    }

    public double getLimiteDoCartao() {
        return limiteDoCartao;
    }

    public String getProduto() {
        return produto;
    }

    public String getDescricaoDoProduto() {
        return descricaoDoProduto;
    }

    public double getValorDaCompra() {
        return valorDaCompra;
    }

}
