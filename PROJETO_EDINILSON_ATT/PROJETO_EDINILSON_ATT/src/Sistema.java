import java.util.ArrayList;
import java.util.Scanner;

/**
 * A classe Sistema e a classe que contem os principais ArrayList desta aplicação. 
 * Alem disso ela foi usada para que de imediato criar no sistema o administrador que é responsavel pela criação de usuarios, turmas....
 * Ademais ela nos permite indentificar qual o tipo de usuario é e logalo no sistema e retorna-lo.
 * @author Miguel, Tufy
*/

public class Sistema implements InterfaceSistema{
	private static int rodou=0;
	private static ArrayList<Usuario> usuarios = new ArrayList<>();
	private static ArrayList<Turma> turmas = new ArrayList<>();
	private static ArrayList<Disciplina> disciplina= new ArrayList<>();
	//private static ArrayList<
	

	// metodos de acessso

	/**
	 * O metodo retorna todo o Arraylist de usuarios do sistema.
	 * 
	 * @return retorna todas os usuarios criados no arraylist Usuarios.
	 */
	public static ArrayList<Usuario> getUsuarios() {
		return usuarios;
	}

	/**
	 * O metodo retorna todo o Arraylist de turmas do sistema.
	 * 
	 * @return retorna todas as turmas criadas no arraylist Turmas.
	 */
	public static ArrayList<Turma> getTurma(){
		return turmas;
	}
	
	/**
	 * O metodo retorna todo o Arraylist de Disciplinas do sistema.
	 * 
	 * @return retorna todas as disciplinas criadas no arraylist Disciplinas.
	 */
	public static ArrayList<Disciplina> getDisciplina(){
		return disciplina;
	}
	

	/**
	 * O metodo cria o administrador no sistema, isso ocorre imediatamente apos a compilação do software.
	 */
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


	/**
	 * O metodo e um simples sistema de login que conseguem indentificar quem esta logando.
	 * e retorna que tipo de usuario logou.
	 * 
	 @return retorna o tipo de usuario logado.
	 */
	public static Usuario Login() {
		int logou=0;
		String Usuario, Senha;
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
