package br.com.compras.main;

import br.com.compras.model.Compra;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        double limiteCartao = 0;
        String produto = "";
        String descricaoDoProduto;
        double valorDaCompra;
        String gostariaDeContinuar = "S";

        Compra compras;

        List<String> listaDeCompras = new ArrayList<>();

        try {
            limiteCartao = Double.parseDouble(JOptionPane.showInputDialog(null, "Digite o limite do seu cartão:"));

            produto = JOptionPane.showInputDialog(null, "Digite o produto escolhido:");
            compras = new Compra(limiteCartao, produto);

            descricaoDoProduto = JOptionPane.showInputDialog(null, "Digite a descrição do produto:");

            valorDaCompra = Double.parseDouble(JOptionPane.showInputDialog(null, "Digite o valor da compra:"));
            limiteCartao -= valorDaCompra;

            JOptionPane.showMessageDialog(null, "Compra realizada!");
            listaDeCompras.add("\nCOMPRAS REALIZADAS: \n\n" + produto + " - " + descricaoDoProduto + " (R$" + valorDaCompra + ") \n");

            boolean verdade = true;
            while (verdade) {
                gostariaDeContinuar = JOptionPane.showInputDialog(null, "Quer continuar comprando? [S/N]").toUpperCase();

                if (gostariaDeContinuar.equals("N")) {

                    for (String item : listaDeCompras) {
                        JOptionPane.showMessageDialog(null, "********************\n\n" + item + "\n\n********************");
                    }

                    JOptionPane.showMessageDialog(null, "\n\nSaldo do cartão: R$%.2f".formatted(limiteCartao));

                    verdade = false;
                    break;
                }else {
                    produto = JOptionPane.showInputDialog(null, "Digite o produto escolhido:");
                    compras = new Compra(limiteCartao, produto);

                    descricaoDoProduto = JOptionPane.showInputDialog(null, "Digite a descrição do produto:");

                    valorDaCompra = Double.parseDouble(JOptionPane.showInputDialog(null, "Digite o valor da compra:"));

                    if (valorDaCompra > limiteCartao) {
                        JOptionPane.showMessageDialog(null, "Valor da compra maior que seu limite!");

                        for (String item : listaDeCompras) {
                            JOptionPane.showMessageDialog(null, "********************\n\n" + item + "\n\n********************");
                        }

                        JOptionPane.showMessageDialog(null, "\n\nSaldo do cartão: R$%.2f".formatted(limiteCartao));

                        break;
                    }else {
                        limiteCartao -= valorDaCompra;

                        JOptionPane.showMessageDialog(null, "Compra realizada!");
                        listaDeCompras.add(produto + " - " + descricaoDoProduto + " (R$" + valorDaCompra + ") \n");

                    }
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Digite valores válidos!");
        }

    }
}
