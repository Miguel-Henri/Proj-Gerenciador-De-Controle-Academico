import java.util.ArrayList;

/**
 * Representa um aluno no sistema, com informações como prontuário, nome, data de nascimento,
 * notas e faltas. A classe permite o cadastro de notas, faltas e consulta ao desempenho do aluno.
 * @author Tufy, Gabriel, Miguel
 */
public class Aluno extends Usuario {
    
    private String prontuario;
    private String nome;
    private String dataNascimento;
    private ArrayList<Double> notas;
    private int faltas;

    private Turma turma; 

    /**
     * Construtor para criar um novo aluno.
     * 
     * @param Usuario O nome de usuário do aluno.
     * @param Senha A senha do aluno.
     * @param prontuario O prontuário do aluno.
     * @param nome O nome do aluno.
     * @param dataNascimento A data de nascimento do aluno.
     */
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

    /**
     * Obtém o prontuário do aluno.
     * 
     * @return O prontuário do aluno.
     */
    public String getProntuarioAluno() {
        return prontuario;
    }

    /**
     * Obtém o nome do aluno.
     * 
     * @return O nome do aluno.
     */
    public String getNomeAluno() {
        return nome;
    }

    /**
     * Obtém a data de nascimento do aluno.
     * 
     * @return A data de nascimento do aluno.
     */
    public String getDataNascimentoAluno() {
        return dataNascimento;
    }

    /**
     * Obtém o total de faltas do aluno.
     * 
     * @return O número de faltas do aluno.
     */
    public int getFaltas() {
        return faltas;
    }

    /**
     * Matricula o aluno em uma turma.
     * 
     * @param turma A turma em que o aluno será matriculado.
     */
    public void matricularTurma(Turma turma) {
        this.turma = turma;
        turma.adicionarAluno(this);
        System.out.println("Aluno " + nome + " matriculado na turma " + turma.getCodigoTurma() + " com sucesso!");
    }

    /**
     * Consulta o desempenho do aluno, exibindo suas faltas e notas registradas.
     */
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

    /**
     * Adiciona uma nova nota ao histórico do aluno.
     * 
     * @param nota A nota a ser registrada.
     */
    public void adicionarNota(double nota) {
        notas.add(nota);
        System.out.println("Nota de " + nome + " registrada: " + nota);
    }

    /**
     * Adiciona faltas ao histórico do aluno.
     * 
     * @param quantidadeFaltas A quantidade de faltas a ser adicionada.
     */
    public void adicionarFaltas(int quantidadeFaltas) {
        if (quantidadeFaltas < 0) {
            System.out.println("A quantidade de faltas não pode ser negativa.");
        } else {
            this.faltas += quantidadeFaltas;
            System.out.println("Faltas de " + nome + " atualizadas. Total de faltas: " + faltas);
        }
    }

    /**
     * Obtém a lista de notas do aluno.
     * 
     * @return A lista de notas do aluno.
     */
    public ArrayList<Double> getNotas() {
        return notas;
    }
}
