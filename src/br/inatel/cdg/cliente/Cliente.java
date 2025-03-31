package br.inatel.cdg.cliente;

import br.inatel.cdg.pc.Computador;

public class Cliente {
    public String nome;
    public long cpf;

    public Cliente(String nome, long cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public float calculaTotalCompra(Computador[] computador) {
        float precoTotal = 0;
        for (int i = 0; i < computador.length; i++) {
            if (computador[i] != null) {
                precoTotal += computador[i].preco;
            }
        }

        return precoTotal;
    }
}
