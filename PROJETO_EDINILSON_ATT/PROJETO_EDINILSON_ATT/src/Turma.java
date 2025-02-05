import java.util.ArrayList;

/**
 * Representa uma turma em uma disciplina, com informações sobre o código da turma,
 * a disciplina associada, os alunos matriculados, os professores responsáveis e as avaliações.
 * @author Gabriel, Miguel, Tufy
 */
public class Turma {

    private String codigoTurma;
    private Disciplina disciplina;
    private ArrayList<Aluno> alunos;
    private Professor professores;
    private ArrayList<Avaliacao> avaliacoes;

    /**
     * Construtor para criar uma nova turma.
     * 
     * @param codigoTurma O código da turma.
     * @param disciplina A disciplina associada à turma.
     * @param usuario O professor responsável pela turma.
     */
    public Turma(String codigoTurma, Disciplina disciplina, Professor usuario) {
        this.codigoTurma = codigoTurma;
        this.disciplina = disciplina;
        this.alunos = new ArrayList<>();
        this.avaliacoes = new ArrayList<>();
        this.professores = usuario;
    }

    /**
     * Obtém o código da turma.
     * 
     * @return O código da turma.
     */
    public String getCodigoTurma() {
        return codigoTurma;
    }

    /**
     * Obtém a disciplina ligada à turma.
     * 
     * @return A disciplina da turma.
     */
    public Disciplina getDisciplina() {
        return disciplina;
    }

    /**
     * Obtém o professor responsável pela turma.
     * 
     * @return O professor responsável pela turma.
     */
    public Professor getProfessores() {
        return professores;
    }

    /**
     * Obtém a lista de alunos matriculados na turma.
     * 
     * @return A lista de alunos da turma.
     */
    public ArrayList<Aluno> getAlunos() {
        return alunos;
    }

    /**
     * Obtém a lista de avaliações ligadas à turma.
     * 
     * @return A lista de avaliações da turma.
     */
    public ArrayList<Avaliacao> getAvaliacoes() {
        return avaliacoes;
    }

    /**
     * Adiciona uma nova avaliação à lista de avaliações da turma.
     * 
     * @param newAvaliacoes A avaliação a ser adicionada.
     */
    public void setAvaliacoes(Avaliacao newAvaliacoes) {
        avaliacoes.add(newAvaliacoes);
        for(int i = 0; i < avaliacoes.size(); i++){
            System.out.println("nome da avaliacao: " + avaliacoes.get(i).getNome() + " peso: " + avaliacoes.get(i).getPeso());
        }
    }

    /**
     * Busca um aluno na turma pelo seu prontuário.
     * 
     * @param prontuario O prontuário do aluno a ser buscado.
     * @return O aluno encontrado ou null caso não seja encontrado.
     */
    public Aluno buscarAluno(String prontuario) {

        System.out.println("Buscando aluno com prontuário: [" + prontuario + "]");

    
        for (Aluno aluno : alunos) {
            String prontuarioAluno = aluno.getProntuarioAluno();
            System.out.println("Verificando aluno: " + aluno.getNomeAluno() + " | Prontuário armazenado: [" + prontuarioAluno + "]");
    
            if (prontuarioAluno.equalsIgnoreCase(prontuario)) {
                System.out.println("Aluno encontrado!");
                return aluno;
            }
        }
    
        System.out.println("Aluno não encontrado!");
        return null;
    }
    

    /**
     * Adiciona um aluno à turma, caso não esteja matriculado.
     * 
     * @param aluno O aluno a ser adicionado à turma.
     */
    public void adicionarAluno(Aluno aluno) {
        if (!alunos.contains(aluno)) {
            alunos.add(aluno);
            System.out.println("Aluno " + aluno.getNomeAluno() + " adicionado à turma " + codigoTurma);
        } else {
            System.out.println("O aluno " + aluno.getNomeAluno() + " já está matriculado nesta turma.");
        }
    }


    /**
     * Este metodo exibi a quantidade de alunos.
     * 
     * @return retorna em numero a quantidade de alunos.
     */
    public int qtddDeAlunos(){
        return alunos.size();
    }


    /**
     * Este metodo vai verificar se ha o nome como argumento esta presente no arraylist de alunos da turma. caso Esteja ele retornara todas as informções deste nome.
     * 
     * @param nome e o nome que vai ser buscado.
     * @return retorna um texto contendo todas as informações.
     */
    public String buscarAlunoPorNome(String nome){
        for(int i = 0; i < qtddDeAlunos(); i++){
            if(alunos.get(i).getNomeAluno().equals(nome)){    
                return "Disciplina: " + codigoTurma + " nome: " + alunos.get(i).getNomeAluno() + " notas " + alunos.get(i).getNotas() + " Faltas: " + alunos.get(i).getFaltas();
        
            }
        }
        return "";
    }

}
