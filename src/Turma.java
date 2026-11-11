
public class Turma {

    private int codigo;
    private String semestre;
    private Disciplina disciplina;
    private Professor professor;
    private int vagas;

    public Turma(int codigo, String semestre, Disciplina disciplina, Professor professor, int vagas) {
        this.codigo = codigo;
        this.semestre = semestre;
        this.disciplina = disciplina;
        this.professor = professor;
        this.vagas = vagas;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getSemestre() {
        return semestre;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public Professor getProfessor() {
        return professor;
    }

    public int getVagas() {
        return vagas;
    }
    
    
    
}

