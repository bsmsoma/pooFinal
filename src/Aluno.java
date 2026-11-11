
public abstract class Aluno {
    private int codigo;
    private String nome;
    private String email;
    private Curso curso;
 
    
    public Aluno (int codigo, String nome, String email, Curso curso) {
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
    
    
}
