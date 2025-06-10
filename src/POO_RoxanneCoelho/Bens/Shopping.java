package POO_RoxanneCoelho.Bens;

import POO_RoxanneCoelho.Pessoa.Jogador;

import java.util.ArrayList;
import java.util.Scanner;

public class Shopping {
    private ArrayList<Bens> coisasParaComprar;

    public Shopping() {
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

    // Método que imprime todos os itens disponíveis
    public void listarItens() {
        int i = 1;
        for (Bens bens : coisasParaComprar) {
            System.out.println(i + ". " + bens);
            i++;
        }
    }

    // Método principal de venda
    public void hallShopping(Jogador jogador) {
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

            // Limpa a lista antes de cada nova opção
            coisasParaComprar.clear();

            switch (opcao) {
                case 1:
                    adicionarImoveis();
                    listarItens();
                    break;
                case 2:
                    adicionarVeiculos();
                    listarItens();
                    break;
                case 3:
                    adicionarAcessoriosModa();
                    listarItens();
                    break;
                case 0:
                    System.out.println("Obrigada pela sua visita, volte sempre!");
                    break;
                default:
                    System.out.println("Opção inválida! Por favor, escolha novamente.");
            }

        } while (opcao != 0);
    }
    public void comprar(Jogador jogador) {
        if (coisasParaComprar.isEmpty()) {
            System.out.println("Não há itens disponíveis para comprar.");
            return;
        }

        listarItens();

        Scanner input = new Scanner(System.in);
        System.out.print("\nInsira o número do item que deseja comprar (0 para cancelar): ");
        int escolha = input.nextInt();

        if (escolha == 0) {
            System.out.println("Compra cancelada.");
            return;
        }

        // Índice começa em 1 para o utilizador, então subtrai 1
        int indice = escolha - 1;

        if (indice < 0 || indice >= coisasParaComprar.size()) {
            System.out.println("Opção inválida.");
            return;
        }

        Bens itemEscolhido = coisasParaComprar.get(indice);

        if (jogador.getDinheiro() >= itemEscolhido.getCusto()) {
            jogador.setDinheiro(jogador.getDinheiro() - itemEscolhido.getCusto());
            jogador.adicionarBem(itemEscolhido);
            System.out.println("Compra realizada com sucesso!");
        } else {
            System.out.println("Saldo insuficiente.");
        }

    }

}


