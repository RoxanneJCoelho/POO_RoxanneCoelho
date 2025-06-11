package POO_RoxanneCoelho.Pessoa;

/**
 * Representa uma pessoa no jogo (pode ser o jogador ou um NPC), com atributos como nome e uma quantidade de dinheiro.
 */

public abstract class Pessoa {
    protected String nome;
    protected double dinheiro;

    /**
     * Construtor da classe Pessoa.
     *
     * @param nome     o nome da pessoa
     * @param dinheiro a quantidade de dinheiro que a pessoa possui
     */

    public Pessoa(String nome, double dinheiro) {
        this.nome = nome;
        this.dinheiro = dinheiro;
    }

    // Getters

    /**
     * Obter o nome da pessoa.
     *
     * @return o nome da pessoa
     */

    public String getNome() {
        return nome;
    }

    /**
     * Obter a quantidade de dinheiro da pessoa.
     *
     * @return a quantidade de dinheiro
     */

    public double getDinheiro() {
        return dinheiro;
    }

    // Setters

    /**
     * Atualizar a quantidade de dinheiro da pessoa.
     *
     * @param dinheiro a nova quantidade de dinheiro
     */

    public void setDinheiro(double dinheiro) {
        this.dinheiro = dinheiro;
    }
}
