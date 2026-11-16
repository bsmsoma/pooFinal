

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

    @Override
    public double calcularMensalidade(double valorBruto) {
        return valorBruto * (1 - getPercentualBolsa());
    }

    @Override
    public String toString() {
        return "Aluno Bolsista:" + super.toString().substring("Aluno".length(), super.toString().length() - 1) + ", tipo de bolsa=" + tipoDeBolsa + ", percentual de bolsa=" + percentualBolsa + "}";
    }
}
