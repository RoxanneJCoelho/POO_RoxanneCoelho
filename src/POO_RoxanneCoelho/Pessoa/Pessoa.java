package POO_RoxanneCoelho.Pessoa;

public abstract class Pessoa {
    protected String nome;
    protected double dinheiro;

    public Pessoa(String nome, double dinheiro) {
        this.nome = nome;
        this.dinheiro = dinheiro;
    }

    public String getNome() {
        return nome;
    }

    public double getDinheiro() {
        return dinheiro;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDinheiro(double dinheiro) {
        this.dinheiro = dinheiro;
    }



}
