

public class AlunoBolsista extends Aluno {
    private String tipoBolsa;
    private double percentualBolsa;
    
    
    public AlunoBolsista(int codigo, String nome, String email, Curso curso, String tipoBolsa, double percentualBolsa){
        super(codigo, nome, email, curso);
        this.tipoBolsa = tipoBolsa;
        this.percentualBolsa = percentualBolsa;
        
        
        
        
        
        
    }

    public String getTipoBolsa() {
        return tipoBolsa;
    }

    public double getPercentualBolsa() {
        return percentualBolsa;
    }
            
    
}
