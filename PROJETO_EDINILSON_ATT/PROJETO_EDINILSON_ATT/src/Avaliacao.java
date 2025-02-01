/**
 * Representa uma avaliação no sistema, que contém um nome e um peso.
 * O peso da avaliação é usado para calcular a média ponderada dos alunos.
 * @author Tufy
 */
public class Avaliacao {
    
    private String nome;
    private double peso;

    /**
     * Construtor para criar uma nova avaliação.
     * 
     * @param nome Nome da avaliação.
     * @param peso Peso da avaliação, representado como uma porcentagem (0 a 100).
     */
    public Avaliacao(String nome, double peso) {
        this.nome = nome;
        this.peso = peso;
    }

    /**
     * Obtém o nome da avaliação.
     * 
     * @return O nome da avaliação.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Obtém o peso da avaliação.
     * O peso é representado como uma porcentagem.
     * 
     * @return O peso da avaliação.
     */
    public double getPeso() {
        return peso;
    }
}
