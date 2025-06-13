package POO_RoxanneCoelho;

import POO_RoxanneCoelho.Sims.Sims;

public class Main {
    public static void main(String[] args) {
        Sims jogo = new Sims(null); // ainda não tens o jogador, ele será criado dentro do método
        jogo.criarPessoa();         // pergunta ao utilizador os dados iniciais
        jogo.jogo();                // inicia o ciclo dos 100 dias
    }
}
