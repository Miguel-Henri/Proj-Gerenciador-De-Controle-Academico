
public class Aluno extends Usuario{
	private String prontuario;
	private String nome;	
	private String dataNascimento;
	
	public Aluno(String Usuario,String Senha,String prontuario,String nome,String dataNascimento) {
		super(Usuario,Senha);
		this.prontuario = prontuario;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
	}
	
}
