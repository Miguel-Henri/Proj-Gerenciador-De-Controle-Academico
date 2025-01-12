import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.text.html.HTMLDocument.HTMLReader.PreAction;
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

	/*public void criarTurma(ArrayList<Turma> turma,ArrayList<Usuario> usuarios){
		String
	}*/
	
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

	
	
	
	public void ApresentarTurmas(ArrayList<Turma> turmas) {
		for(int i = 0;i<turmas.size();i++) {
			System.out.println("TURMA "+(i+1));
			System.out.println("Codigo da Turma: "+turmas.get(i).getCodigoTurma());
			System.out.println("Disciplina: "+turmas.get(i).getDisciplina().getNomeDisciplina());
			System.out.println("Professor da turma: "+turmas.get(i).getProfessores().getNomeProfessor());
		}
	}
}
