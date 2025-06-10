package POO_RoxanneCoelho.Bens;

public class AcessorioModa extends Bens {
    private String marca;
    private boolean formal;

    public AcessorioModa(String nome, double custo, int estatuto, String marca, boolean formal) {
        super(nome, custo, estatuto);
        this.marca = marca;
        this.formal = formal;
    }

    public String getMarca() {
        return marca;
    }

    public boolean isFormal() {
        return formal;
    }
}
