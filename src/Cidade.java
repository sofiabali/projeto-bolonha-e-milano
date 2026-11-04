package bolonhaemilano;

public class Cidade {

    private String nome;
    private int anoAtual;
    private Jogador dono;

    private int florins;
    private int terras;
    private int graos;
    private int servos;

    public Cidade(String nome, Jogador dono) {
        this.nome = nome;
        this.dono = dono;

        this.anoAtual = 1400;

        this.florins = 1000;
        this.terras = 10000;
        this.graos = 500;
        this.servos = 200;
    }

    public String getNome() {
        return nome;
    }

    public int getAnoAtual() {
        return anoAtual;
    }

    public Jogador getDono() {
        return dono;
    }

    public int getFlorins() {
        return florins;
    }

    public int getTerras() {
        return terras;
    }

    public int getGraos() {
        return graos;
    }

    public int getServos() {
        return servos;
    }

    public void avancarAno() {
        anoAtual++;
    }

    public void adicionarFlorins(int quantidade) {
        if (quantidade > 0) {
            florins += quantidade;
        }
    }

    public boolean removerFlorins(int quantidade) {
        if (quantidade <= 0 || florins < quantidade) {
            return false;
        }

        florins -= quantidade;
        return true;
    }

    public void adicionarTerras(int quantidade) {
        if (quantidade > 0) {
            terras += quantidade;
        }
    }

    public boolean removerTerras(int quantidade) {
        if (quantidade <= 0 || terras < quantidade) {
            return false;
        }

        terras -= quantidade;
        return true;
    }

    public void adicionarGraos(int quantidade) {
        if (quantidade > 0) {
            graos += quantidade;
        }
    }

    public boolean removerGraos(int quantidade) {
        if (quantidade <= 0 || graos < quantidade) {
            return false;
        }

        graos -= quantidade;
        return true;
    }

    public void adicionarServos(int quantidade) {
        if (quantidade > 0) {
            servos += quantidade;
        }
    }

    public boolean removerServos(int quantidade) {
        if (quantidade <= 0 || servos < quantidade) {
            return false;
        }

        servos -= quantidade;
        return true;
    }

    public void exibirStatus() {
        System.out.println("\n===== STATUS DA CIDADE =====");

        System.out.println("Cidade: " + nome);
        System.out.println("Governante: " + dono.getNome());
        System.out.println("Título: " + dono.getTitulo());
        System.out.println("Ano atual: " + anoAtual);

        System.out.println("\n===== RECURSOS =====");

        System.out.println("Florins: " + florins);
        System.out.println("Terras: " + terras + " hectares");
        System.out.println("Grãos: " + graos);
        System.out.println("Servos: " + servos);

        System.out.println("============================");
    }
}