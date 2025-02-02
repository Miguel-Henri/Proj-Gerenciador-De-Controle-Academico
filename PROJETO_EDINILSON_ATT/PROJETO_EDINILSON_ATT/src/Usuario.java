/**
 * Representa o usuario no sistema, com informações de usuario e senha.
 * A classe nos permite recuperar os valores: nome de usuario e senha, de cada usuario no sistema.
 * @author Miguel
 */

 
public class Usuario {
	private String Usuario;
	private String Senha;
	 

	/**
	 * Contrutor para criar novos usuarios.
	 * 
	 * @param Usuario O nome do novo usuario.
	 * @param Senha A senha do novo usuario.
	 */
	public Usuario(String Usuario,String Senha) {
		this.Usuario = Usuario;
		this.Senha=Senha;
		
	}

	// Métodos de acesso

	
	/**
	 * Metodo para recuperarmos a senha.
	 * 
	 * @return retorna a senha do usuario.
	 */
	public String getSenha() {
		return Senha;
		
	}


	/**
	 * Metodo para recuperarmos o nome de usuario.
	 * 
	 * @return retorna o nome de usuario.
	 */
	public String getUsuario() {
		return Usuario;
	}
}