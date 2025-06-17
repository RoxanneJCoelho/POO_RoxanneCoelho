package POO_RoxanneCoelho.Bens;

import POO_RoxanneCoelho.Pessoa.Jogador;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Representa o shopping, que tem itens para o jogador visualizar e comprar, com atributos como Jogador e um ArrayList de Bens do Shopping.
 */

public class Shopping {
    private Jogador jogador;
    private ArrayList<Bens> coisasParaComprar;

    /**
     * Construtor do Shopping.
     * O jogador não é construído neste construtor porque ele é criado depois de inicializar o programa no método criarPessoa()
     */

    public Shopping() {
        this.coisasParaComprar = new ArrayList<Bens>(); // inicializa
    }

    // Setters

    /**
     * Definir o jogador que interage com o shopping
     * Permite que o shopping tenha acesso aos atributos do jogador e que possa efetuar compras
     *
     * @param jogador o jogador que interage com o shopping
     */

    public void setJogador(Jogador jogador) {
        this.jogador = jogador;
    }

    // Outros métodos

    /**
     * Adicionar um bem á lista de bens disponíveis para compra no shopping.
     *
     * @param bens o bem disponível para compra no shopping
     */

    public void adicionarItem(Bens bens) {
        this.coisasParaComprar.add(bens);
    }

    /**
     * Mostrar todos os bens do tipo Imovel disponíveis para compra e no final imprime a pergunta pelo ID a comprar ( ou imprimir zero para voltar).
     */

    public void mostrarImoveis() {
        for (Bens bens : coisasParaComprar) {
            if (bens instanceof Imovel) {
                bens.mostrarDetalhesBens();
                System.out.println();

            }
        }
        System.out.print("Insira o ID do imóvel para comprar (ou prima 0 para voltar): ");
    }

    /**
     * Mostra todos os bens do tipo Veículo disponíveis para compra e no final imprime a pergunta pelo ID a comprar ( ou imprimir zero para voltar).
     */

    public void mostrarVeiculo() {
        for (Bens bens : coisasParaComprar) {
            if (bens instanceof Veiculo) {
                bens.mostrarDetalhesBens();
                System.out.println();
            }
        }
        System.out.print("Insira o ID do veículo para comprar (ou prima 0 para voltar): ");
    }

    /**
     * Mostrar todos os bens do tipo AcessorioModa disponíveis para compra e no final imprime a pergunta pelo ID a comprar ( ou imprimir zero para voltar).
     */

    public void mostrarAcessorio() {
        for (Bens bens : coisasParaComprar) {
            if (bens instanceof AcessorioModa) {
                bens.mostrarDetalhesBens();
                System.out.println();
            }
        }
        System.out.print("Insira o ID do acessório para comprar (ou prima 0 para voltar): ");
    }

    /**
     * Executar a compra do bem pelo jogador
     */

    public void comprarBem() {
        Scanner input = new Scanner(System.in);
        int idCompra = input.nextInt(); // se imprimir zero ele regressa ao menu
        if (idCompra == 0) {
            return; // quebra a função
        }
        for (Bens bens : this.coisasParaComprar) {
            if (bens.getId() == idCompra) { // se o id do bem for igual ao idCompra (item disponível), buscamos o preço do mesmo
                double preco = bens.getCusto();

                if (this.jogador.getDinheiro() >= preco) { // se tiver dinheiro suficiente para a compra
                    this.jogador.setDinheiro(this.jogador.getDinheiro() - preco); // retira dinheiro
                    this.jogador.adicionarBem(bens); // adiciona ao arrays de bens do jogador
                    this.jogador.setEstatuto(this.jogador.getEstatuto() + bens.getEstatuto()); // aumenta o estatuto do jogador
                    System.out.println("Parabéns! Comprou " + bens.getNome()); // aparece esta mensagem de confirmação
                } else { // se não tiver dinheiro suficiente
                    System.out.println("Desculpa, mas não tens dinheiro suficiente para comprar " + bens.getNome());
                }
                return; // quebra a função
            }
        }
        // se nenhum bem com o idCompra foi encontrado, aparece esta mensagem
        System.out.println("ID não encontrado.");
    }

    /**
     * Mostra as opções de visualização dos bens do shopping e permite comprar
     */

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
                    comprarBem();
                    break;
                case 2:
                    mostrarVeiculo();
                    comprarBem();
                    break;
                case 3:
                    mostrarAcessorio();
                    comprarBem();
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


