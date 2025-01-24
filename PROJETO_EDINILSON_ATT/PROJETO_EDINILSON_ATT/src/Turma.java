import java.util.ArrayList;

public class Turma {
	private String codigoTurma;
	private Disciplina disciplina;
    private ArrayList<Aluno> alunos;
	private ArrayList<Professor> professores;
	private ArrayList<Avaliacao> avaliacoes;
	
	
    public Turma(String codigoTurma,Disciplina disciplina,Professor usuario) {
    	this.codigoTurma = codigoTurma;
    	this.disciplina = disciplina;
        this.alunos = new ArrayList<>();
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


    public ArrayList<Aluno> getAlunos() {
        return alunos;
    }


    public void adicionarAluno(Aluno aluno) {
        alunos.add(aluno);
    }

    public Aluno buscarAluno(String prontuario) {

        for (int i = 0; i < alunos.size(); i++) {
            if (alunos.get(i).getProntuarioAluno().equals(prontuario)) {
                return alunos.get(i);
            }
        }
        return null; 
    }



    
	
    
    public ArrayList<Avaliacao> getAvaliacoes() {
        return avaliacoes;
    }

    public void setAvaliacoes(ArrayList<Avaliacao> avaliacoes) {
        this.avaliacoes = avaliacoes;
    }
}
