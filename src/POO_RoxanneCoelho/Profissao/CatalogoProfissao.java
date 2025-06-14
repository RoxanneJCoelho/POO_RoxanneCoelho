package POO_RoxanneCoelho.Profissao;

import POO_RoxanneCoelho.Pessoa.Jogador;

import java.util.ArrayList;
import java.util.Scanner;

public class CatalogoProfissao {
    private ArrayList<Profissao> profissoesDisponiveis;

    public CatalogoProfissao() {
        this.profissoesDisponiveis = new ArrayList<Profissao>();
    }

    public void adicionarProfissao(Profissao profissao){
        this.profissoesDisponiveis.add(profissao);
    }

    public void imprimirProfissoes(){
        for(Profissao profissao : this.profissoesDisponiveis){
            profissao.profissoesDetalhes();
        }
    }
    public void trocarProfissao(Jogador jogador) {
        Scanner input = new Scanner(System.in);

        System.out.println("\nProfissões disponíveis:");
        imprimirProfissoes();

        System.out.print("\nEscolhe o ID da nova profissão: ");
        int idEscolhido = input.nextInt();

        Profissao novaProfissao = null;
        for (Profissao profissao : this.profissoesDisponiveis) {
            if (profissao.getId() == idEscolhido) {
                novaProfissao = profissao;
                break;
            }
        }
        if (jogador.getEscolaridade() < novaProfissao.getNivelMinimoEscolaridade()) {
            System.out.println("Não tens escolaridade suficiente para esta profissão.");
        } else if (jogador.getEstatuto() < novaProfissao.getEstatuto()){
            System.out.println("Não tens estatuto suficiente para esta profissão!");
        } else {
            jogador.setProfissao(novaProfissao);
            System.out.println("Mudaste de profissão para: " + novaProfissao.getNome());
        }
    }
}
