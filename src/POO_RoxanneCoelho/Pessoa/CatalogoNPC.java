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
}
