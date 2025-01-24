import java.util.ArrayList;
import java.util.Scanner;

public class Professor extends Usuario {
    private String prontuario;
    private String nome;
    private String dataNascimento;

    public Professor(String Usuario, String Senha, String prontuario, String nome, String dataNascimento) {
        super(Usuario, Senha);
        this.prontuario = prontuario;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }

    public String getNomeProfessor() {
        return nome;
    }




    public void CadastrarAvaliacao(ArrayList<Turma> turmas, Usuario clienteUsuario) {
		if (clienteUsuario instanceof Professor) {
			
			Professor professor = (Professor) clienteUsuario;
			Scanner leitor = new Scanner(System.in);
		
			Turma turmaSelecionada = selecionarTurma(turmas, professor, leitor);
			if (turmaSelecionada != null){
		
				System.out.println("Quantas avaliacoes deseja cadastrar para a turma " + turmaSelecionada.getCodigoTurma() + "?");
				int quantidadeAvaliacoes = leitor.nextInt();
			
				ArrayList<Avaliacao> avaliacoes = new ArrayList<>();
				for (int i = 0; i < quantidadeAvaliacoes; i++) {
					System.out.println("Cadastro da avaliacao " + (i + 1) + ":");
			
					System.out.println("Digite o nome da avaliacao:");
					leitor.nextLine();
					String nomeAvaliacao = leitor.nextLine();
			
					System.out.println("Digite o peso da avaliacao (porcentagem):");
					double pesoAvaliacao = leitor.nextDouble();
			
					if (pesoAvaliacao <= 0 || pesoAvaliacao > 100) {
						System.out.println("Peso invalido");
						i--;
					}else{
						Avaliacao novaAvaliacao = new Avaliacao(nomeAvaliacao, pesoAvaliacao);
						avaliacoes.add(novaAvaliacao);
					}
				}
			
				turmaSelecionada.setAvaliacoes(avaliacoes);
				System.out.println("Avaliacoes cadastradas com sucesso para a turma " + turmaSelecionada.getCodigoTurma() + "!");

				leitor.close();
			}
		}else{
			System.out.println("Apenas professores podem cadastrar avaliacoes");
			
		}

		
	}
	












	public void InserirNotas(ArrayList<Turma> turmas, Usuario clienteUsuario) {
		if (clienteUsuario instanceof Professor) {
			Professor professor = (Professor) clienteUsuario;
			Scanner leitor = new Scanner(System.in);
	
			Turma turmaSelecionada = selecionarTurma(turmas, professor, leitor);
			if (turmaSelecionada != null) {
				System.out.println("Quantos alunos deseja cadastrar notas para a turma " + turmaSelecionada.getCodigoTurma() + "?");
				int quantidadeAlunos = leitor.nextInt();
	
				for (int i = 0; i < quantidadeAlunos; i++) {
					System.out.println("Cadastro da nota para o aluno " + (i + 1) + ":");
	
					System.out.println("Digite o cOdigo do aluno:");
					leitor.nextLine();
					String prontuarioAluno = leitor.nextLine();
	
					Aluno aluno = turmaSelecionada.buscarAluno(prontuarioAluno);
					if (aluno != null) {
						System.out.println("Digite a nota para o aluno:");
						double nota = leitor.nextDouble();
						aluno.adicionarNota(nota);
						System.out.println("Nota inserida com sucesso para o aluno " + aluno.getNomeAluno());
					} else {
						System.out.println("Aluno nao encontrado na turma.");
					}
				}
			}
			leitor.close();
		} else {
			System.out.println("Apenas professores podem inserir notas.");
		}
	}
	





	public void InserirFaltas(ArrayList<Turma> turmas, Usuario clienteUsuario) {
		if (clienteUsuario instanceof Professor) {
			Professor professor = (Professor) clienteUsuario;
			Scanner leitor = new Scanner(System.in);
	
			Turma turmaSelecionada = selecionarTurma(turmas, professor, leitor);
			if (turmaSelecionada != null) {
				System.out.println("Quantos alunos deseja cadastrar faltas" + turmaSelecionada.getCodigoTurma() + "?");
				int quantidadeAlunos = leitor.nextInt();
	
				for (int i = 0; i < quantidadeAlunos; i++) {
					System.out.println("Cadastro das faltas para o aluno " + (i + 1) + ":");
	
					System.out.println("Digite o codigo do aluno:");
					leitor.nextLine();
					String prontunarioAluno = leitor.nextLine();
	
					Aluno aluno = turmaSelecionada.buscarAluno(prontunarioAluno);
					if (aluno != null) {
						System.out.println("Digite a quantidade de faltas para o aluno:");
						int faltas = leitor.nextInt();
						aluno.adicionarFaltas(faltas);
						System.out.println("Faltas inseridas com sucesso para o aluno " + aluno.getNomeAluno());
					} else {
						System.out.println("Aluno nao encontrado na turma.");
					}
				}
			}
			leitor.close();
		} else {
			System.out.println("Apenas professores podem inserir faltas.");
		}
	}
	








	public void ExibirRelatorioAlunos(ArrayList<Turma> turmas, Usuario clienteUsuario) {
		if (clienteUsuario instanceof Professor) {
			Professor professor = (Professor) clienteUsuario;
	
			for (int i = 0; i < turmas.size(); i++) {
				Turma turma = turmas.get(i);
				if (turma.getProfessores().contains(professor)) {
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
	




    public void ExibirRelatorioTurma(ArrayList<Turma> turmas, Usuario clienteUsuario) {
		if (clienteUsuario instanceof Professor) {
			Professor professor = (Professor) clienteUsuario;
	
			for (int i = 0; i < turmas.size(); i++) {
				Turma turma = turmas.get(i);
				if (turma.getProfessores().contains(professor)) {
					System.out.println("Relatorio da Turma: " + turma.getCodigoTurma());
					System.out.println("Quantidade de Alunos: " + turma.getAlunos().size());
					System.out.println("Professores: ");
					
					for (int j = 0; j < turma.getProfessores().size(); j++) {
						Professor prof = turma.getProfessores().get(j);
						System.out.println("- " + prof.getNomeProfessor());
					}
					System.out.println("----------");
				}
			}
		} else {
			System.out.println("Apenas professores podem exibir relatorios de turma");
		}
	}














	
	private Turma selecionarTurma(ArrayList<Turma> turmas, Professor professor, Scanner leitor) {
		ArrayList<Turma> turmasDoProfessor = new ArrayList<>();
		for (int i = 0; i < turmas.size(); i++) {
			Turma turma = turmas.get(i);
			if (turma.getProfessores().contains(professor)) {
				turmasDoProfessor.add(turma);
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
			System.out.println("Opção invalida.");
			return null;
		}
	
		return turmasDoProfessor.get(opcaoTurma - 1);
	}
	







	private Aluno buscarAlunoNaTurma(Turma turma, String codigoAluno) {
		for (int i = 0; i < turma.getAlunos().size(); i++) {
			Aluno aluno = turma.getAlunos().get(i);
			if (aluno.getProntuarioAluno().equals(codigoAluno)) {
				return aluno;
			}
		}
		return null;
	}
	
}
