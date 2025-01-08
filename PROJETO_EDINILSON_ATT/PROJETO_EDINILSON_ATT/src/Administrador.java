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
	
}
