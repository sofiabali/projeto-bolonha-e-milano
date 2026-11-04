package bolonhaemilano;

import java.util.Scanner;

public class Menu {
    private Scanner scanner;
    private boolean emExecucao;
    private Jogador jogador;
    private Cidade cidade;
    private Mercado mercado;
    private Agricultura agricultura;

    public Menu() {
        scanner = new Scanner(System.in);
        emExecucao = true;
        mercado = new Mercado();
        agricultura = new Agricultura();
    }

    public void executar() {
        while (emExecucao) {
            exibirOpcoes();
            int opcao = lerOpcao();
            processarOpcao(opcao);
        }
    }

    private void exibirOpcoes() {
        System.out.println("\n===== BOLONHA E MILANO =====");
        System.out.println("1 - Novo jogo");
        System.out.println("2 - Ver status da cidade");
        System.out.println("3 - Acessar mercado");
        System.out.println("4 - Acessar agricultura");
        System.out.println("5 - Sobre o jogo");
        System.out.println("0 - Sair");
        System.out.print("Escolha uma opção: ");
    }

    private int lerOpcao() {
        String entrada = scanner.nextLine().trim();
        try {
            return Integer.parseInt(entrada);
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private void processarOpcao(int opcao) {
        switch (opcao) {
            case 1: iniciarNovoJogo(); break;
            case 2: exibirStatus(); break;
            case 3:
                if (cidade != null) abrirMercado();
                else System.out.println("Inicie um novo jogo primeiro!");
                break;
            case 4:
                if (cidade != null) abrirAgricultura();
                else System.out.println("Inicie um novo jogo primeiro!");
                break;
            case 5: exibirSobre(); break;
            case 0:
                emExecucao = false;
                System.out.println("Saindo do jogo...");
                break;
            default: System.out.println("Opção inválida!");
        }
    }

    private void iniciarNovoJogo() {
        System.out.print("Digite o nome do jogador: ");
        String nomeJogador = scanner.nextLine().trim();
        System.out.print("Digite o nome da cidade: ");
        String nomeCidade = scanner.nextLine().trim();

        if (nomeJogador.isEmpty() || nomeCidade.isEmpty()) {
            System.out.println("Os nomes não podem ficar vazios.");
            return;
        }

        jogador = new Jogador(nomeJogador);
        cidade = new Cidade(nomeCidade, jogador);
        System.out.println("Novo jogo iniciado com sucesso!");
    }

    private void exibirStatus() {
        if (cidade == null) {
            System.out.println("Nenhum jogo iniciado. Escolha Novo jogo primeiro.");
            return;
        }
        cidade.exibirStatus();
    }

    private void abrirMercado() {
        boolean noMercado = true;
        while (noMercado) {
            System.out.println("\n===== MERCADO =====");
            System.out.println("Florins disponíveis: " + cidade.getFlorins());
            System.out.println("Preço do grão: " + mercado.getPrecoGrao() + " florins por unidade");
            System.out.println("Preço da terra: " + mercado.getPrecoTerra() + " florins por hectare");
            System.out.println("1 - Comprar grãos");
            System.out.println("2 - Vender grãos");
            System.out.println("3 - Comprar terras");
            System.out.println("4 - Vender terras");
            System.out.println("0 - Voltar");
            System.out.print("Escolha uma opção: ");

            int opcao = lerOpcao();
            switch (opcao) {
                case 1: comprarGraos(); break;
                case 2: venderGraos(); break;
                case 3: comprarTerras(); break;
                case 4: venderTerras(); break;
                case 0: noMercado = false; break;
                default: System.out.println("Opção inválida!");
            }
        }
    }

    private int lerQuantidade() {
        System.out.print("Digite a quantidade: ");
        int quantidade = lerOpcao();
        if (quantidade <= 0) {
            System.out.println("Digite uma quantidade inteira maior que zero.");
            return 0;
        }
        return quantidade;
    }

    private void comprarGraos() {
        int quantidade = lerQuantidade();
        if (quantidade > 0 && mercado.comprarGraos(cidade, quantidade))
            System.out.println("Compra de grãos realizada!");
        else if (quantidade > 0)
            System.out.println("Não foi possível comprar. Verifique seus florins.");
    }

    private void venderGraos() {
        int quantidade = lerQuantidade();
        if (quantidade > 0 && mercado.venderGraos(cidade, quantidade))
            System.out.println("Venda de grãos realizada!");
        else if (quantidade > 0)
            System.out.println("Não foi possível vender. Verifique seu estoque de grãos.");
    }

    private void comprarTerras() {
        int quantidade = lerQuantidade();
        if (quantidade > 0 && mercado.comprarTerras(cidade, quantidade))
            System.out.println("Compra de terras realizada!");
        else if (quantidade > 0)
            System.out.println("Não foi possível comprar. Verifique seus florins.");
    }

    private void venderTerras() {
        int quantidade = lerQuantidade();
        if (quantidade > 0 && mercado.venderTerras(cidade, quantidade))
            System.out.println("Venda de terras realizada!");
        else if (quantidade > 0)
            System.out.println("Não foi possível vender. Verifique seu estoque de terras.");
    }

    private void abrirAgricultura() {
        boolean naAgricultura = true;
        while (naAgricultura) {
            System.out.println("\n===== AGRICULTURA =====");
            System.out.println("Terras: " + cidade.getTerras());
            System.out.println("Servos: " + cidade.getServos());
            System.out.println("Grãos: " + cidade.getGraos());
            System.out.println("\n1 - Colher");
            System.out.println("2 - Distribuir alimentos");
            System.out.println("0 - Voltar");
            System.out.print("Escolha uma opção: ");

            int opcao = lerOpcao();
            switch (opcao) {
                case 1: colher(); break;
                case 2: distribuirAlimentos(); break;
                case 0: naAgricultura = false; break;
                default: System.out.println("Opção inválida!");
            }
        }
    }

    private void colher() {
        int hectares = agricultura.processarColheita(cidade);
        System.out.println("\n===== COLHEITA REALIZADA =====");
        System.out.println("Hectares cultivados: " + hectares);
        System.out.println("Grãos disponíveis: " + cidade.getGraos());
    }

    private void distribuirAlimentos() {
        System.out.print("Digite o percentual de distribuição (20 a 80): ");
        int percentual = lerOpcao();
        boolean sucesso = agricultura.distribuirAlimentos(cidade, percentual);

        if (sucesso) {
            System.out.println("Alimentos distribuídos!");
            System.out.println("Servos atuais: " + cidade.getServos());
            System.out.println("Grãos restantes: " + cidade.getGraos());
        } else {
            System.out.println("Percentual inválido! Digite um valor entre 20 e 80.");
        }
    }

    private void exibirSobre() {
        System.out.println("\nBolonha e Milano");
        System.out.println("Jogo de estratégia e administração de uma cidade medieval.");
        System.out.println("Etapa 4: agricultura e população.");
    }
}