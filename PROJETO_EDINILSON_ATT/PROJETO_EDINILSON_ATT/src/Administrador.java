import java.util.ArrayList;
import java.util.Scanner;
public class Administrador extends Usuario{

	public Administrador(String Usuario,String Senha) {
		super(Usuario,Senha);
	}
	
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

	public void verTodasTurma(ArrayList<Turma> turma){
		Disciplina disciplinaTeste = new Disciplina("Disciplina123", "matematica");
		Professor professorTeste = new Professor("joao", "joao123", "prontuarioProfessor123", "joao da silva", "11112005");
		Aluno alunoTeste1 = new Aluno("gabriel", "aluno123", "alunoprontuario123", "gabriel", "11111111", 2);
		professorTeste.atribuirNotas(alunoTeste1, 0, 9.9);
		professorTeste.atribuirNotas(alunoTeste1, 1, 1.9);
		Aluno alunoTeste2 = new Aluno("scache", "aluno456", "alunoprontuario456", "scache", "22222222", 2);
		professorTeste.atribuirNotas(alunoTeste2, 0, 1.0);
		professorTeste.atribuirNotas(alunoTeste2, 1, 1.1);
		Turma Turmateste = new Turma("1234", disciplinaTeste, professorTeste, 2, "primeiro");
		Turmateste.addAlunoNaTurma(alunoTeste1);
		Turmateste.addAlunoNaTurma(alunoTeste2);
		turma.add(Turmateste);
		
		/*
		*/
		
		Disciplina disciplinaTeste2 = new Disciplina("Disciplina456", "fisica");
		Professor professorTeste2 = new Professor("maria", "maria456", "prontuarioProfessor456", "maria de souza", "22022010");
		Aluno alunoTeste3 = new Aluno("aluno789", "aluno789", "alunoprontuario789", "tufy", "33333333", 2);
		professorTeste2.atribuirNotas(alunoTeste3, 0, 4.0);
		professorTeste2.atribuirNotas(alunoTeste3, 1, 5.0);
		Aluno alunoTeste4 = new Aluno("aluno012", "aluno012", "alunoprontuario012", "miguel", "44444444", 2);
		professorTeste2.atribuirNotas(alunoTeste4, 0, 6.0);
		professorTeste2.atribuirNotas(alunoTeste4, 1, 7.0);
		Turma turmaTeste2 = new Turma("5678", disciplinaTeste2, professorTeste2, 2, "segundo");
		turmaTeste2.addAlunoNaTurma(alunoTeste3);
		turmaTeste2.addAlunoNaTurma(alunoTeste4);
		turma.add(turmaTeste2);
		
		Disciplina disciplinaTeste3 = new Disciplina("Disciplina789", "quimica");
		Professor professorTeste3 = new Professor("carlos", "carlos789", "prontuarioProfessor789", "carlos oliveira", "05052012");
		Aluno alunoTeste5 = new Aluno("aluno345", "aluno345", "alunoprontuario345", "gustavo", "55555555", 3);
		professorTeste3.atribuirNotas(alunoTeste5, 0, 8.0);
		professorTeste3.atribuirNotas(alunoTeste5, 1, 9.0);
		professorTeste3.atribuirNotas(alunoTeste5, 2, 9.3);
		Aluno alunoTeste6 = new Aluno("aluno678", "aluno678", "alunoprontuario678", "alisom", "66666666", 3);
		professorTeste3.atribuirNotas(alunoTeste6, 0, 9.5);
		professorTeste3.atribuirNotas(alunoTeste6, 1, 9.7);
		professorTeste3.atribuirNotas(alunoTeste6, 2, 9.8);
		Aluno alunoTeste7 = new Aluno("aluno678", "aluno678", "alunoprontuario678", "setimo", "66666666", 3);
		professorTeste3.atribuirNotas(alunoTeste7, 0, 9.75);
		professorTeste3.atribuirNotas(alunoTeste7, 1, 9.76);
		professorTeste3.atribuirNotas(alunoTeste7, 2, 9.77);
		Turma turmaTeste3 = new Turma("91011", disciplinaTeste3, professorTeste3, 2, "terceiro");
		turmaTeste3.addAlunoNaTurma(alunoTeste5);
		turmaTeste3.addAlunoNaTurma(alunoTeste6);
		turmaTeste3.addAlunoNaTurma(alunoTeste7);
		turma.add(turmaTeste3);

		System.out.println("todas as turma criadas ate agora");
		for(int i = 0; i < turma.size(); i++){
			turma.get(i).mostrarTurma();
		}
	}
	
}
