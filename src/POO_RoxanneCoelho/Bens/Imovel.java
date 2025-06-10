package POO_RoxanneCoelho.Bens;

public class Imovel extends Bens {
    private int capacidadePessoas;

    public Imovel(String nome, double custo, int estatuto, int capacidadePessoas) {
        super(nome, custo, estatuto);
        this.capacidadePessoas = capacidadePessoas;
    }

    public int getCapacidadePessoas() {
        return capacidadePessoas;
    }
}
