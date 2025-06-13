package POO_RoxanneCoelho.Profissao;

import java.util.ArrayList;

/**
 * Representa uma profissão que o jogador pode ter no jogo,
 * com atributos como nome, salário por dia, se é formal ou não, estatuto e um nível mínimo de escolaridade necessário.
 */

public class Profissao {
    private String nome;
    private double salarioDia;
    private boolean formal;
    private int estatuto;
    private int nivelMinimoEscolaridade;

    // Lista estática de profissões disponíveis
    private static ArrayList<Profissao> listaProfissoes = new ArrayList<>();

    /**
     * Construtor da classe Profissao.
     *
     * @param nome                    o nome da profissão
     * @param salarioDia              o valor do salário por dia da profissão
     * @param formal                  true se for uma profissão formal; false se for informal
     * @param estatuto                o valor de estatuto da profissão
     * @param nivelMinimoEscolaridade o nível mínimo de escolaridade necessário
     */

    public Profissao(String nome, double salarioDia, boolean formal, int estatuto, int nivelMinimoEscolaridade) {
        this.nome = nome;
        this.salarioDia = salarioDia;
        this.formal = formal;
        this.estatuto = estatuto;
        this.nivelMinimoEscolaridade = nivelMinimoEscolaridade;
    }
    // Método estático para inicializar a lista com algumas profissões padrão
    public static void inicializarProfissoes() {
        listaProfissoes.add(new Profissao("Professor Universitário", 150, true, 10, 5));
        listaProfissoes.add(new Profissao("Celebridade", 300, false, 15, 0));
        listaProfissoes.add(new Profissao("Empresário", 200, true, 12, 3));
    }

    // Método estático para obter a lista
    public static ArrayList<Profissao> getListaProfissoes() {
        return listaProfissoes;
    }

    // Getters

    /**
     * Obter o nome da profissão.
     *
     * @return o nome da profissão
     */

    public String getNome() {
        return nome;
    }

    /**
     * Obter o valor do salário por dia da profissão.
     *
     * @return o salário por dia da profissão
     */

    public double getSalarioDia() {
        return salarioDia;
    }

    /**
     * Indicar se a profissão é formal ou informal.
     *
     * @return true se for uma profissão formal; false se for informal
     */

    public boolean getFormal() {
        return formal;
    }

    /**
     * Obter o nível de estatuto da profissão.
     *
     * @return o nível de estatuto do bem
     */

    public int getEstatuto() {
        return estatuto;
    }

    /**
     * Obter o nível mínimo de escolaridade necessário para exercer a profissão.
     *
     * @return o nível mínimo de escolaridade necessário
     */

    public int getNivelMinimoEscolaridade() {
        return nivelMinimoEscolaridade;
    }




}
