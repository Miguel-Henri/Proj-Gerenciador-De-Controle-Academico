import java.util.ArrayList;

public class Aluno extends Usuario {
    private String prontuario;
    private String nome;
    private String dataNascimento;
    private ArrayList<Double> notas;
    private int faltas;

    private Turma turma; 

    public Aluno(String Usuario, String Senha, String prontuario, String nome, String dataNascimento) {
        super(Usuario, Senha);
        this.prontuario = prontuario;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.notas = new ArrayList<>();
        this.faltas = 0;
        this.turma = null;
    }

    // Métodos de acesso
    public String getProntuarioAluno() {
        return prontuario;
    }

    public String getNomeAluno() {
        return nome;
    }

    public String getDataNascimentoAluno() {
        return dataNascimento;
    }

    public int getFaltas() {
        return faltas;
    }


    public void matricularTurma(Turma turma) {
        this.turma = turma;
        turma.adicionarAluno(this);
        System.out.println("Aluno " + nome + " matriculado na turma " + turma.getCodigoTurma() + " com sucesso!");
    }

 
    public void consultarRendimento() {
        if (this.turma == null) {
            System.out.println("O aluno não está matriculado em nenhuma turma.");
            return;
        }

        System.out.println("Rendimento do aluno " + nome + ":");


        System.out.println("Faltas: " + faltas);


        System.out.println("Notas: ");
        if (notas.isEmpty()) {
            System.out.println("Nenhuma nota registrada.");
        } else {
            for (int i = 0; i < notas.size(); i++) {
                System.out.println("Nota " + (i + 1) + ": " + notas.get(i));
            }
        }
    }


    public void adicionarNota(double nota) {
        notas.add(nota);
        System.out.println("Nota de " + nome + " registrada: " + nota);
    }


    public void adicionarFaltas(int quantidadeFaltas) {
        if (quantidadeFaltas < 0) {
            System.out.println("A quantidade de faltas não pode ser negativa.");
        } else {
            this.faltas += quantidadeFaltas;
            System.out.println("Faltas de " + nome + " atualizadas. Total de faltas: " + faltas);
        }
    }

    public ArrayList<Double> getNotas() {
        return notas;
    }
}
