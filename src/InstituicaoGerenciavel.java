
public interface InstituicaoGerenciavel {

    // Cadastro: validar dados/codigo e retornar mensagem. 
    // GerenciadorDeInstituicao cria e armazena os objetos. 
    String cadastrarCurso(int codigo, String nome, double valorCredito);

    String cadastrarDisciplina(int codigo, String nome, int creditos, int codigoCurso);

    String cadastrarProfessor(int codigo, String nome, String titulacao, String email);

    String cadastrarAlunoRegular(int codigo, String nome, String email, int codigoCurso);

    String cadastrarAlunoBolsista(int codigo, String nome, String email,
            int codigoCurso, String tipoBolsa, double percentualBolsa);

    String cadastrarTurma(int codigo, String semestre, int codigoDisciplina,
            int codigoProfessor, int vagas);

    // Busca: devolver a referencia encontrada ou null. 
    //-Curso buscarCurso(int codigo);

    Disciplina buscarDisciplina(int codigo);

    Professor buscarProfessor(int codigo);

    Aluno buscarAluno(int codigo);

    Turma buscarTurma(int codigo);

    Matricula buscarMatricula(Aluno aluno, Turma turma);

    // Matricula: aplicar regras e retornar sucesso ou motivo da recusa. 
    //-String matricular(Aluno aluno, Turma turma, String dataMatricula);

    // Consultas: calcular vagas e mensalidade conforme as regras. 
    //-int calcularVagasDisponiveis(Turma turma);

    //-double calcularMensalidade(Aluno aluno);

    // Relatorios: retornar texto, sem acessar a tela. 
    //-String retornarListaDeFrequencia(Turma turma);

    //-String retornarMatriculasDoAluno(Aluno aluno);
}
