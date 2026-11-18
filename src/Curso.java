
public class Curso {

    private int codigo;
    private String nome;
    private double valorPorCredito;

    public Curso() {

    }

    public Curso(int codigo, String nome, double valorPorCredito) {
        this.codigo = codigo;
        this.nome = nome;
        this.valorPorCredito = valorPorCredito;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public double getValorPorCredito() {
        return valorPorCredito;
    }

    @Override
    public String toString() {
        return "Curso{" + "codigo=" + codigo + ", nome=" + nome + ", valorPorCredito=" + valorPorCredito + '}';
    }

}
