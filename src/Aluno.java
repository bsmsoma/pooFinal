
public abstract class Aluno {

    private int codigo;
    private String nome;
    private String email;
    private Curso curso;

    //Construtor padrão. 
    public Aluno() {

    }

    //Contrutor parametrizado
    public Aluno(int codigo, String nome, String email, Curso curso) {
        this.codigo = codigo;
        this.nome = nome;
        this.email = email;
        this.curso = curso;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public Curso getCurso() {
        return curso;
    }

    @Override
    public String toString() {
        return "Aluno{" + "codigo=" + codigo + ", nome=" + nome + ", email=" + email + ", curso=" + curso.getCodigo() + " - " + curso.getNome() + '}';
    }

    public abstract double calcularMensalidade(double valorBruto);

}
