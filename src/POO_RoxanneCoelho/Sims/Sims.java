package POO_RoxanneCoelho.Sims;

import POO_RoxanneCoelho.Bens.Imovel;
import POO_RoxanneCoelho.Bens.Shopping;
import POO_RoxanneCoelho.Pessoa.CatalogoNPC;
import POO_RoxanneCoelho.Pessoa.Jogador;
import POO_RoxanneCoelho.Enums.ObjetivoVida;
import POO_RoxanneCoelho.Pessoa.NPC;
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

    ObjetivoVida objetivo;

    public void criarPessoa() {
        Scanner input = new Scanner(System.in);
        System.out.println("******** Bem vind@ ao Jogo de Sims da Roxie! ********");
        System.out.println("Crie a sua personagem!");

        System.out.print("Nome: ");
        String nome = input.nextLine();


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

        this.jogador = new Jogador(nome, 0, objetivo, null, 100, 100, 100, 0, 0, false);
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

            if (jogador.isCasado()) {
                jogador.setDinheiro(jogador.getDinheiro() + 30);
            }

            // Custo diário por membro da família (reveeeer istoooooo)
            int custoFamilia = jogador.getFamiliaSize() * 10;
            jogador.setDinheiro(jogador.getDinheiro() - custoFamilia);
            System.out.println("Pagaste " + custoFamilia + " euros para sustentar a tua família.");
            jogador.retirarFilhos();


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

                if (jogador.getNecessidadeRefeicao() < 25) {
                    do {
                        System.out.println("Estas com fome, vai comer! Escolhe a opção 3: ");
                        opcao = input.nextInt();
                    } while (opcao != 3);
                    jogador.setNecessidadeRefeicao(120);
                    jogador.setDinheiro(jogador.getDinheiro() - 5);
                } else if (jogador.getNecessidadeSono() < 25) {
                    do {
                        System.out.println("Estas com sono, vai dormir! Escolhe a opção 2: ");
                        opcao = input.nextInt();
                    } while (opcao != 2);
                    jogador.setNecessidadeSono(125);
                } else if (jogador.getNecessidadeSocial() < 25) {
                    do {
                        System.out.println("Sai do buraco e vai socializar! Escolhe a opção 4: ");
                        opcao = input.nextInt();
                    } while (opcao != 4);
                    jogador.setNecessidadeSocial(115);
                } else if (jogador.isCasado() && dia <= 60) {
                    System.out.println("9 - Ter ou Adotar Filho");
                }

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
                    case 9:
                        if (jogador.isCasado() && dia <= 60) {
                            int capacidadeAtual = jogador.getCapacidadeImovel();
                            int membrosFamilia = jogador.getFamiliaSize();

                            if (membrosFamilia + 1 <= capacidadeAtual) {
                                NPC filho = new NPC("Filho(a)", 0, 100, 0); // Nome genérico; podes personalizar
                                jogador.adicionarFamilia(filho);
                                System.out.println("Parabéns! Adicionaste um novo filho à tua família.");
                            } else {
                                System.out.println("Não tens espaço suficiente nas propriedades para acolher um filho.");
                            }
                        } else {
                            System.out.println("Esta opção não está disponível.");
                        }
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
                System.out.println("Deseja ir para a universidade?");
                System.out.println(" 1 - Sim");
                System.out.println(" 2 - Não");
                int opcao = input.nextInt();

                if (opcao == 1) {
                    jogador.setEscolaridade(jogador.getEscolaridade() + 50);
                    jogador.setDinheiro(jogador.getDinheiro() - 3000);
                    System.out.println("Inscreveu-se na universidade. Educação aumentou 50 pontos, mas contraiu uma dívida de 3000 euros.");
                } else {
                    System.out.println("Decidiu não ir para a universidade.");
                }
            }

            // Evento obrigatório no dia 22: casamento
            if (dia == 22) {
                System.out.println("Deseja casar?");
                System.out.println(" 1 - Sim");
                System.out.println(" 2 - Não");
                int opcao = input.nextInt();

                this.jogador.ImovelValido();

                if (opcao == 1) {
                    System.out.println("Eis os seus pretendentes: ");
                    catalogoNPC.imprimirNPC();
                    System.out.println("Com quem deseja casar? Insira o ID da pessoa: ");
                    int idNPC = input.nextInt();
                    catalogoNPC.casar(idNPC, this.jogador);
                } else {
                    System.out.println("Decidiu não se casar.");
                }
            }


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
    public void cumprirObjetivoVida() {
        if ((objetivo == ObjetivoVida.PROFESSOR_UNIVERSITARIO && this.jogador.getProfissao().getNome().equals("Professor Universitário")) ||
                (objetivo == ObjetivoVida.CELEBRIDADE && this.jogador.getEstatuto() >= 100) ||
                (objetivo == ObjetivoVida.SER_RICO && this.jogador.getDinheiro() >= 5000) ||
                (objetivo == ObjetivoVida.FAMILIA_COMPLETA && this.jogador.getFamiliaSize() >= 5)) {
            System.out.println("Parabéns! Cumpriste o teu objetivo de Vida");
        } else if (jogador.getDinheiro() < 0) {
            System.out.println("Perdeste o jogo por ter ficado com dividas! ");
        } else {
            Scanner input = new Scanner(System.in);
            int opcao;
            do {
                System.out.println("Não atingiste o teu objetivo. O que queres fazer?");
                System.out.println("1 - Voltar a jogar com a mesma personagem");
                System.out.println("2 - Criar nova personagem");
                System.out.println("3 - Sair do jogo");
                opcao = input.nextInt();

                switch (opcao) {
                    case 1:
                        jogo();
                        break; // volta ao menu
                    case 2:
                        criarPessoa();
                        jogo();
                        break; // volta ao menu
                    case 3:
                        System.out.println("A sair do jogo");
                        break; // sai do switch e do while
                    default:
                        System.out.println("Número não reconhecido");
                }

            } while (opcao != 3); // o ciclo só termina se a opção for 3
        }
    }
}

