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

/**
 * Esta classe é a classe que serve como uma ponte das ações do usuario para o sistema.
 * Ela permite que possoas possam logar e com base em cada tipo de login classes dedicadas a este tipo de login serão exibidas
 * 
 * @author Miguel, Tufy
 */


import java.util.Scanner;
public class ClientCode {
	public static void main(String[] args) {
		Usuario clienteUsuario=null;
		int escolhaGeral;
		Scanner leitor = new Scanner(System.in);

		//cria e add o admin no sistemas
		Sistema.AdicionarAdm();



		
		
		do {
			System.out.println("[1] Efetuar Login");
			System.out.println("[2] Sair do Sistema");
			escolhaGeral = leitor.nextInt();
			
			switch (escolhaGeral) {
			case 1:
				// com base no tipo de usario que for retornado aqui esse usuario tera acessos a diferentes funções.
				clienteUsuario = Sistema.Login();
				break;
			case 2:
				System.out.println("Saindo...");
				break;
			default:
				System.out.println("Selecione uma opção valida");
			}
			
			if(clienteUsuario!=null) {
				//por exemplo se for retornado um Administrador aparecera um menu com os metodos da classe Administrador.
				if(clienteUsuario instanceof Administrador) {
					int escolhaAdm;
					do {
						System.out.println("[1] Cadastrar novo Usuario");
						System.out.println("[2] Apresentar Usuarios");
						System.out.println("[3] Remover Usuario");					
						System.out.println("[4] Criar Disciplina");
						System.out.println("[5] Criar Turmas");
						System.out.println("[6] Apresentar Turmas");

						System.out.println("[0] Sair da conta");
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
							((Administrador) clienteUsuario).criarDisciplina(Sistema.getDisciplina());
							break;
						case 5:
							((Administrador) clienteUsuario).CriarTurma(Sistema.getDisciplina(),
									Sistema.getTurma(), Sistema.getUsuarios());
							break;
						case 6:
							((Administrador) clienteUsuario).ApresentarTurmas(Sistema.getTurma());
							break;
						case 0:
							System.out.println("Deslogando...");
							clienteUsuario = null;
							break;
						}						
					}while(escolhaAdm!=0);
				}

				//por exemplo se for retornado um Aluno aparecera um menu com os metodos da classe Aluno.
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
	
				//por exemplo se for retornado um Professor aparecera um menu com os metodos da classe Professor
				}else if(clienteUsuario instanceof Professor) {
					int escolhaProfessor;
					do {
						System.out.println("[1]Cadastrar Avaliacao");
						System.out.println("[2]Inserir notas");
						System.out.println("[3]Inserir faltas");
						System.out.println("[4]Exibir relatorio de alunos");
						System.out.println("[5]Exibir relatorio de turma");
						System.out.println("[0]Sair");
						escolhaProfessor = leitor.nextInt();
						
						switch(escolhaProfessor) {
						case 1: 
							((Professor) clienteUsuario).CadastrarAvaliacao(Sistema.getTurma(), clienteUsuario);
							break;
						case 2: 
							((Professor) clienteUsuario).InserirNotas(Sistema.getTurma(), clienteUsuario);
							break;
						case 3:
							((Professor) clienteUsuario).InserirFaltas(Sistema.getTurma(), clienteUsuario);
							break;
						case 4:
							((Professor) clienteUsuario).ExibirRelatorioAlunos(Sistema.getTurma(), clienteUsuario);
							break;
						case 5:
							((Professor) clienteUsuario).ExibirRelatorioTurma(Sistema.getTurma(), clienteUsuario);
							break;							
						default:
							break;
						}
						
					}while(escolhaProfessor > 0 && escolhaProfessor < 6);
				}
				
				
				
			}
			
		}while(escolhaGeral!=2);
		
		leitor.close();

	}
}