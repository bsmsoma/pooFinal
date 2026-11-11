
import java.util.ArrayList;

public class GerenciadorDeInstituicao implements InstituicaoGerenciavel {

    private ArrayList<Curso> cursos = new ArrayList<>();
    private ArrayList<Disciplina> disciplinas = new ArrayList<>();
    private ArrayList<Professor> professores = new ArrayList<>();
    private ArrayList<Aluno> alunos = new ArrayList<>();
    private ArrayList<Turma> turmas = new ArrayList<>();

//--------------------BUSCAR E CADASTRAR CURSO ------------------------
    public Curso buscarCurso(int codigo) {
        for (Curso c : cursos) {
            if (codigo == c.getCodigo()) {
                return c;
            }
        }
        return null;
    }

    public String cadastrarCurso(int codigo, String nome, double valorPorCredito) {
        if (buscarCurso(codigo) == null) {

            Curso curso = new Curso(codigo, nome, valorPorCredito);

            cursos.add(curso);

            return "Curso cadastrado com sucesso !";

        }
        return "Curso já existe !";
    }

//--------------------BUSCAR E CADASTRAR DISCIPLINA ------------------------
    public Disciplina buscarDisciplina(int codigo) {
        for (Disciplina d : disciplinas) {
            if (codigo == d.getCodigo()) {
                return d;
            }

        }
        return null;
    }

    public String cadastrarDisciplina(int codigo, String nome, int qtdCreditos, int codigoCurso) {
        if (buscarDisciplina(codigo) == null) {
            Curso cursoEncontrado = buscarCurso(codigoCurso);

            if (cursoEncontrado != null) {
                Disciplina disciplina = new Disciplina(codigo, nome, qtdCreditos, cursoEncontrado);
                disciplinas.add(disciplina);

                return "Disciplina cadastrada";

            }

        } else {
            return "Disciplina já existe";
        }

        return "Curso não encontrado";
    }

//--------------------BUSCAR E CADASTRAR PROFESSOR------------------------
    public Professor buscarProfessor(int codigo) {
        for (Professor p : professores) {
            if (codigo == p.getCodigo()) {
                return p;
            }

        }
        return null;

    }

    public String cadastrarProfessor(int codigo, String nome, String titulacao, String email) {
        if (buscarProfessor(codigo) == null) {
            Professor p = new Professor(codigo, nome, titulacao, email);
            professores.add(p);
            return "Professor cadastrado com sucesso!";

        }

        return "Já existe cadastro de professor !";
    }

//--------------------BUSCAR E CADASTRAR ALUNO------------------------    
    public Aluno buscarAluno(int codigo) {
        for (Aluno a : alunos) {
            if (codigo == a.getCodigo()) {
                return a;

            }

        }
        return null;
    }

    public String cadastrarAlunoRegular(int codigo, String nome, String email, int codigoCurso) {
        if (buscarAluno(codigo) == null) {

            Curso cursoEncontrado = buscarCurso(codigoCurso);

            if (cursoEncontrado != null) {
                AlunoRegular ar = new AlunoRegular(codigo, nome, email, cursoEncontrado);

                alunos.add(ar);
                return "Aluno Regular cadastrado";

            } else {
                return "Curso não encontrado";
            }

        }
        return "Codigo Aluno ja cadastrado !";

    }

    //ALUNO BOLSISTA
    public String cadastrarAlunoBolsista(int codigo, String nome, String email, int codigoCurso, String tipoDeBolsa, double percentualBolsa) {
        if (buscarAluno(codigo) == null) {

            Curso cursoEncontrado = buscarCurso(codigoCurso);

            if (cursoEncontrado != null) {
                AlunoBolsista ab = new AlunoBolsista(codigo, nome, email, cursoEncontrado, tipoDeBolsa, percentualBolsa);

                alunos.add(ab);
                return "Aluno Bolsista cadastrado";

            } else {
                return "Curso não encontrado";
            }

        }
        return "Codigo Aluno ja cadastrado !";

    }

    //BUSCA TURMA
    public Turma buscarTurma(int codigo) {
        for (Turma t : turmas) {
            if (codigo == t.getCodigo()) {
                return t;

            }

        }
        return null;
    }

    @Override
    public Matricula buscarMatricula(Aluno aluno, Turma turma) {
        return null;
    }

    public String cadastrarTurma(int codigo, String semestre, int codigoDisciplina, int codigoProfessor, int vagas) {

        Disciplina disciplina = buscarDisciplina(codigoDisciplina);
        Professor professor = buscarProfessor(codigoProfessor);

        if (buscarTurma(codigo) == null) {

            if (disciplina != null) {

                if (professor != null) {

                    Turma turma = new Turma(codigo, semestre, disciplina, professor, vagas);

                    turmas.add(turma);

                    return "Turma cadastrada com sucesso!";

                }
                return "Codigo professor não cadastrado";

            }
            return "Codigo Disciplina não cadastrado";

        }
        return "Turma já cadastrada !";

    }
}
