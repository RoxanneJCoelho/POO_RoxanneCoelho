package POO_RoxanneCoelho.Bens;

public class Bens {
    protected String nome;
    protected double custo;
    protected int estatuto;

    public Bens(String nome, double custo, int estatuto) {
        this.nome = nome;
        this.custo = custo;
        this.estatuto = estatuto;
    }

    public String getNome() {
        return nome;
    }

    public double getCusto() {
        return custo;
    }

    public int getEstatuto() {
        return estatuto;
    }

}

