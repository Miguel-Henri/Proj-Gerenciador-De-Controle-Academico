import java.util.ArrayList;
import java.util.Scanner;

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
     * Consulta o desempenho do aluno, exibindo suas faltas e notas registradas usa por meio do nome do usuario para pegar as informações.
     * 
     * @param turmas contem todas as turmas ja criadas ate agora
     * @param clienteUsuario e o usuario que esta acessando esse metodo
     
     */
    public void consultarRendimento(ArrayList<Turma> turmas, Usuario clienteUsuario) {
        for(int i = 0; i < turmas.size(); i++){
            String resultado = turmas.get(i).buscarAlunoPorNome(clienteUsuario.getUsuario());
            if (!resultado.isEmpty()) {
                System.out.println(resultado);
            } else{ 
                System.out.println("sem resultaod");    
            }
        }

        /*
         * 
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
        */
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


    /**
     * Este metodo permite que o Usuario posso escolher em qual turma ele vai querer entrar.
     * 
     * @param turmas contem todas as turmas criadas ate agora
     * @param usuarios contem todos os usuarios criados ate agora
     * @param clienteUsuario e o usuario atual que quer esoclher em qual turma entrar
     */
    public void entrarEmUmaTurma(ArrayList<Turma> turmas, ArrayList<Usuario> usuarios , Usuario clienteUsuario){
        int indice = 0;
        int escolha;
        Scanner input = new Scanner(System.in);

        for(int i = 0; i < usuarios.size(); i++){
            if(usuarios.get(i).getUsuario().equals(clienteUsuario.getUsuario())){
                indice = i;
                i = usuarios.size();
            }
        }

        System.out.println("escolha a turma que quer entrar");
        for(int i = 0; i < turmas.size(); i++){
            System.out.println("["+ i + "] codigo da turma: " + turmas.get(i).getCodigoTurma());
        }
        escolha = input.nextInt();
        input.nextLine();
        
        if (escolha < 0 || escolha >= turmas.size()) {
            System.out.println("Escolha inválida!");
            return;
        }

        turmas.get(escolha).adicionarAluno((Aluno) usuarios.get(indice));
        System.out.println("Aluno adicionado à turma com sucesso!");

    }
}
