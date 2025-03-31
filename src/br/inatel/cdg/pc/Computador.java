package br.inatel.cdg.pc;

import br.inatel.cdg.componentes.HardwareBasico;
import br.inatel.cdg.componentes.MemoriaUSB;
import br.inatel.cdg.componentes.SistemaOperacional;

public class Computador {
    public String marca;
    public float preco;
    public SistemaOperacional sistemaOperacional;
    public HardwareBasico[] hardwareBasico;
    // 1 = processador, 2 = memoria RAM, 3 = armazenamento interno
    public MemoriaUSB memoriaUSB;

    public Computador(String marca, float preco, SistemaOperacional sistemaOperacional, HardwareBasico[] hardwareBasico) {
        this.marca = marca;
        this.preco = preco;
        this.sistemaOperacional = sistemaOperacional;
        this.hardwareBasico = hardwareBasico;
    }

    public void addMemoriaUSB(MemoriaUSB memoriaUSB) {
        this.memoriaUSB = memoriaUSB;
    }

    public void mostrarPCConfig(){
        System.out.println(this);
    }

    public String toString(){
        String pc = "";
        pc += "Marca: " + this.marca + "\n";
        pc += "Preco: " + this.preco + "\n";
        pc += "Sistema Operacional: " + this.sistemaOperacional.toString() + "\n";
        pc += "Hardware Basico:\n";
        pc += " Processador: " + hardwareBasico[0].nome + " (" + hardwareBasico[0].capacidade + " Mhz)\n";
        pc += " Memória Ram: " + hardwareBasico[1].capacidade + "Gb de " + hardwareBasico[1].nome + "\n";
        if(hardwareBasico[2].capacidade < 1000) {
            pc += " Armazenamento: " + hardwareBasico[2].capacidade + "Gb de " + hardwareBasico[2].nome + "\n";
        } else {
            pc += " Armazenamento: " + hardwareBasico[2].capacidade/1000 + "Tb de " + hardwareBasico[2].nome + "\n";
        }

        if(memoriaUSB != null){
            pc += "Acompanha: " + memoriaUSB + "\n";
        }

        return pc;
    }
}
