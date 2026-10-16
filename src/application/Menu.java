package application;

import entites.ContaBancaria;

import java.util.Locale;
import java.util.Scanner;

public class Menu {
    public  void exibirMenu() {
        Scanner sc = new Scanner(System.in);
        Locale.setDefault(Locale.US);
        int opcao = -1;

        System.out.println("====SEJA BEM VINDO AO JAVA====");

        System.out.println("Me informe seu nome: ");
        String nome = sc.nextLine();

        System.out.println("Me informe seu saldo: ");
        double saldo = sc.nextDouble();

        ContaBancaria usuario = new ContaBancaria(nome, saldo);
        double chequeEspecial;

        if (saldo > 500) {
            chequeEspecial = saldo * 0.5;
        } else {
            chequeEspecial = 50;
        }

        usuario.setSaldo(usuario.getSaldo() + chequeEspecial);
        System.out.println("CHEQUE ESPECIAL ACRESCENTADO NO SEU SALDO: R$ " + chequeEspecial);
        System.out.println("Saldo ATUALIZADO: R$ " + usuario.getSaldo());


        while(opcao != 0) {

            System.out.println();
            System.out.println("1.CONSULTAR SALDO");
            System.out.println("2.CONSULTAR CHEQUE");
            System.out.println("3.DEPOSITAR DINHEIRO");
            System.out.println("4.SACAR DINHEIRO");
            System.out.println("5.PAGAR BOLETO");
            System.out.println("6.VERIFICAR SE A CONTA ESTA USANDO CHEQUE ESPECIAL");
            System.out.println("0.SAIR");
            System.out.println("====ESCOLHA UMA OPÇÂO!====");

            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("SALDO ATUAL: R$" +  usuario.getSaldo());
                    break;

                case 2:
                    System.out.println("Limite do cheque especial: R$ " + chequeEspecial);
                    break;

                case 3:
                     System.out.println("Digite o valor do deposito: ");
                     double deposito = sc.nextDouble();
                        if(deposito > 0) {
                            usuario.setSaldo(usuario.getSaldo() + deposito);
                            System.out.println("SALDO ATUALIZADO COM SUCESSO!");
                            System.out.println("O VALOR ATUALIZADO: R$" + usuario.getSaldo());
                        }else{
                            System.out.println("Digite um valor acima de R$0.");
                        }
                        break;

                case 4:
                    System.out.println("Digite o valor que deseja sacar:");
                    double sacar = sc.nextDouble();

                    if (sacar > 0 && sacar <= usuario.getSaldo() + chequeEspecial) {

                        usuario.setSaldo(usuario.getSaldo() - sacar);

                        System.out.println("Saque realizado com sucesso!");
                        System.out.println("Saldo atualizado: R$ " + usuario.getSaldo());

                    } else {
                        System.out.println("Saldo e limite insuficientes.");
                    }
                     break;

                case 5:
                    System.out.println("Informe o valor do boleto:");
                    double boleto = sc.nextDouble();

                    if (boleto > 0 && boleto <= usuario.getSaldo() + chequeEspecial) {

                        usuario.setSaldo(usuario.getSaldo() - boleto);

                        System.out.println("Pagamento efetuado com sucesso!");
                        System.out.println("Saldo atualizado: R$ " + usuario.getSaldo());

                    } else {
                        System.out.println("Saldo e limite insuficientes.");
                    }
                         break;
                case 6:
                    if (usuario.getSaldo() < 0) {
                        System.out.println("Você está utilizando o cheque especial.");
                        System.out.println("Valor utilizado: R$ " +
                                Math.abs(usuario.getSaldo()));
                    } else {
                        System.out.println("Você não está utilizando o cheque especial.");
                    }
                    break;

                case 0:
                    System.out.println("Obrigado por utilizar o java Bank!");
                break;

                default:
                    System.out.println("OPÇÃO INVALIDA.");
                sc.close();
            }
        }
    }

}
