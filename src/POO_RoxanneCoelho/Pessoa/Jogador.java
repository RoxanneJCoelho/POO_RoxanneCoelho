package POO_RoxanneCoelho.Pessoa;

import POO_RoxanneCoelho.Bens.Bens;
import POO_RoxanneCoelho.Bens.AcessorioModa;
import POO_RoxanneCoelho.Enums.ObjetivoVida;
import POO_RoxanneCoelho.Profissao.Profissao;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Representa o jogador (uma subclasse de Pessoa), com atributos como objetivo de Vida, profissão, necessidades (Sono, Social, Refeicao), estatuto, escolaridade, lista de bens materiais e família do jogador.
 */

public class Jogador extends Pessoa {
    private ObjetivoVida objetivoVida;
    private Profissao profissao;
    private int necessidadeSono;
    private int necessidadeRefeicao;
    private int necessidadeSocial;
    private int estatuto;
    private int escolaridade;
    private ArrayList<Bens> bensMateriais;
    private ArrayList<NPC> familiaJogador;

    /**
     * Construtor da classe Jogador.
     *
     * @param nome                o nome do jogador
     * @param dinheiro            a quantidade de dinheiro que o jogador possui
     * @param objetivoVida        o objetivo de vida escolhido pelo utilizador para o jogador
     * @param profissao           a quantidade de dinheiro que o jogador possui
     * @param necessidadeSono     a quantidade de energia que o jogador possui (100 significa energia total, 0 significa sem energia)
     * @param necessidadeRefeicao a quantidade de comida que o jogador possui (100 significa totalmente alimentado, 0 significa com fome)
     * @param necessidadeSocial   a quantidade de socialização que o jogador possui (100 significa totalmente socializado, 0 significa deprimido)
     * @param estatuto            o nível de estatuto do jogador
     * @param escolaridade        o nível de escolaridade do jogador
     */

    public Jogador(String nome, double dinheiro, ObjetivoVida objetivoVida, Profissao profissao, int necessidadeSono, int necessidadeRefeicao, int necessidadeSocial, int estatuto, int escolaridade) {
        super(nome, dinheiro);
        this.objetivoVida = objetivoVida;
        this.profissao = profissao;
        this.necessidadeSono = necessidadeSono;
        this.necessidadeRefeicao = necessidadeRefeicao;
        this.necessidadeSocial = necessidadeSocial;
        this.estatuto = estatuto;
        this.escolaridade = escolaridade;
        this.bensMateriais = new ArrayList<Bens>();
        this.familiaJogador = new ArrayList<NPC>();
    }

    // Getters

    /**
     * Obter o objetivo de Vida do jogador.
     *
     * @return o objetivo de Vida do jogador
     */
    public ObjetivoVida getObjetivoVida() {
        return objetivoVida;
    }

    /**
     * Obter a profissão do jogador.
     *
     * @return a profissão do jogador
     */
    public Profissao getProfissao() {
        return profissao;
    }

    /**
     * Obter a necessidade de sono do jogador.
     *
     * @return a necessidade de sono do jogador
     */
    public int getNecessidadeSono() {
        return necessidadeSono;
    }

    /**
     * Obter a necessidade de refeição do jogador.
     *
     * @return a necessidade de refeição do jogador
     */
    public int getNecessidadeRefeicao() {
        return necessidadeRefeicao;
    }

    /**
     * Obter a necessidade social do jogador.
     *
     * @return a necessidade social do jogador
     */
    public int getNecessidadeSocial() {
        return necessidadeSocial;
    }

    /**
     * Obter o nível de estatuto do jogador.
     *
     * @return o nível de estatuto do jogador
     */
    public int getEstatuto() {
        return estatuto;
    }

    /**
     * Obter o nível de escolaridade do jogador.
     *
     * @return o nível de escolaridade do jogador
     */
    public int getEscolaridade() {
        return escolaridade;
    }

    // Setters

    /**
     * Atualizar o objetivo de vida do jogador.
     *
     * @param objetivoVida o novo objetivo de vida
     */
    public void setObjetivoVida(ObjetivoVida objetivoVida) {
        this.objetivoVida = objetivoVida;
    }

    /**
     * Atualizar a profissão do jogador.
     *
     * @param profissao a nova profissão
     */
    public void setProfissao(Profissao profissao) {
        this.profissao = profissao;
    }

    /**
     * Atualizar a necessidade de sono do jogador.
     *
     * @param necessidadeSono o novo valor da necessidade de sono
     */
    public void setNecessidadeSono(int necessidadeSono) {
        this.necessidadeSono = necessidadeSono;
    }

    /**
     * Atualizar a necessidade de refeição do jogador.
     *
     * @param necessidadeRefeicao o novo valor da necessidade de refeição
     */
    public void setNecessidadeRefeicao(int necessidadeRefeicao) {
        this.necessidadeRefeicao = necessidadeRefeicao;
    }

    /**
     * Definir a necessidade social do jogador.
     *
     * @param necessidadeSocial o novo valor da necessidade social
     */
    public void setNecessidadeSocial(int necessidadeSocial) {
        this.necessidadeSocial = necessidadeSocial;
    }

    /**
     * Atualizar o nível de estatuto do jogador.
     *
     * @param estatuto o novo nível do estatuto
     */
    public void setEstatuto(int estatuto) {
        this.estatuto = estatuto;
    }

    /**
     * Atualizar o nível de escolaridade do jogador.
     *
     * @param escolaridade o novo nível de escolaridade
     */

    public void setEscolaridade(int escolaridade) {
        this.escolaridade = escolaridade;
    }

    /**
     * Adicionar um bem material à lista de bens materiais do jogador.
     *
     * @param bens o novo bem material
     */
    public void adicionarBem(Bens bens) {
        this.bensMateriais.add(bens);
    }
    /**
     * Adicionar um membro à família do jogador.
     *
     * @param npc o novo membro da família
     */
    public void adicionarfamilia(NPC npc) {
        this.familiaJogador.add(npc);
    }

    /**
     * Remover um bem material da lista de bens materiais do jogador.
     *
     * @param bens o bem material a ser removido
     */
    public void removerBem(Bens bens) {
        this.bensMateriais.remove(bens);
    }

    /**
     * Remover um membro da família do jogador.
     *
     * @param npc o membro da família a ser removido
     */
    public void removerfamilia(NPC npc) {
        this.familiaJogador.remove(npc);
    }

    /**
     * Imprimir no ecrã os detalhes completos dum jogador:
     * o seu nome, o seu dinheiro, o seu objetivo de Vida, a sua profissão,
     * as necessidades, o nível de estatuto, de escolaridade,
     * a lista de bens materiais e da família
     */
    public void mostrarBensMateriais() {
        System.out.println("Bens materiais:");
        int contador = 1;
        for (Bens bem : this.bensMateriais) {
            System.out.println("Bem número " + contador++ + ": ");
            bem.mostrarDetalhesBens();
        }
    }

    public void mostrarFamilia() {
        System.out.println("Família de " + this.nome + ": ");
        for (NPC npc : this.familiaJogador) {
            npc.mostrarNPC();
        }
    }

    public void mostrarDetalhes() {
            System.out.println("Nome: " + this.nome);
            System.out.println("Dinheiro: " + this.dinheiro);
            System.out.println("Objetivo de Vida: " + this.objetivoVida);
            System.out.println("Profissão: " + this.profissao);
            System.out.println("Necessidade de Sono: " + this.necessidadeSono);
            System.out.println("Necessidade Social: " + this.necessidadeSocial);
            System.out.println("Necessidade de Refeição: " + this.necessidadeRefeicao);
            System.out.println("Estatuto: " + this.estatuto);
            System.out.println("Escolaridade: " + this.escolaridade);

            mostrarBensMateriais();
            mostrarFamilia();
        }

    public void procurarNovaProfissao() {
        Scanner input = new Scanner(System.in);
        ArrayList<Profissao> lista = Profissao.getListaProfissoes();

        System.out.println("Profissões disponíveis:");
        for (int i = 0; i < lista.size(); i++) {
            Profissao p = lista.get(i);
            System.out.println(i + " - " + p.getNome() + " | Salário: " + p.getSalarioDia()
                    + " | Formal: " + p.getFormal()
                    + " | Estatuto mínimo: " + p.getEstatuto()
                    + " | Escolaridade mínima: " + p.getNivelMinimoEscolaridade());
        }

        System.out.print("Escolha o número da profissão que deseja tentar: ");
        int escolha = input.nextInt();
        Profissao nova = lista.get(escolha);

        boolean temAcessorioFormal = false;

        for (Bens bem : this.bensMateriais) {
            // Verifica se o bem é um AcessorioModa
            if (bem instanceof AcessorioModa) {
                // Faz o cast (conversão) de Bens para AcessorioModa
                AcessorioModa acessorio = (AcessorioModa) bem;

                // Agora sim, podes usar getFormal() porque sabes que é um acessório
                if (acessorio.getFormal()) {
                    temAcessorioFormal = true;
                    break; // Já encontraste um, podes parar o ciclo
                }
            }
        }

        if (temAcessorioFormal == false) {
            System.out.println("Rejeitado: precisa de pelo menos um acessório de moda formal para essa profissão.");
            return;
        }

        if (this.estatuto < nova.getEstatuto()) {
            System.out.println("Rejeitado: o seu estatuto não é suficiente.");
            return;
        }

        if (this.escolaridade < nova.getNivelMinimoEscolaridade()) {
            System.out.println("Rejeitado: o seu nível de escolaridade não é suficiente.");
            return;
        }

        // Se passou todos os critérios:
        this.profissao = nova;
        System.out.println("Parabéns! Conseguiste o emprego como " + nova.getNome() + ".");
    }



}
