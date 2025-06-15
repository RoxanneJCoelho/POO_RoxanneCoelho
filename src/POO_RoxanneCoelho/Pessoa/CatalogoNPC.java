package POO_RoxanneCoelho.Pessoa;

import java.util.ArrayList;

public class CatalogoNPC {

    private ArrayList<NPC> npcsDisponiveis;

    public CatalogoNPC() {
        this.npcsDisponiveis = new ArrayList<NPC>();
    }

    public void adicionarNPC(NPC npc){
        this.npcsDisponiveis.add(npc);
    }

    public void imprimirNPC(){
        for(NPC npc : this.npcsDisponiveis){
            npc.mostrarNPC();
        }
    }
    public void casar(int idNPC, Jogador jogador) {
        for (NPC npc : this.npcsDisponiveis) {
            if (npc.getId() == idNPC) {
                if (npc.getEstatutoMinimo() >= jogador.getEstatuto()) {
                    System.out.println("Parabéns! Casaste com " + npc.getNome() + "!");
                    jogador.setDinheiro(jogador.getDinheiro() + npc.getDinheiro());
                    jogador.setCasado(true);
                    jogador.adicionarFamilia(npc);
                } else {
                    System.out.println(npc.getNome() + " não quer casar contigo. O teu estatuto é demasiado baixo!");
                }
                return; // Sai do loop depois de encontrar o NPC
            }
        }
        System.out.println("NPC com ID " + idNPC + " não encontrado.");
    }



}
