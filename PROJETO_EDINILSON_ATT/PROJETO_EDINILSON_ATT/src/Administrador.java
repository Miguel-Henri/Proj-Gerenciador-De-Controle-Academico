import java.util.ArrayList;
import java.util.Scanner;
public class Administrador extends Usuario{
	

	public Administrador(String Usuario,String Senha) {
		super(Usuario,Senha);
	}
	
	public void CadastrarUsuario(ArrayList<Usuario> usuarios) {
		Usuario user ;
		Scanner leitor = new Scanner(System.in); 
		
		String nome,senha;
		
		System.out.println("Insira o nome do Usuario: ");
		nome = leitor.nextLine();
		System.out.println("Insira a senha : ");
		senha = leitor.nextLine();
		user = new Usuario(nome,senha);
		
		usuarios.add(user);
	
	
		
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
	
	
}
