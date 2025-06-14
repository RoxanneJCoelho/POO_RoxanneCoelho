package POO_RoxanneCoelho.Bens;

/**
 * Representa um imóvel (uma subclasse de bem) que pode ser adquirido pelo jogador, com atributos como capacidadePessoas.
 */

public class Imovel extends Bens {
    private int capacidadePessoas;

    /**
     * Construtor da classe Imovel.
     *
     * @param id                o id do imóvel
     * @param nome              o nome do imóvel
     * @param custo             o custo do imóvel
     * @param estatuto          o nível de estatuto do imóvel
     * @param capacidadePessoas a capacidade máxima de pessoas do imóvel
     */

    public Imovel(int id, String nome, double custo, int estatuto, int capacidadePessoas) {
        super(id, nome, custo, estatuto);
        this.capacidadePessoas = capacidadePessoas;
    }

    //Getters

    /**
     * Obter a capacidade máxima de pessoas que o imóvel pode acomodar.
     *
     * @return a capacidade máxima de pessoas do imóvel
     */

    public int getCapacidadePessoas() {
        return capacidadePessoas;
    }

    /**
     * Imprimir os detalhes completos do imóvel.
     * Primeiro, chama o método da superclasse para mostrar o nome, custo e estatuto.
     * Depois, imprime também a capacidade máxima de pessoas.
     */

    @Override
    public void mostrarDetalhesBens() {
        super.mostrarDetalhesBens();
        System.out.println("Capacidade máxima de pessoas: " + this.capacidadePessoas);
    }
}
