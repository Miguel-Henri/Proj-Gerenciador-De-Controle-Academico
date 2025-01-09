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
		Aluno alunoTeste1 = new Aluno("aluno123", "aluno123", "alunoprontuario123", "alunoga132", "11111111");
		Aluno alunoTeste2 = new Aluno("aluno456", "aluno456", "alunoprontuario456", "alunosc456", "22222222");
		Turma Turmateste = new Turma("1234", disciplinaTeste, professorTeste, 2, "primeiro");
		Turmateste.addAlunoNaTurma(alunoTeste1);
		Turmateste.addAlunoNaTurma(alunoTeste2);
		turma.add(Turmateste);
		
		Disciplina disciplinaTeste2 = new Disciplina("Disciplina456", "fisica");
		Professor professorTeste2 = new Professor("maria", "maria456", "prontuarioProfessor456", "maria de souza", "22022010");
		Aluno alunoTeste3 = new Aluno("aluno789", "aluno789", "alunoprontuario789", "alunosc789", "33333333");
		Aluno alunoTeste4 = new Aluno("aluno012", "aluno012", "alunoprontuario012", "alunosc012", "44444444");
		Turma turmaTeste2 = new Turma("5678", disciplinaTeste2, professorTeste2, 2, "segundo");
		turmaTeste2.addAlunoNaTurma(alunoTeste3);
		turmaTeste2.addAlunoNaTurma(alunoTeste4);
		turma.add(turmaTeste2);

		Disciplina disciplinaTeste3 = new Disciplina("Disciplina789", "quimica");
		Professor professorTeste3 = new Professor("carlos", "carlos789", "prontuarioProfessor789", "carlos oliveira", "05052012");
		Aluno alunoTeste5 = new Aluno("aluno345", "aluno345", "alunoprontuario345", "alunosc345", "55555555");
		Aluno alunoTeste6 = new Aluno("aluno678", "aluno678", "alunoprontuario678", "alunosc678", "66666666");
		Turma turmaTeste3 = new Turma("91011", disciplinaTeste3, professorTeste3, 2, "terceiro");
		turmaTeste3.addAlunoNaTurma(alunoTeste5);
		turmaTeste3.addAlunoNaTurma(alunoTeste6);
		turma.add(turmaTeste3);

		System.out.println("todas as turma criadas ate agora");
		for(int i = 0; i < turma.size(); i++){
			turma.get(i).mostrarTurma();
		}
	}
	
}
