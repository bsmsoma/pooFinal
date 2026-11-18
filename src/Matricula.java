
public class Matricula implements MatriculaGerenciavel {

    private Aluno aluno;
    private Turma turma;
    private String data;
    private String situacao = "ATIVA";
    private double nota1 = 0;
    private double nota2 = 0;
    private int faltas = 0;
    private boolean notasLancadas = false;

    public Matricula() {

    }

    public Matricula(Aluno aluno, Turma turma, String data) {
        this.aluno = aluno;
        this.turma = turma;
        this.data = data;
    }

    // OS GETTER !!
    public Aluno getAluno() {
        return aluno;
    }

    public Turma getTurma() {
        return turma;
    }

    public String getData() {
        return data;
    }

    public String getSituacao() {
        return situacao;
    }

    public double getNota1() {
        return nota1;
    }

    public double getNota2() {
        return nota2;
    }

    public int getFaltas() {
        return faltas;
    }

    public boolean isNotasLancadas() {
        return notasLancadas;
    }

    // OS METODOS !!! -------------------------------------
    @Override
    public String lancarNotas(double nota1, double nota2) {
        if (situacao.equals("ATIVA")) {

            if (nota1 >= 0 && nota1 <= 10) {

                if (nota2 >= 0 && nota2 <= 10) {
                    this.nota1 = nota1;
                    this.nota2 = nota2;

                    notasLancadas = true;
                    return "Nota lançada com sucesso !!";

                }
                return "Nota 2 tem que ser entre ( 0 e 10)";

            }
            return "Nota 1 tem que ser entre ( 0 e 10)";

        }
        return "Matricula NÃO está ativa !";

    }

    @Override
    public String registrarFaltas(int quantidade) {

        if (situacao.equals("ATIVA")) {
            this.faltas += quantidade;
            return "Faltas registradas";

        }
        return "Matricula NÃO está ativa !";

    }

    @Override
    public String trancar() {
        if (situacao.equals("ATIVA")) {
            this.situacao = "TRANCADA";
            return "Matricula trancada com sucesso !";

        } else if (situacao.equals("TRANCADA")) {
            return "Matricula já está trancada !";

        } else if (situacao.equals("CANCELADA")) {
            return "Matricula está cancelada, não é póssivel trancar !";

        }
        return "Situação invalida ou desconhecida !";

    }

    @Override
    public String cancelar() {
        if (situacao.equals("ATIVA") || situacao.equals("TRANCADA")) {
            this.situacao = "CANCELADA";

            return "Matricula cancelada com sucesso !";

        } else if (situacao.equals("CANCELADA")) {
            return "Matricula já está cancelada !";
        }
        return "Situação invalida ou desconhecida !";

    }

    @Override
    public double calcularMedia() {

        double media = (nota1 + nota2 * 2) / 3;

        return media;

    }

    @Override
    public String retornarResultado() {
        if (!notasLancadas) {
            return "SEM NOTAS LANÇADAS";

        } else if (faltas > 15) {
            return "REPROVADO POR FALTA";

        } else if (calcularMedia() >= 6) {
            return "APROVADO";

        } else {
            return "REPROVADO POR NOTA";

        }

    }

    @Override
    public String toString() {
        return "Matricula{" + "aluno=" + aluno + ", turma=" + turma + ", data=" + data + ", situacao=" + situacao + ", nota1=" + nota1 + ", nota2=" + nota2 + ", faltas=" + faltas + ", notasLancadas=" + notasLancadas + '}';
    }

}
