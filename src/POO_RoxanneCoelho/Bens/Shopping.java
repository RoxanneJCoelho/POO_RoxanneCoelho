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

    public void adicionarImoveis() {
        adicionarItem(new Imovel("Apartamento T1", 150000, 70, 3));
        adicionarItem(new Imovel("Apartamento T2", 300000, 150, 4));
        adicionarItem(new Imovel("Mansão de Luxo", 1500000, 800, 14));
        adicionarItem(new Imovel("Casa Geminada", 500000, 200, 4));
        adicionarItem(new Imovel("Casa na Praia", 750000, 400, 7));
        adicionarItem(new Imovel("Apartamento T0", 120000, 50, 2));
        adicionarItem(new Imovel("Casa Pequena", 100000, 40, 2));
        adicionarItem(new Imovel("Casa no Campo", 450000, 300, 5));
        adicionarItem(new Imovel("Casa Não-Geminada", 800000, 450, 6));
        adicionarItem(new Imovel("Quarto Alugado", 400, 10, 1));
    }

    public void adicionarVeiculos() {
        adicionarItem(new Veiculo("Bicicleta", 200, 5, "Caloi", "Montain Bike"));
        adicionarItem(new Veiculo("Fiat 500 Branco", 15000, 40, "Fiat", "500"));
        adicionarItem(new Veiculo("Mota", 10000, 25, "Honda", "CBR 600RR"));
        adicionarItem(new Veiculo("Mercedes Branco", 80000, 100, "Mercedes", "Classe C"));
        adicionarItem(new Veiculo("Avião Particular", 5000000, 1000, "Cessna", "Citation X"));
        adicionarItem(new Veiculo("Trotineta Elétrica", 1000, 10, "Boosted", "Mini X"));
        adicionarItem(new Veiculo("Scooter", 2500, 15, "Vespa", "Sprint"));
        adicionarItem(new Veiculo("Barco a Vela", 20000, 160, "Beneteau", "Oceanis 30.1"));
        adicionarItem(new Veiculo("Carrinha", 30000, 60, "Ford", "Ranger"));
        adicionarItem(new Veiculo("Ferrari 488", 300000, 200, "Ferrari", "488 GTB"));
    }

    public void adicionarAcessoriosModa() {
        adicionarItem(new AcessorioModa("Boné", 20, 2, "Nike", false));
        adicionarItem(new AcessorioModa("Óculos de Sol", 150, 10, "Ray-Ban", false));
        adicionarItem(new AcessorioModa("Relógio de Pulso", 200, 15, "Casio", false));
        adicionarItem(new AcessorioModa("Bolsa", 2000, 50, "Chanel", true));
        adicionarItem(new AcessorioModa("Anel de Diamante", 10000, 100, "Tiffany", true));
        adicionarItem(new AcessorioModa("Sapatilhas", 120, 15, "Adidas", false));
        adicionarItem(new AcessorioModa("Colar de Pérolas", 800, 100, "Vivara", true));
        adicionarItem(new AcessorioModa("Lenço de Seda", 270, 60, "Hermes", true));
        adicionarItem(new AcessorioModa("Gravata", 300, 45, "Armani", true));
        adicionarItem(new AcessorioModa("Chapéu de Sol", 30, 3, "H&M", false));
    }

    public void mostrarImoveis() {
        int i = 1;
        for (Bens bens : coisasParaComprar) {
            if (bens instanceof Imovel) {
                System.out.println("Imóvel número: " + i);
                bens.mostrarDetalhesBens();
                System.out.println();
                i++;
            }
        }
    }



    public void mostrarVeiculo() {
        int i = 1;
        for (Bens bens : coisasParaComprar) {
            if (bens instanceof Veiculo) {
                System.out.println("Veículo número: " + i);
                bens.mostrarDetalhesBens();
                System.out.println();
                i++;
            }
        }
    }

    public void mostrarAcessorio() {
        int i = 1;
        for (Bens bens : coisasParaComprar) {
            if (bens instanceof AcessorioModa) {
                System.out.println("Acessório número: " + i);
                bens.mostrarDetalhesBens();
                System.out.println();
                i++;
            }
        }
    }

    public void comprarBem(Jogador jogador, int indice) {

        Bens bemEscolhido = coisasParaComprar.get(indice);
        double preco = bemEscolhido.getCusto();

        if (jogador.getDinheiro() >= preco) {
            jogador.setDinheiro(jogador.getDinheiro() - preco);  // Tirar o dinheiro do jogador
            jogador.adicionarBem(bemEscolhido);                  // Adicionar bem à lista do jogador
            jogador.setEstatuto(jogador.getEstatuto() + bemEscolhido.getEstatuto()); // Aumentar estatuto
            System.out.println("Compra efetuada: " + bemEscolhido.getNome());
        } else {
            System.out.println("Dinheiro insuficiente para comprar " + bemEscolhido.getNome());
        }
    }

    public void imprimirImoveis(){
            Scanner input = new Scanner(System.in);
            int opcao;

            do {
                System.out.println("\nBem-vindo á Imobiliaria! O que deseja comprar?");
                mostrarImoveis();

                System.out.print("Insira o número do item que quer comprar (ou prima '11' para sair): ");
                opcao = input.nextInt();

                if (opcao >= 1 && opcao <= 10) {
                    comprarBem(jogador, opcao - 1); // corrigido para índice
                } else if (opcao == 11) {
                    System.out.println("Obrigada por visitar a Imobiliária, volte sempre!");
                } else {
                    System.out.println("Opção inválida! Por favor, escolha novamente.");
                }
            } while (opcao != 11);
    }

    public void imprimirVeiculo(){
        Scanner input = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\nBem-vindo ao Stand! O que deseja comprar?");
            mostrarVeiculo();

            System.out.print("Insira o número do item que quer comprar (ou prima '11' para sair): ");
            opcao = input.nextInt();

            if (opcao >= 1 && opcao <= 10) {
                comprarBem(jogador, opcao - 1); // corrigido para índice
            } else if (opcao == 11) {
                System.out.println("Obrigada por visitar a Imobiliária, volte sempre!");
            } else {
                System.out.println("Opção inválida! Por favor, escolha novamente.");
            }
        } while (opcao != 11);
    }

    public void imprimirAcessorio(){
        Scanner input = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\nBem-vindo ao Fashion Outlet! O que deseja comprar?");
            mostrarAcessorio();

            System.out.print("Insira o número do item que quer comprar (ou prima '11' para sair): ");
            opcao = input.nextInt();

            if (opcao >= 1 && opcao <= 10) {
                comprarBem(jogador, opcao - 1); // corrigido para índice
            } else if (opcao == 11) {
                System.out.println("Obrigada por visitar a Imobiliária, volte sempre!");
            } else {
                System.out.println("Opção inválida! Por favor, escolha novamente.");

            }
        } while (opcao != 11);
    }



    public void vender(Jogador jogador) {
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

            switch (opcao) {
                case 1:
                    imprimirImoveis();
                    break;
                case 2:
                    imprimirVeiculo();

                    break;
                case 3:
                    imprimirAcessorio();

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


