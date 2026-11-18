
import java.util.ArrayList;

public class GerenciadorDeInstituicao implements InstituicaoGerenciavel {

    private ArrayList<Curso> cursos = new ArrayList<>();
    private ArrayList<Disciplina> disciplinas = new ArrayList<>();
    private ArrayList<Professor> professores = new ArrayList<>();
    private ArrayList<Aluno> alunos = new ArrayList<>();
    private ArrayList<Turma> turmas = new ArrayList<>();
    private ArrayList<Matricula> matriculas = new ArrayList<>();

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

    @Override
    public Matricula buscarMatricula(Aluno aluno, Turma turma) {
        if (aluno == null || turma == null) {
            return null;
        }
        for (Matricula m : matriculas) {
            if (m.getAluno() == aluno && m.getTurma() == turma) {
                return m;
            }
        }
        return null;

    }

    @Override
    public String matricular(Aluno aluno, Turma turma, String dataMatricula) {

        if (aluno == null || turma == null) {
            return "Aluno ou Turma não informado";
        }
        Aluno alunoCadastrado = buscarAluno(aluno.getCodigo());
        Turma turmaCadastrada = buscarTurma(turma.getCodigo());
        if (alunoCadastrado == null || turmaCadastrada == null) {
            return "Aluno ou Turma não cadastrados";
        }

        Matricula matriculaCadastrada = buscarMatricula(alunoCadastrado, turmaCadastrada);

        if (matriculaCadastrada != null) {
            return "Matricula já encontrada";
        }

        int disponibilidadeDeVagas = calcularVagasDisponiveis(turmaCadastrada);
        if (disponibilidadeDeVagas < 1) {
            return "Turma sem vagas disponiveis";
        }

        Matricula novaMatricula = new Matricula(alunoCadastrado, turmaCadastrada, dataMatricula);
        matriculas.add(novaMatricula);

        return "Nova matricula efetuada com sucesso";

    }

    @Override
    public int calcularVagasDisponiveis(Turma turma) {
        //turma inexistente: não há vagas, então devolve 0 e nenhuma matrícula é aceita.
        if (turma == null) {
            return 0;
        }
        int numeroDeVagas = turma.getNumeroDeVagas();

        for (Matricula m : matriculas) {
            if (m.getTurma() == turma && m.getSituacao().equals("ATIVA")) {
                numeroDeVagas -= 1;
            }
        }
        return numeroDeVagas;
    }

    @Override
    public double calcularMensalidade(Aluno aluno) {
        if (aluno == null) {
            return 0;
        }
        Aluno alunoCadastrado = buscarAluno(aluno.getCodigo());
        if (alunoCadastrado == null) {
            return 0; // a professora permitiu não tratar excecões. 
        }
        int qtdDeCreditos = 0;

        for (Matricula m : matriculas) {
            if (m.getAluno() == alunoCadastrado && m.getSituacao().equals("ATIVA")) {
                qtdDeCreditos += m.getTurma().getDisciplina().getQtdCreditos();

            }
        }
        double valorDoCredito = alunoCadastrado.getCurso().getValorPorCredito();
        double valorBruto = qtdDeCreditos * valorDoCredito;

        return alunoCadastrado.calcularMensalidade(valorBruto);
    }

    @Override
    public String retornarListaDeFrequencia(Turma turma) {
        if (turma == null) {
            return "Cadastre uma turma";
        }
        Turma turmaCadastrada = buscarTurma(turma.getCodigo());
        if (turmaCadastrada == null) {
            return "Turma não encontrada";
        }

        String listaFormatada = "Turma: " + turmaCadastrada.getSemestreLetivo() + " - " + turmaCadastrada.getCodigo() + "\n"
                                + "Disciplina: " + turmaCadastrada.getDisciplina().getNome() + " - " + turmaCadastrada.getDisciplina().getCodigo() + "\n"
                                + "Professor: " + turmaCadastrada.getProfessor().getNome() + "\n"
                                + "Alunos: \n";

        for (Matricula m : matriculas) {
            if (m.getTurma() == turmaCadastrada && m.getSituacao().equals("ATIVA")) {
                listaFormatada += m.getAluno().getCodigo() + " - " + m.getAluno().getNome() + "\n";
            }
        }

        return listaFormatada;
    }

    @Override
    public String retornarMatriculasDoAluno(Aluno aluno) {
        if (aluno == null) {
            return "Cadastre Aluno";
        }

        Aluno alunoCadastrado = buscarAluno(aluno.getCodigo());
        if (alunoCadastrado == null) {
            return "Aluno não cadastrado";
        }

        String matriculasDoAlunos = "";
        for (Matricula m : matriculas) {
            if (m.getAluno() == alunoCadastrado) {
                matriculasDoAluno += m.getTurma().getDisciplina();
            }
        }
        return "String";
    }

}
