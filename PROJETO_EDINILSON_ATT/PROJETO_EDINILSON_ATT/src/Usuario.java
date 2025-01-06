public class Usuario {
	private String Usuario;
	private String Senha;
	
	public Usuario(String Usuario,String Senha) {
		this.Usuario = Usuario;
		this.Senha=Senha;
		
	}
	
	public String getSenha() {
		return Senha;
		
	}
	public String getUsuario() {
		return Usuario;
	}
}