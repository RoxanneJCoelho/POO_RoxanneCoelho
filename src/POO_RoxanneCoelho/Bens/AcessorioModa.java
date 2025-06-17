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
     * @param id       o id do acessório
     * @param nome     o nome do acessório
     * @param custo    o custo do acessório
     * @param estatuto o nível de estatuto do acessório
     * @param marca    a marca do acessório
     * @param formal   true se for um acessório formal; false se for informal
     */

    public AcessorioModa(int id, String nome, double custo, int estatuto, String marca, boolean formal) {
        super(id, nome, custo, estatuto);
        this.marca = marca;
        this.formal = formal;
    }

    // Getters

    /**
     * Indicar se o acessório é formal ou informal.
     *
     * @return true se for um acessório formal; false se for informal
     */

    public boolean isFormal() {
        return formal;
    }

    // Outros métodos

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
