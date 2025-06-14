package POO_RoxanneCoelho.Bens;

import POO_RoxanneCoelho.Pessoa.Jogador;

import java.util.ArrayList;
import java.util.Scanner;

public class Shopping {
    private Jogador jogador;
    private ArrayList<Bens> coisasParaComprar;

    public Shopping(Jogador jogador) {
        this.jogador = jogador;
        this.coisasParaComprar = new ArrayList<Bens>();
    }

    public void adicionarItem(Bens bens) {
        this.coisasParaComprar.add(bens);
    }

    public void mostrarImoveis() {
        Scanner input = new Scanner(System.in);

        for (Bens bens : coisasParaComprar) {
            if (bens instanceof Imovel) {
                bens.mostrarDetalhesBens();
                System.out.println();
            }
        }
    }

    public void mostrarVeiculo() {

        Scanner input = new Scanner(System.in);

        for (Bens bens : coisasParaComprar) {
            if (bens instanceof Veiculo) {
                bens.mostrarDetalhesBens();
                System.out.println();
            }
        }
    }

    public void mostrarAcessorio() {
        Scanner input = new Scanner(System.in);

        for (Bens bens : coisasParaComprar) {
            if (bens instanceof Veiculo) {
                bens.mostrarDetalhesBens();
                System.out.println();
            }
        }
    }

    public void comprarBem(Jogador jogador, int idCompra) {
        for (Bens bens : this.coisasParaComprar) {
            if (bens.getId() == idCompra) {
                double preco = bens.getCusto();

                if (jogador.getDinheiro() >= preco) {
                    jogador.setDinheiro(jogador.getDinheiro() - preco);
                    jogador.adicionarBem(bens);
                    jogador.setEstatuto(jogador.getEstatuto() + bens.getEstatuto());
                    System.out.println("Compra efetuada: " + bens.getNome());
                } else {
                    System.out.println("Dinheiro insuficiente para comprar " + bens.getNome());
                }
                return; // Parar o loop após encontrar o item
            }
        }

        // Só é executado se nenhum bem com o ID foi encontrado
        System.out.println("ID não encontrado.");
    }


    public void vender() {
        Scanner input = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\nBem-vindo ao Shopping! O que deseja comprar?");
            System.out.println("1. Imobiliária (Imóveis)");
            System.out.println("2. Stand de Veículos (Veículos)");
            System.out.println("3. Fashion Outlet (Acessórios de Moda)");
            System.out.println("0. Sair do Shopping");
            System.out.print("Insira uma opção: ");
            opcao = input.nextInt();

            int idCompra;

            switch (opcao) {
                case 1:
                    mostrarImoveis();
                    System.out.print("Insira o ID do imóvel para comprar: ");
                    idCompra = input.nextInt();
                    comprarBem(this.jogador, idCompra);
                    break;
                case 2:
                    mostrarVeiculo();
                    System.out.print("Insira o ID do veículo para comprar: ");
                    idCompra = input.nextInt();
                    comprarBem(this.jogador, idCompra);
                    break;
                case 3:
                    mostrarAcessorio();
                    System.out.print("Insira o ID do acessório para comprar: ");
                    idCompra = input.nextInt();
                    comprarBem(this.jogador, idCompra);
                    break;
                case 0:
                    System.out.println("Obrigada pela sua visita, volte sempre!");
                    break;
                default:
                    System.out.println("Opção inválida! Por favor, escolha novamente.");
            }
        } while (opcao != 0);
    }
}


