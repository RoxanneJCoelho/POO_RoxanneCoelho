package POO_RoxanneCoelho.Sims;

import POO_RoxanneCoelho.Bens.Imovel;
import POO_RoxanneCoelho.Bens.Shopping;
import POO_RoxanneCoelho.Pessoa.CatalogoNPC;
import POO_RoxanneCoelho.Pessoa.Jogador;
import POO_RoxanneCoelho.Enums.ObjetivoVida;
import POO_RoxanneCoelho.Profissao.CatalogoProfissao;

import java.util.Scanner;


public class Sims {
    private Jogador jogador;
    private Shopping shopping;
    private CatalogoProfissao catalogoProfissao;
    private CatalogoNPC catalogoNPC;

    public Sims(Shopping shopping, CatalogoProfissao catalogoProfissao, CatalogoNPC catalogoNPC) {
        this.shopping = shopping;
        this.catalogoProfissao = catalogoProfissao;
        this.catalogoNPC = catalogoNPC;
    }

    public void criarPessoa() {
        Scanner input = new Scanner(System.in);
        System.out.println("******** Bem vind@ ao Jogo de Sims da Roxie! ********");
        System.out.println("Crie a sua personagem!");

        System.out.print("Nome: ");
        String nome = input.nextLine();

        ObjetivoVida objetivo;
        int opcao;

        do {
            System.out.println("Escolhe o teu objetivo de vida:");
            System.out.println("1 - PROFESSOR UNIVERSITÁRIO");
            System.out.println("2 - CELEBRIDADE");
            System.out.println("3 - FAMÍLIA COMPLETA");
            System.out.println("4 - SER RICO");
            System.out.print("Insere o número correspondente: ");
            opcao = input.nextInt();

            switch (opcao) {
                case 1:
                    objetivo = ObjetivoVida.PROFESSOR_UNIVERSITARIO;
                    break;
                case 2:
                    objetivo = ObjetivoVida.CELEBRIDADE;
                    break;
                case 3:
                    objetivo = ObjetivoVida.FAMILIA_COMPLETA;
                    break;
                case 4:
                    objetivo = ObjetivoVida.SER_RICO;
                    break;
                default:
                    System.out.println("Opção inválida, tenta novamente.\n");
                    objetivo = null;
            }
        } while (objetivo == null);

        this.jogador = new Jogador (nome, 0, objetivo, null, 100, 100, 100, 0, 0);
        System.out.println("Personagem criada! Bem vind@, " + nome);
        this.shopping.setJogador(this.jogador);
    }


    public void jogo() {
        Jogador jogador = this.jogador;
        Scanner input = new Scanner(System.in);
        int dia = 1;

        while (dia < 100) {
            System.out.println("Dia nº " + dia);
            String[] momentoDia = {"Manhã", "Meio-dia", "Tarde", "Noite"};
            for (String momento : momentoDia) {
                System.out.println("Momento do dia: " + momento);
                jogador.mostrarDetalhes();
                System.out.println("O que queres fazer?");
                System.out.println("1 - Ir trabalhar");
                System.out.println("2 - Dormir");
                System.out.println("3 - Ter uma refeição");
                System.out.println("4 - Falar com alguém / Jogar Computador / Praticar Hobby");
                System.out.println("5 - Ir ao Shopping");
                System.out.println("6 - Ter formação");
                System.out.println("7 - Mostrar propriedades");
                System.out.println("8 - Procurar outra profissao");
                System.out.println("0 - Sair do jogo");
                System.out.println("Insira uma opção: ");

                int opcao = input.nextInt();

                switch (opcao) {
                    case 1:
                        jogador.setDinheiro(jogador.getDinheiro() + jogador.getProfissao().getSalarioDia());
                        System.out.println("Ganhou " + jogador.getProfissao().getSalarioDia() + " euros.");
                        break;
                    case 2:
                        jogador.setNecessidadeSono(125);
                        break;
                    case 3:
                        jogador.setNecessidadeRefeicao(120);
                        jogador.setDinheiro(jogador.getDinheiro() - 5);
                        break;
                    case 4:
                        jogador.setNecessidadeSocial(115);
                        break;
                    case 5:
                        shopping.vender();
                        break;
                    case 6:
                        jogador.setEscolaridade(jogador.getEscolaridade() + 2);
                        break;
                    case 7:
                        System.out.println("Propriedades:");
                        jogador.mostrarDetalhes();
                        break;
                    case 8:
                        catalogoProfissao.trocarProfissao(this.jogador);
                        break;
                    case 0:
                        System.out.println("A sair do jogo...");
                        return;
                    default:
                        System.out.println("Opção inválida.");
                }
                // Diminuir necessidades
                jogador.setNecessidadeSono(jogador.getNecessidadeSono() - 25);
                jogador.setNecessidadeRefeicao(jogador.getNecessidadeRefeicao() - 20);
                jogador.setNecessidadeSocial(jogador.getNecessidadeSocial() - 15);
            }

            dia++;

            // Evento obrigatório no dia 5: universidade
            if (dia == 5) {
                System.out.println("Deseja ir para a universidade? (s/n)");
                String escolhaUni = input.next().toLowerCase();

                if (escolhaUni.equals("s")) {
                    jogador.setEscolaridade(jogador.getEscolaridade() + 50);
                    jogador.setDinheiro(jogador.getDinheiro() - 3000);
                    System.out.println("Inscreveu-se na universidade. Educação aumentou, mas contraiu uma dívida de 3000.");
                } else {
                    System.out.println("Decidiu não ir para a universidade.");
                }
            }

            // Evento do dia 22: casamento


            // Evento que vai do dia 22 ao 60: filhos

            // Evento á nossa escolha nº1: acidente de carro!
            if (dia == 30) {
                System.out.println("Tiveste um acidente de carro, vais ter uma despesa grande para arranjar o carro!");
                jogador.setDinheiro(jogador.getDinheiro() - 300);
            }

            // Evento á nossa escolha nº2: heranca
            if (dia == 50) {
                System.out.println("Ganhaste de herança um apartamento!");

                // Criar o apartamento herdado
                Imovel apartamento = new Imovel(90, "Apartamento de herança", 0, 20, 3); // nome, custo, estatuto

                // Adicionar à lista de bens do jogador
                jogador.adicionarBem(apartamento);

                // Aumentar o estatuto do jogador com o valor do imóvel
                jogador.setEstatuto(jogador.getEstatuto() + apartamento.getEstatuto());

                System.out.println("Estatuto aumentado! Novo estatuto: " + jogador.getEstatuto());
            }

            // Evento á nossa escolha nº3: jogar no euromilhoes
            if (dia == 35) {
                System.out.println("Evento especial: Euromilhões!");

                if (jogador.getDinheiro() >= 10) {
                    jogador.setDinheiro(jogador.getDinheiro() - 10);
                    System.out.println("Pagou 10€ para jogar no Euromilhões.");

                    System.out.print("Escolhe um número entre 1 e 200: ");
                    int numeroJogador = input.nextInt();

                    int numeroSorteado = (int) (Math.random() * 200) + 1;

                    if (numeroJogador == numeroSorteado) {
                        jogador.setDinheiro(jogador.getDinheiro() + 1_000_000);
                        System.out.println("Parabéns!!! Ganhou 1.000.000€!");
                    } else {
                        System.out.println("Não foi desta vez. O número sorteado foi: " + numeroSorteado);
                    }

                } else {
                    System.out.println("Dinheiro insuficiente para jogar no Euromilhões.");
                }
            }

            // Exemplo: Dia 10 - Festa surpresa
            if (dia == 10) {
                System.out.println("Foste a uma festa surpresa com amigos! +10 à necessidade social.");
                jogador.setNecessidadeSocial(Math.min(jogador.getNecessidadeSocial() + 10, 100));
            }

            // Exemplo: Dia 15 - Doença leve
            if (dia == 15) {
                System.out.println("Apanhaste uma doença leve. Precisas de descansar.");
                jogador.setNecessidadeSono(jogador.getNecessidadeSono() - 20);
            }

            // Exemplo: Dia 25 - Compra de carro
            if (dia == 25) {
                double precoCarro = 10000;
                System.out.println("Oportunidade de comprar um carro por " + precoCarro + " euros. Queres comprar? (1-Sim / 0-Não)");
                int opcao = input.nextInt();
                if (opcao == 1 && jogador.getDinheiro() >= precoCarro) {
                    jogador.setDinheiro(jogador.getDinheiro() - precoCarro);
                    jogador.setEstatuto(jogador.getEstatuto() + 15);
                    System.out.println("Compraste um carro! +15 ao estatuto.");
                } else {
                    System.out.println("Não compraste o carro.");
                }
            }


        }


    }

}

