import java.util.ArrayList;
import java.util.Scanner;

/**
 * Classe que representa um Professor no sistema.
 * O professor pode cadastrar avaliações, inserir notas e faltas, e gerar relatórios sobre alunos e turmas.
 * @author Tufy, Miguel
 */
public class Professor extends Usuario {
    private String prontuario;
    private String nome;
    private String dataNascimento;
    private int qtddDeAvaliacoes;

    /**
     * Construtor para criar um novo professor.
     * 
     * @param Usuario Nome de usuário do professor.
     * @param Senha Senha do professor.
     * @param prontuario Identificação única do professor.
     * @param nome Nome completo do professor.
     * @param dataNascimento Data de nascimento do professor.
     */
    public Professor(String Usuario, String Senha, String prontuario, String nome, String dataNascimento) {
        super(Usuario, Senha);
        this.prontuario = prontuario;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }

    /**
     * Obtém o nome do professor.
     * 
     * @return Nome completo do professor.
     */
    public String getNomeProfessor() {
        return nome;
    }

   
    /**
     * Cadastra avaliações para uma turma, incluindo o nome da avaliação e seu peso.
     * 
     * @param turmas Lista de turmas disponíveis no sistema.
     * @param clienteUsuario Usuário logado (deve ser um professor).
     */
    public void CadastrarAvaliacao(ArrayList<Turma> turmas, Usuario clienteUsuario) {
        if (clienteUsuario instanceof Professor) {

            Professor professor = (Professor) clienteUsuario;
            Scanner leitor = new Scanner(System.in);

            // Escolha da turma em que as avaliações serão cadastradas
            Turma turmaSelecionada = selecionarTurma(turmas, professor, leitor);
            if (turmaSelecionada != null) {
                System.out.println("Quantas avaliacoes deseja cadastrar para a turma " + turmaSelecionada.getCodigoTurma() + "?");
                int quantidadeAvaliacoes = leitor.nextInt();
                this.qtddDeAvaliacoes = quantidadeAvaliacoes;

                // Cadastro das avaliações para a turma
                for (int i = 0; i < quantidadeAvaliacoes; i++) {
                    System.out.println("Cadastro da avaliacao " + (i + 1) + ":");
                    System.out.println("Digite o nome da avaliacao:");
                    leitor.nextLine();
                    String nomeAvaliacao = leitor.nextLine();
                    System.out.println("Digite o peso da avaliacao (porcentagem):");
                    double pesoAvaliacao = leitor.nextDouble();

                    if (pesoAvaliacao <= 0 || pesoAvaliacao > 100) {
                        System.out.println("Peso invalido");
                        i--; // Repetir caso o peso seja inválido
                    } else {
                        Avaliacao novaAvaliacao = new Avaliacao(nomeAvaliacao, pesoAvaliacao);
                        turmaSelecionada.setAvaliacoes(novaAvaliacao);
                    }
                }

                System.out.println("Avaliacoes cadastradas com sucesso para a turma " + turmaSelecionada.getCodigoTurma() + "!");
            }
        } else {
            System.out.println("Apenas professores podem cadastrar avaliacoes");
        }



    }




    /**
     * Insere notas para os alunos de uma turma específica.
     * 
     * @param turmas Lista de turmas disponíveis no sistema.
     * @param clienteUsuario Usuário logado (deve ser um professor).
     */
    public void InserirNotas(ArrayList<Turma> turmas, Usuario clienteUsuario) {
        if (clienteUsuario instanceof Professor) {
            Professor professor = (Professor) clienteUsuario;
            Scanner leitor = new Scanner(System.in);
    
            Turma turmaSelecionada = selecionarTurma(turmas, professor, leitor);
            if (turmaSelecionada == null) {
                System.out.println("Nenhuma turma selecionada.");
            } else {
                System.out.println("Alunos da turma " + turmaSelecionada.getCodigoTurma() + ":");
                for (Aluno aluno : turmaSelecionada.getAlunos()) {
                    System.out.println("Nome: " + aluno.getNomeAluno() + " | Prontuario: " + aluno.getProntuarioAluno());
                }
    
                System.out.println("Digite o prontuario do aluno:");
                leitor.nextLine();
                String prontuarioAluno = leitor.nextLine(); 
    
                Aluno aluno = turmaSelecionada.buscarAluno(prontuarioAluno);
    
                if (aluno != null ) {
                    System.out.println("Avaliações disponíveis:");
                    for (Avaliacao avaliacao : turmaSelecionada.getAvaliacoes()) {
                        System.out.println("Avaliação: " + avaliacao.getNome() + " | Peso: " + avaliacao.getPeso());
                    }
    
                    System.out.println("Digite o nome da avaliação:");
                    String nomeAvaliacao = leitor.nextLine();
    
                    System.out.println("Digite a nota do aluno:");
                    double nota = leitor.nextDouble();
                    leitor.nextLine();
                    aluno.adicionarNota(nomeAvaliacao, nota, turmaSelecionada.getAvaliacoes(), this.qtddDeAvaliacoes);
                   
                } else {
                    System.out.println("Aluno não encontrado na turma.");
                }
            }
        } else {
            System.out.println("Apenas professores podem inserir notas.");
        }
    }
    

    




    /**
     * Insere faltas para os alunos de uma turma específica.
     * 
     * @param turmas Lista de turmas disponíveis no sistema.
     * @param clienteUsuario Usuário logado (deve ser um professor).
     */
    public void InserirFaltas(ArrayList<Turma> turmas, Usuario clienteUsuario) {
        if (clienteUsuario instanceof Professor) {
            Professor professor = (Professor) clienteUsuario;
            Scanner leitor = new Scanner(System.in);
    
        
            Turma turmaSelecionada = selecionarTurma(turmas, professor, leitor);
            if (turmaSelecionada == null) {
                System.out.println("Nenhuma turma selecionada.");
                
            }else{
                System.out.println("Alunos da turma " + turmaSelecionada.getCodigoTurma() + ":");
                for (Aluno aluno : turmaSelecionada.getAlunos()) {
                    System.out.println("Nome: " + aluno.getNomeAluno() + " | Prontuario: " + aluno.getProntuarioAluno());
                }
        
                
                System.out.println("Digite o prontuario do aluno:");
                leitor.nextLine();
                String prontuarioAluno = leitor.nextLine(); 
               
        
                Aluno aluno = turmaSelecionada.buscarAluno(prontuarioAluno);
        
                if (aluno != null) {
                    System.out.println("Digite a quantidade de faltas:");
                    int faltas = leitor.nextInt();
                    aluno.adicionarFaltas(faltas);
                    System.out.println("Faltas inseridas com sucesso para " + aluno.getNomeAluno());
                } else {
                    System.out.println("Aluno nao encontrado na turma.");
                }
            }
        } else {
            System.out.println("Apenas professores podem inserir faltas.");
        }
    }
    
               

                   
                  




    /**
     * Exibe um relatório com informações sobre os alunos de uma turma.
     * 
     * @param turmas Lista de turmas disponíveis no sistema.
     * @param clienteUsuario Usuário logado (deve ser um professor).
     */
    public void ExibirRelatorioAlunos(ArrayList<Turma> turmas, Usuario clienteUsuario) {
        if (clienteUsuario instanceof Professor) {
            for (int i = 0; i < turmas.size(); i++) {
                Turma turma = turmas.get(i);
                if (turma.getProfessores() == clienteUsuario) {
                    System.out.println("Relatorio de Alunos da Turma: " + turma.getCodigoTurma());
                    for (int j = 0; j < turma.getAlunos().size(); j++) {
                        Aluno aluno = turma.getAlunos().get(j);
                        System.out.println("Aluno: " + aluno.getNomeAluno());
                        System.out.println("Notas: " + aluno.getNotas());
                        System.out.println("Faltas: " + aluno.getFaltas());
                        System.out.println("------------");
                    }
                }
            }
        } else {
            System.out.println("Apenas professores podem exibir relatorios de alunos");
        }
    }



    

    /**
     * Exibe um relatório com informações sobre uma turma.
     * 
     * @param turmas Lista de turmas disponíveis no sistema.
     * @param clienteUsuario Usuário logado (deve ser um professor).
     */
    public void ExibirRelatorioTurma(ArrayList<Turma> turmas, Usuario clienteUsuario) {
        

        if (clienteUsuario instanceof Professor) {
            Professor professor = (Professor) clienteUsuario;
            for (int i = 0; i < turmas.size(); i++) {
                Turma turma = turmas.get(i);
                if (turma.getProfessores() == clienteUsuario) {
                    System.out.println("Relatorio da Turma: " + turma.getCodigoTurma());
                    System.out.println("Quantidade de Alunos: " + turma.getAlunos().size());
                    System.out.println("Professores: ");
                    System.out.println("- " + professor.getNomeProfessor());
                    System.out.println("----------");
                }
            }
        } else {
            System.out.println("Apenas professores podem exibir relatorios de turma");
        }

    }



    /**
     * Método publico para calcular a media de aluno especifico.
     * 
     * @param turmas Lista de turmas disponíveis no sistema.
     * @param clienteUsuario Professor que está selecionando a turma.
     * @param leitor Scanner para leitura da entrada do usuário.

     */
    public void calculaMedia(ArrayList<Turma> turmas, Usuario clienteUsuario) {
        if (clienteUsuario instanceof Professor || clienteUsuario instanceof Aluno) {
            Professor professor = (Professor) clienteUsuario;
            Scanner leitor = new Scanner(System.in);
    
            Turma turmaSelecionada = selecionarTurma(turmas, professor, leitor);
    
            if (turmaSelecionada == null  || turmaSelecionada.getAvaliacoes() == null) {
                System.out.println("Nenhuma turma selecionada ou sem avaliacoes cadastradas.");
            } else {
                System.out.println("Alunos da turma " + turmaSelecionada.getCodigoTurma() + ":");
                for (Aluno aluno : turmaSelecionada.getAlunos()) {
                    System.out.println("Nome: " + aluno.getNomeAluno() + " | Prontuario: " + aluno.getProntuarioAluno());
                }
    
                System.out.println("Digite o prontuario do aluno:");
                leitor.nextLine();
                String prontuarioAluno = leitor.nextLine();
    
                Aluno aluno = turmaSelecionada.buscarAluno(prontuarioAluno);

                if (aluno != null) {

                    double somaNotasComPesos = 0;
                    double somaPesos = 0;


                    for (int i = 0; i < turmaSelecionada.getAvaliacoes().size(); i++) {
                        Avaliacao avaliacao = turmaSelecionada.getAvaliacoes().get(i);
                        double nota = aluno.getNotas().get(i);
                        double peso = avaliacao.getPeso();
                        somaNotasComPesos += nota * peso; 
                        somaPesos += peso; 
                    }
    
                   
                    double mediaPonderada = somaNotasComPesos / somaPesos;
                    System.out.println("Média ponderada do aluno " + aluno.getNomeAluno() + ": " + mediaPonderada);
                    aluno.setNota(mediaPonderada);

                } else {
                    System.out.println("Aluno não encontrado na turma.");
                }
                
            }
        }
    }




    /**
     * Método privado para selecionar uma turma do professor.
     * 
     * @param turmas Lista de turmas disponíveis no sistema.
     * @param professor Professor que está selecionando a turma.
     * @param leitor Scanner para leitura da entrada do usuário.
     * @return A turma selecionada pelo professor ou null se nenhuma for selecionada.
     */
    private Turma selecionarTurma(ArrayList<Turma> turmas, Professor professor, Scanner leitor) {
        ArrayList<Turma> turmasDoProfessor = new ArrayList<>();
        for (int i = 0; i < turmas.size(); i++) {
            if (turmas.get(i).getProfessores() == professor) {
                turmasDoProfessor.add(turmas.get(i));
            }
        }

        if (turmasDoProfessor.isEmpty()) {
            System.out.println("Você nao possui turmas cadastradas");
            return null;
        }

        System.out.println("Selecione uma turma:");
        for (int i = 0; i < turmasDoProfessor.size(); i++) {
            System.out.println("[" + (i + 1) + "] " + turmasDoProfessor.get(i).getCodigoTurma());
        }

        int opcaoTurma = leitor.nextInt();
        if (opcaoTurma < 1 || opcaoTurma > turmasDoProfessor.size()) {
            System.out.println("Opcao invalida.");
            return null;
        }

        return turmasDoProfessor.get(opcaoTurma - 1);
		
    }





    



    
    
}


