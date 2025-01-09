public class Disciplina {
    private String prontuario;
    private String nomeDisciplina;

    public Disciplina(String pron, String nomeDisciplina){
        this.prontuario = pron;
        this.nomeDisciplina = nomeDisciplina;
    }

    //get e set
    public String getProntuario(){
        return prontuario;
    }
    public void setProntuario(String novoPron){
        prontuario = novoPron;
    }

    public String getNomeDisciplina(){
        return nomeDisciplina;
    }
    public void setNomeDisciplina(String novoNomeDisci){
        nomeDisciplina = novoNomeDisci;
    }

}
