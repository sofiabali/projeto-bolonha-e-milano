
package bolonhaemilano;

public class Mercado {

    private static final int PRECO_GRAO = 2;
    private static final int PRECO_TERRA = 10;

    public int getPrecoGrao() {
        return PRECO_GRAO;
    }

    public int getPrecoTerra() {
        return PRECO_TERRA;
    }

    public boolean comprarGraos(Cidade cidade, int quantidade) {

        if (quantidade <= 0) {
            return false;
        }

        int custo = quantidade * PRECO_GRAO;

        if (!cidade.removerFlorins(custo)) {
            return false;
        }

        cidade.adicionarGraos(quantidade);

        return true;
    }

    public boolean venderGraos(Cidade cidade, int quantidade) {

        if (quantidade <= 0) {
            return false;
        }

        if (!cidade.removerGraos(quantidade)) {
            return false;
        }

        int receita = quantidade * PRECO_GRAO;

        cidade.adicionarFlorins(receita);

        return true;
    }

    public boolean comprarTerras(Cidade cidade, int quantidade) {

        if (quantidade <= 0) {
            return false;
        }

        int custo = quantidade * PRECO_TERRA;

        if (!cidade.removerFlorins(custo)) {
            return false;
        }

        cidade.adicionarTerras(quantidade);

        return true;
    }

    public boolean venderTerras(Cidade cidade, int quantidade) {

        if (quantidade <= 0) {
            return false;
        }

        if (!cidade.removerTerras(quantidade)) {
            return false;
        }

        int receita = quantidade * PRECO_TERRA;

        cidade.adicionarFlorins(receita);

        return true;
    }
}