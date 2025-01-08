/*
git pull
git status
git commit -m ""
git push 
*/

/*
cd .\Proj-Gerenciador-De-Controle-Academico\PROJETO_EDINILSON_ATT\PROJETO_EDINILSON_ATT\src\    

javac ClientCode.java  

java ClientCode
*/
import java.util.Scanner;
public class ClientCode {
	public static void main(String[] args) {
		Usuario clienteUsuario=null;
		int escolhaGeral;
		Scanner leitor = new Scanner(System.in);
		Sistema.AdicionarAdm();
		
		
		do {
			System.out.println("[1] Efetuar Login");
			System.out.println("[2] Sair do Sistema");
			escolhaGeral = leitor.nextInt();
			
			switch (escolhaGeral) {
			case 1:
				clienteUsuario = Sistema.Login();
				break;
			case 2:
				System.out.println("Saindo...");
				break;
			default:
				System.out.println("Selecione uma opção valida");
			}
			
			if(clienteUsuario!=null) {
				if(clienteUsuario instanceof Administrador) {
					int escolhaAdm;
					do {
						System.out.println("[1] Cadastrar novo Usuario");
						System.out.println("[2] Apresentar Usuarios");
						System.out.println("[3] Remover Usuario");
						System.out.println("[4] Sair da conta");
						escolhaAdm = leitor.nextInt();
						leitor.nextLine();
						switch(escolhaAdm) {
						case 1:
							((Administrador) clienteUsuario).CadastrarUsuario(Sistema.getUsuarios());
							break;
						case 2:
							((Administrador) clienteUsuario).ApresentarUsuarios(Sistema.getUsuarios());
							break;
						case 3:	
							((Administrador) clienteUsuario).DeletarUsuario(Sistema.getUsuarios());
							break;
						case 4:
							clienteUsuario = null;
							break;
						}						
					}while(escolhaAdm!=4);
				}
				else if(clienteUsuario instanceof Aluno) {
					int escolhaAluno;
					do {
						System.out.println("[1]Exibir Usuario");
						System.out.println("[2]Sair da conta");
						escolhaAluno=leitor.nextInt();
						
						switch(escolhaAluno) {
						case 1:
						
							break;
							
						case 2:
							clienteUsuario=null;
							break;
						}
					}while(escolhaAluno!=2);
					
				}
			}
			
		}while(escolhaGeral!=2);
		
		
	}
}
