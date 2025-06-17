package POO_RoxanneCoelho.Profissao;

import POO_RoxanneCoelho.Pessoa.Jogador;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Representa o Catalogo das Profissoes, com atributo como um ArrayList de profissoes disponíveis
 */

public class CatalogoProfissao {
    private ArrayList<Profissao> profissoesDisponiveis;

    /**
     * Construtor do catalogo das profissoes.
     */

    public CatalogoProfissao() {
        this.profissoesDisponiveis = new ArrayList<Profissao>();
    }

    /**
     * Adicionar uma profisao ao catálogo
     *
     * @param profissao a nova profissao
     */

    public void adicionarProfissao(Profissao profissao) {
        this.profissoesDisponiveis.add(profissao);
    }

    /**
     * Imprimir os detalhes de todos as profissões disponíveis no catálogo
     */

    public void imprimirProfissoes() {
        for (Profissao profissao : this.profissoesDisponiveis) {
            profissao.profissoesDetalhes();
        }
    }

    /**
     * Permitir ao jogador trocar de profissão
     *
     * @param jogador o jogador que vai trocar de profissão
     */

    public void trocarProfissao(Jogador jogador) {
        Scanner input = new Scanner(System.in);

        System.out.println("\nProfissões disponíveis: ");
        imprimirProfissoes(); // mostra as profissões disponíveis

        System.out.print("\nEscolhe o ID da nova profissão: ");
        int idNovaProfissao = input.nextInt(); // pede ao jogador para inserir o id da nova profissão que quer ter

        for (Profissao profissao : this.profissoesDisponiveis) {
            if (profissao.getId() == idNovaProfissao) { // se o id da nova profissao for igual ao id da profissao, foi selecionada a profissao
                if (jogador.verAcessorioFormal() == false && profissao.isFormal() == true) { // se o jogador nao tiver acessorio formal e ter pedido uma profissao formal
                    System.out.println("Não tens acessório formal para exercer esta profissao.");
                } else if (jogador.getEscolaridade() < profissao.getNivelMinimoEscolaridade()) { // se o jogador nao tiver escolaridade suficiente
                    System.out.println("Não tens escolaridade suficiente para esta profissão.");
                } else if (jogador.getEstatuto() < profissao.getEstatuto()) { // se o jogador não estiver estatuto suficiente
                    System.out.println("Não tens estatuto suficiente para esta profissão!");
                } else {
                    jogador.setProfissao(profissao); // mudou de profissao
                    System.out.println("Mudaste de profissão para: " + profissao.getNome());
                }
                return;
            }
        } //se o id introduzido não for nenhum dos ids encontrados
        System.out.println("Profissão com ID " + idNovaProfissao + " não encontrado.");


    }
}
