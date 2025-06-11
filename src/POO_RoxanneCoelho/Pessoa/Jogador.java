package POO_RoxanneCoelho.Pessoa;

import POO_RoxanneCoelho.Bens.Bens;
import POO_RoxanneCoelho.Enums.ObjetivoVida;
import POO_RoxanneCoelho.Profissao.Profissao;

import java.util.ArrayList;

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

    public int getEstatuto() {
        return estatuto;
    }

    public int getEscolaridade() {
        return escolaridade;
    }

    public void setObjetivoVida(ObjetivoVida objetivoVida) {
        this.objetivoVida = objetivoVida;
    }

    public void setProfissao(Profissao profissao) {
        this.profissao = profissao;
    }

    public void setNecessidadeSono(int necessidadeSono) {
        this.necessidadeSono = necessidadeSono;
    }

    public void setNecessidadeRefeicao(int necessidadeRefeicao) {
        this.necessidadeRefeicao = necessidadeRefeicao;
    }

    public void setNecessidadeSocial(int necessidadeSocial) {
        this.necessidadeSocial = necessidadeSocial;
    }

    public void setEstatuto(int estatuto) {
        this.estatuto = estatuto;
    }

    public void setEscolaridade(int escolaridade) {
        this.escolaridade = escolaridade;
    }

    public void adicionarBem(Bens bens) {
        this.bensMateriais.add(bens);
    }

    public void adicionarfamilia(NPC npc) {
        this.familiaJogador.add(npc);
    }

    public void removerBem(Bens bens) {
        this.bensMateriais.remove(bens);
    }

    public void removerfamilia(NPC npc) {
        this.familiaJogador.remove(npc);
    }

    public void mostrarDetalhes() {
        System.out.println("Nome: " + this.nome);
        System.out.println("Dinheiro: " + this.dinheiro);
        System.out.println("Objetivo de vida: " + this.objetivoVida);
        System.out.println("Profissão: " + this.profissao);
        System.out.println("Necessidade de Sono: " + this.necessidadeSono);
        System.out.println("Necessidade Social: " + this.necessidadeSocial);
        System.out.println("Necessidade de Refeição: " + this.necessidadeRefeicao);
        System.out.println("Estatuto: " + this.estatuto);
        System.out.println("Escolaridade: " + this.escolaridade);

        int contadorBens = 1;

        for (Bens bens : this.bensMateriais) {
            System.out.println("Bem número " + contadorBens++ + ": ");
            bens.mostrarDetalhesBens();

        }
        System.out.println("Familia de " + this.nome + ": ");
        for (NPC npc : this.familiaJogador) {
            npc.mostrarNPC();
        }
    }
}
