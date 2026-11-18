
import java.util.ArrayList;

public class GerenciadorDeInstituicao implements InstituicaoGerenciavel {

    private ArrayList<Curso> cursos = new ArrayList<>();
    private ArrayList<Disciplina> disciplinas = new ArrayList<>();
    private ArrayList<Professor> professores = new ArrayList<>();
    private ArrayList<Aluno> alunos = new ArrayList<>();
    private ArrayList<Turma> turmas = new ArrayList<>();
    private ArrayList<Matricula> matriculas = new ArrayList<>();

    // Carga inicial: cursos de TI cadastrados pelo proprio metodo de cadastro.
    // Valor por credito e provisorio: ajustar com os dados reais da instituicao.
    public GerenciadorDeInstituicao() {
        cadastrarCurso(1, "Analise e Desenvolvimento de Sistemas", 120.0);
        cadastrarCurso(2, "Ciencia da Computacao", 120.0);
        cadastrarCurso(3, "Engenharia de Software", 120.0);
        cadastrarCurso(4, "Sistemas de Informacao", 120.0);
        cadastrarCurso(5, "Redes de Computadores", 120.0);
        cadastrarCurso(6, "Ciencia de Dados", 120.0);

        // Carga inicial de disciplinas (codigo, nome, creditos, codigo do curso).
        // Creditos e nomes sao provisorios: ajustar com a grade real.
        cadastrarDisciplina(1, "Algoritmos", 4, 1);
        cadastrarDisciplina(2, "Estruturas de Dados", 4, 2);
        cadastrarDisciplina(3, "Engenharia de Requisitos", 4, 3);
        cadastrarDisciplina(4, "Redes de Computadores I", 4, 5);
        cadastrarDisciplina(5, "Estatistica Aplicada", 4, 6);

        // Carga inicial de professores (codigo, nome, titulacao, email).
        // Dados ficticios: ajustar se necessario.
        cadastrarProfessor(1, "Maria Silva", "Doutora", "maria.silva@exemplo.com");
        cadastrarProfessor(2, "Joao Santos", "Mestre", "joao.santos@exemplo.com");
        cadastrarProfessor(3, "Ana Oliveira", "Doutora", "ana.oliveira@exemplo.com");
        cadastrarProfessor(4, "Carlos Souza", "Especialista", "carlos.souza@exemplo.com");
        cadastrarProfessor(5, "Patricia Lima", "Mestre", "patricia.lima@exemplo.com");

        // Carga inicial de alunos: 3 regulares e 2 bolsistas.
        // Bolsista: percentual em fracao (0.5 = 50%).
        cadastrarAlunoRegular(1, "Ana Costa", "ana.costa@exemplo.com", 1);
        cadastrarAlunoRegular(2, "Bruno Lima", "bruno.lima@exemplo.com", 2);
        cadastrarAlunoBolsista(3, "Carla Mendes", "carla.mendes@exemplo.com", 3, "ProUni", 0.5);
        cadastrarAlunoBolsista(4, "Diego Rocha", "diego.rocha@exemplo.com", 4, "Institucional", 0.3);
        cadastrarAlunoRegular(5, "Eduarda Alves", "eduarda.alves@exemplo.com", 5);

        // Carga inicial: turma 1 (Algoritmos, Maria Silva) com a aluna Ana Costa matriculada.
        cadastrarTurma(1, "2026-2", 1, 1, 30);
        matricular(buscarAluno(1), buscarTurma(1), "18/11/2026");
    }

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
            return "Turma não encontrada!";
        }

        Turma turmaCadastrada = buscarTurma(turma.getCodigo());

        if (turmaCadastrada == null) {
            return "Turma não cadastrada!";
        }

        String relatorio = "LISTA DE FREQUÊNCIA \n";

        relatorio += "Turma: " + turmaCadastrada.getCodigo() + "\n";
        relatorio += "Disciplina: " + turmaCadastrada.getDisciplina().getNome() + "\n";
        relatorio += "Professor: " + turmaCadastrada.getProfessor().getNome() + "\n";
        relatorio += "Semestre: " + turmaCadastrada.getSemestreLetivo() + "\n";
        relatorio += "\nALUNOS MATRICULADOS:\n";

        for (Matricula m : matriculas) {
            if (m.getTurma() == turmaCadastrada && m.getSituacao().equals("ATIVA")) {
                relatorio += m.getAluno().getCodigo() + " - "
                        + m.getAluno().getNome() + "\n";
            }
        }

        return relatorio;
    }

    @Override
    public String retornarMatriculasDoAluno(Aluno aluno) {
        if (aluno == null) {
            return "Aluno não encontrado!";
        }

        Aluno alunoCadastrado = buscarAluno(aluno.getCodigo());

        if (alunoCadastrado == null) {
            return "Aluno não cadastrado!";
        }

        String relatorio = "MATRÍCULAS DO ALUNO\n";

        relatorio += "Aluno: " + alunoCadastrado.getNome() + "\n\n";

        for (Matricula m : matriculas) {
            if (m.getAluno() == alunoCadastrado) {
                relatorio += "Turma: " + m.getTurma().getCodigo()
                        + " | Disciplina: " + m.getTurma().getDisciplina().getNome()
                        + " | Situação: " + m.getSituacao()
                        + " | Resultado: " + m.retornarResultado() + "\n";
            }
        }

        return relatorio;

    }

    public String retornarListaDeCursos() {
        String cursoFormatado = "";
        for (Curso c : cursos) {
            cursoFormatado += "Código: " + c.getCodigo() + " - Nome: " + c.getNome() + " - Valor por Crédito: " + c.getValorPorCredito() + "\n";
        }
        return cursoFormatado;
    }

    public String retornarListaDeDisciplinas() {
        String disciplinaFormatada = "";
        for (Disciplina d : disciplinas) {
            disciplinaFormatada += "Código: " + d.getCodigo() + " - Nome: " + d.getNome() + " - Créditos: " + d.getQtdCreditos() + " - Curso: " + d.getCurso().getNome() + "\n";
        }
        return disciplinaFormatada;
    }

    public String retornarListaDeProfessores() {
        String professorFormatado = "";
        for (Professor p : professores) {
            professorFormatado += "Código: " + p.getCodigo() + " - Nome: " + p.getNome() + " - Titulação: " + p.getTitulacao() + " - Email: " + p.getEmail() + "\n";
        }
        return professorFormatado;
    }

    public String retornarListaDeAlunos() {
        String alunoFormatado = "";
        for (Aluno a : alunos) {
            alunoFormatado += "Código: " + a.getCodigo() + " - Nome: " + a.getNome() + " - Email: " + a.getEmail() + " - Curso: " + a.getCurso().getNome() + "\n";
        }
        return alunoFormatado;
    }

    public String retornarListaDeTurmas() {
        String turmaFormatada = "";
        for (Turma t : turmas) {
            turmaFormatada += "Código: " + t.getCodigo() + " - Semestre: " + t.getSemestreLetivo() + " - Disciplina: " + t.getDisciplina().getNome() + " - Professor: " + t.getProfessor().getNome() + " - Vagas: " + t.getNumeroDeVagas() + "\n";
        }
        return turmaFormatada;
    }


    public String retornarListaDeMatriculas() {
        String matriculaFormatada = "";
        for (Matricula m : matriculas) {
            matriculaFormatada += "Aluno: " + m.getAluno().getCodigo() + " - " + m.getAluno().getNome()
                    + " | Turma: " + m.getTurma().getCodigo()
                    + " | Disciplina: " + m.getTurma().getDisciplina().getNome()
                    + " | Situacao: " + m.getSituacao()
                    + " | Resultado: " + m.retornarResultado() + "\n";
        }
        return matriculaFormatada;
    }

}

/*

// Abstração do Objeto Matricula em JSON // 
{
  "classe": "Matricula",
  "implementa": "MatriculaGerenciavel",
  "atributos": {
    "aluno": {
      "classe": "Aluno",
      "codigo": 10,
      "nome": "Ana",
      "email": "ana@x.com",
      "curso": { "codigo": 1, "nome": "ADS", "valorPorCredito": 120.0 }
    },
    "turma": {
      "classe": "Turma",
      "codigo": 1,
      "semestreLetivo": "2026-2",
      "disciplina": { "codigo": 1, "nome": "POO", "qtdCreditos": 4 },
      "professor": { "codigo": 1, "nome": "Prof", "titulacao": "Doutor", "email": "p@x.com" },
      "numeroDeVagas": 30
    },
    "data": "16/11/2026",
    "situacao": "ATIVA",
    "nota1": 0.0,
    "nota2": 0.0,
    "faltas": 0,
    "notasLancadas": false
  },
  "comportamentos": {
    "lancarNotas(nota1, nota2)": "so com ATIVA e notas entre 0 e 10; pode corrigir de novo",
    "registrarFaltas(quantidade)": "soma as faltas; so com ATIVA",
    "trancar()": "ATIVA -> TRANCADA",
    "cancelar()": "ATIVA ou TRANCADA -> CANCELADA (definitivo)",
    "calcularMedia()": "(nota1 + 2 * nota2) / 3, sem guardar",
    "retornarResultado()": "SEM NOTAS LANCADAS | REPROVADO POR FALTA (mais de 15) | REPROVADO POR NOTA (media < 6) | APROVADO"
  },
  "regrasDeSituacao": {
    "ATIVA": "conta como vaga ocupada e entra na soma de creditos",
    "TRANCADA": "nao conta para vagas nem para mensalidade; continua guardada",
    "CANCELADA": "nao conta para vagas nem para mensalidade; nao volta"
  }
}

*/
