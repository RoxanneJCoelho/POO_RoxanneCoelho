package POO_RoxanneCoelho.Sims;

import POO_RoxanneCoelho.Bens.Imovel;
import POO_RoxanneCoelho.Bens.Shopping;
import POO_RoxanneCoelho.Bens.Veiculo;
import POO_RoxanneCoelho.Pessoa.CatalogoNPC;
import POO_RoxanneCoelho.Pessoa.Jogador;
import POO_RoxanneCoelho.Enums.ObjetivoVida;
import POO_RoxanneCoelho.Pessoa.NPC;
import POO_RoxanneCoelho.Profissao.CatalogoProfissao;

import java.util.Scanner;
import java.util.Random;

/**
 * Representa uma simulação de jogo estilo Sims, com atributos como Jogador, Shopping, CatalogoProfissao, CatalogoNPC e objetivoVida.
 */

public class Sims {
    private Jogador jogador;
    private Shopping shopping;
    private CatalogoProfissao catalogoProfissao;
    private CatalogoNPC catalogoNPC;
    private ObjetivoVida objetivo;

    /**
     * Construtor da classe Sims
     *
     * @param shopping          o shopping onde o jogador poderá fazer compras
     * @param catalogoProfissao a lista de profissões disponíveis
     * @param catalogoNPC       a lista de NPCs disponíveis
     */

    public Sims(Shopping shopping, CatalogoProfissao catalogoProfissao, CatalogoNPC catalogoNPC) {
        this.shopping = shopping;
        this.catalogoProfissao = catalogoProfissao;
        this.catalogoNPC = catalogoNPC;
    }

    /**
     * Criar um novo jogador
     */

    public void criarPessoa() {
        Scanner input = new Scanner(System.in);
        System.out.println("******** Bem vind@ ao Jogo de Sims da Roxie! ********");
        System.out.println("Crie a sua personagem!");

        System.out.print("Nome: "); // Nome do jogador
        String nome = input.nextLine();

        int opcao;

        do { // enquanto o objetivo for nulo (não haver objetivo, ele vai perguntar qual o objetivo de Vida)
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

        // Jogador criado
        this.jogador = new Jogador(nome, 0, objetivo, null, 100, 100, 100, 0, 0, false);
        System.out.println("Personagem criada! Bem vind@, " + nome);
    }

    /**
     * Simula a vida de 100 dias do jogador
     */

    public void jogo() {
        Scanner input = new Scanner(System.in);
        int dia = 1; // comeca dia 1

        while (dia < 100) {
            String[] momentoDia = {"Manhã", "Meio-dia", "Tarde", "Noite"}; // o dia é dividido em 4 momentos

            int opcao;

            for (String momento : momentoDia) { // percorrer os momentos do dia
                System.out.println("\nDia nº " + dia);
                System.out.println("Momento do dia: " + momento +"\n");

                this.jogador.mostrarDetalhes(); // mostra o estador atual do jogador

                System.out.println("\nO que queres fazer?"); // mostra o menu
                System.out.println("1 - Ir trabalhar");
                System.out.println("2 - Dormir");
                System.out.println("3 - Ter uma refeição");
                System.out.println("4 - Falar com alguém / Jogar Computador / Praticar Hobby");
                System.out.println("5 - Ir ao Shopping");
                System.out.println("6 - Ter formação");
                System.out.println("7 - Mostrar propriedades");
                System.out.println("8 - Procurar outra profissao");
                if (this.jogador.isCasado() && dia <= 60) { // esta função só aparece se o jogador for casado e o dia for menor que 60
                    System.out.println("9 - Ter ou Adotar Filho");
                }
                System.out.println("0 - Sair do jogo");
                System.out.println("Insira uma opção: ");

                opcao = input.nextInt();

                switch (opcao) {
                    case 1:
                        this.jogador.setDinheiro(this.jogador.getDinheiro() + this.jogador.getProfissao().getSalarioDia());
                        System.out.println("Ganhou " + this.jogador.getProfissao().getSalarioDia() + " euros.");
                        break;
                    case 2:
                        this.jogador.dormir();
                        break;
                    case 3:
                        this.jogador.comerRefeicao();
                        this.jogador.pagarRefeicao();
                        break;
                    case 4:
                        this.jogador.socializar();
                        break;
                    case 5:
                        shopping.setJogador(this.jogador);
                        shopping.vender();
                        break;
                    case 6:
                        this.jogador.terFormacao();
                        break;
                    case 7:
                        System.out.println("Propriedades de " + this.jogador.getNome() + ":");
                        this.jogador.mostrarBensMateriais();
                        break;
                    case 8:
                        this.catalogoProfissao.trocarProfissao(this.jogador);
                        break;
                    case 9:
                        if (this.jogador.isCasado() && dia <= 60) {
                            int capacidadeAtual = jogador.getCapacidadeMaxima();
                            int membrosFamilia = jogador.getFamiliaSize();

                            if (membrosFamilia + 1 <= capacidadeAtual) { // se os membros da atual familia mais o futuro filho forem em numero menor que a capacidade do imovel
                                NPC npc = new NPC("Cria", 0, 100, 0); // cria um npc
                                jogador.adicionarFamilia(npc); // adiciona o npc á familia
                                System.out.println("Parabéns! Adicionaste um novo filho à tua família.");
                            } else {
                                System.out.println("Não tens espaço suficiente no imóvel para acolher um filho.");
                            }
                        }
                        break;
                    case 0:
                        System.out.println("A sair do jogo...");
                        return;
                    default:
                        System.out.println("Opção inválida.");
                }
                // Diminuir necessidades
                jogador.diminuirSono();
                jogador.diminuirRefeicao();
                jogador.diminuirSocial();

                // decidi separar os ifs para o máximo de funçoes serem abrangidas ao mesmo tempo

                // ifs sobre a vida de casado
                if (this.jogador.isCasado() && this.jogador.getFamiliaSize() >= 3) { // se o jogador é casado e tem 3 ou mais elementos na família calcula o custo Familia
                    this.jogador.custoFamilia();
                    System.out.println("Pagaste "+this.jogador.custoFamilia() + " para sustentar o teu lar");
                } else if (this.jogador.isCasado()) { // se for só casado, recebe o dinheiroCasado
                    this.jogador.dinheiroCasado();
                    System.out.println("Recebeste "+ this.jogador.dinheiroCasado() + " do teu casamento");
                }

                // ifs sobre as necessidades
                if (this.jogador.getNecessidadeRefeicao() < 25) { // se o jogador tiver com fome, enquanto não carregar a tecla 3 (ir comer), ficará no loop
                    do {
                        System.out.println("Estas com fome, vai comer! Escolhe a opção 3: ");
                        opcao = input.nextInt();
                    }
                    while (opcao != 3);

                    this.jogador.comerRefeicao(); // ao carregar em 3, ele come
                    this.jogador.pagarRefeicao(); // depois paga

                } else if (this.jogador.getNecessidadeSono() < 25) { // se o jogador tiver com sono, enquanto não carregar a tecla 2 (ir dormir), ficará no loop
                    do {

                        System.out.println("Estas com sono, vai dormir! Escolhe a opção 2: ");
                        opcao = input.nextInt();

                    } while (opcao != 2);

                    this.jogador.dormir(); // ao carregar em 2, ele dorme

                } else if (this.jogador.getNecessidadeSocial() < 25) { // se o jogador tiver com energia social, enquanto não carregar a tecla 4 (ir socializar), ficará no loop
                    do {
                        System.out.println("Sai do buraco e vai socializar! Escolhe a opção 4: ");
                        opcao = input.nextInt();
                    } while (opcao != 4);

                    this.jogador.socializar(); // ao carregar em 4 ele vai socializar
                }
                // if sobre os filhos
                if (this.jogador.getDinheiro() <= -3250) {
                    this.jogador.retirarFilhos();
                }
            }

            dia++;

            // Evento obrigatório no dia 5: universidade
            if (dia == 5) {
                System.out.println("Queres ir para a universidade?");
                System.out.println("1 - Sim");
                System.out.println("2 - Não");
                System.out.println("Insira uma opção: ");
                opcao = input.nextInt();
                input.nextLine();

                switch (opcao) {
                    case 1:
                        jogador.setEscolaridade(jogador.getEscolaridade() + 50); // ganhou 50 pontos de escolaridade
                        jogador.setDinheiro(jogador.getDinheiro() - 3000); // perdeu 3000 euros
                        System.out.println("Inscreveste-se na universidade!");
                        break;
                    case 2:
                        System.out.println("Decidiste não ir para a universidade.");
                        break;
                    default:
                        System.out.println("Opção não reconhecida");

                }
            }

            // Evento obrigatório no dia 22: casamento
            if (dia == 22) {
                System.out.println("Queres casar?");
                System.out.println(" 1 - Sim");
                System.out.println(" 2 - Não");
                opcao = input.nextInt();


                switch (opcao) {
                    case 1:
                        if (this.jogador.ImovelValido()) { // se tiver um imovel com capacidade para 2 pessoas, mostra a lista de npcs
                            System.out.println("Eis os seus pretendentes: ");
                            catalogoNPC.imprimirNPC();
                            System.out.println("Com quem deseja casar? Insira o ID da pessoa: ");
                            int idNPC = input.nextInt();
                            catalogoNPC.casar(idNPC, this.jogador);
                        } else {
                            System.out.println("Não tem propriedade para casar!");
                        }
                        break;
                    case 2:
                        System.out.println("Decidiste não te casar.");
                        break;
                    default:
                        System.out.println("Opção não reconhecida.");
                }

            }

            // Evento á nossa escolha nº1: acidente de carro
            if (dia == 14) {
                System.out.println("Tiveste um acidente de carro, vais ter uma despesa grande para arranjar o carro!");
                jogador.setDinheiro(jogador.getDinheiro() - 300);
            }

            // Evento á nossa escolha nº2: heranca
            if (dia == 15) {
                System.out.println("Ganhaste de herança um apartamento!");
                Imovel apartamento = new Imovel(90, "Apartamento de herança", 0, 200, 3); // novo imovel
                jogador.adicionarBem(apartamento); // adicionar á lista de bens do jogador
                jogador.setEstatuto(jogador.getEstatuto() + apartamento.getEstatuto()); // aumenta estatuto
            }

            // Evento á nossa escolha nº3: jogar no euromilhoes
            if (dia == 26) {
                System.out.println("Foste com o teu pai jogar ao euromilhões, apesar de não achares muita piada a jogos de azar.");

                if (jogador.getDinheiro() >= 6) { // se tiver dinheiro para pagar, joga
                    jogador.setDinheiro(jogador.getDinheiro() - 6);
                    System.out.println("Pagaste 6 € para jogar no euromilhões.");

                    System.out.print("Escolhe um número inteiro entre 1 e 200: ");
                    int numeroJogador = input.nextInt();

                    Random rd = new Random();

                    int numeroSorteado = rd.nextInt(1, 200);

                    if (numeroJogador == numeroSorteado) { // se acertar ganha 1 milhao, senão mostra o numero sorteado
                        jogador.setDinheiro(jogador.getDinheiro() + 1000000);
                        System.out.println("Parabéns!!! Ganhaste 1 milhão yaaaaaay!");
                    } else {
                        System.out.println("Não foi desta vez. O número sorteado foi: " + numeroSorteado);
                    }
                } else {
                    System.out.println("Não tens dinheiro suficiente para jogar no euromilhões.");
                }
            }

            // Evento á nossa escolha nº4: fazer festinhas nos Gatinhos da Ecovia da Povoa
            if (dia == 37) {
                System.out.println("Encontraste um gatinho da Póvoa pelo caminho, ganhaste uma bomba de energia social!");
                this.jogador.gatinhoPovoa();

            }

            // Evento á nossa escolha nº5: ficar de cama
            if (dia == 48) {
                System.out.println("Oh não, deu-te uma diarreira muito grande. Vais ficar uns dias de cama...");
                this.jogador.cama();
            }

            // Evento á nossa escolha nº6: comprar um carro na promoção
            if (dia == 49) {
                Veiculo carroPrenda = new Veiculo(55, "Carro Desconto", 500, 15, "Ford", "500");

                System.out.println("Oportunidade de comprar um carro por " + carroPrenda.getCusto() + " euros. Queres comprar?");
                System.out.println("1 - Sim");
                System.out.println("2 - Não");
                int opcao1 = input.nextInt();

                switch (opcao1) {
                    case 1:
                        if (jogador.getDinheiro() >= carroPrenda.getCusto()) {
                            jogador.setDinheiro(jogador.getDinheiro() - carroPrenda.getCusto());
                            jogador.setEstatuto(jogador.getEstatuto() + 15);
                            System.out.println("Compraste um carro!");
                        } else {
                            System.out.println("Não tens dinheiro para comprar o carro.");
                        }
                        break;
                    case 2:
                        System.out.println("Decidiste não comprar o carro.");
                        break;
                    default:
                        System.out.println("Opção não reconhecida.");

                }
            }
        }
    }

    /**
     * Avalia se o objetivo de vida foi cumprido
     */

    public void cumprirObjetivoVida() {
        if (jogador.getDinheiro() < 0) { // o jogador não pode ficar com dívidas, senão ele automaticamente perde
            System.out.println("Perdeste o jogo por teres ficado com dividas! ");
        } else if ((objetivo == ObjetivoVida.PROFESSOR_UNIVERSITARIO && this.jogador.getProfissao().getNome().equals("Professor Universitário")) ||
                (objetivo == ObjetivoVida.CELEBRIDADE && this.jogador.getEstatuto() >= 300) ||
                (objetivo == ObjetivoVida.SER_RICO && this.jogador.getDinheiro() >= 5000) ||
                (objetivo == ObjetivoVida.FAMILIA_COMPLETA && this.jogador.getFamiliaSize() >= 5)) {
            System.out.println("Parabéns! Cumpriste o teu objetivo de Vida"); // se ele cumprir aparece mensagem de parabens
        } else { // se não ganhar, dá para escolher entre voltar a jogar com a mesma personagem, criar nova personagem ou sair
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
                        break;
                    case 2:
                        criarPessoa();
                        jogo();
                        break;
                    case 3:
                        System.out.println("A sair do jogo...");
                        break;
                    default:
                        System.out.println("Opção não reconhecida");
                }

            } while (opcao != 3);
        }
    }
}


