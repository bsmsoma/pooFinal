
public class AlunoRegular extends Aluno {

    public AlunoRegular() {
        super();
    }

    public AlunoRegular(int codigo, String nome, String email, Curso curso) {
        super(codigo, nome, email, curso);
    }

    @Override
    public double calcularMensalidade(double valorBruto) {
        return valorBruto;
    }

    // Monta o texto do aluno regular. Pega o texto do Aluno (que começa com "Aluno{...}"),
    // tira a palavra "Aluno" do começo e coloca "Aluno Regular:" no lugar.
    // Assim o resultado fica "Aluno Regular:{codigo=..., nome=..., ...}".
    @Override
    public String toString() {
        return "Aluno Regular:" + super.toString().substring("Aluno".length());
    }

}
