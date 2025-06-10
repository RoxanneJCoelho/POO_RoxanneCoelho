package POO_RoxanneCoelho.Shopping;

import POO_RoxanneCoelho.Bens.AcessorioModa;
import POO_RoxanneCoelho.Bens.Bens;
import POO_RoxanneCoelho.Bens.Imovel;
import POO_RoxanneCoelho.Bens.Veiculo;
import POO_RoxanneCoelho.Pessoa.Jogador;
import POO_RoxanneCoelho.Pessoa.NPC;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Shopping {
    private ArrayList<Bens> coisasParaComprar;
    private Scanner scanner;
    private Random random;

    public Shopping() {
        this.coisasParaComprar = new ArrayList<>();
        this.scanner = new Scanner(System.in);
        this.random = new Random();
        popularEstoque();
    }

    public void adicionarItem(Bens item) {
        this.coisasParaComprar.add(item);
    }

    private void popularEstoque() {
        // Imóveis
        adicionarItem(new Imovel("Apartamento T1", 150000, 50, 2));
        adicionarItem(new Imovel("Moradia com Jardim", 300000, 150, 4));
        adicionarItem(new Imovel("Mansão de Luxo", 1500000, 500, 8));
        adicionarItem(new Imovel("Estúdio Pequeno", 80000, 20, 1));
        adicionarItem(new Imovel("Casa de Praia", 450000, 200, 6));
        adicionarItem(new Imovel("Loft Urbano", 200000, 70, 2));
        adicionarItem(new Imovel("Terreno Rural", 50000, 10, 0));
        adicionarItem(new Imovel("Casa de Campo", 250000, 100, 3));
        adicionarItem(new Imovel("Cobertura", 800000, 350, 4));
        adicionarItem(new Imovel("Quarto Alugado", 500, 0, 1));


        // Veículos
        adicionarItem(new Veiculo("Bicicleta", 200, 5, "Caloi", "Montain Bike"));
        adicionarItem(new Veiculo("Carro Popular", 15000, 30, "Fiat", "Uno"));
        adicionarItem(new Veiculo("Moto Esportiva", 10000, 25, "Honda", "CBR 600RR"));
        adicionarItem(new Veiculo("Carro de Luxo", 80000, 100, "Mercedes", "Classe C"));
        adicionarItem(new Veiculo("Jato Particular", 5000000, 1000, "Cessna", "Citation X"));
        adicionarItem(new Veiculo("Skate Elétrico", 800, 3, "Boosted", "Mini X"));
        adicionarItem(new Veiculo("Scooter", 2500, 10, "Vespa", "Sprint"));
        adicionarItem(new Veiculo("Barco a Vela", 20000, 60, "Beneteau", "Oceanis 30.1"));
        adicionarItem(new Veiculo("Caminhonete", 30000, 50, "Ford", "Ranger"));
        adicionarItem(new Veiculo("Ferrari 488", 300000, 200, "Ferrari", "488 GTB"));


        // Acessórios de Moda
        adicionarItem(new AcessorioModa("Boné", 20, 2, "Nike", false));
        adicionarItem(new AcessorioModa("Óculos de Sol", 150, 10, "Ray-Ban", false));
        adicionarItem(new AcessorioModa("Relógio de Pulso", 500, 20, "Casio", true));
        adicionarItem(new AcessorioModa("Bolsa de Grife", 2000, 50, "Chanel", true));
        adicionarItem(new AcessorioModa("Anel de Diamante", 10000, 100, "Tiffany", true));
        adicionarItem(new AcessorioModa("Tênis Esportivo", 120, 5, "Adidas", false));
        adicionarItem(new AcessorioModa("Colar de Pérolas", 800, 30, "Vivara", true));
        adicionarItem(new AcessorioModa("Lenço de Seda", 70, 8, "Hermes", true));
        adicionarItem(new AcessorioModa("Gravata de Grife", 100, 15, "Armani", true));
        adicionarItem(new AcessorioModa("Chapéu de Sol", 30, 3, "H&M", false));

    }

    public void vender(Jogador jogador) {
        System.out.println("\nBem-vindo ao Shopping!");
        hallShopping(jogador);
    }
    public void adicionarPropriedade(Propriedade p) {
        this.propriedades.add(p);
        atualizarEstatuto(); // Atualiza o estatuto ao adicionar propriedade
    }

    public void removerPropriedade(Propriedade p) {
        this.propriedades.remove(p);
        atualizarEstatuto(); // Atualiza o estatuto ao remover propriedade
    }

    public void adicionarMembroFamilia(NPC npc) {
        this.familia.add(npc);
    }

    public void atualizarEstatuto() {
        this.estatuto = this.propriedades.stream()
                .mapToInt(Propriedade::getEstatuto)
                .sum();
    }

    private void hallShopping(Jogador jogador) {
        int escolha;
        do {
            System.out.println("\nPara qual seção você deseja ir?");
            System.out.println("1. Imobiliária (Imóveis)");
            System.out.println("2. Stand de Veículos (Veículos)");
            System.out.println("3. Fashion Outlet (Acessórios de Moda)");
            System.out.println("0. Sair do Shopping");
            System.out.print("Sua escolha: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Entrada inválida. Por favor, digite um número.");
                scanner.next(); // consome a entrada inválida
            }
            escolha = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha

            switch (escolha) {
                case 1:
                    imprimirSecao(Imovel.class, jogador);
                    break;
                case 2:
                    imprimirSecao(Veiculo.class, jogador);
                    break;
                case 3:
                    imprimirSecao(AcessorioModa.class, jogador);
                    break;
                case 0:
                    System.out.println("Saindo do Shopping. Volte sempre!");
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, escolha novamente.");
            }
        } while (escolha != 0);
    }

    private void imprimirSecao(Class<? extends Bens> tipoClasse, Jogador jogador) {
        ArrayList<Bens> itensDaSecao = filtrarItensPorTipo(tipoClasse);
        if (itensDaSecao.isEmpty()) {
            System.out.println("Não há itens nesta seção no momento.");
            return;
        }

        // Embaralha a lista e pega os primeiros 10 (ou menos, se houver menos de 10)
        Collections.shuffle(itensDaSecao);
        int numItensExibir = Math.min(10, itensDaSecao.size());

        System.out.println("\n--- Itens Disponíveis na Seção de " + tipoClasse.getSimpleName() + " ---");
        for (int i = 0; i < numItensExibir; i++) {
            Propriedade item = itensDaSecao.get(i);
            String detalhes = "";
            if (item instanceof Imovel) {
                Imovel imovel = (Imovel) item;
                detalhes = " (Capacidade: " + imovel.getCapacidadePessoas() + ")";
            } else if (item instanceof Veiculo) {
                Veiculo veiculo = (Veiculo) item;
                detalhes = " (Marca: " + veiculo.getMarca() + ", Modelo: " + veiculo.getModelo() + ")";
            } else if (item instanceof AcessorioModa) {
                AcessorioModa acessorio = (AcessorioModa) item;
                detalhes = " (Marca: " + acessorio.getMarca() + ", Formal: " + (acessorio.isFormal() ? "Sim" : "Não") + ")";
            }
            System.out.printf("%d. %s - %.2f€ (Estatuto: %d)%s\n", (i + 1), item.getNome(), item.getCusto(), item.getEstatuto(), detalhes);
        }

        System.out.println("0. Voltar");
        System.out.print("Escolha o número do item que deseja comprar ou 0 para voltar: ");
        int escolhaItem;
        while (!scanner.hasNextInt()) {
            System.out.println("Entrada inválida. Por favor, digite um número.");
            scanner.next();
        }
        escolhaItem = scanner.nextInt();
        scanner.nextLine();

        if (escolhaItem > 0 && escolhaItem <= numItensExibir) {
            Propriedade itemEscolhido = itensDaSecao.get(escolhaItem - 1);
            comprarItem(jogador, itemEscolhido);
        } else if (escolhaItem != 0) {
            System.out.println("Escolha inválida.");
        }
    }

    private ArrayList<Propriedade> filtrarItensPorTipo(Class<? extends Propriedade> tipoClasse) {
        return coisasParaComprar.stream()
                .filter(tipoClasse::isInstance)
                .collect(Collectors.toCollection(ArrayList::new));
    }


    private void comprarItem(Jogador jogador, Propriedade item) {
        if (jogador.getDinheiro() >= item.getCusto()) {
            jogador.setDinheiro(jogador.getDinheiro() - item.getCusto());
            jogador.adicionarPropriedade(item);
            // Remover do estoque do shopping se for um item "único" ou se o estoque é limitado
            coisasParaComprar.remove(item);
            System.out.printf("Parabéns! Você comprou %s por %.2f€.\n", item.getNome(), item.getCusto());
            System.out.printf("Dinheiro restante: %.2f€\n", jogador.getDinheiro());
        } else {
            System.out.println("Você não tem dinheiro suficiente para comprar " + item.getNome() + ".");
        }
    }

}
