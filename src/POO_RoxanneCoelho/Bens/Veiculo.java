package POO_RoxanneCoelho.Bens;

/**
 * Representa um veículo (uma subclasse de bem) que pode ser adquirido pelo jogador, com atributos como marca e modelo.
 */

public class Veiculo extends Bens {
    private String marca;
    private String modelo;

    /**
     * Construtor da classe Veiculo.
     *
     * @param id       o id do veículo
     * @param nome     o nome do veículo
     * @param custo    o custo do veículo
     * @param estatuto o nível de estatuto do veículo
     * @param marca    a marca do veículo
     * @param modelo   o modelo do veículo
     */

    public Veiculo(int id, String nome, double custo, int estatuto, String marca, String modelo) {
        super(id, nome, custo, estatuto);
        this.marca = marca;
        this.modelo = modelo;
    }

    // Outros métodos

    /**
     * Imprimir os detalhes completos do veículo.
     * Primeiro, chama o método da superclasse para mostrar o nome, custo e estatuto.
     * Depois, imprime também a marca e o modelo.
     */

    @Override
    public void mostrarDetalhesBens() {
        super.mostrarDetalhesBens();
        System.out.println("Marca: " + this.marca);
        System.out.println("Modelo: " + this.modelo);
    }
}
