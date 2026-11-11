
public class Professor {

    private int codigo;
    private String nome;
    private String titulacao;
    private String email;

    
    public Professor(int codigo, String nome, String titulacao, String email){
        this.codigo = codigo;
        this.nome = nome;
        this.titulacao = titulacao;
        this.email = email;
    }
    
    
    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public String getTitulacao() {
        return titulacao;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Professor{" + "codigo=" + codigo + ", nome=" + nome + ", titulacao=" + titulacao + ", email=" + email + '}';
    }
    
    
    
}
