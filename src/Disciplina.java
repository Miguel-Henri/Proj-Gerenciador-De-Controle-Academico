public class Disciplina {
    private String nomeDisciplina;	
    private String siglaDisciplina;
    private String ementa;
    private int cargaHoraria;
    private int totalAulas;
    
    
    public Disciplina(String nomeDisciplina,String siglaDisciplina,String ementa,int cargaHoraria
    		,int totalAulas){

        this.nomeDisciplina = nomeDisciplina;
        this.siglaDisciplina = siglaDisciplina;
        this.ementa = ementa;
        this.cargaHoraria = cargaHoraria;
        this.totalAulas = totalAulas;
    }

 
    public String getNomeDisciplina() {
    	return nomeDisciplina;
    }
    
   
}
