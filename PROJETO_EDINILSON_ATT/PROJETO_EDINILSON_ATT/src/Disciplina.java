/**
 * Classe responsável por representar uma disciplina.
 * Contém informações sobre o nome, sigla, ementa, carga horária e número de aulas.
 * 
 * @author Gabriel, Miguel
 */
public class Disciplina {

    /**
     * Nome da disciplina.
     */
    private String nomeDisciplina;

    /**
     * Sigla da disciplina.
     */
    private String siglaDisciplina;

    /**
     * Ementa da disciplina.
     */
    private String ementa;

    /**
     * Carga horária da disciplina.
     */
    private int cargaHoraria;

    /**
     * Total de aulas da disciplina.
     */
    private int totalAulas;

    /**
     * Construtor para inicializar a disciplina.
     * 
     * @param nomeDisciplina Nome da disciplina.
     * @param siglaDisciplina Sigla da disciplina.
     * @param ementa Ementa da disciplina.
     * @param cargaHoraria Carga horária da disciplina.
     * @param totalAulas Total de aulas da disciplina.
     */
    public Disciplina(String nomeDisciplina, String siglaDisciplina, String ementa, int cargaHoraria, int totalAulas) {
        this.nomeDisciplina = nomeDisciplina;
        this.siglaDisciplina = siglaDisciplina;
        this.ementa = ementa;
        this.cargaHoraria = cargaHoraria;
        this.totalAulas = totalAulas;
    }

    /**
     * Obtém o nome da disciplina.
     * 
     * @return Nome da disciplina.
     */
    public String getNomeDisciplina() {
        return nomeDisciplina;
    }
}
