package POO_RoxanneCoelho.Bens;

/**
 * Representa um bem que pode ser adquirido pelo jogador, com atributos como nome, custo e estatuto.
 */

public class Bens {
    protected int id;
    protected String nome;
    protected double custo;
    protected int estatuto;

    /**
     * Construtor da classe Bens.
     *
     * @param id       o id do bem
     * @param nome     o nome do bem
     * @param custo    o custo do bem
     * @param estatuto o nível de estatuto do bem
     */

    public Bens(int id, String nome, double custo, int estatuto) {
        this.id = id;
        this.nome = nome;
        this.custo = custo;
        this.estatuto = estatuto;
    }

    // Getters

    /**
     * Obter o id do bem.
     *
     * @return o id do bem
     */

    public int getId() {
        return id;
    }

    /**
     * Obter o nome do bem.
     *
     * @return o nome do bem
     */

    public String getNome() {
        return nome;
    }

    /**
     * Obter o custo do bem.
     *
     * @return o custo do bem
     */

    public double getCusto() {
        return custo;
    }

    /**
     * Obter o nível de estatuto do bem.
     *
     * @return o nível de estatuto do bem
     */

    public int getEstatuto() {
        return estatuto;
    }

    /**
     * Imprimir no ecrã os detalhes completos dum bem: o seu nome, o seu custo e o nível atual do seu estatuto.
     */

    public void mostrarDetalhesBens() {
        System.out.println("ID nº " + this.id + "Nome: " + this.nome + " | Custo:  " + this.custo + " | Estatuto: " + this.estatuto);
    }

}

