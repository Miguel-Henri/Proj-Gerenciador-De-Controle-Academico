import java.util.ArrayList;
import java.util.Scanner;

public class Sistema {
	private static int rodou=0;
	private static ArrayList<Usuario> usuarios= new ArrayList<>();
	
	
	public static ArrayList<Usuario> getUsuarios() {
		return usuarios;
	}
	
	public static void AdicionarAdm() {
		if(rodou==0) {
			Usuario admin = new Administrador("admin","admin");
			usuarios.add(admin);
			rodou++;
		}
		else {
			System.out.println("Administrador adicionado");
		}
		
		
	}
	
	public static Usuario Login() {
		int logou=0;
		String Usuario,Senha;
		Scanner leitor = new Scanner(System.in);
		Usuario Logado = null;
		
		System.out.println("Login");
		do {
			System.out.println("Insira o usuario: ");
			Usuario = leitor.nextLine();
			System.out.println("Insira a senha");
			Senha = leitor.nextLine();
		
			for(int i = 0;i<usuarios.size();i++) {
				
				
					if(usuarios.get(i).getUsuario().equalsIgnoreCase(Usuario) &&
							usuarios.get(i).getSenha().equalsIgnoreCase(Senha)
							) {
						
						System.out.println("Login efetuado com sucesso");
						logou++;
						Logado = usuarios.get(i);
						}
			}
			if(logou==0) {
				System.out.println("Usuario ou senha incorretos");
			}
	}while(logou==0);
		
		return Logado;
	}
	

}
