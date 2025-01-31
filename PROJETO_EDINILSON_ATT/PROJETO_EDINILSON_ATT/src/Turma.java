import java.util.ArrayList;

public class Turma {
    private String codigoTurma;
    private Disciplina disciplina;
    private ArrayList<Aluno> alunos;
    private Professor professores;

    public Turma(String codigoTurma, Disciplina disciplina, Professor usuario) {
        this.codigoTurma = codigoTurma;
        this.disciplina = disciplina;
        this.alunos = new ArrayList<>();
        this.professores = usuario;
    }

    // Métodos de acesso
    public String getCodigoTurma() {
        return codigoTurma;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public Professor getProfessores() {
        return professores;
    }

    public ArrayList<Aluno> getAlunos() {
        return alunos;
    }

    public void adicionarAluno(Aluno aluno) {
        if (!alunos.contains(aluno)) {
            alunos.add(aluno);
            System.out.println("Aluno " + aluno.getNomeAluno() + " adicionado à turma " + codigoTurma);
        } else {
            System.out.println("O aluno " + aluno.getNomeAluno() + " já está matriculado nesta turma.");
        }
    }
}
