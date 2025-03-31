package br.inatel.cdg.componentes;

public class MemoriaUSB {
    String nome;
    int capacidade;

    public MemoriaUSB(String nome, int capacidade) {
        this.nome = nome;
        this.capacidade = capacidade;
    }

    public String toString() {
        if (this.capacidade < 1000) {
            return nome + " de " + capacidade + "Gb";
        } else {
            float novaCapacidade = (float) capacidade;
            return nome + " de " + novaCapacidade/1000 + "Tb";
        }
    }
}
