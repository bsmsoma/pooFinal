
public class Turma {

    private int codigo;
    private String semestreLetivo;
    private Disciplina disciplina;
    private Professor professor;
    private int numeroDeVagas;

    public Turma(int codigo, String semestreLetivo, Disciplina disciplina, Professor professor, int numeroDeVagas) {
        this.codigo = codigo;
        this.semestreLetivo = semestreLetivo;
        this.disciplina = disciplina;
        this.professor = professor;
        this.numeroDeVagas = numeroDeVagas;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getSemestreLetivo() {
        return semestreLetivo;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public Professor getProfessor() {
        return professor;
    }

    public int getNumeroDeVagas() {
        return numeroDeVagas;
    }
    
    
    
}

