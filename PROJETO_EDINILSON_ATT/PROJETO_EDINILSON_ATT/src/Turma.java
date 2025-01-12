import java.util.ArrayList;

public class Turma {
	private String codigoTurma;
	private Disciplina disciplina;
	private Professor usuario;
    public Turma(String codigoTurma,Disciplina disciplina,Professor usuario) {
    	this.codigoTurma = codigoTurma;
    	this.disciplina = disciplina;
    	this.usuario = usuario;
    }
    
    public String getCodigoTurma() {
    	return codigoTurma;
    }
    public Disciplina getDisciplina() {
    	return disciplina;
    }
     
    public Professor getProfessores(){
    	return usuario;
    }
}
