package br.newtonpaiva.dominio;

import java.util.ArrayList;

public class Pedido {

    private Cliente cliente;

    private Double valorTotal;
    private ArrayList<Ingresso> ingressos = new ArrayList<>();

    public Double calculaValor(Ingresso ingresso){
        this.valorTotal = ingresso.getValor() * ingresso.getQuantidade();
        return valorTotal;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ArrayList<Ingresso> getIngressos() {
        return ingressos;
    }

    public void setIngressos(ArrayList<Ingresso> ingressos) {
        this.ingressos = ingressos;
    }

    public Double getValorTotal() {
        return valorTotal;
    }
}
