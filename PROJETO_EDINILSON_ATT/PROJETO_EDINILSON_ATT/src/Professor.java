import java.util.ArrayList;
import java.util.Scanner;

public class Professor extends Usuario{
	private String prontuario;
	private String nome;	
	private String dataNascimento;

	public Professor(String Usuario,String Senha,String prontuario,String nome,String dataNascimento) {
		super(Usuario,Senha);
		this.prontuario = prontuario;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
	}



	public String getNomeProfessor(){
		return nome;
	}
	
	
	


	public void CadastrarAvaliacao(ArrayList<Turma> turmas, Usuario clienteUsuario) {
	    Scanner leitor = new Scanner(System.in);

	    
	    if (clienteUsuario instanceof Professor) {
	        Professor professor = (Professor) clienteUsuario;

	        
	        ArrayList<Turma> turmasDoProfessor = new ArrayList<>();
	        for (int i = 0; i < turmas.size(); i++) {
	            Turma turma = turmas.get(i);
	            if (turma.getProfessores().contains(professor)) {
	                turmasDoProfessor.add(turma);
	            }
	        }

	        if (turmasDoProfessor.isEmpty()) {
	            System.out.println("Voce nao possui turmas cadastradas.");
	            return;
	        }

	        System.out.println("Selecione uma turma para cadastrar avaliacoes:");
	        for (int i = 0; i < turmasDoProfessor.size(); i++) {
	            System.out.println("[" + (i + 1) + "] " + turmasDoProfessor.get(i).getCodigoTurma());
	        }

	        int opcaoTurma = leitor.nextInt();
	        if (opcaoTurma < 1 || opcaoTurma > turmasDoProfessor.size()) {
	            System.out.println("Opção inválida.");
	            return;
	        }

	        Turma turmaSelecionada = turmasDoProfessor.get(opcaoTurma - 1);

	        System.out.println("Quantas avaliacoes deseja cadastrar para a turma " + turmaSelecionada.getCodigoTurma() + "?");
	        int quantidadeAvaliacoes = leitor.nextInt();

	        ArrayList<Avaliacao> avaliacoes = new ArrayList<>();
	        for (int i = 0; i < quantidadeAvaliacoes; i++) {
	            System.out.println("Cadastro da avaliação " + (i + 1) + ":");
	            
	            System.out.println("Digite o nome da avaliação:");
	            leitor.nextLine(); 
	            String nomeAvaliacao = leitor.nextLine();

	            System.out.println("Digite o peso da avaliacao (em porcentagem):");
	            double pesoAvaliacao = leitor.nextDouble();

	            if (pesoAvaliacao <= 0 || pesoAvaliacao > 100) {
	                System.out.println("Peso invalido. Digite um valor entre 1 e 100.");
	                i--;
	                continue;
	            }

	            Avaliacao novaAvaliacao = new Avaliacao(nomeAvaliacao, pesoAvaliacao);
	            avaliacoes.add(novaAvaliacao);
	        }

	        
	        turmaSelecionada.setAvaliacoes(avaliacoes);

	        System.out.println("Avaliacoes cadastradas com sucesso para a turma " + turmaSelecionada.getCodigoTurma() + "!");
	    } else {
	        System.out.println("Apenas professores podem cadastrar avaliacoes.");
	    }
	}

	
	
	
	
	
	
	
	void atribuirNotas(Aluno aluno, int indice, double nota){
        aluno.setDefinirNotas(indice, nota);
        System.out.println("Nota " + nota + " atribuída ao aluno " + aluno);

    }



}
