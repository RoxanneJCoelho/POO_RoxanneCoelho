package POO_RoxanneCoelho.Pessoa;

import POO_RoxanneCoelho.Bens.AcessorioModa;
import POO_RoxanneCoelho.Bens.Bens;
import POO_RoxanneCoelho.Bens.Imovel;
import POO_RoxanneCoelho.Enums.ObjetivoVida;
import POO_RoxanneCoelho.Profissao.Profissao;

import java.util.ArrayList;

/**
 * Representa o jogador (uma subclasse de Pessoa), com atributos como objetivo de Vida, profissão, necessidades (Sono, Social, Refeicao), estatuto, escolaridade, lista de bens materiais, lista da família do jogador e o estado civil (casado ou não)
 */

public class Jogador extends Pessoa {
    private ObjetivoVida objetivoVida;
    private Profissao profissao;
    private int necessidadeSono;
    private int necessidadeRefeicao;
    private int necessidadeSocial;
    private int estatuto;
    private int escolaridade;
    private ArrayList<Bens> bensMateriais;
    private ArrayList<NPC> familiaJogador;
    private boolean casado;


    /**
     * Construtor da classe Jogador.
     *
     * @param nome                o nome do jogador
     * @param dinheiro            a quantidade de dinheiro que o jogador possui
     * @param objetivoVida        o objetivo de vida escolhido pelo utilizador para o jogador
     * @param profissao           a quantidade de dinheiro que o jogador possui
     * @param necessidadeSono     a quantidade de energia que o jogador possui (100 significa energia total, 0 significa sem energia)
     * @param necessidadeRefeicao a quantidade de comida que o jogador possui (100 significa totalmente alimentado, 0 significa com fome)
     * @param necessidadeSocial   a quantidade de socialização que o jogador possui (100 significa totalmente socializado, 0 significa deprimido)
     * @param estatuto            o nível de estatuto do jogador
     * @param escolaridade        o nível de escolaridade do jogador
     * @param casado              true se for casado, false se não for
     */

    public Jogador(String nome, double dinheiro, ObjetivoVida objetivoVida, Profissao profissao, int necessidadeSono, int necessidadeRefeicao, int necessidadeSocial, int estatuto, int escolaridade, boolean casado) {
        super(nome, dinheiro);
        this.objetivoVida = objetivoVida;
        this.profissao = profissao;
        this.necessidadeSono = necessidadeSono;
        this.necessidadeRefeicao = necessidadeRefeicao;
        this.necessidadeSocial = necessidadeSocial;
        this.estatuto = estatuto;
        this.escolaridade = escolaridade;
        this.bensMateriais = new ArrayList<Bens>();
        this.familiaJogador = new ArrayList<NPC>();
        this.casado = casado;
    }

    // Getters

    /**
     * Obter a profissão do jogador.
     *
     * @return a profissão do jogador
     */
    public Profissao getProfissao() {
        return profissao;
    }

    /**
     * Obter a necessidade de sono do jogador.
     *
     * @return a necessidade de sono do jogador
     */
    public int getNecessidadeSono() {
        return necessidadeSono;
    }

    /**
     * Obter a necessidade de refeição do jogador.
     *
     * @return a necessidade de refeição do jogador
     */
    public int getNecessidadeRefeicao() {
        return necessidadeRefeicao;
    }

    /**
     * Obter a necessidade social do jogador.
     *
     * @return a necessidade social do jogador
     */
    public int getNecessidadeSocial() {
        return necessidadeSocial;
    }

    /**
     * Obter o nível de estatuto do jogador.
     *
     * @return o nível de estatuto do jogador
     */
    public int getEstatuto() {
        return estatuto;
    }

    /**
     * Obter o nível de escolaridade do jogador.
     *
     * @return o nível de escolaridade do jogador
     */
    public int getEscolaridade() {
        return escolaridade;
    }

    /**
     * Obter o estado civil do jogador (true se for casado, false se não for)
     *
     * @return o nível de escolaridade do jogador
     */
    public boolean isCasado() {
        return casado;
    }

    /**
     * Obter o tamanho da familia do jogador
     *
     * @return o tamanho do arrayList da familia do jogador
     */

    public int getFamiliaSize() {
        return this.familiaJogador.size();
    }

    /**
     * Obter a capacidade do imovel com maior capacidade de pessoa dos bens do jogador
     *
     * @return o valor da capacidade do imovel
     */


    public int getCapacidadeMaxima() {
        int capacidadeMaxima = 0;

        for (Bens bens : this.bensMateriais) {
            if (bens instanceof Imovel) { // procurar todos os imoveis
                Imovel imovel = (Imovel) bens;
                int capacidade = imovel.getCapacidadePessoas();
                if (capacidade > capacidadeMaxima) { // se a capacidade atual for maior do que a capacidade do outro imovel, ele vai atualizando
                    capacidadeMaxima = capacidade;
                }
            }
        }
        return capacidadeMaxima;
    }

    // Setters

    /**
     * Atualizar a profissão do jogador.
     *
     * @param profissao a nova profissão
     */
    public void setProfissao(Profissao profissao) {
        this.profissao = profissao;
    }

    /**
     * Atualizar o nível de estatuto do jogador.
     *
     * @param estatuto o novo nível do estatuto
     */
    public void setEstatuto(int estatuto) {
        this.estatuto = estatuto;
    }

    /**
     * Atualizar o nível de escolaridade do jogador.
     *
     * @param escolaridade o novo nível de escolaridade
     */

    public void setEscolaridade(int escolaridade) {
        this.escolaridade = escolaridade;
    }

    /**
     * Atualizar o nível de escolaridade do jogador.
     *
     * @param casado o novo estado civil
     */

    public void setCasado(boolean casado) {
        this.casado = casado;
    }

    /**
     * Atualizar o dinheiro do jogador casado.
     *
     * @return o novo valor do dinheiro do jogador
     */

    public double dinheiroCasado() {
        return this.dinheiro += 30;
    }

    /**
     * Repor a necessidade de refeição para o valor máximo.
     *
     * @return o novo valor da necessidade de refeição
     */

    public int comerRefeicao() {
        return this.necessidadeRefeicao = 100;
    }

    /**
     * Pagar o custo de uma refeição do dinheiro do jogador.
     *
     * @return o novo valor do dinheiro
     */

    public double pagarRefeicao() {
        return this.dinheiro -= 5;
    }

    /**
     * Repor a necessidade de sono para o valor máximo.
     *
     * @return o novo valor da necessidade de sono
     */

    public int dormir() {
        return this.necessidadeSono = 100;
    }
    /**
     * Repõe a necessidade social para o valor máximo.
     *
     * @return o novo valor da necessidade social
     */

    public int socializar() {
        return this.necessidadeSocial = 100;
    }

    /**
     * Calcular o custo da família baseado no número de membros e descontar do dinheiro.
     *
     * @return o novo valor atualizado do dinheiro
     */

    public double custoFamilia() {
        int custoFamilia = this.familiaJogador.size() * 10;
        this.dinheiro -= custoFamilia;
        return this.dinheiro;
    }

    /**
     * Aumentar o nível de escolaridade do jogador.
     *
     * @return o novo valor da escolaridade
     */

    public int terFormacao() {
        return this.escolaridade += 2;
    }

    /**
     * Diminui a necessidade de sono em 25 pontos.
     *
     * @return o novo valor da necessidade de sono.
     */

    public int diminuirSono() {
        return this.necessidadeSono -= 25;
    }

    /**
     * Diminui a necessidade de refeicao em 20 pontos.
     *
     * @return o novo valor da necessidade de refeicao.
     */

    public int diminuirRefeicao() {
        return this.necessidadeRefeicao -= 20;
    }

    /**
     * Diminui a necessidade social em 15 pontos.
     *
     * @return o novo valor da necessidade social
     */

    public int diminuirSocial() {
        return this.necessidadeSocial -= 15;
    }

    /**
     * Aumenta a necessidade social em 200 pontos.
     *
     * @return o novo valor da necessidade social
     */

    public int gatinhoPovoa() {
        return this.necessidadeSocial += 200;
    }

    /**
     * Aumenta a necessidade de sono em 115 pontos.
     *
     * @return o novo valor da necessidade social
     */

    public int cama() {
        return this.necessidadeSono += 150;
    }

    // Outros métodos

    /**
     * Adicionar um bem material à lista de bens materiais do jogador.
     *
     * @param bens o novo bem material
     */
    public void adicionarBem(Bens bens) {
        this.bensMateriais.add(bens);
    }

    /**
     * Adicionar um membro à família do jogador.
     *
     * @param npc o novo membro da família
     */
    public void adicionarFamilia(NPC npc) {
        this.familiaJogador.add(npc);
    }

    /**
     * Remover um membro da família do jogador.
     *
     * @param npc o membro da família a ser removido
     */
    public void removerfamilia(NPC npc) {
        this.familiaJogador.remove(npc);
    }

    /**
     * Imprimir no ecrã os detalhes completos dos bens do jogador
     */
    public void mostrarBensMateriais() {
        System.out.println("Bens materiais:");
        for (Bens bem : this.bensMateriais) {
            bem.mostrarDetalhesBens();
        }
    }

    /**
     * Imprimir no ecrã os detalhes completos da familia do jogador
     */
    public void mostrarFamilia() {
        System.out.println("Família de " + this.nome + ": ");
        for (NPC npc : this.familiaJogador) {
            npc.mostrarNPC();
        }
    }

    /**
     * Imprimir no ecrã os detalhes completos dum jogador:
     * o seu nome, o seu dinheiro, o seu objetivo de Vida, a sua profissão,
     * as necessidades, o nível de estatuto, de escolaridade,
     * a lista de bens materiais e da família
     */

    public void mostrarDetalhes() {
        System.out.println("Nome: " + this.nome);
        System.out.println("Dinheiro: " + this.dinheiro);
        System.out.println("Objetivo de Vida: " + this.objetivoVida);
        if (this.profissao != null) {
            System.out.println("Profissão: " + this.profissao.getNome());
        } else {
            System.out.println("Profissão: Não tem");
        }
        System.out.println("Necessidade de Sono: " + this.necessidadeSono);
        System.out.println("Necessidade Social: " + this.necessidadeSocial);
        System.out.println("Necessidade de Refeição: " + this.necessidadeRefeicao);
        System.out.println("Estatuto: " + this.estatuto);
        System.out.println("Escolaridade: " + this.escolaridade);

        mostrarBensMateriais();
        mostrarFamilia();
    }

    /**
     * Verificar se o jogador tem algum imóvel com capacidade para pelo menos 2 pessoas.
     *
     * @return true se tiver imóvel para casar, false se não
     */

    public boolean ImovelValido() {
        for (Bens bens : this.bensMateriais) { // percorre os bens materiais do jogador
            if (bens instanceof Imovel && ((Imovel) bens).getCapacidadePessoas() >= 2) { // se ele tiver um imovel com capacidade igual ao superior a 2 pessoas retorna true, senão retorna false
                return true;
            }
        }
        return false;
    }

    /**
     * Remover os filhos do jogador
     */

    public void retirarFilhos() {
        ArrayList<NPC> filhosRemover = new ArrayList<NPC>(); // para nao causar exception, criamos um novo array onde vamos colocar todos os npcs com id 100 (os filhos)
        for (NPC npc : this.familiaJogador) {
            if (npc.getId() == 100) {
                filhosRemover.add(npc);
            }
        }
        for (NPC npc : filhosRemover) { // depois vamos ao array da familia e removemos os filhos
            removerfamilia(npc);
            System.out.println("A Segurança Social retirou-te os filhos!");
        }
    }

    /**
     * Verificar se o jogador tem algum acessorio formal
     *
     * @return true se tiver acessorio formal, false se não
     */
    public boolean verAcessorioFormal() {
        for (Bens bens : this.bensMateriais) {
            if (bens instanceof AcessorioModa) {
                if (((AcessorioModa) bens).isFormal()) {
                    return true;
                }
            }
        }
        return false;
    }
}






