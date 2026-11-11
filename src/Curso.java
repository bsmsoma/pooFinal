

public class Curso {

    private int codigo;
    private String nome;
    private double valorCredito;

    public Curso(int codigo, String nome, double valorCredito) {
        this.codigo = codigo;
        this.nome = nome;
        this.valorCredito = valorCredito;
    }
    
    
    
    
    public int getCodigo(){
        return codigo;
    }
   
    public String getNome(){
        return nome;
    }

    public double getValorCredito(){
        return valorCredito;
    }

    @Override
    public String toString() {
        return "Curso{" + "codigo=" + codigo + ", nome=" + nome + ", valorCredito=" + valorCredito + '}';
    }
    
    
    
}


