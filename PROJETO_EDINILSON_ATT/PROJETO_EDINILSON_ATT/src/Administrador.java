import java.util.ArrayList;
import java.util.Scanner;

/**
 * A Class Administrador Contem todos os metodos que o objeto Administrador ultilizara.
 * Permitindo entao, criar professores, alunos, disciplinas e turma. alem de mostrar ou remover usuarios.

 * 
 * @author Miguel, Tufy
 */

import javax.swing.text.html.HTMLDocument.HTMLReader.PreAction;
public class Administrador extends Usuario{

	/**
	 * Apenas implementa o metodo construtor da super classe.
	 * 
	 * @param Usuario e o nome do usuario para o metodo construtor da classe super.
	 * @param Senha e a senha do usuario para o metodo construtor da classe super.
	*/
	public Administrador(String Usuario,String Senha) {
		super(Usuario,Senha);
	}
	
	/**
	 * Este metodo cria varios alunos, professores, disciplinas e turmas de uma vez assim que o sistema for executado
	 * 
	 * @param disciplinas e o arraylist que contem todas as disciplinas criadas ate agora.
	 * @param turmas e o arraylist que sera armazenado esta turma criada agora.
	 * @param usuarios e o arraylist que contem todas os usuario criados ate agora.
	 */
	public void CriarDisciplinaProfessorAlunoTurma(ArrayList<Disciplina> disciplinas, ArrayList<Turma> turmas, ArrayList<Usuario> usuarios){
		//criação de alunos e professores
		Professor professor1 = new Professor("Edinilson", "123", "111", "Edinilson", "23022000");
		Professor professor2 = new Professor("Leal", "1234", "222", "Leal", "23112000");
		Aluno newAluno1 = new Aluno("Pedrão", "1234", "bbb", "Pedrão", "33052000");
		Aluno newAluno2 = new Aluno("Marcelo", "12345", "333", "Marcelo", "23042000");
		Aluno newAluno3 = new Aluno("Wesley", "123", "aaa", "Wesley", "12052000");
		usuarios.add(newAluno1);
		usuarios.add(newAluno2);
		usuarios.add(newAluno3);
		usuarios.add(professor1);
		usuarios.add(professor2);

		//criação de Disciplinas
		Disciplina newDisci1 = new Disciplina("Fisica", "fs", "fs", 10, 10);
		Disciplina newDisci2 = new Disciplina("Portugues", "pt", "pt", 11, 11);
		disciplinas.add(newDisci1);
		disciplinas.add(newDisci2);

		//criação de turmas
		Turma newTurma = new Turma("111", newDisci1,professor1);
		turmas.add(newTurma);
		
		//colocando alunos numa turma
		newTurma.adicionarAluno(newAluno1);
		newTurma.adicionarAluno(newAluno2);
		newTurma.adicionarAluno(newAluno3);
	}


	/**
	 * Este metodo permite a criação de novos usuarios como alunos e professores.
	 * ele usa da classe criacao que retorna se o usuario criado vai ser um professor ou aluno.
	 * E por fim ele cadastra no arrayList de usuarios independente se for professor ou aluno.
	 * 
	 * @param usuarios E o arralist de todos criados ate agora e onde vai ser add o que for criado neste metodo.
	 */
	public void CadastrarUsuario(ArrayList<Usuario> usuarios) {
		int escolha;
		Usuario user=null;
		Scanner leitor = new Scanner(System.in); 
		
		String nome,senha;
		
		System.out.println("Insira o nome do Usuario: ");
		nome = leitor.nextLine();
		System.out.println("Insira a senha : ");
		senha = leitor.nextLine();
		System.out.println("Deseja cadastrar:");
		do {
			
			System.out.println("[1] Aluno");
			System.out.println("[2] Professor");
			escolha = leitor.nextInt();
			
			switch(escolha) {
			case 1:
				user = Criacao(nome, senha,escolha);
				break;
			case 2:
				user = Criacao(nome, senha,escolha);
				break;
				
				default: System.out.println("Opção invalida");
			}
		}while(user==null);
		
		usuarios.add(user);	
	}
	
	/**
	 * Este metodo cria alunos ou professores com base no argumento escolha.
	 * 
	 * @param usuario e o nome do usuario definido no metodo CadastrarUsuario.
	 * @param senha e a senha do usuario definida no metodo CadastrarUsuario.
	 * @param escolha e a escolha de qual tipo de usuario ele sera (aluno ou professor) definido no metodo CadastrarUsuario.
	 
	 * @return com base no parametro escolha retorna o tipo de usuario podendo ser aluno ou professor.
	 * o que for retornado vai ser add no arraylist de usuarios.
	 */
	private Usuario Criacao(String usuario,String senha,int escolha) {
		String texto=null;
		Usuario newClientUsuario=null;
		if(escolha ==1) {
			texto="Aluno: ";
		}
		else if(escolha==2) {
			texto="Professor: ";
		}
		
		
		Scanner leitor = new Scanner(System.in);
		String prontuario,dataNascimento,nome;
		
		System.out.println("Insira o prontuario do "+texto);
		prontuario = leitor.nextLine();
		
		System.out.println("Insira a data de nascimento do "+texto);
		dataNascimento = leitor.nextLine();
		
		System.out.println("Insira o nome do "+texto);
		nome = leitor.nextLine();
		
		if(escolha==1) {
			newClientUsuario = new Aluno(usuario,senha,prontuario,nome,dataNascimento);
		}
		else if(escolha==2) {
			newClientUsuario = new Professor(usuario,senha,prontuario,nome,dataNascimento);
		}
		return newClientUsuario;
		
	}
	
	
	
	/**
	 * Este metodo pega o parametro usuarios que é um arralist de todos os usuario criados ate agora e retorna todos.
	 * 
	 * @param usuarios e o arralist contendo todos os usuarios criados ate agora.
	 */
	public void ApresentarUsuarios(ArrayList<Usuario> usuarios) {
		if(usuarios.size()>1) {
			for(int i = 1;i<usuarios.size();i++) {
				System.out.println("Usuario ["+i+"]: "+usuarios.get(i).getUsuario());
			
			}
		}
		
		else {
			System.out.println("Não ha usuarios cadastrados");
		}
	}
	
	/**
	 * Este metodo remove por meio do indice, o indice que vai ser removido é definido pelo usuario.
	 * 
	 * @param usuarios e o arralist contendo todos os usuarios criados ate agora.
	 */
	public void DeletarUsuario(ArrayList<Usuario> usuarios) {
		Scanner leitor = new Scanner(System.in);
		int escolha;
		ApresentarUsuarios(usuarios);
		escolha = leitor.nextInt();
		if(usuarios.size()>1) {
			for(int i = 1;i<usuarios.size();i++) {
				if(escolha==i) {
					usuarios.remove(escolha);
					System.out.println("Usuario Removido com sucesso");
					break;
				}
			}
		}else {
			System.out.println("Não tem usuarios para remover");
		}
		
		
	}

	/**
	 * Este metodo cria uma disciplina e a coloca no arraylist de disciplinas.
	 * 
	 * @param disciplinas e o arralist contendo todos as disciplinas criadas ate agora.
	 */
	public void criarDisciplina(ArrayList<Disciplina> disciplinas) {
		Disciplina novaDisciplina;
		
		Scanner leitor = new Scanner(System.in);
		String NomeDisciplina,siglaDisciplina,ementa;
		int cargaHoraria,totalAulas;
		
		System.out.println("Insira o nome da Disciplina: ");
		NomeDisciplina = leitor.nextLine();
		System.out.println("Insira a sigla da Disciplina: ");
		siglaDisciplina = leitor.nextLine();
		System.out.println("Insira a ementa da Disciplina: ");
		ementa = leitor.nextLine();
		System.out.println("Insira a carga horaria da Disciplina: ");
		cargaHoraria = leitor.nextInt();
		System.out.println("Insira o total de aulas da Disciplina: ");
		totalAulas = leitor.nextInt();
		
		novaDisciplina = new Disciplina(NomeDisciplina, siglaDisciplina, ementa, cargaHoraria
				, totalAulas);
		disciplinas.add(novaDisciplina);
	}


	/**
	 * Este metodo cria turmas, mas para isso é necessario ter criado pelo menos um elemento nos arralist Disciplinas e Usuarios (pelo menos um professor).
	 * 
	 * @param disciplinas e o arraylist que contem todas as disciplinas criadas ate agora.
	 * @param turmas e o arraylist que sera armazenado esta turma criada agora.
	 * @param usuarios e o arraylist que contem todas os usuario criados ate agora.
	 */
	public void CriarTurma(ArrayList<Disciplina> disciplinas, ArrayList<Turma> turmas,
            ArrayList<Usuario> usuarios) {

	int achouProfessores = 0;
	String codigoTurma = null;
	Disciplina disciplinaEscolhida = null;
	Professor professorEscolhido = null;
	Turma novaTurma;

	Scanner leitor = new Scanner(System.in);

	if (disciplinas.size() > 0) {
	for (int i = 0; i < usuarios.size(); i++) {
	if (usuarios.get(i) instanceof Professor) {
		achouProfessores++;
	}
	}

	if (achouProfessores == 0) {
	System.out.println("Nenhum professor cadastrado");
	return;
	}

	System.out.println("Insira o código da turma: ");
	codigoTurma = leitor.nextLine();

	int escolha;
	do {
	System.out.println("Escolha uma das seguintes disciplinas: ");
	for (int i = 0; i < disciplinas.size(); i++) {
		System.out.println("[" + i + "] Nome da Disciplina: " +
				disciplinas.get(i).getNomeDisciplina());
	}
	escolha = leitor.nextInt();

	if (escolha >= 0 && escolha < disciplinas.size()) {
		disciplinaEscolhida = disciplinas.get(escolha);
		System.out.println("Disciplina escolhida: " +
				disciplinaEscolhida.getNomeDisciplina());
	} else {
		System.out.println("Selecionou opção inválida");
	}
	} while (escolha < 0 || escolha >= disciplinas.size());

	do {
	System.out.println("Escolha um dos seguintes professores: ");
	ArrayList<Professor> professores = new ArrayList<>();
	for (int i = 0, index = 0; i < usuarios.size(); i++) {
		if (usuarios.get(i) instanceof Professor) {
			professores.add((Professor) usuarios.get(i));
			System.out.println("[" + index + "] Nome Professor: " +
					((Professor) usuarios.get(i)).getNomeProfessor());
			index++;
		}
	}

	escolha = leitor.nextInt();

	if (escolha >= 0 && escolha < professores.size()) {
		professorEscolhido = professores.get(escolha);
		System.out.println("Professor escolhido: " +
				professorEscolhido.getNomeProfessor());
	} else {
		System.out.println("Selecionou opção inválida");
	}
	} while (professorEscolhido == null);

	novaTurma = new Turma(codigoTurma, disciplinaEscolhida, professorEscolhido);
	turmas.add(novaTurma);

	System.out.println("Turma criada com sucesso!");
	} else {
	System.out.println("Nenhuma disciplina cadastrada");
	}
}

	
	
	/**
	 * Este metodo exibi todas as turmas criadas ate agora.
	 * 
	 * @param turmas arraylist contendo todas as turmas criadas ate agora.
	 */
	public void ApresentarTurmas(ArrayList<Turma> turmas) {
	    for (int i = 0; i < turmas.size(); i++) {
	        System.out.println("TURMA " + (i + 1));
	        System.out.println("Codigo da Turma: " + turmas.get(i).getCodigoTurma());
	        System.out.println("Disciplina: " + turmas.get(i).getDisciplina().getNomeDisciplina());

	        
	        Professor professores = turmas.get(i).getProfessores();

	        System.out.print("Professores da turma: ");
	        if (professores == null) {
	            System.out.println("Nenhum professor atribuido.");
	        } else {
	            System.out.print(professores.getNomeProfessor());
	        }
	    }
	}
}
