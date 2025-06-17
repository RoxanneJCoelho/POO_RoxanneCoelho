package POO_RoxanneCoelho;

import POO_RoxanneCoelho.Bens.Imovel;
import POO_RoxanneCoelho.Bens.Veiculo;
import POO_RoxanneCoelho.Bens.AcessorioModa;
import POO_RoxanneCoelho.Pessoa.CatalogoNPC;
import POO_RoxanneCoelho.Pessoa.NPC;
import POO_RoxanneCoelho.Profissao.Profissao;
import POO_RoxanneCoelho.Profissao.CatalogoProfissao;
import POO_RoxanneCoelho.Bens.Shopping;
import POO_RoxanneCoelho.Sims.Sims;

public class Main {
    public static void main(String[] args) {

        // criar o catalogo das profissões
        CatalogoProfissao catalogoProfissao = new CatalogoProfissao();

        // criar profissoes
        Profissao prof1 = new Profissao(1, "Caixa de Supermercado", 40, false, 0, 0);
        Profissao prof2 = new Profissao(2, "Babysitter", 40, false, 0, 0);
        Profissao prof3 = new Profissao(3, "Bancari@", 80, true, 50, 50);
        Profissao prof4 = new Profissao(4, "Técnic@ de Laboratório", 130, false, 80, 80);
        Profissao prof5 = new Profissao(5, "Empresári@", 200, true, 150, 80);

        // adicionar as profissões ao catálogo
        catalogoProfissao.adicionarProfissao(prof1);
        catalogoProfissao.adicionarProfissao(prof2);
        catalogoProfissao.adicionarProfissao(prof3);
        catalogoProfissao.adicionarProfissao(prof4);
        catalogoProfissao.adicionarProfissao(prof5);

        // criar o catalogo dos npcs
        CatalogoNPC catalogoNPC = new CatalogoNPC();

        // criar npcs
        NPC npc1 = new NPC("Chico da Tina", 5000, 1, 200);
        NPC npc2 = new NPC("Rosinha", 3000, 2, 100);
        NPC npc3 = new NPC("Lídia Jorge", 2000, 3, 90);
        NPC npc4 = new NPC("Roxanne Coelho", 500, 4, 0);
        NPC npc5 = new NPC("Ricardo Araújo Pereira", 2000, 5, 90);

        // adicionar as profissões ao npc
        catalogoNPC.adicionarNPC(npc1);
        catalogoNPC.adicionarNPC(npc2);
        catalogoNPC.adicionarNPC(npc3);
        catalogoNPC.adicionarNPC(npc4);
        catalogoNPC.adicionarNPC(npc5);

        // criar shopping
        Shopping shopping = new Shopping();

        // criar imóveis
        Imovel imovel1 = new Imovel(1, "Apartamento T1", 150000, 70, 3);
        Imovel imovel2 = new Imovel(2, "Apartamento T2", 300000, 150, 4);
        Imovel imovel3 = new Imovel(3, "Mansão de Luxo", 1500000, 800, 14);
        Imovel imovel4 = new Imovel(4, "Casa Geminada", 500000, 200, 4);
        Imovel imovel5 = new Imovel(5, "Casa na Praia", 750000, 400, 7);
        Imovel imovel6 = new Imovel(6, "Apartamento T0", 120000, 50, 2);
        Imovel imovel7 = new Imovel(7, "Casa Pequena", 100000, 40, 2);
        Imovel imovel8 = new Imovel(8, "Casa no Campo", 450000, 300, 5);
        Imovel imovel9 = new Imovel(9, "Casa Não-Geminada", 800000, 450, 6);
        Imovel imovel10 = new Imovel(10, "Quarto Alugado", 400, 10, 1);

        // adicionar imóveis ao shopping
        shopping.adicionarItem(imovel1);
        shopping.adicionarItem(imovel2);
        shopping.adicionarItem(imovel3);
        shopping.adicionarItem(imovel4);
        shopping.adicionarItem(imovel5);
        shopping.adicionarItem(imovel6);
        shopping.adicionarItem(imovel7);
        shopping.adicionarItem(imovel8);
        shopping.adicionarItem(imovel9);
        shopping.adicionarItem(imovel10);

        // criar veículo
        Veiculo veiculo1 = new Veiculo(1, "Bicicleta", 200, 5, "Caloi", "Montain Bike");
        Veiculo veiculo2 = new Veiculo(12, "Fiat 500 Branco", 15000, 40, "Fiat", "500");
        Veiculo veiculo3 = new Veiculo(13, "Mota", 10000, 25, "Honda", "CBR 600RR");
        Veiculo veiculo4 = new Veiculo(14, "Mercedes Branco", 80000, 100, "Mercedes", "Classe C");
        Veiculo veiculo5 = new Veiculo(15, "Avião Particular", 5000000, 1000, "Cessna", "Citation X");
        Veiculo veiculo6 = new Veiculo(16, "Trotineta Elétrica", 1000, 10, "Boosted", "Mini X");
        Veiculo veiculo7 = new Veiculo(17, "Scooter", 2500, 15, "Vespa", "Sprint");
        Veiculo veiculo8 = new Veiculo(18, "Barco a Vela", 20000, 160, "Beneteau", "Oceanis 30.1");
        Veiculo veiculo9 = new Veiculo(19, "Carrinha", 30000, 60, "Ford", "Ranger");
        Veiculo veiculo10 = new Veiculo(20, "Ferrari 488", 300000, 200, "Ferrari", "488 GTB");

        // adicionar veículos ao shopping
        shopping.adicionarItem(veiculo1);
        shopping.adicionarItem(veiculo2);
        shopping.adicionarItem(veiculo3);
        shopping.adicionarItem(veiculo4);
        shopping.adicionarItem(veiculo5);
        shopping.adicionarItem(veiculo6);
        shopping.adicionarItem(veiculo7);
        shopping.adicionarItem(veiculo8);
        shopping.adicionarItem(veiculo9);
        shopping.adicionarItem(veiculo10);

        // criar acessórios de moda
        AcessorioModa acessorioModa1 = new AcessorioModa(21, "Boné", 20, 2, "Nike", true);
        AcessorioModa acessorioModa2 = new AcessorioModa(22, "Óculos de Sol", 150, 10, "Ray-Ban", false);
        AcessorioModa acessorioModa3 = new AcessorioModa(23, "Relógio de Pulso", 200, 15, "Casio", false);
        AcessorioModa acessorioModa4 = new AcessorioModa(24, "Bolsa", 2000, 50, "Chanel", true);
        AcessorioModa acessorioModa5 = new AcessorioModa(25, "Anel de Diamante", 10000, 100, "Tiffany", true);
        AcessorioModa acessorioModa6 = new AcessorioModa(26, "Sapatilhas", 120, 15, "Adidas", false);
        AcessorioModa acessorioModa7 = new AcessorioModa(27, "Colar de Pérolas", 800, 100, "Vivara", true);
        AcessorioModa acessorioModa8 = new AcessorioModa(28, "Lenço de Seda", 270, 60, "Hermes", true);
        AcessorioModa acessorioModa9 = new AcessorioModa(29, "Gravata", 300, 45, "Armani", true);
        AcessorioModa acessorioModa10 = new AcessorioModa(30, "Chapéu de Sol", 30, 3, "H&M", false);

        // adicionar acessórios de Moda ao shopping
        shopping.adicionarItem(acessorioModa1);
        shopping.adicionarItem(acessorioModa2);
        shopping.adicionarItem(acessorioModa3);
        shopping.adicionarItem(acessorioModa4);
        shopping.adicionarItem(acessorioModa5);
        shopping.adicionarItem(acessorioModa6);
        shopping.adicionarItem(acessorioModa7);
        shopping.adicionarItem(acessorioModa8);
        shopping.adicionarItem(acessorioModa9);
        shopping.adicionarItem(acessorioModa10);

        // criar um novo Sims e iniciar o jogo
        Sims jogo = new Sims(shopping, catalogoProfissao, catalogoNPC);
        jogo.criarPessoa();
        jogo.jogo();
        jogo.cumprirObjetivoVida();

    }
}
