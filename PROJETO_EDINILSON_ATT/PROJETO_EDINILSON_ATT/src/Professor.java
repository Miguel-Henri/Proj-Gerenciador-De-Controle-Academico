
public class Professor extends Usuario{
	private String prontuario;
	private String nome;	
	private String dataNascimento;

	public Professor(String Usuario,String Senha,String prontuario,String nome,String dataNascimento) {
		super(Usuario,Senha);
		this.prontuario = prontuario;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
	}

	public String getProntuarioProfessor(){
		return prontuario;
	}
	public void setProntuarioProfessor(String prontuario){
		this.prontuario = prontuario;
	}

	public String getNomeProfessor(){
		return nome;
	}
	public void setNomeProfessor(String nome){
		this.nome = nome;
	}
	
	public String getDataNascimentoProfessor(){
		return dataNascimento;
	}
	public void setDataNascimentoProfessor(String dataNascimento){
		this.dataNascimento = dataNascimento;
	}
}
