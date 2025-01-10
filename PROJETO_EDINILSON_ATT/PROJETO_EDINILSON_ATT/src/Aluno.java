public class Aluno extends Usuario{
	private String prontuario;
	private String nome;	
	private String dataNascimento;	

	Turma turma;
	
	private double[] arrayNotas;

	public Aluno(String Usuario,String Senha,String prontuario,String nome,String dataNascimento) {
		super(Usuario,Senha);
		this.prontuario = prontuario;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
	}

	public Aluno(String Usuario,String Senha,String prontuario,String nome,String dataNascimento, int qtddDeAvaliacoes) {
		super(Usuario,Senha);
		this.prontuario = prontuario;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.arrayNotas = new double[qtddDeAvaliacoes];
	}
	
	public String getProntuarioAluno(){
		return prontuario;
	}
	public void setProntuarioAluno(String prontuario){
		this.prontuario = prontuario;
	}

	public String getNomeAluno(){
		return nome;
	}
	public void setNomeAluno(String nome){
		this.nome = nome;
	}
	
	public String getDataNascimentoAluno(){
		return dataNascimento;
	}
	public void setDataNascimentoAluno(String dataNascimento){
		this.dataNascimento = dataNascimento;
	}

	public void getArrayNotas(){
		for(int i = 0; i < arrayNotas.length; i++){
			System.out.println("Nota["+i+"]: "+arrayNotas[i]+" de " + getNomeAluno());
		}
	}

	public void setDefinirNotas(int indice, double nota){
		if(indice >= 0 && indice < arrayNotas.length){
			arrayNotas[indice] = nota;
		}else {
			System.out.println("nao foi possivel colocar a nota");
		}
	}
	
}
