
package bolonhaemilano;

public class Jogador {

    private String nome;
    private String titulo;

    public Jogador(String nome) {
        this.nome = nome;
        this.titulo = "Cavaleiro";
    }

    public String getNome() {
        return nome;
    }

    public String getTitulo() {
        return titulo;
    }
}