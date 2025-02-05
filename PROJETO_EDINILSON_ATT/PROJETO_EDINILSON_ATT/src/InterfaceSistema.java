import java.util.ArrayList;

/**
 * Esta classe serve como uma interface para os metodos da classe Sistema
 * @author Gabriel
 */
public interface InterfaceSistema {


    /**
	 * O metodo retorna todo o Arraylist de usuarios do sistema.
	 * 
	 * @return retorna todas os usuarios criados no arraylist Usuarios.
	 */
    static ArrayList<Usuario> getUsuarios(){
        return new ArrayList<>();    
    }
   
    /**
	 * O metodo retorna todo o Arraylist de turmas do sistema.
	 * 
	 * @return retorna todas as turmas criadas no arraylist Turmas.
	 */
    static ArrayList<Turma> getTurma() {
        return new ArrayList<>();
    }

    /**
	 * O metodo retorna todo o Arraylist de Disciplinas do sistema.
	 * 
	 * @return retorna todas as disciplinas criadas no arraylist Disciplinas.
	 */
    static ArrayList<Disciplina> getDisciplina() {
        return new ArrayList<>();
    }

    /**
	 * O metodo cria o administrador no sistema, isso ocorre imediatamente apos a compilação do software.
	 */
    static void AdicionarAdm() {
        System.out.println("Administrador adicionado");
    }

    /**
	 * O metodo e um simples sistema de login que conseguem indentificar quem esta logando.
	 * e retorna que tipo de usuario logou.
	 * 
	 @return retorna o tipo de usuario logado.
	 */
    static Usuario Login() {
        return null; 
    }



}
