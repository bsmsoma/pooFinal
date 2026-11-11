

public class AlunoBolsista extends Aluno {
    private String tipoDeBolsa;
    private double percentualBolsa;
    
    
    public AlunoBolsista(int codigo, String nome, String email, Curso curso, String tipoDeBolsa, double percentualBolsa){
        super(codigo, nome, email, curso);
        this.tipoDeBolsa = tipoDeBolsa;
        this.percentualBolsa = percentualBolsa;
        
        
        
        
        
        
    }

    public String getTipoDeBolsa() {
        return tipoDeBolsa;
    }

    public double getPercentualBolsa() {
        return percentualBolsa;
    }
            
    
}
