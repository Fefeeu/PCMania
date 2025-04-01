package br.inatel.cdg;
import br.inatel.cdg.cliente.Cliente;
import br.inatel.cdg.componentes.HardwareBasico;
import br.inatel.cdg.componentes.MemoriaUSB;
import br.inatel.cdg.componentes.SistemaOperacional;
import br.inatel.cdg.pc.Computador;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int matricula = 380;
        Computador[] computadores = new Computador[3];
        HardwareBasico[] hardwares = new HardwareBasico[3];

        // -------------------- CRIANDO SISTEMAS OPERACIONAIS --------------------
        SistemaOperacional sistemaUbuntu = new SistemaOperacional("Linux Ubuntu", 32);
        SistemaOperacional sistemaWindows8 = new SistemaOperacional("Windows 8", 64);
        SistemaOperacional sistemaWindows10 = new SistemaOperacional("Windows 10", 64);

        // -------------------- CRIANDO COMPUTADOR 1 -----------------------------
        hardwares[0] = new HardwareBasico("Pentium Core i3", 2200);
        hardwares[1] = new HardwareBasico("Memória RAM", 8);
        hardwares[2] = new HardwareBasico("HD", 500);
        computadores[0] = new Computador("Apple", matricula, sistemaUbuntu, hardwares);

        // -------------------- CRIANDO COMPUTADOR 2 -----------------------------
        hardwares[0] = new HardwareBasico("Pentium Core i5", 3370);
        hardwares[1] = new HardwareBasico("Memória RAM", 16);
        hardwares[2] = new HardwareBasico("HD", 1000);
        computadores[1] = new Computador("Sandung", matricula + 1234, sistemaWindows8, hardwares);
        MemoriaUSB memoriaUSB1 = new MemoriaUSB("Pen-drive", 32);
        computadores[1].addMemoriaUSB(memoriaUSB1);

        // -------------------- CRIANDO COMPUTADOR 3 -----------------------------
        hardwares[0] = new HardwareBasico("Pentium Core i7", 4500);
        hardwares[1] = new HardwareBasico("Memória RAM", 32);
        hardwares[2] = new HardwareBasico("HD", 2000);
        computadores[2] = new Computador("Dell", matricula + 5678, sistemaWindows10, hardwares);
        MemoriaUSB memoriaUSB2 = new MemoriaUSB("HD Externo", 1500);
        computadores[2].addMemoriaUSB(memoriaUSB2);

        // -------------------- CRIANDO CLIENTE --------------------------------
        Cliente cliente = new Cliente("Felipe Ferreira", 123456789);


        // -------------------- LISTA DE COMPRAS DO CLIENTE --------------------
        int compra = 0;
        int contadorCompras = 0;
        Computador[] listaDeCompras = new Computador[3];
        Scanner sc = new Scanner(System.in);
        do{ // do while que verifica se ainda ha computadores para serem vendidos e sair se o usuário digitar 0
            // -------- MOSTRANDO COMPUTADORES AINDA DISPONIVEIS PARA A COMPRA -
            System.out.println("Computadores ainda disponeiveis para compra: ");
            for(int i = 0; i < computadores.length; i++){
                if(computadores[i] != null && listaDeCompras[i] == null){
                    System.out.println("-------------------- COMPUTADOR " + (i + 1) + " --------------------");
                    computadores[i].mostrarPCConfig();
                }
            }

            // -------- PRIMEIRA COMPRA REALIZADA, NAO EH PERMITIDO SAIR AINDA -
            if (compra == 0){
                do{
                    System.out.print("Qual computador deseja comprar? \n" +
                            "(digite o numero do computador correspondente): ");
                    compra = sc.nextInt();
                    if (compra <= 0 || compra > listaDeCompras.length){
                        System.out.println("valor invalido tente novamente...");
                    }
                }while(compra <= 0 || compra > listaDeCompras.length);
                listaDeCompras[compra-1] = computadores[compra-1];
                System.out.println("Computador " + compra + " adicionado a lista de compras");
                contadorCompras++;
            } else {    // -------- OUTRAS COMPRAS, AGORA PERMITIDO A SAIDA -----
                // -------- VERIFICACAO DE UMA ENTRADA COM NUMERO VALIDO --------
                do{
                    System.out.print("Qual computador deseja comprar? \n" +
                            "(digite o numero do computador correspondente, se deseja encerrar a lista digite 0): ");
                    compra = sc.nextInt();
                    if (compra < 0 || compra > listaDeCompras.length){
                        System.out.println("valor invalido tente novamente...");
                    }
                }while(compra < 0 || compra > listaDeCompras.length);
                // -------- VERIFICACAO SE COMPUTADOR JA COMPRADO OU NAO --------
                if (compra != 0 && listaDeCompras[compra-1] == null){
                    listaDeCompras[compra-1] = computadores[compra-1];
                    System.out.println("Computador " + compra + " adicionado a lista de compras");
                    contadorCompras++;
                } else {
                    System.out.println("Computador já comprado voltando para menu de compras");
                }
            }
            // -------- ACABARAM OS COMPUTADORES -------------------------------
            if(contadorCompras == listaDeCompras.length){
                System.out.println("Mais nenhum computador disponivel, proceguindo para o calculo da compra");
            }
        }while(compra != 0 && contadorCompras < 3);

        // -------- MOSTRA RESULTADO FINAL DA COMPRA ---------------------------
        System.out.println("Lista de compras encerrada.\n\n\n");
        System.out.println("Compra do cliente " + cliente.nome + " com CPF " + cliente.cpf + " criada com sucesso!");
        System.out.println("Computadores na lista de compras de " + cliente.nome + ": ");
        for(int i = 0; i < computadores.length; i++){
            if(listaDeCompras[i] != null){
                System.out.println("COMPUTADOR " + (i + 1) + ": ");
                listaDeCompras[i].mostrarPCConfig();
            }
        }
        cliente.computador = listaDeCompras;
        System.out.println("O total a pagar por " + cliente.nome + " é de " + cliente.calculaTotalCompra() + "R$");
    }
}