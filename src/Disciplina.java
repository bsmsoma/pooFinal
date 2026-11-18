
public class Disciplina {

    private int codigo;
    private String nome;
    private int qtdCreditos;
    private Curso curso;

    public Disciplina() {

    }

    public Disciplina(int codigo, String nome, int qtdCreditos, Curso curso) {
        this.codigo = codigo;
        this.nome = nome;
        this.qtdCreditos = qtdCreditos;
        this.curso = curso;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public int getQtdCreditos() {
        return qtdCreditos;
    }

    public Curso getCurso() {
        return curso;
    }

    @Override
    public String toString() {
        return "Disciplina{" + "codigo=" + codigo + ", nome=" + nome + ", qtdCreditos=" + qtdCreditos + ", curso=" + curso + '}';
    }

}
