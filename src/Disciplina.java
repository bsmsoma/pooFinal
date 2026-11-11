
public class Disciplina {

    private int codigo;
    private String nome;
    private int credito;
    private Curso curso;

    public Disciplina(int codigo, String nome, int credito, Curso curso) {
        this.codigo = codigo;
        this.nome = nome;
        this.credito = credito;
        this.curso = curso;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public int getCredito() {
        return credito;
    }

    public Curso getCurso() {
        return curso;
    }

    @Override
    public String toString() {
        return "Disciplina{" + "codigo=" + codigo + ", nome=" + nome + ", credito=" + credito + ", curso=" + curso + '}';
    }

    
    
    
}
