package POO_RoxanneCoelho.Bens;

public class Veiculo extends Bens {
    private String marca;
    private String modelo;

    public Veiculo(String nome, double custo, int estatuto, String marca, String modelo) {
        super(nome, custo, estatuto);
        this.marca = marca;
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

}
