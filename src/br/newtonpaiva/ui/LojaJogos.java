package br.newtonpaiva.ui;

import br.newtonpaiva.dominio.Cliente;
import br.newtonpaiva.dominio.Ingresso;
import br.newtonpaiva.dominio.Pedido;
import jdk.nashorn.internal.scripts.JO;

import javax.swing.*;
import java.util.ArrayList;

public class LojaJogos {
    public static void main(String[] args) {

        Integer opcao = 0;
        try {
            String mensagem;
            do {
                String nomeCliente = JOptionPane.showInputDialog("Informe o nome do cliente: ");
                if (nomeCliente.matches(".*\\d.*")) {
                    throw new Exception("Contém números, digite apenas letras");
                }
                String nomeJogo = JOptionPane.showInputDialog("Informe o nome do jogo: ");
                if (nomeCliente.matches(".*\\d.*")) {
                    throw new Exception("Contém números, digite apenas letras");
                }
                Double valorJogo = Double.parseDouble(JOptionPane.showInputDialog("Informe o valor do jogo: "));
                Integer qtIngresso = Integer.parseInt(JOptionPane.showInputDialog("Informe a quantidade de ingressos: "));

                Cliente c1 = new Cliente();
                c1.setNome(nomeCliente);

                Ingresso i1 = new Ingresso();
                i1.setNomeJogo(nomeJogo);
                i1.setQuantidade(qtIngresso);
                i1.setValor(valorJogo);

                Pedido p1 = new Pedido();
                p1.setIngressos(new ArrayList<>());
                p1.getIngressos().add(i1);
                p1.calculaValor(i1);

                String mensagemJogos = "";
                int posicao = 0;
                for (Ingresso ingresso : p1.getIngressos()) {
                    mensagemJogos = qtIngresso + " Ingresso(s): " + ingresso.getNomeJogo() + "\nValor: " + p1.getValorTotal();
                    posicao++;
                }
                mensagem = "Pedido feito para " + c1.getNome() + "\n" + mensagemJogos;
                opcao = Integer.parseInt(JOptionPane.showInputDialog("Deseja ingresso de outro jogo ?\n(1) Sim\n(2) Não"));

            } while (opcao == 1);
            System.out.println();

        } catch (NumberFormatException e1) {
            JOptionPane.showMessageDialog(null, "Contém letras, digite apenas números");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
