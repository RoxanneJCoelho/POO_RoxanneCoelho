package POO_RoxanneCoelho.Pessoa;

public class NPC extends Pessoa {
    private int estatutoMinimo;

    public NPC(String nome, double dinheiro, int estatutoMinimo) {
        super(nome, dinheiro);
        this.estatutoMinimo = estatutoMinimo;
    }

    public int getEstatutoMinimo() {
        return estatutoMinimo;
    }
}
