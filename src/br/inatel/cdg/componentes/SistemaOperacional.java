package br.inatel.cdg.componentes;

public class SistemaOperacional {
    public String nome;
    public int tipo;

    public SistemaOperacional(String nome, int bits) {
        this.nome = nome;
        this.tipo = bits;
    }

    public String toString() {
        return nome + " (" + tipo + " bits)";
    }
}
