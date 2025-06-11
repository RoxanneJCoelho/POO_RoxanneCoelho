package POO_RoxanneCoelho.Pessoa;

import POO_RoxanneCoelho.Bens.Bens;
import POO_RoxanneCoelho.Enums.ObjetivoVida;
import POO_RoxanneCoelho.Profissao.Profissao;

import java.util.ArrayList;

    public class Jogador extends Pessoa {
        private ObjetivoVida objetivoVida;
        private Profissao profissao;
        private int necessidadeSono;
        private int necessidadeRefeicao;
        private int necessidadeSocial;
        private int estatuto;
        private int educacao;
        private ArrayList<Bens> bensMateriais;
        private ArrayList<NPC> familiaJogador;


        public Jogador(String nome, double dinheiro, ObjetivoVida objetivoVida, Profissao profissao, int necessidadeSono, int necessidadeRefeicao, int necessidadeSocial, int estatuto, int educacao) {
            super(nome, dinheiro);
            this.objetivoVida = objetivoVida;
            this.profissao = profissao;
            this.necessidadeSono = necessidadeSono;
            this.necessidadeRefeicao = necessidadeRefeicao;
            this.necessidadeSocial = necessidadeSocial;
            this.estatuto = estatuto;
            this.educacao = educacao;
            this.bensMateriais = new ArrayList<Bens>();
            this.familiaJogador = new ArrayList<NPC>();
        }


        public Profissao getProfissao() {
            return profissao;
        }

        public int getNecessidadeSono() {
            return necessidadeSono;
        }

        public int getNecessidadeRefeicao() {
            return necessidadeRefeicao;
        }

        public int getNecessidadeSocial() {
            return necessidadeSocial;
        }

        public int getEstatuto() {
            return estatuto;
        }

        public int getEducacao() {
            return educacao;
        }

        public ArrayList<Bens> getBensMateriais() {
            return bensMateriais;
        }

        public ArrayList<NPC> getFamiliaJogador() {
            return familiaJogador;
        }

        public void setObjetivoVida(ObjetivoVida objetivoVida) {
            this.objetivoVida = objetivoVida;
        }

        public void setProfissao(Profissao profissao) {
            this.profissao = profissao;
        }

        public void setNecessidadeSono(int necessidadeSono) {
            this.necessidadeSono = necessidadeSono;
        }

        public void setNecessidadeRefeicao(int necessidadeRefeicao) {
            this.necessidadeRefeicao = necessidadeRefeicao;
        }

        public void setNecessidadeSocial(int necessidadeSocial) {
            this.necessidadeSocial = necessidadeSocial;
        }

        public void setEstatuto(int estatuto) {
            this.estatuto = estatuto;
        }

        public void setEducacao(int educacao) {
            this.educacao = educacao;
        }

        public void setBensMateriais(ArrayList<Bens> bensMateriais) {
            this.bensMateriais = bensMateriais;
        }

        public void setFamiliaJogador(ArrayList<NPC> familiaJogador) {
            this.familiaJogador = familiaJogador;
        }

        public void adicionarBem(Bens bem) {
            this.bensMateriais.add(bem);
        }


        public void mostrarDetalhes() {
            System.out.println("Nome: " + this.nome);
            System.out.println("Dinheiro: " + this.dinheiro);
            System.out.println("Objetivo de vida: " + this.objetivoVida);
            System.out.println("Profissão: " + this.profissao);
            System.out.println("Necessidade de Sono: " + this.necessidadeSono);
            System.out.println("Necessidade Social: " + this.necessidadeSocial);
            System.out.println("Necessidade de Refeição: " + this.necessidadeRefeicao);
            System.out.println("Estatuto: " + this.estatuto);
            System.out.println("Educacao: " + this.educacao);
            System.out.println("Bens Materiais: " + this.bensMateriais);
            System.out.println("Familia de " + this.nome + ": " + this.familiaJogador);
        }
    }
