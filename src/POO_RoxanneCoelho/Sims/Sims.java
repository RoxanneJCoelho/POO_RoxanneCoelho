package POO_RoxanneCoelho.Sims;

import POO_RoxanneCoelho.Bens.Shopping;
import POO_RoxanneCoelho.Pessoa.Jogador;
import POO_RoxanneCoelho.Profissao.Profissao;
import POO_RoxanneCoelho.Enums.ObjetivoVida;
import java.util.Scanner;

public class Sims {

    private Jogador jogador;
    private Shopping shopping;

    public Sims() {
        this.shopping = new Shopping();
        shopping.adicionarImoveis();
        shopping.adicionarVeiculos();
        shopping.adicionarAcessoriosModa();
    }

    public void criarPessoa() {
        Scanner input = new Scanner(System.in);

        System.out.print("Insira o nome da pessoa: ");
        String nome = input.nextLine();

        System.out.print("Escolha o objetivo de vida (FAMA, RIQUEZA, CONHECIMENTO): ");
        ObjetivoVida objetivo = ObjetivoVida.valueOf(input.nextLine().toUpperCase());

        System.out.print("Escolha a profissão (nome apenas, salário será definido automaticamente): ");
        String nomeProfissao = input.nextLine();
        Profissao profissao = new Profissao(nomeProfissao, 100, false, 0, 0); // exemplo

        jogador = new Jogador(nome, 0, objetivo, profissao, 100, 100, 100, 0, 0);
        System.out.println("Jogador criado com sucesso!\n");
    }

    public void jogo() {
        Scanner input = new Scanner(System.in);
        int dia = 1;

        while (true) {
            System.out.println("Dia " + dia);

            for (String momento : new String[]{"Manhã", "Meio-dia", "Tarde", "Noite"}) {
                System.out.println("\nMomento do dia: " + momento);

                // Necessidades abaixo de 25 bloqueiam outras ações
                if (jogador.getNecessidadeSono() < 25) {
                    System.out.println("Está demasiado cansado. Precisa de dormir.");
                    jogador.setNecessidadeSono(100);
                    continue;
                }
                if (jogador.getNecessidadeRefeicao() < 25) {
                    System.out.println("Está com fome. Precisa de comer.");
                    jogador.setNecessidadeRefeicao(100);
                    jogador.setDinheiro(jogador.getDinheiro() - 5);
                    continue;
                }
                if (jogador.getNecessidadeSocial() < 25) {
                    System.out.println("Está carente. Precisa socializar.");
                    jogador.setNecessidadeSocial(100);
                    continue;
                }

                System.out.println("""
                        Escolha uma ação:
                        1. Ir trabalhar
                        2. Dormir
                        3. Ter uma refeição
                        4. Socializar
                        5. Ir às compras
                        6. Ter formação
                        7. Visitar propriedades
                        8. Procurar nova profissão
                        0. Sair do jogo
                        """);
                int escolha = input.nextInt();

                switch (escolha) {
                    case 1:
                        jogador.setDinheiro(jogador.getDinheiro() + jogador.getProfissao().getSalarioDia());
                        System.out.println("Ganhou " + jogador.getProfissao().getSalarioDia() + " dinheiros.");
                        break;
                    case 2:
                        jogador.setNecessidadeSono(100);
                        break;
                    case 3:
                        jogador.setNecessidadeRefeicao(100);
                        jogador.setDinheiro(jogador.getDinheiro() - 5);
                        break;
                    case 4:
                        jogador.setNecessidadeSocial(100);
                        break;
                    case 5:
                        shopping.hallShopping(jogador);
                        break;
                    case 6:
                        jogador.setEducacao(jogador.getEducacao() + 2);
                        break;
                    case 7:
                        System.out.println("Propriedades:");
                        for (var b : jogador.getBensMateriais()) {
                            System.out.println(b);
                        }
                        break;
                    case 8:
                        System.out.println("Funcionalidade de nova profissão ainda por implementar.");
                        break;
                    case 0:
                        System.out.println("A sair do jogo...");
                        return;
                    default:
                        System.out.println("Opção inválida.");
                }
            }

            // Diminuir necessidades
            jogador.setNecessidadeSono(jogador.getNecessidadeSono() - 25);
            jogador.setNecessidadeRefeicao(jogador.getNecessidadeRefeicao() - 20);
            jogador.setNecessidadeSocial(jogador.getNecessidadeSocial() - 15);

            dia++;
        }
    }
}

