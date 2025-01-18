import java.util.ArrayList;

public class Turma {
	private String codigoTurma;
	private Disciplina disciplina;
	private Professor usuario;
	private ArrayList<Professor> professores;
	private ArrayList<Avaliacao> avaliacoes;
	
	
    public Turma(String codigoTurma,Disciplina disciplina,Professor usuario) {
    	this.codigoTurma = codigoTurma;
    	this.disciplina = disciplina;
    	this.usuario = usuario;
        professores = new ArrayList<>();
        avaliacoes = new ArrayList<>();
    }
    
    public String getCodigoTurma() {
    	return codigoTurma;
    }
    public Disciplina getDisciplina() {
    	return disciplina;
    }
     
    public ArrayList<Professor> getProfessores() {
        return professores;
    }
    
	
    
    public ArrayList<Avaliacao> getAvaliacoes() {
        return avaliacoes;
    }

    public void setAvaliacoes(ArrayList<Avaliacao> avaliacoes) {
        this.avaliacoes = avaliacoes;
    }
}
