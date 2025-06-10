package POO_RoxanneCoelho.Profissao;

public class Profissao {
    private String nome;
    private double salarioDia;
    private boolean formal;
    private int estatuto;
    private int nivelMinimoEducacao;

    public Profissao(String nome, double salarioDia, boolean formal, int estatuto, int nivelMinimoEducacao) {
        this.nome = nome;
        this.salarioDia = salarioDia;
        this.formal = formal;
        this.estatuto = estatuto;
        this.nivelMinimoEducacao = nivelMinimoEducacao;
    }

    public String getNome() {
        return nome;
    }

    public double getSalarioDia() {
        return salarioDia;
    }

    public boolean isFormal() {
        return formal;
    }

    public int getEstatuto() {
        return estatuto;
    }

    public int getNivelMinimoEducacao() {
        return nivelMinimoEducacao;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSalarioDia(double salarioDia) {
        this.salarioDia = salarioDia;
    }

    public void setFormal(boolean formal) {
        this.formal = formal;
    }

    public void setEstatuto(int estatuto) {
        this.estatuto = estatuto;
    }

    public void setNivelMinimoEducacao(int nivelMinimoEducacao) {
        this.nivelMinimoEducacao = nivelMinimoEducacao;
    }
}