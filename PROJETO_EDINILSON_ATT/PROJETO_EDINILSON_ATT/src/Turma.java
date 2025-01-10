import java.util.ArrayList;

public class Turma {
    private String prontuario;
    private Disciplina disciplina;
    private Professor professor;
    private ArrayList<Aluno> alunos = new ArrayList<>();
    private int qtddDeAvaliacoes;
    private String ano;

    public Turma(String prontuario, Disciplina diciplina, Professor professor, int qtddDeAvaliacoes, String ano){
        this.prontuario = prontuario;
        this.disciplina = diciplina;
        this.professor = professor;
        this.qtddDeAvaliacoes = qtddDeAvaliacoes;
        this.ano = ano;
    }

    public String getProntuario(){
        return prontuario;
    }
    public int getQtddDeAvaliacoes(){
        return qtddDeAvaliacoes;
    }
    public String getAno(){
        return ano;
    }

    private void getAlunos(){
        for(int i = 0; i < alunos.size(); i++){
            System.out.println("\nProntuario " + alunos.get(i).getProntuarioAluno() + " Nome: " + alunos.get(i).getNomeAluno() + " data de nascimento: " + alunos.get(i).getDataNascimentoAluno());
            alunos.get(i).getArrayNotas();
        }
    }

    public void addAlunoNaTurma(Aluno alunoNovo){
        alunos.add(alunoNovo);
        System.out.println("aluno adicionado");
    }

    

    public void mostrarTurma(){
        System.out.println("\n\nprontuario da turma: " + prontuario);
        System.out.println("prontuario da Disciplina: " + disciplina.getProntuario());
        System.out.println("nome da disciplina : " + disciplina.getNomeDisciplina());
        System.out.println("ano: " + getAno());
        System.out.println("\n\nprofessor : " + professor.getNomeProfessor());
        System.out.println("prontuario do professor : " + professor.getProntuarioProfessor());
        System.out.println("data de nascimento do professor : " + professor.getDataNascimentoProfessor());
        System.out.println("quantidade de avaliações: " + getQtddDeAvaliacoes());
        System.out.println("\n\nAlunos da turma:");
        getAlunos();
        
        
    }
}
