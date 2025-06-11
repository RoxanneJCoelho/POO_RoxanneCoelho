package POO_RoxanneCoelho.Bens;

/**
 * Representa um acessório de moda (uma subclasse de bem) que pode ser adquirido pelo jogador, com atributos como marca e formal.
 */

public class AcessorioModa extends Bens {
    private String marca;
    private boolean formal;

    /**
     * Construtor da classe AcessorioModa.
     *
     * @param nome     o nome do acessório
     * @param custo    o custo do acessório
     * @param estatuto o nível de estatuto do acessório
     * @param marca    a marca do acessório
     * @param formal   true se for um acessório formal; false se for informal
     */

    public AcessorioModa(String nome, double custo, int estatuto, String marca, boolean formal) {
        super(nome, custo, estatuto);
        this.marca = marca;
        this.formal = formal;
    }

    // Getters

    /**
     * Obter a marca do acessório.
     *
     * @return a marca do acessório
     */

    public String getMarca() {
        return marca;
    }

    /**
     * Indicar se o acessório é formal ou informal.
     *
     * @return true se for um acessório formal; false se for informal
     */

    public boolean getFormal() {
        return formal;
    }

    /**
     * Imprimir os detalhes completos do acessório.
     * Primeiro, chama o método da superclasse para mostrar o nome, custo e estatuto.
     * Depois, imprime também a marca e se o acessório é formal ou não.
     */

    @Override
    public void mostrarDetalhesBens() {
        super.mostrarDetalhesBens();
        System.out.println("Marca: " + this.marca);
        System.out.println("Formal: " + this.formal);
    }
}
