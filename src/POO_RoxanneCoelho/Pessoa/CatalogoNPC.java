package POO_RoxanneCoelho.Pessoa;

import java.util.ArrayList;

/**
 * Representa o Catalogo dos NPC, com atributo como um ArrayList de npcs disponíveis
 */

public class CatalogoNPC {

    private ArrayList<NPC> npcsDisponiveis;

    /**
     * Construtor do catalogo dos NPCS.
     *
     */

    public CatalogoNPC() {
        this.npcsDisponiveis = new ArrayList<NPC>();
    }

    /**
     * Adicionar um NPC ao catálogo
     * @param npc o novo NPC
     */

    public void adicionarNPC(NPC npc){
        this.npcsDisponiveis.add(npc);
    }

    /**
     * Imprimir os detalhes de todos os NPCS disponíveis no catálogo
     */

    public void imprimirNPC(){
        for(NPC npc : this.npcsDisponiveis){
            npc.mostrarNPC();
        }
    }

    /**
     * Casar o jogador com o NPC escolhido
     * @param idNPC o id do NPC com quem o jogador quer casar
     * @param jogador o jogador que quer casar
     */
    public void casar(int idNPC, Jogador jogador) {
        for (NPC npc : this.npcsDisponiveis) {
            if (npc.getId() == idNPC) { // se o id do npc for o mesmo do selecionado, o npc foi escolhido, agora é preciso ver se cumpre com os proximos requisitos
                if (npc.getEstatutoMinimo() <= jogador.getEstatuto()) { // se o jogador tiver maior ou igual estatuto que o npc, casam-se
                    System.out.println("Parabéns! Casaste com " + npc.getNome() + "!"); // mensagem de confirmação
                    jogador.setDinheiro(jogador.getDinheiro() + npc.getDinheiro()); // o jogador ganha o dinheiro do NPC
                    jogador.setCasado(true); // altera o estado para casado
                    jogador.adicionarFamilia(npc); // adiciona o npc na familia do jogador
                } else { // se o jogador tiver menos estatuto, não se casam
                    System.out.println(npc.getNome() + " não quer casar contigo. O teu estatuto é demasiado baixo!");
                }
                return; // quebra a função
            }

        }// se o id introduzido não for nenhum dos ids encontrados
        System.out.println("NPC com ID " + idNPC + " não encontrado.");
    }
}
