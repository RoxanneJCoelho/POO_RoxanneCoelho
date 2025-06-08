import Enums.ObjetivoVida;
import Enums.Profissao;

import java.util.ArrayList;

public abstract class Pessoa {
    private String nome;
    private double dinheiro;

    public Pessoa(String nome, double dinheiro) {
        this.nome = nome;
        this.dinheiro = dinheiro;
    }

    public class Jogador extends Pessoa{
        private ObjetivoVida objetivoVida;
        private Profissao profissao;
        private int NecessidadeSono;
        private int NecessidadeRefeicao;
        private int NecessidadeSocial;
        private int estatuto;
        private int educacao;
    }
}
