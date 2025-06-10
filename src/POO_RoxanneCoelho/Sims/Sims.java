package POO_RoxanneCoelho.Sims;

public class Sims {
    private Jogador jogador;
    private Shopping shopping;
    private ArrayList<Profissao> profissoesDisponiveis;
    private ArrayList<NPC> npcsDisponiveis; // Para casar
    private Scanner scanner;
    private Random random;

    public Sims() {
        this.shopping = new Shopping();
        this.profissoesDisponiveis = new ArrayList<>();
        this.npcsDisponiveis = new ArrayList<>();
        this.scanner = new Scanner(System.in);
        this.random = new Random();
        popularProfissoes();
        popularNPCs();
    }

    /**
     * Preenche a lista de profissões disponíveis no jogo.
     */
    private void popularProfissoes() {
        profissoesDisponiveis.add(new Profissao("Estudante", 0, false, 0, 0));
        profissoesDisponiveis.add(new Profissao("Caixa de Supermercado", 50, false, 5, 0));
        profissoesDisponiveis.add(new Profissao("Programador Júnior", 120, true, 20, 2));
        profissoesDisponiveis.add(new Profissao("Vendedor de Carros", 80, false, 15, 1));
        profissoesDisponiveis.add(new Profissao("Advogado", 250, true, 80, 40));
        profissoesDisponiveis.add(new Profissao("Médico", 300, true, 90, 50));
        profissoesDisponiveis.add(new Profissao("Influencer", 180, false, 60, 10));
        profissoesDisponiveis.add(new Profissao("Professor Universitário", 220, true, 75, 50));
        profissoesDisponiveis.add(new Profissao("Ator de Cinema", 400, true, 150, 20));
        profissoesDisponiveis.add(new Profissao("Cientista", 280, true, 85, 45));
    }

    /**
     * Preenche a lista de NPCs disponíveis para interação no jogo.
     */
    private void popularNPCs() {
        npcsDisponiveis.add(new NPC("Ana", 500, 10));
        npcsDisponiveis.add(new NPC("Bruno", 1200, 30));
        npcsDisponiveis.add(new NPC("Carla", 800, 20));
        npcsDisponiveis.add(new NPC("Diogo", 2500, 50));
        npcsDisponiveis.add(new NPC("Elsa", 300, 5));
        npcsDisponiveis.add(new NPC("Filipe", 10000, 100)); // NPC com mais dinheiro/estatuto
        npcsDisponiveis.add(new NPC("Sofia", 1500, 40));
        npcsDisponiveis.add(new NPC("Gonçalo", 700, 15));
    }

    /**
     * Permite ao utilizador criar a sua personagem no início do jogo,
     * definindo o nome e o objetivo de vida. Os atributos iniciais são definidos a 0 ou 100.
     */
    public void criarPessoa() {
        System.out.println("--- Criar Nova Pessoa ---");
        System.out.print("Digite o nome da sua personagem: ");
        String nome = scanner.nextLine();

        System.out.println("\nEscolha o objetivo de vida da sua personagem:");
        for (int i = 0; i < Objetivo.values().length; i++) {
            System.out.println((i + 1) + ". " + Objetivo.values()[i].getDescricao());
        }
        int escolhaObjetivo;
        Objetivo objetivoEscolhido = null;
        do {
            System.out.print("Sua escolha: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Entrada inválida. Por favor, digite um número.");
                scanner.next();
            }
            escolhaObjetivo = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha
            if (escolhaObjetivo >= 1 && escolhaObjetivo <= Objetivo.values().length) {
                objetivoEscolhido = Objetivo.values()[escolhaObjetivo - 1];
            } else {
                System.out.println("Opção inválida. Por favor, escolha novamente.");
            }
        } while (objetivoEscolhido == null);


        // Atributos iniciais conforme especificado
        // dinheiro: 0, profissao: null, necessidades: 100, estatuto: 0, educação: 0, propriedades/familia: vazias
        this.jogador = new Jogador(nome, 0, objetivoEscolhido, null, 100, 100, 100, 0);
        System.out.println("\nPersonagem " + nome + " criada com sucesso!");
        jogador.mostrarDetalhes();
        System.out.println("Comece sua jornada para se tornar " + objetivoEscolhido.getDescricao() + "!");
    }

    /**
     * Método principal que controla o fluxo do jogo, simulando os dias e os momentos.
     */
    public void jogo() {
        if (jogador == null) {
            System.out.println("Primeiro, crie sua personagem.");
            return;
        }

        int diasDeVida = 100; // Número de dias que o jogo vai durar
        int diaAtual = 1;
        boolean casado = false;
        boolean podeTerFilhos = false; // Opção para ter filhos, desbloqueada após o casamento

        while (diaAtual <= diasDeVida) {
            System.out.println("\n--- Dia " + diaAtual + " ---");
            jogador.mostrarDetalhes(); // Mostra detalhes no início de cada dia

            // Eventos obrigatórios e dinâmicos
            if (diaAtual == 5) {
                eventoUniversidade();
            }
            if (diaAtual == 22 && !casado) { // Verifica se já não casou antes
                casado = eventoCasamento();
                if (casado) {
                    podeTerFilhos = true; // Desbloqueia opção de ter filhos
                }
            }
            if (diaAtual > 60) { // Desabilita opção de ter filhos após o dia 60
                podeTerFilhos = false;
            }

            // Eventos aleatórios diários
            checarEventosAleatorios(diaAtual);

            // Ganhos diários de dinheiro se for casado
            if (casado) {
                jogador.setDinheiro(jogador.getDinheiro() + 30);
                System.out.printf("Ganhos diários (casamento): +30€. Dinheiro atual: %.2f€.\n", jogador.getDinheiro());
            }

            // Pagamento da família, se houver
            if (!jogador.getFamilia().isEmpty()) {
                double custoFamilia = jogador.getFamilia().size() * 10;
                jogador.setDinheiro(jogador.getDinheiro() - custoFamilia);
                System.out.printf("Custo diário da família: %.2f€. Dinheiro atual: %.2f€.\n", custoFamilia, jogador.getDinheiro());
            }

            // Checar limite mínimo de dinheiro para evitar dívidas excessivas e perda de filhos
            if (jogador.getDinheiro() < -3250) {
                if (!jogador.getFamilia().isEmpty()) {
                    System.out.println("\nAVISO CRÍTICO: Dívida muito alta (-3250€)! Serviço Social retirou seus filhos!");
                    jogador.getFamilia().clear(); // Remove todos os filhos
                    System.out.println("Você não tem mais filhos.");
                } else {
                    System.out.println("\nAVISO: Dívida muito alta! Atenção aos seus gastos.");
                }
            }

            // Diminuição diária das necessidades
            jogador.setNecessidadeSono(Math.max(0, jogador.getNecessidadeSono() - 25));
            jogador.setNecessidadeRefeicao(Math.max(0, jogador.getNecessidadeRefeicao() - 20));
            jogador.setNecessidadeSocial(Math.max(0, jogador.getNecessidadeSocial() - 15));


            // Loop dos 4 momentos do dia
            String[] momentosDoDia = {"Manhã", "Meio-dia", "Tarde", "Noite"};
            for (String momento : momentosDoDia) {
                System.out.println("\n--- " + momento + " ---");
                exibirMenuAcoes(podeTerFilhos);
                realizarAcao(podeTerFilhos); // Passa podeTerFilhos para controlar a opção 10

                // Verifica se alguma necessidade está criticamente baixa após a ação
                if (jogador.getNecessidadeSono() < 25 || jogador.getNecessidadeRefeicao() < 25 || jogador.getNecessidadeSocial() < 25) {
                    System.out.println("\nSuas necessidades estão muito baixas! Priorize repô-las!");
                }
            }

            diaAtual++;
        }

        // --- Fim do Jogo ---
        System.out.println("\n--- Fim da Vida ---");
        jogador.mostrarDetalhes();
        verificarFimDeJogo();
    }

    /**
     * Exibe o menu de ações disponíveis para o jogador em cada momento do dia.
     * Restringe as opções se uma necessidade estiver criticamente baixa.
     * @param podeTerFilhos Indica se a opção de ter/adotar filhos deve ser exibida.
     */
    private void exibirMenuAcoes(boolean podeTerFilhos) {
        System.out.println("\nO que você quer fazer?");

        // Lógica de restrição de necessidades críticas
        if (jogador.getNecessidadeSono() < 25) {
            System.out.println("AVISO: Sua necessidade de sono está criticamente baixa! Você SÓ pode dormir.");
            System.out.println("1. Dormir");
            return; // Sai do método para não exibir outras opções
        } else if (jogador.getNecessidadeRefeicao() < 25) {
            System.out.println("AVISO: Sua necessidade de refeição está criticamente baixa! Você SÓ pode ter uma refeição.");
            System.out.println("1. Ter uma refeição (-5€)");
            return; // Sai do método
        } else if (jogador.getNecessidadeSocial() < 25) {
            System.out.println("AVISO: Sua necessidade social está criticamente baixa! Você SÓ pode socializar/hobby.");
            System.out.println("1. Falar com alguém/Jogar Computador/Praticar Hobby");
            return; // Sai do método
        }

        // Menu completo se não houver necessidades críticas
        System.out.println("1. Ir trabalhar " + (jogador.getProfissao() != null ? "" : "(Precisa de uma profissão)"));
        System.out.println("2. Dormir");
        System.out.println("3. Ter uma refeição (-5€)");
        System.out.println("4. Falar com alguém/Jogar Computador/Praticar Hobby");
        System.out.println("5. Ir às compras");
        System.out.println("6. Ter formação");
        System.out.println("7. Visitar as propriedades");
        System.out.println("8. Procurar nova profissão");
        System.out.println("9. Jogar Euromilhões (-10€)");
        if (podeTerFilhos) {
            System.out.println("10. Ter/Adotar filhos");
        }
    }


    /**
     * Executa a ação escolhida pelo jogador, com base nas restrições de necessidades críticas.
     * @param podeTerFilhos Indica se a opção de ter/adotar filhos está disponível.
     */
    private void realizarAcao(boolean podeTerFilhos) {
        int escolha;
        while (true) {
            System.out.print("Sua escolha: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Entrada inválida. Por favor, digite um número.");
                scanner.next();
            }
            escolha = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha

            // Lógica de restrição de necessidades críticas - agora apenas verifica a escolha
            if (jogador.getNecessidadeSono() < 25 && escolha != 1) { // Se sono crítico, só pode dormir (opção 1 na restrição)
                System.out.println("Você deve dormir agora!");
            } else if (jogador.getNecessidadeRefeicao() < 25 && escolha != 1) { // Se refeição crítico, só pode comer (opção 1 na restrição)
                System.out.println("Você deve comer agora!");
            } else if (jogador.getNecessidadeSocial() < 25 && escolha != 1) { // Se social crítico, só pode socializar (opção 1 na restrição)
                System.out.println("Você deve socializar agora!");
            } else {
                // Se chegou aqui, a escolha é válida ou não há restrição.
                // Ajusta a escolha para o menu completo se não houver restrição
                if (jogador.getNecessidadeSono() >= 25 && jogador.getNecessidadeRefeicao() >= 25 && jogador.getNecessidadeSocial() >= 25) {
                    // Mapeia a escolha para o menu completo
                    switch (escolha) {
                        case 1: // Trabalhar
                            if (jogador.getProfissao() != null) {
                                jogador.setDinheiro(jogador.getDinheiro() + jogador.getProfissao().getSalarioDia());
                                System.out.printf("Você trabalhou e ganhou %.2f€. Dinheiro atual: %.2f€.\n", jogador.getProfissao().getSalarioDia(), jogador.getDinheiro());
                            } else {
                                System.out.println("Você não tem uma profissão! Procure um emprego.");
                            }
                            break;
                        case 2: // Dormir
                            jogador.setNecessidadeSono(100);
                            System.out.println("Você dormiu bem. Necessidade de Sono: 100.");
                            break;
                        case 3: // Refeição
                            if (jogador.getDinheiro() >= 5) {
                                jogador.setDinheiro(jogador.getDinheiro() - 5);
                                jogador.setNecessidadeRefeicao(100);
                                System.out.printf("Você fez uma refeição. Necessidade de Refeição: 100. Dinheiro atual: %.2f€.\n", jogador.getDinheiro());
                            } else {
                                System.out.println("Você não tem dinheiro para comer!");
                            }
                            break;
                        case 4: // Socializar/Hobby
                            jogador.setNecessidadeSocial(100);
                            System.out.println("Você se divertiu. Necessidade Social: 100.");
                            break;
                        case 5: // Compras
                            shopping.vender(jogador);
                            break;
                        case 6: // Formação
                            jogador.setEducacao(jogador.getEducacao() + 2);
                            System.out.println("Você estudou e sua educação aumentou para: " + jogador.getEducacao());
                            break;
                        case 7: // Propriedades
                            if (jogador.getPropriedades().isEmpty()) {
                                System.out.println("Você não possui nenhuma propriedade ainda.");
                            } else {
                                System.out.println("\n--- Suas Propriedades ---");
                                for (Propriedade p : jogador.getPropriedades()) {
                                    System.out.printf("- %s (Custo: %.2f€, Estatuto: %d)\n", p.getNome(), p.getCusto(), p.getEstatuto());
                                }
                            }
                            break;
                        case 8: // Nova Profissão
                            procurarNovaProfissao();
                            break;
                        case 9: // Euromilhões
                            jogarEuromilhoes();
                            break;
                        case 10: // Ter/Adotar filhos
                            if (podeTerFilhos) {
                                terAdotarFilhos();
                            } else {
                                System.out.println("Opção inválida ou não disponível.");
                            }
                            break;
                        default:
                            System.out.println("Opção inválida. Por favor, escolha novamente.");
                            continue; // Continua o loop para pedir nova entrada
                    }
                } else { // Se há restrição, a escolha 1 (única opção) é mapeada para a ação correta
                    switch (escolha) {
                        case 1:
                            if (jogador.getNecessidadeSono() < 25) { // Era para dormir
                                jogador.setNecessidadeSono(100);
                                System.out.println("Você dormiu bem. Necessidade de Sono: 100.");
                            } else if (jogador.getNecessidadeRefeicao() < 25) { // Era para comer
                                if (jogador.getDinheiro() >= 5) {
                                    jogador.setDinheiro(jogador.getDinheiro() - 5);
                                    jogador.setNecessidadeRefeicao(100);
                                    System.out.printf("Você fez uma refeição. Necessidade de Refeição: 100. Dinheiro atual: %.2f€.\n", jogador.getDinheiro());
                                } else {
                                    System.out.println("Você não tem dinheiro para comer!");
                                }
                            } else if (jogador.getNecessidadeSocial() < 25) { // Era para socializar
                                jogador.setNecessidadeSocial(100);
                                System.out.println("Você se divertiu. Necessidade Social: 100.");
                            }
                            break;
                        default:
                            System.out.println("Opção inválida. Quando as necessidades estão baixas, você só pode escolher a opção que as repõe.");
                            continue; // Continua o loop para pedir nova entrada
                    }
                }
                break; // Sai do loop de escolha se a ação foi válida
            }
        }
    }


    /**
     * Permite ao jogador procurar e candidatar-se a uma nova profissão,
     * verificando os requisitos de formalidade, estatuto e educação.
     */
    private void procurarNovaProfissao() {
        System.out.println("\n--- Profissões Disponíveis ---");
        for (int i = 0; i < profissoesDisponiveis.size(); i++) {
            Profissao p = profissoesDisponiveis.get(i);
            System.out.printf("%d. %s (Salário/Dia: %.2f€, Formal: %s, Estatuto Necessário: %d, Educação Necessária: %d)\n",
                    (i + 1), p.getNome(), p.getSalarioDia(), p.isFormal() ? "Sim" : "Não", p.getEstatuto(), p.getNivelMinimoEducacao());
        }
        System.out.print("Escolha o número da profissão que deseja tentar ou 0 para voltar: ");
        int escolha;
        while (!scanner.hasNextInt()) {
            System.out.println("Entrada inválida. Por favor, digite um número.");
            scanner.next();
        }
        escolha = scanner.nextInt();
        scanner.nextLine();

        if (escolha > 0 && escolha <= profissoesDisponiveis.size()) {
            Profissao profissaoTentativa = profissoesDisponiveis.get(escolha - 1);

            boolean aptoFormal = true;
            if (profissaoTentativa.isFormal()) {
                aptoFormal = jogador.getPropriedades().stream()
                        .filter(p -> p instanceof AcessorioModa)
                        .map(p -> (AcessorioModa) p)
                        .anyMatch(AcessorioModa::isFormal);
            }

            boolean aptoEstatuto = jogador.getEstatuto() >= profissaoTentativa.getEstatuto();
            boolean aptoEducacao = jogador.getEducacao() >= profissaoTentativa.getNivelMinimoEducacao();

            if (aptoFormal && aptoEstatuto && aptoEducacao) {
                jogador.setProfissao(profissaoTentativa);
                System.out.println("Parabéns! Você foi contratado como " + profissaoTentativa.getNome() + "!");
            } else {
                System.out.println("Você não atende aos requisitos para esta profissão:");
                if (profissaoTentativa.isFormal() && !aptoFormal) System.out.println("- Precisa de um acessório de moda formal.");
                if (!aptoEstatuto) System.out.println("- Estatuto muito baixo (necessário: " + profissaoTentativa.getEstatuto() + ", seu: " + jogador.getEstatuto() + ").");
                if (!aptoEducacao) System.out.println("- Educação insuficiente (necessário: " + profissaoTentativa.getNivelMinimoEducacao() + ", seu: " + jogador.getEducacao() + ").");
            }
        } else if (escolha != 0) {
            System.out.println("Escolha inválida.");
        }
    }

    /**
     * Permite ao jogador apostar no Euromilhões, com chance de ganhar uma grande soma.
     */
    private void jogarEuromilhoes() {
        if (jogador.getDinheiro() >= 10) {
            jogador.setDinheiro(jogador.getDinheiro() - 10);
            System.out.print("Digite um número entre 1 e 200: ");
            int numJogador;
            while (!scanner.hasNextInt()) {
                System.out.println("Entrada inválida. Por favor, digite um número.");
                scanner.next();
            }
            numJogador = scanner.nextInt();
            scanner.nextLine();

            if (numJogador < 1 || numJogador > 200) {
                System.out.println("Número fora do intervalo. A aposta foi perdida.");
                System.out.printf("Dinheiro atual: %.2f€\n", jogador.getDinheiro());
                return;
            }

            int numSorteado = random.nextInt(200) + 1; // Número entre 1 e 200

            if (numJogador == numSorteado) {
                jogador.setDinheiro(jogador.getDinheiro() + 1_000_000);
                System.out.println("PARABÉNS! Você ganhou no Euromilhões! Ganhou 1.000.000€!");
            } else {
                System.out.println("Que pena! O número sorteado foi " + numSorteado + ". Você não ganhou desta vez.");
            }
            System.out.printf("Dinheiro atual: %.2f€\n", jogador.getDinheiro());
        } else {
            System.out.println("Você precisa de 10€ para jogar no Euromilhões.");
        }
    }

    // --- Eventos Obrigatórios ---

    /**
     * Evento no Dia 5: o jogador pode escolher ir para a universidade.
     */
    private void eventoUniversidade() {
        System.out.println("\n--- EVENTO ESPECIAL: O Dia 5 Chegou! ---");
        System.out.println("Você tem a oportunidade de ir para a universidade.");
        System.out.print("Deseja ir para a universidade? (s/n): ");
        String escolha = scanner.nextLine();

        if (escolha.equalsIgnoreCase("s")) {
            jogador.setEducacao(jogador.getEducacao() + 50);
            jogador.setDinheiro(jogador.getDinheiro() - 3000); // Contrai dívida
            System.out.printf("Parabéns! Você se matriculou na universidade. Educação +50. Dívida de 3.000€ contraída. Dinheiro atual: %.2f€\n", jogador.getDinheiro());
        } else {
            System.out.println("Você decidiu não ir para a universidade neste momento.");
        }
    }

    /**
     * Evento no Dia 22: o jogador pode escolher casar com um NPC.
     * Requer uma propriedade com capacidade para 2+ pessoas e estatuto mínimo.
     * @return true se o casamento ocorreu, false caso contrário.
     */
    private boolean eventoCasamento() {
        System.out.println("\n--- EVENTO ESPECIAL: Casamento! ---");
        System.out.println("É dia de tomar uma grande decisão! Você quer se casar?");
        System.out.print("Deseja casar? (s/n): ");
        String escolha = scanner.nextLine();

        if (escolha.equalsIgnoreCase("s")) {
            if (npcsDisponiveis.isEmpty()) {
                System.out.println("Não há NPCs disponíveis para casamento no momento.");
                return false;
            }
            System.out.println("Com quem você gostaria de se casar?");
            for (int i = 0; i < npcsDisponiveis.size(); i++) {
                NPC npc = npcsDisponiveis.get(i);
                System.out.printf("%d. %s (Dinheiro: %.2f€, Estatuto Mínimo: %d)\n", (i + 1), npc.getNome(), npc.getDinheiro(), npc.getEstatutoMinimo());
            }
            System.out.print("Sua escolha: ");
            int escolhaNPC;
            while (!scanner.hasNextInt()) {
                System.out.println("Entrada inválida. Por favor, digite um número.");
                scanner.next();
            }
            escolhaNPC = scanner.nextInt();
            scanner.nextLine();

            if (escolhaNPC > 0 && escolhaNPC <= npcsDisponiveis.size()) {
                NPC parceiro = npcsDisponiveis.get(escolhaNPC - 1);

                // Verificações para casar
                boolean temPropriedadeAdequada = jogador.getPropriedades().stream()
                        .filter(p -> p instanceof Imovel)
                        .map(p -> (Imovel) p)
                        .anyMatch(imovel -> imovel.getCapacidadePessoas() >= 2);

                boolean estatutoSuficiente = jogador.getEstatuto() >= parceiro.getEstatutoMinimo();

                if (temPropriedadeAdequada && estatutoSuficiente) {
                    jogador.adicionarMembroFamilia(parceiro);
                    jogador.setDinheiro(jogador.getDinheiro() + parceiro.getDinheiro()); // Ganha o dinheiro do NPC
                    // O NPC 'desaparece' da lista de disponíveis para casar, mas permanece na família
                    npcsDisponiveis.remove(parceiro); // Remove da lista de 'solteiros'

                    System.out.printf("Parabéns! Você se casou com %s! Seu dinheiro aumentou em %.2f€. Dinheiro atual: %.2f€.\n",
                            parceiro.getNome(), parceiro.getDinheiro(), jogador.getDinheiro());
                    System.out.println("A partir de agora, seu dinheiro aumentará em 30€/dia automaticamente.");
                    return true; // Casamento bem-sucedido
                } else {
                    System.out.println("Você não pode se casar com " + parceiro.getNome() + " por enquanto:");
                    if (!temPropriedadeAdequada) System.out.println("- Você precisa de uma propriedade (Imóvel) que albergue 2 ou mais pessoas.");
                    if (!estatutoSuficiente) System.out.println("- Seu estatuto (" + jogador.getEstatuto() + ") é muito baixo para casar com este NPC (mínimo: " + parceiro.getEstatutoMinimo() + ").");
                }
            } else {
                System.out.println("Escolha de NPC inválida.");
            }
        } else {
            System.out.println("Você decidiu não casar neste momento.");
        }
        return false; // Casamento não ocorreu
    }

    /**
     * Permite ao jogador ter ou adotar filhos, com uma chance aleatória,
     * desde que haja espaço em alguma propriedade.
     */
    private void terAdotarFilhos() {
        // Encontra a propriedade com maior capacidade
        int maiorCapacidade = jogador.getPropriedades().stream()
                .filter(p -> p instanceof Imovel)
                .mapToInt(p -> ((Imovel) p).getCapacidadePessoas())
                .max().orElse(0); // 0 se não tiver imóveis

        int pessoasNaCasa = jogador.getFamilia().size() + 1; // Jogador + membros da família

        if (maiorCapacidade > pessoasNaCasa) { // Há espaço para mais uma pessoa
            System.out.println("\n--- Evento: Ter/Adotar Filhos ---");
            System.out.print("Deseja ter ou adotar um filho? (s/n): ");
            String escolha = scanner.nextLine();

            if (escolha.equalsIgnoreCase("s")) {
                // Fator aleatório: 70% de chance de ter/adotar um filho
                if (random.nextDouble() < 0.7) {
                    // Cria um NPC para representar o filho (sem dinheiro ou estatuto inicial)
                    NPC filho = new NPC("Filho " + (jogador.getFamilia().size() + 1), 0, 0);
                    jogador.adicionarMembroFamilia(filho);
                    System.out.println("Parabéns! Um novo membro, " + filho.getNome() + ", se juntou à sua família!");
                } else {
                    System.out.println("Parece que não foi dessa vez. Tente novamente mais tarde!");
                }
            } else {
                System.out.println("Você decidiu não ter/adotar filhos neste momento.");
            }
        } else {
            System.out.println("Você não tem espaço suficiente em suas propriedades (imóveis) para ter mais filhos.");
        }
    }


    // --- Eventos Aleatórios (Pelo menos 6) ---

    /**
     * Verifica e executa eventos aleatórios no jogo, com uma certa probabilidade.
     * @param diaAtual O dia atual do jogo.
     */
    private void checarEventosAleatorios(int diaAtual) {
        int chance = random.nextInt(100); // 0-99

        if (chance < 15) { // 15% de chance para eventos
            int tipoEvento = random.nextInt(6); // 6 tipos de eventos aleatórios (0 a 5)

            switch (tipoEvento) {
                case 0: // Bom: Aumento de salário inesperado
                    if (jogador.getProfissao() != null && diaAtual > 10) { // Só acontece depois de ter emprego
                        double aumento = jogador.getProfissao().getSalarioDia() * (random.nextDouble() * 0.1 + 0.05); // 5% a 15% de aumento
                        Profissao profissaoAtual = jogador.getProfissao();
                        profissaoAtual.setSalarioDia(profissaoAtual.getSalarioDia() + aumento);
                        System.out.printf("\n[EVENTO BOM] Seu chefe gostou do seu trabalho! Seu salário diário aumentou em %.2f€! Novo salário: %.2f€.\n", aumento, profissaoAtual.getSalarioDia());
                    }
                    break;
                case 1: // Mau: Problema com propriedade (custo de reparo)
                    if (!jogador.getPropriedades().isEmpty()) {
                        Propriedade p = jogador.getPropriedades().get(random.nextInt(jogador.getPropriedades().size()));
                        double custoReparo = p.getCusto() * (random.nextDouble() * 0.03 + 0.01); // 1% a 4% do custo da propriedade
                        jogador.setDinheiro(jogador.getDinheiro() - custoReparo);
                        System.out.printf("\n[EVENTO MAU] Problemas com sua propriedade '%s'! Você gastou %.2f€ em reparos. Dinheiro atual: %.2f€.\n", p.getNome(), custoReparo, jogador.getDinheiro());
                    }
                    break;
                case 2: // Bom: Encontra dinheiro na rua
                    double dinheiroEncontrado = random.nextInt(100) + 20; // Entre 20 e 120
                    jogador.setDinheiro(jogador.getDinheiro() + dinheiroEncontrado);
                    System.out.printf("\n[EVENTO BOM] Você encontrou %.2f€ na rua! Que sorte! Dinheiro atual: %.2f€.\n", dinheiroEncontrado, jogador.getDinheiro());
                    break;
                case 3: // Mau: Doença (necessidades diminuem mais rápido)
                    System.out.println("\n[EVENTO MAU] Você pegou um resfriado! Suas necessidades diminuirão mais rápido hoje.");
                    jogador.setNecessidadeSono(Math.max(0, jogador.getNecessidadeSono() - 15)); // Extra
                    jogador.setNecessidadeRefeicao(Math.max(0, jogador.getNecessidadeRefeicao() - 15)); // Extra
                    jogador.setNecessidadeSocial(Math.max(0, jogador.getNecessidadeSocial() - 15)); // Extra
                    break;
                case 4: // Bom: Bônus de Educação
                    if (jogador.getEducacao() < 100) { // Limita o bônus para educação não ficar muito alta
                        int bonusEducacao = random.nextInt(10) + 3; // Entre 3 e 12
                        jogador.setEducacao(jogador.getEducacao() + bonusEducacao);
                        System.out.printf("\n[EVENTO BOM] Você aprendeu algo novo inesperadamente! Educação +%d. Nível de educação atual: %d.\n", bonusEducacao, jogador.getEducacao());
                    }
                    break;
                case 5: // Mau: Roubo
                    if (jogador.getDinheiro() > 50) {
                        double dinheiroPerdido = jogador.getDinheiro() * (random.nextDouble() * 0.15 + 0.05); // Perde 5% a 20% do dinheiro
                        jogador.setDinheiro(jogador.getDinheiro() - dinheiroPerdido);
                        System.out.printf("\n[EVENTO MAU] Você foi roubado! Perdeu %.2f€. Dinheiro atual: %.2f€.\n", dinheiroPerdido, jogador.getDinheiro());
                    } else {
                        System.out.println("\n[EVENTO MAU] Quase foi roubado, mas você não tinha muito dinheiro para perder.");
                    }
                    break;
                // Adicione mais eventos aqui!
            }
        }
    }


    /**
     * Verifica as condições de vitória ou derrota no final do jogo,
     * com base no objetivo de vida do jogador e no seu estado financeiro.
     */
    private void verificarFimDeJogo() {
        System.out.println("\n--- AVALIAÇÃO FINAL ---");

        // Condição de perda: dívida
        if (jogador.getDinheiro() < 0) {
            System.out.printf("Você terminou o jogo com dívidas (%.2f€)! Infelizmente, você perdeu.\n", jogador.getDinheiro());
            permitirNovoJogo(false); // Perdeu, então não pode usar a mesma personagem para recomeçar
            return;
        }

        boolean objetivoAlcancado = false;
        switch (jogador.getObjetivoVida()) {
            case MILIONARIO:
                double valorTotalPatrimonio = jogador.getDinheiro();
                for (Propriedade p : jogador.getPropriedades()) {
                    valorTotalPatrimonio += p.getCusto();
                }
                if (valorTotalPatrimonio >= 1_000_000) {
                    objetivoAlcancado = true;
                    System.out.printf("Você alcançou o objetivo de Milionário! Seu patrimônio total é de %.2f€.\n", valorTotalPatrimonio);
                } else {
                    System.out.printf("Para ser Milionário, precisava de 1.000.000€. Seu patrimônio total é de %.2f€.\n", valorTotalPatrimonio);
                }
                break;
            case FAMILIA_COMPLETA:
                if (jogador.getFamilia().size() >= 4) { // 4 membros da família + jogador = 5 pessoas na casa
                    objetivoAlcancado = true;
                    System.out.printf("Você alcançou o objetivo de Família Completa! Sua família tem %d membros (incluindo o jogador).\n", jogador.getFamilia().size() + 1);
                } else {
                    System.out.printf("Para ter uma Família Completa, precisava de 5 ou mais membros (incluindo o jogador). Sua família tem %d membros.\n", jogador.getFamilia().size() + 1);
                }
                break;
            case CELEBRIDADE:
                // Exemplo: atingir um alto estatuto e ter muitas propriedades de moda
                if (jogador.getEstatuto() >= 200 &&
                        jogador.getPropriedades().stream().filter(p -> p instanceof AcessorioModa).count() >= 5) {
                    objetivoAlcancado = true;
                    System.out.println("Você se tornou uma Celebridade! Alto estatuto e muitos acessórios de moda!");
                } else {
                    System.out.println("Para ser Celebridade, precisava de alto estatuto (mín. 200) e 5+ acessórios de moda.");
                }
                break;
            case PROFESSOR:
                // Exemplo: alta educação e uma profissão de professor
                if (jogador.getEducacao() >= 50 && jogador.getProfissao() != null &&
                        jogador.getProfissao().getNome().equalsIgnoreCase("Professor Universitário")) {
                    objetivoAlcancado = true;
                    System.out.println("Você se tornou um Professor Universitário! Alta educação e a profissão certa!");
                } else {
                    System.out.println("Para ser Professor, precisava de educação alta (mín. 50) e ser Professor Universitário.");
                }
                break;
            default:
                System.out.println("Objetivo de vida não reconhecido para verificação final.");
                break;
        }

        if (objetivoAlcancado) {
            System.out.println("\nPARABÉNS! Você alcançou seu objetivo de vida e venceu o jogo!");
            permitirNovoJogo(true);
        } else {
            System.out.println("\nVocê não alcançou seu objetivo de vida desta vez.");
            permitirNovoJogo(false);
        }
    }

    /**
     * Oferece ao jogador a opção de jogar novamente com a mesma personagem
     * ou começar um novo jogo.
     * @param vitoria Indica se o jogador venceu ou perdeu o jogo atual.
     */
    private void permitirNovoJogo(boolean vitoria) {
        System.out.println("\nDeseja jogar novamente?");
        if (vitoria) { // Se venceu, pode recomeçar com a mesma personagem
            System.out.println("1. Jogar com a mesma Personagem (recomeçar do Dia 1)");
        }
        System.out.println("2. Começar um Novo Jogo (nova Personagem)");
        System.out.println("0. Sair do Jogo");
        System.out.print("Sua escolha: ");
        int escolha;
        while (!scanner.hasNextInt()) {
            System.out.println("Entrada inválida. Por favor, digite um número.");
            scanner.next();
        }
        escolha = scanner.nextInt();
        scanner.nextLine();

        if (escolha == 1 && vitoria) { // Só permite esta opção se houve vitória
            System.out.println("Recomeçando o jogo com a mesma personagem...");
            // Resetar o estado do jogador para um novo jogo
            jogador.setDinheiro(0);
            jogador.setProfissao(null);
            jogador.setNecessidadeSono(100);
            jogador.setNecessidadeRefeicao(100);
            jogador.setNecessidadeSocial(100);
            jogador.setEducacao(0);
            jogador.getPropriedades().clear();
            jogador.getFamilia().clear();
            jogador.atualizarEstatuto(); // Recalcula o estatuto após limpar propriedades
            jogo(); // Inicia o loop do jogo novamente
        } else if (escolha == 2) {
            System.out.println("Começando um novo jogo...");
            criarPessoa();
            jogo();
        } else {
            System.out.println("Obrigado por jogar!");
            scanner.close(); // Fechar o scanner ao sair
        }
    }

    // --- Getters (se necessário) ---
    public Jogador getJogador() {
        return jogador;
    }
}
