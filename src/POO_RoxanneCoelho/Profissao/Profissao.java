package POO_RoxanneCoelho.Profissao;

/**
 * Representa uma profissão que o jogador pode ter no jogo,
 * com atributos como nome, salário por dia, se é formal ou não, estatuto e um nível mínimo de escolaridade necessário.
 */

public class Profissao {
    private int id;
    private String nome;
    private double salarioDia;
    private boolean formal;
    private int estatuto;
    private int nivelMinimoEscolaridade;

    /**
     * Construtor da classe Profissao.
     *
     * @param id                      o id da profissao
     * @param nome                    o nome da profissão
     * @param salarioDia              o valor do salário por dia da profissão
     * @param formal                  true se for uma profissão formal; false se for informal
     * @param estatuto                o valor de estatuto da profissão
     * @param nivelMinimoEscolaridade o nível mínimo de escolaridade necessário
     */

    public Profissao(int id, String nome, double salarioDia, boolean formal, int estatuto, int nivelMinimoEscolaridade) {
        this.id = id;
        this.nome = nome;
        this.salarioDia = salarioDia;
        this.formal = formal;
        this.estatuto = estatuto;
        this.nivelMinimoEscolaridade = nivelMinimoEscolaridade;
    }


    // Getters

    /**
     * Obter o id da profissão.
     *
     * @return o id da profissão
     */

    public int getId() {
        return id;
    }

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

    public void profissoesDetalhes() {
        System.out.println("Profissao nº: " + this.id + "Nome: " + this.nome + " | Salário por dia: " + this.salarioDia + " euros | Formal: " + this.formal + " | Estatuto: " + this.estatuto + " | Nível Mínimo de Escolaridade: " + this.nivelMinimoEscolaridade);
    }
}
