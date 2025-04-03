package br.com.compras.main;

import br.com.compras.model.Compra;

import javax.swing.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        double limiteCartao = 0;
        String produto = "";
        String descricaoDoProduto;
        double valorDaCompra;
        String gostariaDeContinuar = "S";

        Compra compras;
        Scanner scanner;

        try {
            scanner = new Scanner(System.in);

            System.out.print("Digite o limite do seu cartão: R$");
            limiteCartao = scanner.nextDouble();
            scanner.nextLine();

            System.out.print("Digite o produto escolhido: ");
            produto = scanner.nextLine();
            compras = new Compra(limiteCartao, produto);

            System.out.print("Digite a descrição do produto: ");
            descricaoDoProduto = scanner.nextLine();

            System.out.print("Digite o valor da compra: R$");
            valorDaCompra = scanner.nextDouble();
            scanner.nextLine();
            limiteCartao -= valorDaCompra;

            System.out.println("Compra realizada!");

            System.out.print("Quer continuar comprando? [S/N]".toUpperCase());
            gostariaDeContinuar = scanner.nextLine();

            boolean verdade = true;
            while (verdade) {
                System.out.print("Quer continuar comprando? [S/N]".toUpperCase());
                gostariaDeContinuar = scanner.nextLine();
                if (limiteCartao >= valorDaCompra && gostariaDeContinuar.equals("S")) {
                    System.out.print("Digite o produto escolhido: ");
                    produto = scanner.nextLine();
                    compras = new Compra(limiteCartao, produto);

                    System.out.print("Digite a descrição do produto: ");
                    descricaoDoProduto = scanner.nextLine();

                    System.out.print("Digite o valor da compra: R$");
                    valorDaCompra = scanner.nextDouble();
                    scanner.nextLine();
                    limiteCartao -= valorDaCompra;

                    System.out.println("Compra realizada!");
                }else {
                    System.out.printf("Saldo do cartão: R$%.2f", limiteCartao);
                    break;
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Digite valores válidos!");
        }

    }
}
