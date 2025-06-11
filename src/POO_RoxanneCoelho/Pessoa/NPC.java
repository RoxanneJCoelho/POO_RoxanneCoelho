package POO_RoxanneCoelho.Pessoa;

/**
 * Representa um NPC (uma subclasse de Pessoa), com atributos como estatuto mínimo.
 */

public class NPC extends Pessoa {
    private int estatutoMinimo;

    /**
     * Construtor da classe NPC.
     *
     * @param nome o nome do NPC
     * @param dinheiro  a quantidade de dinheiro que o NPC possui
     * @param estatutoMinimo o nível mínimo de estatuto que o NPC deve possuir para interagir com o jogador
     */

    public NPC(String nome, double dinheiro, int estatutoMinimo) {
        super(nome, dinheiro);
        this.estatutoMinimo = estatutoMinimo;
    }

    //Getters
    /**
     * Obter o estatuto do NPC.
     *
     * @return o estatuto do NPC
     */

    public int getEstatutoMinimo() {
        return estatutoMinimo;
    }

    /**
     * Imprimir no ecrã os detalhes completos dum NPC: o seu nome, o seu dinheiro e o seu estatuto.
     */

    public void mostrarNPC(){
        System.out.println(this.nome + " | Dinheiro:  " + this.dinheiro + " | Estatuto Mínimo: " + this.estatutoMinimo);
    }
}
