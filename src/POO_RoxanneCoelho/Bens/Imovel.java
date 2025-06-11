package POO_RoxanneCoelho.Bens;

/**
 * Representa um imóvel (uma subclasse de bem) que pode ser adquirido pelo jogador, com atributos como capacidadePessoas.
 */

public class Imovel extends Bens {
    private int capacidadePessoas;

    /**
     * Construtor da classe Imovel.
     *
     * @param nome o nome do imóvel
     * @param custo o custo do imóvel
     * @param estatuto o nível de estatuto do imóvel
     * @param capacidadePessoas a capacidade máxima de pessoas do imóvel
     */

    public Imovel(String nome, double custo, int estatuto, int capacidadePessoas) {
        super(nome, custo, estatuto);
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
}
